package Usuarios;

import Usuarios.Usuario;
import Tools.Menu;
import Animales.Animal;
import java.util.List;
import java.util.Scanner;

public class Administrador extends Usuario {
    String rol;
    String fechaContratacion;
    long clave;

    public Administrador(int id, String nombre, int edad, String direccion, long numeroContacto, long clave) {
        super(id, nombre, edad, direccion, numeroContacto);
        this.clave = clave;
    }

    private static void crearAdministrador (Scanner scanner, List<Administrador>administradores){

        System.out.println("crear un nuevo administrador:");

        System.out.println("id del administrador");
        int id =scanner.nextInt();
        scanner.nextLine();

        System.out.println("nombre del administrador:");
        String nombre = scanner.nextLine();

        System.out.println("edad del administrador");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ingrese la direccion del administrador");
    }
    public static void crearEmpleados(Scanner scanner, List<Empleados> empleados) {

        System.out.println("Crea un nuevo empleado: ");

        System.out.println("Id del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.println("edad del empleado: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Direccion del empleado: ");
        String direccion = scanner.nextLine();

        System.out.println("Numero del contacto del empleado: ");
        long numeroContacto = Long.parseLong(scanner.nextLine());

        System.out.println("Rol del empleado: ");
        String rol = scanner.nextLine();

        System.out.println("Fecha de contratacion: ");
        String fechaContratacion = scanner.nextLine();

        Empleados empleado = new Empleados(id, nombre, edad, direccion, numeroContacto, rol, fechaContratacion);
        empleados.add(empleado);

        System.out.println("Empleado registrado");
    }

    public static void agregarAnimal(Scanner scanner, List<Animal> animalesDisponibles){
        Animal.registrarAnimalDisponible(scanner,animalesDisponibles);
    }

    public void mostrarEmpleado() {
        System.out.println("ID del empleado " + id);
        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Edad del empleado: " + edad);
        System.out.println("Direccion del empleado: " + direccion);
        System.out.println(" Numero de contacto del empleado: " + numeroContacto);
        System.out.println("Rol del empleado: " + rol);
        System.out.println("Fecha de contratación: " + fechaContratacion);
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

    public long getClave() {
        return clave;
    }

    public void setClave(long clave) {
        this.clave = clave;
    }
}
