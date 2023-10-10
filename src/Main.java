
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<AnimaleDisponible> animalesDisponibles = new ArrayList<>();
    static List<Adopcion> adopciones = new ArrayList<>();
    static List<Empleados> empleados = new ArrayList<>();
    public static void main(String[] args) {
        cargarDatosDesdeExcel();
        AnimaleDisponible perro1 = new AnimaleDisponible("Pitbull", "Perro", "Dante", 2,"Excelente","Perro amigable", "Pastor aleman", "Perro", "Kleymon", 3,"Muy bien", "Perro entrenado");
        Empleados emple1 = new Empleados("Carlos", "Cuidado perros", "02-05-2020");
        empleados.add(emple1);

        animalesDisponibles.add(perro1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de adopción de animales");

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Registrar un animal disponible");
            System.out.println("2. Mostrar animales disponibles");
            System.out.println("3. Registrar una adopción");
            System.out.println("4. Mostrar empleados");
            System.out.println("5. Mostrar centro de adopción");
            System.out.println("6. Salir");
            System.out.print("Por favor, seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarAnimalDisponible(scanner);
                    break;
                case 2:
                    AnimaleDisponible.mostrarAnimalesDisponibles();
                    mostrarAnimalesDisponibles();
                    break;
                case 3:
                    registrarAdopcion(scanner);
                    break;
                case 4:
                    mostrarEmpleados();
                    break;
                case 5:
                    mostrarCentroAdopcion();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema de adopción de animales. ¡Hasta luego!");
                    guardarAnimalesEnExcel();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }


public static void guardarAnimalesEnExcel(){
  try {
      Workbook workbook = new HSSFWorkbook();
      Sheet sheet = workbook.createSheet("Animales Disponibles");

      Row headerRow = sheet.createRow(0);
      headerRow.createCell(0).setCellValue("Raza");
      headerRow.createCell(1).setCellValue("Especie");
      headerRow.createCell(2).setCellValue("Nombre");
      headerRow.createCell(3).setCellValue("Edad");
      headerRow.createCell(4).setCellValue("Estado de salud");
      headerRow.createCell(4).setCellValue("Descripcion");

      int rowNum = 1;

      for(AnimaleDisponible animal : animalesDisponibles){
          Row row = sheet.createRow(rowNum++);
          row.createCell(0).setCellValue(animal.getRaza());
          row.createCell(1).setCellValue(animal.getEspecie());
          row.createCell(2).setCellValue(animal.getNombre());
          row.createCell(3).setCellValue(animal.getEdad());
          row.createCell(4).setCellValue(animal.getEstadoDeSalud());
          row.createCell(5).setCellValue(animal.getDescripcion());
      }
      FileOutputStream outputStream = new FileOutputStream("AnimalesDisponibles.xlsx");
      workbook.write(outputStream);

      System.out.println("Datos guardados correctamente");
  } catch (Exception e){
      e.printStackTrace();

  }

}
    public static void registrarAnimalDisponible(Scanner scanner) {
        System.out.println("Registrar un animal disponible:");
        System.out.print("Raza: ");
        String raza = scanner.nextLine();

        System.out.print("Especie: ");
        String especie = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Estado de salud: ");
        String estadoDeSalud = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        AnimaleDisponible animal = new AnimaleDisponible(raza, especie, nombre, edad, estadoDeSalud, descripcion,raza, especie, nombre, edad, estadoDeSalud, descripcion);
        animalesDisponibles.add(animal);
        guardarAnimalesEnExcel();
        System.out.println("Animal registrado con éxito.");
    }

    public static void mostrarAnimalesDisponibles() {
        System.out.println("Animales disponibles:");
        for (AnimaleDisponible animal : animalesDisponibles) {
            animal.mostrarAnimalDisponible();

        }

    }

    public static void registrarAdopcion(Scanner scanner) {
        System.out.println("Registrar una adopción:");
        System.out.print("Nombre del adoptante: ");
        String nombreAdoptante = scanner.nextLine();

        System.out.print("Dirección del adoptante: ");
        String direccion = scanner.nextLine();

        System.out.print("Número de contacto del adoptante: ");
        long numeroContacto = Long.parseLong(scanner.nextLine());

        System.out.print("Preferencia de adopción: ");
        String preferenciaAdopcion = scanner.nextLine();

        System.out.print("Información del adoptante: ");
        String infAdoptante = scanner.nextLine();

        System.out.print("Animal adoptado: ");
        String animalAdoptado = scanner.nextLine();

        System.out.print("Fecha de adopción: ");
        String fechaAdopcion = scanner.nextLine();


        Adopcion adopcion = new Adopcion(nombreAdoptante, direccion, numeroContacto, preferenciaAdopcion, infAdoptante, animalAdoptado, fechaAdopcion);
        adopciones.add(adopcion);
        System.out.println("Adopción registrada con éxito.");
        eliminarAnimalAdoptado(animalAdoptado);
    }

    public static void mostrarEmpleados() {
        System.out.println("Empleados:");
        for (Empleados empleado : empleados) {
            empleado.mostrarEmpleado();
        }
    }

    public static void eliminarAnimalAdoptado(String nombreDeAnimal){
        for (AnimaleDisponible animal : animalesDisponibles) {
            if(animal.getNombre().equals(nombreDeAnimal)){
                animalesDisponibles.remove(animal);
                break;
            }
        }
    }

    public static void mostrarCentroAdopcion() {

        System.out.println("Información del centro de adopción:");
        System.out.println("Nombre: Centro de Adopción de Animales");
        System.out.println("Dirección: Carrera117 Calle 39D");
        System.out.println("Teléfono: 31209436869");
    }

    public static void cargarDatosDesdeExcel(){
        try {
            FileInputStream fileInputStream = new FileInputStream("AnimalesDisponibles.xlsx");
            Workbook workbook = new HSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet("Animales Disponibles");

            for (Row row : sheet){
                if(row.getRowNum() == 0)continue;
                String raza = row.getCell(0).getStringCellValue();
                String especie = row.getCell(1).getStringCellValue();
                String nombre = row.getCell(2).getStringCellValue();
                int edad = (int) row.getCell(3).getNumericCellValue();
                String estadoDeSalud = row.getCell(4).getStringCellValue();
                String descripcion = row.getCell(5).getStringCellValue();

                AnimaleDisponible animal = new AnimaleDisponible(raza, especie, nombre, edad,
                        estadoDeSalud, descripcion, raza, especie, nombre , edad , estadoDeSalud, descripcion);
                animalesDisponibles.add(animal);

            }

            fileInputStream.close();
            System.out.println("Datos cargados desde el archivo Excel");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

