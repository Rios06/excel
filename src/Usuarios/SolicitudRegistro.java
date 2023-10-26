package Usuarios;

public class SolicitudRegistro {
    private String nombreUsuario;
    private String contrasena;

    public SolicitudRegistro(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }

}
