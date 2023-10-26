
import Animales.Animal;
import Tools.Menu;
import Usuarios.*;

import Usuarios.SolicitudRegistro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import Tools.Excel;
public class Main {
    //Los Array en lista para agregar mis datos al tamaño que le ingrese
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    static List<Animal> animalesDisponibles = new ArrayList<>();
     static List<Empleados> empleados = new ArrayList<>();
    static List<Adoptante> adoptantes = new ArrayList<>();
    static List<SolicitudRegistro>solicitudesDeRegistro = new ArrayList<>();
    static List<Administrador>administradores = new ArrayList<>();
    static List<Adopcion> adopciones = new ArrayList<>();
    public static void main(String[] args) {
        Administrador UnicoAdministrador = new Administrador("cualquiera", 20, "calle39Dcrr117", 1234567890, "4910247", "RRR",6);
        administradores.add(UnicoAdministrador);
        Excel.cargarEmpleadosDesdeExcel(empleados);
        Excel.cargarAdoptanteDesdeExcel(adoptantes);
        Excel.cargarAnimalesDesdeExcel(animalesDisponibles);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de adopción de animales");

        while (true) {
            System.out.println("Menú:");
            System.out.println("Seleccione el tipo de usuario:");
            System.out.println("1. Usuarios-Adoptante");
            System.out.println("2. Administrador");
            System.out.println("3. Empleado");
            System.out.println("4. informacion centro de adopcion");
            System.out.println("5. Salir");
            System.out.print("Por favor, seleccione su tipo de usuario: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Menu.adoptarMenu(scanner,animalesDisponibles,solicitudesDeRegistro,adoptantes);
                    break;
                case 2:
                    Menu.administradorMenu(scanner, empleados,animalesDisponibles,administradores);
                    break;
                case 3:
                    Menu.empleadoMenu(scanner,animalesDisponibles,solicitudesDeRegistro,adoptantes);
                    break;
                case 4:
                    Menu.mostrarCentroAdopcion();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de adopción de animales. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }
    public static void procesarSolicitudesDeAdopcion(Scanner scanner, List<Adopcion> adopciones) {
        System.out.println("Solicitudes de adopción pendientes:");
        for (Adopcion adopcion : adopciones) {
            System.out.println("Adoptante: " + adopcion.getAdoptante().getNombre() + " - Animal: " + adopcion.getAnimal().getNombre());
        }

        System.out.println("Ingrese el nombre del adoptante y el nombre del animal que desea aprobar o denegar:");
        String nombreAdoptante = scanner.nextLine();
        String nombreAnimal = scanner.nextLine();

        for (Adopcion adopcion : adopciones) {
            if (adopcion.getAdoptante().getNombre().equals(nombreAdoptante) && adopcion.getAnimal().getNombre().equals(nombreAnimal)) {
                System.out.println("¿Aprobar adopción? (si/no)");
                String respuesta = scanner.nextLine();
                if (respuesta.equalsIgnoreCase("si")) {
                    adopcion.setEstado("Aprobado");
                    System.out.println("Adopción aprobada para el adoptante: " + adopcion.getAdoptante().getNombre() + " y el animal: " + adopcion.getAnimal().getNombre());
                } else {
                    adopcion.setEstado("Denegado");
                    System.out.println("Adopción denegada para el adoptante: " + adopcion.getAdoptante().getNombre() + " y el animal: " + adopcion.getAnimal().getNombre());
                }
                return;
            }
        }
    }
    }


