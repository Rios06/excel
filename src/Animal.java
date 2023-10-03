public class Animal {

    private String raza;
    private String especie;
    private String nombre;
    private int edad;
    private String estadoDeSalud;
    private String descripcion;

    public Animal(String raza, String especie, String nombre, int edad, String estadoDeSalud, String descripcion) {
        this.raza = raza;
        this.especie = especie;
        this.nombre = nombre;
        this.edad = edad;
        this.estadoDeSalud = estadoDeSalud;
        this.descripcion = descripcion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstadoDeSalud() {
        return estadoDeSalud;
    }

    public void setEstadoDeSalud(String estadoDeSalud) {
        this.estadoDeSalud = estadoDeSalud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
