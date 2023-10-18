
import Animales.Animal;
import Usuarios.Administrador;
import Usuarios.Adopcion;
import Usuarios.Empleados;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
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
    static List<Animal> animalesDisponibles = new ArrayList<>();
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


        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de adopción de animales");

        while (true) {
            System.out.println("Menú:");
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Adoptante");
            System.out.println("2. Usuarios.Administrador");
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
                    Animal.guardarAnimalesEnExcel(animalesDisponibles);
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }

    public static void adoptarMenu(Scanner scanner){
        Empleados empleados = new Empleados(1,"Carlos",25,"Carrera117", 30198765434l,"Cuidador", "22-04-2023");
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
                    Animal.mostrarAnimalesDisponibles();
                    break;
                case 2:
                  empleados.registrarAdopcion(scanner, adopciones, animalesDisponibles);
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
            System.out.println("\nMenú de Usuarios.Administrador:");
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
                    Animal.registrarAnimalDisponible(scanner, animalesDisponibles);
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
                    Empleados.mostrarAnimalesDisponibles(animalesDisponibles);
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


    public static void mostrarEmpleados() {
        System.out.println("Usuarios.Empleados:");
        for (Empleados empleado : empleados) {
            empleado.mostrarEmpleado();
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

                Animal animal = new Animal(raza, especie, nombre, edad, estadoDeSalud, descripcion);
                animalesDisponibles.add(animal);

            }

            fileInputStream.close();
            System.out.println("Datos cargados desde el archivo Excel");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

