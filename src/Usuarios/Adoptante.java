package Usuarios;
import java.util.List;
import java.util.Scanner;
import Animales.Animal;

public class Adoptante extends Usuario{
    private String nombreUsuario;
    private String contrasena;
    private boolean isAprovada;
    private int id;
    private static int idCounter = 1;

    public Adoptante(int id,String nombreUsuario,String contrasena, int edad, String direccion, long numeroContacto) {
        super( nombreUsuario, edad, direccion, numeroContacto);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.isAprovada = false;
        this.id = id;
        idCounter++;
    }

    @Override
    public int getId() {
        return id;
    }


    public void solicitarAdopcion(Animal animal, List<Adopcion> adopciones) {
        Adopcion solicitudAdopcion = new Adopcion(this, animal); //  la clase Adopcion toma un Adoptante y un Animal como parámetros en su constructor
        adopciones.add(solicitudAdopcion);
        System.out.println("Solicitud de adopción realizada con éxito para el animal: " + animal.getNombre());
    }
    public boolean isAprovada() {
        return isAprovada;
    }

    public void setAprovada(boolean aprovada) {
        isAprovada = aprovada;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }



}
