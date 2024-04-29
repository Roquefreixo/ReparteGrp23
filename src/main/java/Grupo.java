import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Grupo {
    private String nombre;
    private String fotoPerfil;
    private Usuario liderGrupo;
    private List<Usuario> participantes;
    private Map<Usuario, Double> montos;
    private List<Gastos> gastos;

    // Constructor
    public Grupo(String nombre, String fotoPerfil, Usuario liderGrupo,List<Usuario> participantes) {
        if (nombre == null || fotoPerfil == null || liderGrupo == null) {
            throw new IllegalArgumentException("El nombre, la foto de perfil y el líder del grupo no pueden ser nulos.");
        }

        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.liderGrupo = liderGrupo;
        this.participantes = new ArrayList<>();
        this.montos = new HashMap<>();
        // Inicializar montos para cada participante con 0
        for (Usuario participante : participantes) {
            this.montos.put(participante, 0.0);
        }

    }


    // Añadir usuario a grupo
    public Boolean addUserGrp(Usuario usuario) {
        if (participantes.contains(usuario)) {
            System.out.println("El usuario ya pertenece al grupo.");
            return false;
        } else {
            participantes.add(usuario);
            this.montos.put(usuario, 0.0);
            System.out.println("Usuario añadido al grupo.");
            return true;
        }
    }

    // Eliminar usuario del grupo
    public Boolean deleteUserGrp(Usuario usuario) {
        if (!participantes.contains(usuario)) {
            System.out.println("El usuario no pertenece al grupo.");
            return false;
        } else if (this.montos.get(usuario) != 0.0) {
            System.out.println("El usuario tiene deudas o haberes dentro del grupo.");
            return false;
        } else {
            participantes.remove(usuario);
            this.montos.remove(usuario);
            System.out.println("Usuario eliminado del grupo.");
            return true;
        }
    }
    
    
    // Método para añadir un gasto
       public void añadirGasto(Grupo grupo, Usuario usuarioQueHaPagado, List<Usuario> listaDeUsuariosPagadores,
               double monto, String descripcion, Date fecha, String actividad) {
           Gastos gasto = new Gastos(grupo, usuarioQueHaPagado, listaDeUsuariosPagadores, monto, descripcion, fecha, actividad);
           gasto.calcularHaberesDeberes(this.montos);
           gastos.add(gasto);
        // Imprimir las deudas o haberes de cada usuario
           System.out.println("Deudas/Haberes de cada usuario:");
           calcularTransaccionesMinimas();
           /*for (Map.Entry<Usuario, Double> entry : montos.entrySet()) {
               Usuario usuario = entry.getKey();
               Double deudaHaber = entry.getValue();
               System.out.println(usuario.getNombreApellidos() + ": " + deudaHaber);
           }*/
       }
       
       // Función para calcular transacciones mínimas
       public void calcularTransaccionesMinimas() {
           List<String> transacciones = new ArrayList<>();
           List<Usuario> participantes = new ArrayList<>(montos.keySet());
           // Mientras haya deudas pendientes
           while (!todosLosMontosSonCero(montos)) {
               // Encontrar el deudor y el acreedor con la mayor deuda y el mayor haber
               Usuario deudor = null;
               Usuario acreedor = null;
               double maxDeuda = Double.MIN_VALUE;
               double maxHaber = Double.MIN_VALUE;
               for (Usuario participante : participantes) {
                   double monto = montos.get(participante);
                   if (monto < 0 && monto < maxDeuda) {
                       deudor = participante;
                       maxDeuda = monto;
                   } else if (monto > 0 && monto > maxHaber) {
                       acreedor = participante;
                       maxHaber = monto;
                   }
               }

               // Realizar la transacción entre el deudor y el acreedor
               double transaccion = Math.min(-maxDeuda, maxHaber);
               montos.put(deudor, montos.get(deudor) + transaccion);
               montos.put(acreedor, montos.get(acreedor) - transaccion);

               // Agregar la transacción a la lista de transacciones mínimas
               transacciones.add(deudor.getNombreApellidos() + " paga " + transaccion + " a " + acreedor.getNombreApellidos());
           }

           // Imprimir las transacciones mínimas
           for (String transaccion : transacciones) {
               System.out.println(transaccion);
           }
       }

       // Función auxiliar para verificar si todos los montos en el mapa son cero
       private boolean todosLosMontosSonCero(Map<Usuario, Double> montos) {
           for (double monto : montos.values()) {
               if (monto != 0.0) {
                   return false;
               }
           }
           return true;
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
