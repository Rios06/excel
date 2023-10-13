
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static List<AnimaleDisponible> animalesDisponibles = new ArrayList<>();
    static List<Adopcion> adopciones = new ArrayList<>();
    static List<Empleados> empleados = new ArrayList<>();
    public static void main(String[] args) {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("C:/Log/MyLog.log" ,true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e){
            logger.log(Level.WARNING, "ERROR al configurar el logger" , e);
        }
        cargarDatosDesdeExcel();
        AnimaleDisponible perro1 = new AnimaleDisponible("Pitbull", "Perro", "Dante", 2,"Excelente","Perro amigable", "Pastor aleman", "Perro", "Kleymon", 3,"Muy bien", "Perro entrenado");
        Empleados emple1 = new Empleados(1,"Juan" ,8,"Carrera117",  3098765434l,"Cuidado perros", "02-05-2020");
        empleados.add(emple1);

        animalesDisponibles.add(perro1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de adopción de animales");

        while (true) {
            System.out.println("Menú:");
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Adoptante");
            System.out.println("2. Administrador");
            System.out.println("3. Empleado");
            System.out.println("4. informacion centro de adopcion");
            System.out.println("5. Salir");
            System.out.print("Por favor, seleccione su tipo de usuario: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    adoptarMenu(scanner);
                    break;
                case 2:
                    administradorMenu(scanner);
                    break;
                case 3:
                    empleadoMenu(scanner);
                    break;
                case 4:
                    mostrarCentroAdopcion();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de adopción de animales. ¡Hasta luego!");
                    guardarAnimalesEnExcel();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }

    public static void adoptarMenu(Scanner scanner){
        while (true){
            System.out.println("\nMenú de Adoptante:");
            System.out.println("1. Ver animales disponibles");
            System.out.println("2. Realizar proceso de adopción");
            System.out.println("3. Volver al menú principal");
            System.out.print("Por favor, seleccione una opción: ");

            int adoptarOpcion = scanner.nextInt();
            scanner.nextLine();

            switch (adoptarOpcion) {
                case 1:
                    mostrarAnimalesDisponibles();
                    break;
                case 2:
                    registrarAdopcion(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void administradorMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú de Administrador:");
            System.out.println("1. Crear empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Crear animal disponible");
            System.out.println("4. Aprobar adopción");
            System.out.println("5. Rechazar adopción");
            System.out.println("6. Volver al menú principal");
            System.out.print("Por favor, seleccione una opción: ");

            int adminOption = scanner.nextInt();
            scanner.nextLine();

            switch (adminOption) {
                case 1:
                    Administrador.crearEmpleados(scanner, empleados);
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    registrarAnimalDisponible(scanner);
                    break;
                case 4:
                    // metodo para aprobar adopción
                    break;
                case 5:
                    // metodo para rechazar adopción
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void empleadoMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nMenú de Empleado:");
            System.out.println("1. Ver animales disponibles");
            System.out.println("2. Ver procesos de adopción");
            System.out.println("3. Volver al menú principal");
            System.out.print("Por favor, seleccione una opción: ");

            int employeeOption = scanner.nextInt();
            scanner.nextLine();

            switch (employeeOption) {
                case 1:
                    mostrarAnimalesDisponibles();
                    break;
                case 2:
                    // metodo para ver procesos de adopción
                    break;
                case 3:
                    return;
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
     logger.log(Level.SEVERE, "ERROR al guardar datos" , e);

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

        System.out.println("ID del adoptante: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre del adoptante: ");
        String nombre = scanner.nextLine();

        System.out.println("Edad del adoptante: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Dirección del adoptante: ");
        String direccion = scanner.nextLine();

        System.out.print("Número de contacto del adoptante: ");
        long numeroContacto = Long.parseLong(scanner.nextLine());

        System.out.print("Preferencia de adopción: ");
        String preferenciaAdopcion = scanner.nextLine();

        System.out.print("Nombre del animal que desea adoptar: ");
        String animalAdoptado = scanner.nextLine();

        System.out.print("Fecha de adopción: ");
        String fechaAdopcion = scanner.nextLine();


        Adopcion adopcion = new Adopcion(id , nombre , edad, direccion, numeroContacto ,preferenciaAdopcion, animalAdoptado, fechaAdopcion );
        adopciones.add(adopcion);
        System.out.println("Proceso de adopción registrado con éxito.");
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

