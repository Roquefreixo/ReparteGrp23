import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Grupo {
    private String nombre;
    private String fotoPerfil;
    private Usuario liderGrupo;
    private List<Usuario> participantes;

    // Constructor
    public Grupo(String nombre, String fotoPerfil, Usuario liderGrupo) {
        if (nombre == null || fotoPerfil == null || liderGrupo == null) {
            throw new IllegalArgumentException("El nombre, la foto de perfil y el líder del grupo no pueden ser nulos.");
        }

        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.liderGrupo = liderGrupo;
        this.participantes = new ArrayList<>();
    }


    // Añadir usuario a grupo
    public Boolean addUserGrp(Usuario usuario) {
        if (participantes.contains(usuario)) {
            System.out.println("El usuario ya pertenece al grupo.");
            return false;
        } else {
            participantes.add(usuario);
            System.out.println("Usuario añadido al grupo.");
            return true;
        }
    }

    // Eliminar usuario del grupo
    public Boolean deleteUserGrp(Usuario usuario) {
        if (participantes.contains(usuario)) {
            participantes.remove(usuario);
            System.out.println("Usuario eliminado del grupo.");
            return true;
        } else {
            System.out.println("El usuario no pertenece al grupo.");
            return false;
        }
    }
    
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    private void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Usuario getLiderGrupo() {
        return liderGrupo;
    }

    private void setLiderGrupo(Usuario liderGrupo) {
        this.liderGrupo = liderGrupo;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    private void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

}
