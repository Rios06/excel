package Usuarios;

import java.util.ArrayList;
import java.util.List;
import Tools.Menu;
import Animales.Animal;
import Usuarios.Usuario;

public  class Adopcion{

private String estado;
private Adoptante adoptante;
private Animal animal;

    public Adopcion(Adoptante adoptante, Animal animal) {
        this.adoptante = adoptante;
        this.animal = animal;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public Animal getAnimal() {
        return animal;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }
}

