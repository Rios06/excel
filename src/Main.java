
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
    public static void main(String[] args) {
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
                    Menu.administradorMenu(scanner, empleados,animalesDisponibles);
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

    }


