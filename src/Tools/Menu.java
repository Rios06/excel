package Tools;

import Animales.Animal;
import Usuarios.Administrador;
import Usuarios.Adoptante;
import Usuarios.Empleados;
import Usuarios.SolicitudRegistro;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void adoptarMenu(Scanner scanner, List<Animal> animalesDisponibles, List<SolicitudRegistro> solicitudesDeRegistro, List<Adoptante> adoptantes){

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


        while (true){
            System.out.println("\nMenú de Adoptante:");
            System.out.println("1. Ver animales disponibles");
            System.out.println("2. Buscar animal por caracteristicas especificas");
            System.out.println("3. Solicitar proceso de adopcion");
            System.out.println("4. Volver al menú principal");
            System.out.print("Por favor, seleccione una opción: ");

            int adoptarOpcion = scanner.nextInt();
            scanner.nextLine();

            switch (adoptarOpcion) {
                case 1:
                    Animal.mostrarAnimalesDisponibles(animalesDisponibles);
                    break;
                case 2:
                    buscarAnimalesDisponibles(scanner, animalesDisponibles);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void administradorMenu(Scanner scanner, List<Empleados> empleados, List<Animal> animalesDisponibles) {
        while (true) {
            System.out.println("\nMenú de Usuarios.Administrador:");
            System.out.println("1. Crear empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Editar empleado");
            System.out.println("5. Crear animal disponible");
            System.out.println("6. Eliminar Animal");
            System.out.println("7. Editar Animal");
            System.out.println("8. Volver al menú principal");
            System.out.print("Por favor, seleccione una opción: ");

            int adminOption = scanner.nextInt();
            scanner.nextLine();

            switch (adminOption) {
                case 1:
                    Administrador.crearEmpleados(scanner, empleados);
                    break;
                case 2:
                    mostrarEmpleados(empleados);
                    break;
                case 3:
                    Excel.eliminarEmpleados(scanner,empleados);
                    break;
                case 4:
                    Excel.editarEmpleados(scanner,empleados);
                    break;
                case 5:
                    Administrador.agregarAnimal(scanner,animalesDisponibles);
                    break;
                case 6:
                    Excel.eliminarAnimalDisponible(scanner,animalesDisponibles);
                    return;
                case 7:
                    Excel.editarAnimalDisponible(scanner,animalesDisponibles);
                    return;
                case 8:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    public static void empleadoMenu(Scanner scanner, List<Animal> animalesDisponibles, List<SolicitudRegistro> solicitudesDeRegistro, List<Adoptante> adoptantes) {
        Empleados empleado = new Empleados( 8,"Carlos", 25, "Carrera117", 30198765434l, "Cuidador", "22-04-2023");
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

    public static void mostrarEmpleados(List<Empleados> empleados) {
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


}
