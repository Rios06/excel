public class Empleados extends Usuario {
    String rol;
    String fechaContratacion;

    public Empleados(int id, String nombre, int edad, String direccion, long numeroContacto, String rol, String fechaContratacion) {
        super(id, nombre, edad, direccion, numeroContacto);
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
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




}