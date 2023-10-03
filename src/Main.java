
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<AnimaleDisponible> animalesDisponibles = new ArrayList<>();
    static List<Adopcion> adopciones = new ArrayList<>();
    static List<Empleados> empleados = new ArrayList<>();
    public static void main(String[] args) {
        AnimaleDisponible perro1 = new AnimaleDisponible("Pitbull", "Perro", "Dante", 2,"Excelente","Perro amigable", "Pastor aleman", "Perro", "Kleymon", 3,"Muy bien", "Perro entrenado");
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
                    Adopcion.registrarAdopcion(scanner);
                    break;
                case 4:
                    Empleados.mostrarEmpleados();
                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema de adopción de animales. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
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
    }

    public static void mostrarEmpleados() {
        System.out.println("Empleados:");
        for (Empleados empleado : empleados) {
            empleado.mostrarEmpleado();
        }
    }

    public static void mostrarCentroAdopcion() {

        System.out.println("Información del centro de adopción:");
        System.out.println("Nombre: Centro de Adopción de Animales");
        System.out.println("Dirección: Dirección del Centro");
        System.out.println("Teléfono: 123-456-789");
    }
}

