import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nombreApellidos;
    private String correoElectronico;
    private String numeroTelefono;
    private String contraseña;
    private String numeroCuentaBancaria;
    private List<String> mensajes;

    // Constructor
    public Usuario(String nombreApellidos, String correoElectronico, String numeroTelefono, String contraseña, String numeroCuentaBancaria) {
        if (nombreApellidos == null || correoElectronico == null || numeroTelefono == null || contraseña == null || numeroCuentaBancaria == null) {
            throw new IllegalArgumentException("Ningún parámetro puede ser nulo.");
        }
        
        // Verificar si la contraseña es igual al nombre y/o apellidos
        if (contraseña.equals(nombreApellidos)) {
            throw new IllegalArgumentException("La contraseña no puede ser igual al nombre y apellidos del usuario.");
        }
        
        // Verificar si el número de teléfono contiene caracteres, excluyendo el "+"
        if (!numeroTelefono.matches("^\\+[0-9]+$")) {
            throw new IllegalArgumentException("El número de teléfono debe contener solo dígitos después del signo de más (+).");
        }
        if(numeroCuentaBancaria.length() != 22) {
        	throw new IllegalArgumentException("El número de cuenta bancaria debe tener exactamente 22 dígitos.");
            
        }
        this.nombreApellidos = nombreApellidos;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.contraseña = contraseña;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
        this.mensajes=new ArrayList<>();
    }

    // Métodos para obtener y establecer los valores de los atributos

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }
    
    
    
    public List<String> getMensajes(){
    	return mensajes;
    }
    
    public void setMensajes(List<String> mensajes){
    	for(String m:mensajes) {
    		this.mensajes.add(m);
    	}
    }
    
    
    // Método para imprimir los mensajes
    public void imprimirMensajes() {
    	if (mensajes.isEmpty()) {
            System.out.println("No hay mensajes para imprimir");
            return;
        }
        for (String mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Usuario usuario = (Usuario) obj;
        return Objects.equals(nombreApellidos, usuario.nombreApellidos) && Objects.equals(correoElectronico, usuario.correoElectronico) && Objects.equals(numeroTelefono, usuario.numeroTelefono) && Objects.equals(contraseña, usuario.contraseña) && Objects.equals(numeroCuentaBancaria, usuario.numeroCuentaBancaria);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(nombreApellidos, correoElectronico, numeroTelefono, contraseña, numeroCuentaBancaria);
    }*/

}