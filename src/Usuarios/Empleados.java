package Usuarios;
import Animales.Animal;
import Usuarios.*;
import Usuarios.Adopcion;
import Usuarios.Usuario;
import Tools.Menu;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Empleados extends Usuario {
   private String rol;
   private String fechaContratacion;

    private List<Adopcion> adopciones;

    public Empleados( String nombre, int edad, String direccion, long numeroContacto, String rol, String fechaContratacion) {
        super( nombre, edad, direccion, numeroContacto);
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
        this.adopciones = new ArrayList<>();
    }


    public void mostrarEmpleado() {
        System.out.println("Nombre del empleado: " + getNombre());
        System.out.println("Edad del empleado: " + getEdad());
        System.out.println("Direccion del empleado: " + getDireccion());
        System.out.println(" Numero de contacto del empleado: " + getNumeroContacto());
        System.out.println("Rol del empleado: " + rol);
        System.out.println("Fecha de contratación: " + fechaContratacion);
    }


    public void registrarAdopcion(Scanner scanner, List<Adopcion> adopciones, List<Animal> animalesDisponibles, Adoptante adoptanteEncontrado) {
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

        System.out.print("Fecha de adopción: ");
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



    public static void mostrarAnimalesDisponibles(List<Animal>animalesDisponibles) {
        System.out.println("Animales disponibles:");
        for (Animal animal : animalesDisponibles) {
            animal.mostrarAnimalDisponible();

        }
    }

    public void aprobarAdopcion(Adopcion adopcion) {
        adopcion.setEstado("Aprobado");
        System.out.println("Adopción aprobada para el adoptante: " + adopcion.getAdoptante().getNombre() + " y el animal: " + adopcion.getAnimal().getNombre());

    }

    public void confirmarAdopcion(Adopcion adopcion) {
        adopcion.setEstado("Confirmado");
        adopcion.getAnimal().setDisponible(false);
        System.out.println("Adopción confirmada para el adoptante: " + adopcion.getAdoptante().getNombre() + " y el animal: " + adopcion.getAnimal().getNombre());

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
                System.out.println("Contraseña del nuevo adoptante: ");
                String nuevaContrasena = scanner.nextLine();
                System.out.println("Edad del nuevo adoptante: ");
                int edadNuevoAdoptante = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Dirección del nuevo adoptante: ");
                String direccionNuevoAdoptante = scanner.nextLine();
                System.out.println("Número de contacto del nuevo adoptante: ");
                long numeroContactoNuevoAdoptante = Long.parseLong(scanner.nextLine());

                Adoptante adoptanteNuevo = new Adoptante( solicitud.getNombreUsuario(), nuevaContrasena, edadNuevoAdoptante, direccionNuevoAdoptante, numeroContactoNuevoAdoptante);
                adoptanteNuevo.setAprovada(true);
                adoptantes.add(adoptanteNuevo);
                System.out.println("Adoptante aprobado y registrado exitosamente.");
                solicitudesDeRegistro.remove(solicitud);
                return;
            }
        }
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






