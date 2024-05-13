import java.util.Date;

public class Actividad {
    private String nombreActividad;
    private Date fechaInicio;
    private float duracion;
    private String lugar;
    private String descripcion;

    // Constructor
    public Actividad(String nombreActividad, Date fechaInicio, float duracion, String lugar, String descripcion) {
        this.nombreActividad = nombreActividad;
        this.fechaInicio = fechaInicio;
        this.duracion = duracion;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
