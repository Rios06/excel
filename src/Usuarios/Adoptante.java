package Usuarios;
import java.util.List;
import java.util.Scanner;
import Animales.Animal;

public class Adoptante extends Usuario{
    private String nombreUsuario;
    private String contrasena;
    private boolean isAprovada;

    public Adoptante(int id, String nombreUsuario,String contrasena, int edad, String direccion, long numeroContacto) {
        super(id, nombreUsuario, edad, direccion, numeroContacto);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.isAprovada = false;
    }

    public static void registrarAdoptante(Scanner scanner, List<Adoptante> adoptantes) {
        System.out.println("registrar adoptante");

        System.out.println("Id");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Número de contacto: ");
        long numeroContacto = Long.parseLong(scanner.nextLine());

        Adoptante adoptante = new Adoptante(id,nombreUsuario,contrasena, edad, direccion, numeroContacto);
        adoptantes.add(adoptante);
        System.out.println("Animales.Animal registrado con éxito.");
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



    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
