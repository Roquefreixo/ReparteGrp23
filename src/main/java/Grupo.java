import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private Map<Usuario, Usuario> transaccion;//primer usuario le debe al segundo
    private List<Gastos> gastos;
    private List<Actividad> calendarioActividades;

    // Constructor
    public Grupo(String nombre, String fotoPerfil, Usuario liderGrupo,List<Usuario> participantes) {
        if (nombre == null || fotoPerfil == null || liderGrupo == null) {
            throw new IllegalArgumentException("El nombre, la foto de perfil y el líder del grupo no pueden ser nulos.");
        }

        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.liderGrupo = liderGrupo;
        if(participantes!=null) {
        	if(!participantes.contains(liderGrupo)){
                throw new IllegalArgumentException("El lider del grupo tiene que ser un participante");
              }
        	this.participantes = participantes;
        }else {
        	this.participantes = new ArrayList<>();
            this.participantes.add(liderGrupo);
        }
        
        
          
        
        this.montos = new HashMap<>();
        this.transaccion=new HashMap<>();
        // Inicializar montos para cada participante con 0

        if(this.participantes.size()>0) {
	      for (Usuario participante : this.participantes) {
	         this.montos.put(participante, 0.0);
	      }
        }

        this.gastos=new ArrayList<>();
        this.calendarioActividades= new ArrayList<>();
    }


    // Añadir usuario a grupo
    public Boolean addUserGrp(Usuario usuario) {
    	if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
    	
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
    	if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
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
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto del gasto debe ser mayor que 0.");
        }

        if (usuarioQueHaPagado == null) {
            throw new IllegalArgumentException("El usuario que ha pagado el gasto no puede ser nulo.");
        }
        if (listaDeUsuariosPagadores.isEmpty()) {
            throw new IllegalArgumentException("La lista de usuarios pagadores no puede estar vacía.");
        }
        if (!grupo.getParticipantes().contains(usuarioQueHaPagado)) {
            throw new IllegalArgumentException("El usuario que ha pagado no pertenece al grupo.");
        }
        for (Usuario deudor : listaDeUsuariosPagadores) {
            if (!grupo.getParticipantes().contains(deudor)) {
                throw new IllegalArgumentException("Los deudores especificados no están en el grupo.");
            }
        }
        Gastos gasto = new Gastos(grupo, usuarioQueHaPagado, listaDeUsuariosPagadores, monto, descripcion, fecha, actividad);
        gastos.add(gasto);

        // Imprimir las deudas o haberes de cada usuario
        
        
        monto= monto/ gasto.getListaDeUsuariosPagadores().size();
        for (Usuario usuario : gasto.getListaDeUsuariosPagadores()) {
            if (usuario.equals(gasto.getUsuarioQueHaPagado())) {
                montos.put(usuario, montos.getOrDefault(usuario, 0.0) + monto);
            } else {
                montos.put(usuario, montos.getOrDefault(usuario, 0.0) - monto);
                List<String> mensajes = new ArrayList<>();
                mensajes.add(usuario.getNombreApellidos() + " le debe "+ monto+ " a "+ usuarioQueHaPagado.getNombreApellidos());
                usuario.setMensajes(mensajes);
                
                
            }
            
        }
        
        
        //System.out.println("Se le debe "+ monto+ " a "+ usuarioQueHaPagado.getNombreApellidos());
        
        //calcularTransaccionesMinimas();
    }

     /*  
    public void calcularTransaccionesMinimas() {
        List<String> transacciones = new ArrayList<>();
        Map<Usuario, Double> montosCopiados = new HashMap<>(montos);
        
        // Mientras haya deudas pendientes
        while (!todosLosMontosSonCero(montosCopiados)) {
            // Encontrar el deudor y el acreedor con la mayor deuda y el mayor haber
            Usuario deudor = null;
            Usuario acreedor = null;
            double maxDeuda = Double.MIN_VALUE;
            double maxHaber = Double.MIN_VALUE;
            for (Usuario participante : montosCopiados.keySet()) {
                double monto = montosCopiados.get(participante);
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

            // Agregar la transacción a la lista de transacciones mínimas
            String nuevaTransaccion = deudor.getNombreApellidos() + " paga " + transaccion + " a " + acreedor.getNombreApellidos();
            transacciones.add(nuevaTransaccion);
            System.out.println(nuevaTransaccion);
            // Actualizar la copia de montos
            montosCopiados.put(deudor, montosCopiados.getOrDefault(deudor, 0.0) + transaccion);
            montosCopiados.put(acreedor, montosCopiados.getOrDefault(acreedor, 0.0) - transaccion);
        }

        // Imprimir las transacciones mínimas
        for (String transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }*/
    

       // Función auxiliar para verificar si todos los montos en el mapa son cero
       public boolean todosLosMontosSonCero(Map<Usuario, Double> montos) {
           for (double monto : montos.values()) {
               if (monto != 0.0) {
                   return false;
               }
           }
           return true;
       }
    
       
       
       
    public boolean reclamarDeuda(Usuario usuarioReclamador) {
    	if (!participantes.contains(usuarioReclamador)) {
            System.out.println("El usuario no pertenece al grupo.");
            return false;
        } else{
            for (Usuario participante : participantes) {
            	List<String> mensajes = new ArrayList<>();
                mensajes.add(usuarioReclamador.getNombreApellidos() + " ha solicito que liquides la deuda con ella.");
            	participante.setMensajes(mensajes);
            	participante.imprimirMensajes();
           
            }
        	
            return true; 
        } 
    }

    
 // Método para añadir actividad al calendario
    public boolean añadirActividad(String nombreActividad, Date fechaInicio, float duracion, String lugar, String descripcion) {
        // Verificar que la actividad no sea nula
        if (nombreActividad == null) {
            throw new IllegalArgumentException("Los campos de la actividad no pueden ser nulos.");
        }

        // Verificar que los campos de la actividad no sean nulos
        if (fechaInicio == null || lugar==null ) {
            throw new IllegalArgumentException("Los campos de la actividad no pueden ser nulos.");
        }
        
        if(duracion<=0) {
        	throw new IllegalArgumentException("La duracion de la actividad debe ser positiva.");
        }
        
        if(descripcion.length()<=5 || descripcion.length()>150) {
        	throw new IllegalArgumentException("La longitud de la descripcion debe ser mayor a 5 y menor a 151.");
        }
        
        Actividad actNueva = new Actividad(nombreActividad, fechaInicio, duracion, lugar, descripcion);
        
        // Verificar si la actividad ya existe en el calendario (mismo lugar y hora)
        
        if(!calendarioActividades.isEmpty()) {
        	for (Actividad act : calendarioActividades) {
                if (act.getLugar().equals(actNueva.getLugar()) || act.getFechaInicio().equals(actNueva.getFechaInicio())) {
                    return false; // Actividad repetida encontrada, no se añade
                }
            }
        }
        calendarioActividades.add(actNueva);
                
        return true;
    }
    
    //Metodo para visualizar las actividades presentes en el calendario de actividades
    public String visualizarActividades() {
        StringBuilder actividadesStr = new StringBuilder();
        if (calendarioActividades.isEmpty()) {
            actividadesStr.append("No hay actividades en el calendario.");
        } else {
            // Ordenar las actividades por fecha de inicio
            Collections.sort(calendarioActividades, Comparator.comparing(Actividad::getFechaInicio));
            
            // Limitar la cantidad de actividades a mostrar (por ejemplo, a las primeras 10)
            
            actividadesStr.append("Actividades en el calendario:\n");
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            for (int i = 0; i < this.calendarioActividades.size(); i++) {
                Actividad actividad = calendarioActividades.get(i);
                if (actividad != null) { // Validación de objeto nulo
                    actividadesStr.append("Nombre: ").append(actividad.getNombreActividad()).append("\n");
                    actividadesStr.append("Fecha de inicio: ").append(sdf.format(actividad.getFechaInicio())).append("\n");
                    actividadesStr.append("Duración: ").append(actividad.getDuracion()).append(" horas\n");
                    actividadesStr.append("Lugar: ").append(actividad.getLugar()).append("\n");
                    actividadesStr.append("Descripción: ").append(actividad.getDescripcion()).append("\n");
                    actividadesStr.append("-----------------------------\n");
                }
            }
        }
        System.out.println(actividadesStr);
        return actividadesStr.toString();
    }
    
    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Usuario getLiderGrupo() {
        return liderGrupo;
    }

    
    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public Map<Usuario, Double> getMontos() {
    	return montos;
    }


	public List<Gastos> getGastos() {
		return gastos;
	}


	
    

}
