package Usuarios;
import Animales.Animal;
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

    public Empleados(int id, String nombre, int edad, String direccion, long numeroContacto, String rol, String fechaContratacion) {
        super(id, nombre, edad, direccion, numeroContacto);
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
        this.adopciones = new ArrayList<>();
    }


    public void mostrarEmpleado() {
        System.out.println("ID del empleado " + getId());
        System.out.println("Nombre del empleado: " + getNombre());
        System.out.println("Edad del empleado: " + getEdad());
        System.out.println("Direccion del empleado: " + getDireccion());
        System.out.println(" Numero de contacto del empleado: " + getNumeroContacto());
        System.out.println("Rol del empleado: " + rol);
        System.out.println("Fecha de contratación: " + fechaContratacion);
    }


    public void registrarAdopcion(Scanner scanner, List<Adopcion> adopciones, List<Animal> animalesDisponibles) {
        System.out.println("Registrar proceso de adopción:");

        System.out.println("ID del adoptante: ");
        int id = scanner.nextInt();
        scanner.nextLine();

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

        Adopcion adopcion = new Adopcion(id, nombreAdoptante, edadAdoptante, direccionAdoptante, numeroContacto, preferenciaAdopcion, animalAdoptado, fechaAdopcion);
        adopciones.add(adopcion);
        System.out.println("Proceso de adopción registrado con éxito.");
        eliminarAnimalAdoptado(animalesDisponibles, animalAdoptado);
    }

    private void eliminarAnimalAdoptado(List<Animal> animalesDisponibles, String nombreDeAnimal) {
        for (Animal animal : animalesDisponibles) {
            if (animal.getNombre().equals(nombreDeAnimal)) {
                animalesDisponibles.remove(animal);
                break;
            }
        }
    }

    public static void mostrarAnimalesDisponibles(List<Animal>animalesDisponibles) {
        System.out.println("Animales disponibles:");
        for (Animal animal : animalesDisponibles) {
            animal.mostrarAnimalDisponible();

        }
    }

    public void aprobarAdopcion(int idAdopcion) {
        for (Adopcion adopcion : this.adopciones) {
            if (adopcion.getId() == idAdopcion) {
                System.out.println("Adopción aprobada para el adoptante con ID: " + adopcion.getId());
                this.adopciones.remove(adopcion);
                return;
            }
        }
        System.out.println("No se encontró ninguna adopción con el ID proporcionado.");
    }

    public void rechazarAdopcion(int idAdopcion) {
        for (Adopcion adopcion : this.adopciones) {
            if (adopcion.getId() == idAdopcion) {
                System.out.println("Adopción rechazada para el adoptante con ID: " + adopcion.getId());
                this.adopciones.remove(adopcion);
                return;
            }
        }
        System.out.println("No se encontró ninguna adopción con el ID proporcionado.");
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






