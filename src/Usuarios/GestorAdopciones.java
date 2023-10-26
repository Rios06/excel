package Usuarios;
import java.util.List;

public class GestorAdopciones {

        public void procesarSolicitudesDeAdopcion(List<Adopcion> adopciones) {
            for (Adopcion adopcion : adopciones) {
                if (adopcion.isDisponible() && adopcion.getAdoptante().isAprovada()) {
                    adopcion.getAnimal().setAdoptado(true);
                    adopcion.setEstado("Aprobado");
                    System.out.println("La solicitud de adopción para el animal " + adopcion.getAnimal().getNombre() + " ha sido aprobada para " + adopcion.getAdoptante().getNombreUsuario());
                } else {
                    adopcion.setEstado("Rechazado");
                    System.out.println("La solicitud de adopción para el animal " + adopcion.getAnimal().getNombre() + " ha sido rechazada para " + adopcion.getAdoptante().getNombreUsuario());
                }
            }
        }
    }

