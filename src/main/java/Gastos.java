import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Gastos{

    // Atributos específicos de los gastos
    private Grupo grupo;
    private Usuario usuarioQueHaPagado;
    private List<Usuario> listaDeUsuariosPagadores;
    private double monto;
    private String descripcion;
    private Date fecha;
    private String actividad;

    // Constructor
    public Gastos(Grupo grupo, Usuario usuarioQueHaPagado, List<Usuario> listaDeUsuariosPagadores,
                  double monto, String descripcion, Date fecha, String actividad) {
        this.grupo = grupo;
        this.usuarioQueHaPagado = usuarioQueHaPagado;
        this.listaDeUsuariosPagadores = listaDeUsuariosPagadores;
        //this.monto = monto;
        setMonto(monto); 
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.actividad = actividad;
        
    }
    
 // Método para calcular los haberes y deberes de cada usuario
    public void calcularHaberesDeberes(Map<Usuario, Double> montosUsuarios) {
        double montoPorUsuario = monto / listaDeUsuariosPagadores.size();
        for (Usuario usuario : listaDeUsuariosPagadores) {
            if (usuario.equals(usuarioQueHaPagado)) {
                montosUsuarios.put(usuario, montosUsuarios.getOrDefault(usuario, 0.0) + montoPorUsuario);
            } else {
                montosUsuarios.put(usuario, montosUsuarios.getOrDefault(usuario, 0.0) - montoPorUsuario);
            }
        }
    }
    
    


    // Métodos getters para los atributos

    public Grupo getGrupo() {
        return grupo;
    }

    public Usuario getUsuarioQueHaPagado() {
        return usuarioQueHaPagado;
    }

    public List<Usuario> getListaDeUsuariosPagadores() {
        return listaDeUsuariosPagadores;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getActividad() {
        return actividad;
    }

    // Métodos setters para los atributos

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setUsuarioQueHaPagado(Usuario usuarioQueHaPagado) {
        this.usuarioQueHaPagado = usuarioQueHaPagado;
    }

    public void setListaDeUsuariosPagadores(List<Usuario> listaDeUsuariosPagadores) {
        this.listaDeUsuariosPagadores = listaDeUsuariosPagadores;
    }

 // Método para establecer el monto asegurándose de que sea positivo
    public void setMonto(double monto) {
        this.monto = Math.abs(monto); // Tomar el valor absoluto del monto
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    
}