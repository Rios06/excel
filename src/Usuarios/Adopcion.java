package Usuarios;

import java.util.ArrayList;
import java.util.List;
import Tools.Menu;
import Animales.Animal;
import Usuarios.Usuario;

public  class Adopcion extends Usuario {
    String preferenciaAdopcion;
    String animalAdoptado;
    String fechaAdopcion;

    public Adopcion(int id, String nombre, int edad, String direccion, long numeroContacto, String preferenciaAdopcion, String animalAdoptado, String fechaAdopcion) {
        super(id, nombre, edad, direccion, numeroContacto);
        this.preferenciaAdopcion = preferenciaAdopcion;
        this.animalAdoptado = animalAdoptado;
        this.fechaAdopcion = fechaAdopcion;
    }



    public void mostrarAdopcion() {
        System.out.println("Datos de la adopción:");
        System.out.println("ID del adoptante: " + id);
        System.out.println("Nombre del adoptante: " + nombre);
        System.out.println("Edad del adoptante: " + edad);
        System.out.println("Dirección: " + direccion);
        System.out.println("Número de contacto: " + numeroContacto);
        System.out.println("Preferencia de adopción: " + preferenciaAdopcion);
        System.out.println("Animales.Animal adoptado: " + animalAdoptado);
        System.out.println("Fecha de adopción: " + fechaAdopcion);
    }

    public String getPreferenciaAdopcion() {
        return preferenciaAdopcion;
    }

    public void setPreferenciaAdopcion(String preferenciaAdopcion) {
        this.preferenciaAdopcion = preferenciaAdopcion;
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

