package Usuarios;
import Animales.Animal;
import Tools.LoggerH;
import Usuarios.*;
import Usuarios.Adopcion;
import Usuarios.Usuario;
import Tools.Menu;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Empleados extends Usuario {
   private String rol;
   private String fechaContratacion;
    private List<Adopcion> solicitudesPendientes;
    private int idE;
    private  static int idCounterE = 1;
    private List<Adopcion> adopciones;

    public Empleados(int id, String nombre, int edad, String direccion, long numeroContacto, String rol, String fechaContratacion) {
        super( nombre, edad, direccion, numeroContacto);
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
        this.idE = id;
        this.adopciones = new ArrayList<>();
        this.solicitudesPendientes = new ArrayList<>();
        idCounterE++;
    }


    public void mostrarEmpleado() {
        System.out.println("ID" + getId());
        System.out.println("Nombre del empleado: " + getNombre());
        System.out.println("Edad del empleado: " + getEdad());
        System.out.println("Direccion del empleado: " + getDireccion());
        System.out.println(" Numero de contacto del empleado: " + getNumeroContacto());
        System.out.println("Rol del empleado: " + rol);
        System.out.println("Fecha de contratación: " + fechaContratacion);
    }

    public void procesoAdopcion(Scanner scanner, List<Adopcion> adopciones, List<Animal> animalesDisponibles, Adoptante adoptanteEncontrado) {
        System.out.println("Registrar proceso de adopción:");


        System.out.print("Nombre del adoptante: ");
        String nombreAdoptante = scanner.nextLine();

        System.out.println("Edad del adoptante: ");
        int edadAdoptante = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dirección del adoptante: ");
        String direccionAdoptante = scanner.nextLine();

        System.out.print("Número de contacto del adoptante: ");
        long numeroContacto = Long.parseLong(scanner.nextLine());

        System.out.print("Preferencia de adopción: ");
        String preferenciaAdopcion = scanner.nextLine();

        System.out.print("Nombre del animal que desea adoptar: ");
        String animalAdoptado = scanner.nextLine();

        System.out.print("Fecha de solicitud: ");
        String fechaAdopcion = scanner.nextLine();

        Animal animalEncontrado = null;
        for (Animal animal : animalesDisponibles) {
            if (animal.getNombre().equals(animalAdoptado)) {
                animalEncontrado = animal;
                break;
            }
        }

        if (animalEncontrado != null) {
            Adopcion nuevaAdopcion = new Adopcion(adoptanteEncontrado, animalEncontrado);
            adopciones.add(nuevaAdopcion);
            System.out.println("Proceso de adopción registrado con éxito.");
        } else {
            System.out.println("No se pudo encontrar el animal especificado para la adopción.");
        }
    }

   
    public void aprobarAdopcion(Adopcion adopcion) {
        adopcion.setEstado("Aprobado");
        System.out.println("Adopción aprobada para el adoptante: " + adopcion.getAdoptante().getNombre() + " y el animal: " + adopcion.getAnimal().getNombre());
    }

    public void denegarAdopcion(Adopcion adopcion) {
        adopcion.setEstado("Denegado");
        System.out.println("Adopción denegada para el adoptante: " + adopcion.getAdoptante().getNombre() + " y el animal: " + adopcion.getAnimal().getNombre());
    }
    public static void mostrarAnimalesDisponibles(List<Animal>animalesDisponibles) {
        System.out.println("Animales disponibles:");
        for (Animal animal : animalesDisponibles) {
            animal.mostrarAnimalDisponible();

        }
    }

    public static void aprobarRegistro(Scanner scanner, List<SolicitudRegistro> solicitudesDeRegistro, List<Adoptante> adoptantes) {
        System.out.println("Solicitudes de registro pendientes:");
        for (SolicitudRegistro solicitud : solicitudesDeRegistro) {
            System.out.println("Nombre de usuario: " + solicitud.getNombreUsuario());
        }

        System.out.println("Ingrese el nombre de usuario que desea aprobar:");
        String nombreUsuarioAprobado = scanner.nextLine();

        for (SolicitudRegistro solicitud : solicitudesDeRegistro) {
            if (solicitud.getNombreUsuario().equals(nombreUsuarioAprobado)) {
                int idE = idCounterE;
                idCounterE++;
                System.out.println("Contraseña del nuevo adoptante: ");
                String nuevaContrasena = scanner.nextLine();
                System.out.println("Edad del nuevo adoptante: ");
                int edadNuevoAdoptante = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Dirección del nuevo adoptante: ");
                String direccionNuevoAdoptante = scanner.nextLine();
                System.out.println("Número de contacto del nuevo adoptante: ");
                long numeroContactoNuevoAdoptante = Long.parseLong(scanner.nextLine());

                Adoptante adoptante = new Adoptante( idE ,solicitud.getNombreUsuario(), nuevaContrasena, edadNuevoAdoptante, direccionNuevoAdoptante, numeroContactoNuevoAdoptante);
                adoptante.setAprovada(true);
                adoptantes.add(adoptante);
                System.out.println("Adoptante aprobado y registrado exitosamente.");
                solicitudesDeRegistro.remove(solicitud);
                try {
                    File file = new File("TiendaDA.xls");
                    Workbook workbook;
                    if (file.exists()){
                        FileInputStream fileIn = new FileInputStream(file);
                        workbook = WorkbookFactory.create(fileIn);
                        fileIn.close();
                    }else {
                        workbook = new HSSFWorkbook();
                    }

                    Sheet sheet = workbook.getSheet("Adoptantes");
                    if (sheet == null){
                        sheet = workbook.createSheet("Adoptantes");
                    }
                    int rowIndex = sheet.getLastRowNum() + 1;

                    Row row = sheet.createRow(rowIndex);
                    row.createCell(0).setCellValue(adoptante.getId());
                    row.createCell(1).setCellValue(adoptante.getNombreUsuario());
                    row.createCell(2).setCellValue(adoptante.getContrasena());
                    row.createCell(3).setCellValue(adoptante.getEdad());
                    row.createCell(4).setCellValue(adoptante.getDireccion());
                    row.createCell(5).setCellValue(adoptante.getNumeroContacto());


                    FileOutputStream fileOut = new FileOutputStream("TiendaDA.xls");
                    workbook.write(fileOut);
                    fileOut.close();
                    workbook.close();
                    System.out.println("Datos  guardados correctamente en excel");
                }catch (IOException e){
                    LoggerH.logException(new Exception("Error al crear Animal" + e.getMessage()));
                }
                return;
            }
        }
    }


    public void setNumeroContacto(long numeroContacto) {
        if (String.valueOf(numeroContacto).length() != 10) {
            throw new IllegalArgumentException("El número de contacto debe tener 10 dígitos.");
        }
        this.numeroContacto = numeroContacto;

    }
    @Override
    public int getId() {
        return idE;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public List<Adopcion> getAdopciones() {
        return adopciones;
    }

    public void setAdopciones(List<Adopcion> adopciones) {
        this.adopciones = adopciones;
    }

}






