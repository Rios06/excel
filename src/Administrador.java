import java.util.List;
import java.util.Scanner;

public class Administrador extends Usuario {
    long clave;

    public Administrador(int id, String nombre, int edad, String direccion, long numeroContacto, long clave) {
        super(id, nombre, edad, direccion, numeroContacto);
        this.clave = clave;
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
}