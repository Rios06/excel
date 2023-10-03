import java.util.Scanner;

public  class Adopcion {
    String nombreAdoptante;
    String direccion;
    long numeroContacto;
    String preferenciaAdopcion;
    String infAdoptante;
    String animalAdoptado;
    String fechaAdopcion;

    public Adopcion(String nombreAdoptante, String direccion, long numeroContacto, String preferenciaAdopcion, String infAdoptante, String animalAdoptado, String fechaAdopcion) {
        this.nombreAdoptante = nombreAdoptante;
        this.direccion = direccion;
        this.numeroContacto = numeroContacto;
        this.preferenciaAdopcion = preferenciaAdopcion;
        this.infAdoptante = infAdoptante;
        this.animalAdoptado = animalAdoptado;
        this.fechaAdopcion = fechaAdopcion;
    }

    public static  void registrarAdopcion(Scanner adopciones){
        System.out.println("Registra adopcion:");


    }

    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    public void setNombreAdoptante(String nombreAdoptante) {
        this.nombreAdoptante = nombreAdoptante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(long numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getPreferenciaAdopcion() {
        return preferenciaAdopcion;
    }

    public void setPreferenciaAdopcion(String preferenciaAdopcion) {
        this.preferenciaAdopcion = preferenciaAdopcion;
    }

    public String getInfAdoptante() {
        return infAdoptante;
    }

    public void setInfAdoptante(String infAdoptante) {
        this.infAdoptante = infAdoptante;
    }

    public String getAnimalAdoptado() {
        return animalAdoptado;
    }

    public void setAnimalAdoptado(String animalAdoptado) {
        this.animalAdoptado = animalAdoptado;
    }

    public String getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(String fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }


}

