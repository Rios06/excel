public class AnimaleDisponible extends Animal{
    String raza;
    String especie;
    String nombre;
    int edad;
    String estadoDeSalud;
    String descripcion;


    public AnimaleDisponible(String raza, String especie, String nombre, int edad, String estadoDeSalud, String descripcion, String raza1, String especie1, String nombre1, int edad1, String estadoDeSalud1, String descripcion1) {
        super(raza, especie, nombre, edad, estadoDeSalud, descripcion);
        this.raza = raza1;
        this.especie = especie1;
        this.nombre = nombre1;
        this.edad = edad1;
        this.estadoDeSalud = estadoDeSalud1;
        this.descripcion = descripcion1;
    }

    public void mostrarAnimalDisponible() {
        System.out.println("ANIMAL DISPONIBLE " + getNombre() + ", Raza " + getRaza() + ", Edad " + getEdad() + ", Estado de salud " + getEstadoDeSalud() + ", Descripción " + getDescripcion());
    }

    public static void mostrarAnimalesDisponibles() {
        System.out.println("Animales disponibles:");

    }

}