package Usuarios;

import Usuarios.Usuario;
import Tools.Menu;
import Animales.Animal;
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

public class Administrador extends Usuario {
    String rol;
    String fechaContratacion;
    long clave;

    public Administrador( String nombre, int edad, String direccion, long numeroContacto, long clave) {
        super( nombre, edad, direccion, numeroContacto);
        this.clave = clave;
    }

    private static void crearAdministrador (Scanner scanner, List<Administrador>administradores){

        System.out.println("crear un nuevo administrador:");

        System.out.println("id del administrador");
        int id =scanner.nextInt();
        scanner.nextLine();

        System.out.println("nombre del administrador:");
        String nombre = scanner.nextLine();

        System.out.println("edad del administrador");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ingrese la direccion del administrador");
    }
    public static void crearEmpleados(Scanner scanner, List<Empleados> empleados) {

        System.out.println("Crea un nuevo empleado: ");


        System.out.println("Nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.println("edad del empleado: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Direccion del empleado: ");
        String direccion = scanner.nextLine();

        System.out.println("Numero del contacto del empleado: ");
        long numeroContacto = Long.parseLong(scanner.nextLine());

        System.out.println("Rol del empleado: ");
        String rol = scanner.nextLine();

        System.out.println("Fecha de contratacion: ");
        String fechaContratacion = scanner.nextLine();

        Empleados empleado = new Empleados(nombre, edad, direccion, numeroContacto, rol, fechaContratacion);
        empleados.add(empleado);

        System.out.println("Empleado registrado");

        try {
            File file = new File("TiendaDA.xls");
            Workbook workbook;
            if (file.exists()) {
                FileInputStream fileIn = new FileInputStream(file);
                workbook = WorkbookFactory.create(fileIn);
                fileIn.close();
            } else {
                workbook = new HSSFWorkbook();
            }
            Sheet sheet = workbook.getSheet("Empleados");
            if (sheet == null){
                sheet = workbook.createSheet("Empleados");
            }
            int lastRowNum = sheet.getLastRowNum();
            Row row = sheet.createRow(lastRowNum + 1);
            row.createCell(0).setCellValue(empleado.getNombre());
            row.createCell(1).setCellValue(empleado.getEdad());
            row.createCell(2).setCellValue(empleado.getDireccion());
            row.createCell(3).setCellValue(empleado.getNumeroContacto());
            row.createCell(4).setCellValue(empleado.getRol());
            row.createCell(5).setCellValue(empleado.getFechaContratacion());

            FileOutputStream fileOut = new FileOutputStream("TiendaDA.xls");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Datos guardados en Excel");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void agregarAnimal(Scanner scanner, List<Animal> animalesDisponibles){
        Animal.registrarAnimalDisponible(scanner,animalesDisponibles);
    }

    public void mostrarEmpleado() {

        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Edad del empleado: " + edad);
        System.out.println("Direccion del empleado: " + direccion);
        System.out.println(" Numero de contacto del empleado: " + numeroContacto);
        System.out.println("Rol del empleado: " + rol);
        System.out.println("Fecha de contratación: " + fechaContratacion);
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

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }
}
