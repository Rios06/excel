public class Empleados {
    String nombreEmpleado;
    String rol;
    String fechaContratacion;

    public Empleados(String nombreEmpleado, String rol, String fechaContratacion) {
        this.nombreEmpleado = nombreEmpleado;
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;

    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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

    public void mostrarEmpleado() {
        System.out.println("Nombre del empleado: " + nombreEmpleado);
        System.out.println("Rol del empleado: " + rol);
        System.out.println("Fecha de contratación: " + fechaContratacion);
    }




}