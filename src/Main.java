
import Animales.Animal;
import Usuarios.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import Usuarios.SolicitudRegistro;
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
    static List<Adoptante> adoptantes = new ArrayList<>();
    static List<SolicitudRegistro>solicitudesDeRegistro = new ArrayList<>();
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
        System.out.println("¿Desea registrarse como nuevo adoptante? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Nombre de usuario: ");
            String nuevoNombreUsuario = scanner.nextLine();
            System.out.print("Contraseña: ");
            String nuevaContrasena = scanner.nextLine();

            // Guardar la solicitud de registro
            SolicitudRegistro solicitud = new SolicitudRegistro(nuevoNombreUsuario, nuevaContrasena);
            solicitudesDeRegistro.add(solicitud);
            System.out.println("Solicitud de registro enviada para aprobación.");
            return;
        }


        // Lógica de inicio de sesión para adoptantes
        System.out.println("Por favor, ingrese su información de inicio de sesión:");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        Adoptante adoptanteEncontrado = null;

        // Verificar si el adoptante está registrado
        for (Adoptante adoptante : adoptantes) {
            if (adoptante.getNombreUsuario().equals(nombreUsuario) && adoptante.getContrasena().equals(contrasena) && adoptante.isAprovada()) {
                adoptanteEncontrado = adoptante;
                break;
            }
        }

        // Si no está registrado, mostrar un mensaje de error y salir del menú
        if (adoptanteEncontrado == null) {
            System.out.println("Usuario no encontrado o no aprobado. Acceso denegado.");
            return;
        }

        // Si está registrado, permitir el acceso al menú de opciones
        System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + adoptanteEncontrado.getNombre() + "!");

        // Acceso a la función de búsqueda de animales disponibles solo para adoptantes registrados
        buscarAnimalesDisponibles(scanner, animalesDisponibles);

        while (true){
            System.out.println("\nMenú de Adoptante:");
            System.out.println("1. Ver animales disponibles");
            System.out.println("2. Registro para adoptante");
            System.out.println("3. Volver al menú principal");
            System.out.print("Por favor, seleccione una opción: ");

            int adoptarOpcion = scanner.nextInt();
            scanner.nextLine();

            switch (adoptarOpcion) {
                case 1:
                    Animal.mostrarAnimalesDisponibles();
                    break;
                case 2:
                  empleados.registrarAdopcion(scanner, adopciones, animalesDisponibles, adoptanteEncontrado);
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
                   Administrador.agregarAnimal(scanner,animalesDisponibles);
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
        Empleados empleado = new Empleados(1, "Carlos", 25, "Carrera117", 30198765434l, "Cuidador", "22-04-2023");
        while (true) {
            System.out.println("\nMenú de Empleado:");
            System.out.println("1. Ver animales disponibles");
            System.out.println("2. Ver procesos de adopción");
            System.out.println("3. Aprovar registro adoptantes");
            System.out.println("4. Aprovar adopcion");
            System.out.println("5. Denegar adopcion");
            System.out.println("6. Volver al menú principal");
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
                    Empleados.aprobarRegistro(scanner,solicitudesDeRegistro,adoptantes);
                    return;
                case 4:

                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void buscarAnimalesDisponibles(Scanner scanner, List<Animal> animalesDisponibles) {
        System.out.println("Búsqueda de animales disponibles:");
        System.out.print("Especie: ");
        String especieBusqueda = scanner.nextLine();

        System.out.print("Raza: ");
        String razaBusqueda = scanner.nextLine();

        System.out.print("Estado de salud: ");
        String estadoSaludBusqueda = scanner.nextLine();

        boolean animalesEncontrados = false;

        for (Animal animal : animalesDisponibles) {
            if (animal.getEspecie().equalsIgnoreCase(especieBusqueda) &&
                    animal.getRaza().equalsIgnoreCase(razaBusqueda) &&
                    animal.getEstadoDeSalud().equalsIgnoreCase(estadoSaludBusqueda)) {
                animal.mostrarAnimalDisponible();
                animalesEncontrados = true;
            }
        }

        if (!animalesEncontrados) {
            System.out.println("No se encontraron animales que coincidan con los criterios de búsqueda.");
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

