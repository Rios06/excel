package Usuarios;
import Animales.Animal;
public  class Adopcion{
private boolean disponible;
private String estado;
private Adoptante adoptante;
private Animal animal;
//Hacer logica para que algun adoptante adopte
    public Adopcion(Adoptante adoptante, Animal animal) {
        this.adoptante = adoptante;
        this.animal = animal;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

