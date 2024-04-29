import java.util.Date;

public class Usuario {
    private String nombreApellidos;
    private String correoElectronico;
    private String numeroTelefono;
    private String contraseña;
    private String numeroCuentaBancaria;
    private Date fechaCreacion;
    private Date fechaExpiracion;

    // Constructor
    public Usuario(String nombreApellidos, String correoElectronico, String numeroTelefono, String contraseña, String numeroCuentaBancaria) {
        this.nombreApellidos = nombreApellidos;
        this.correoElectronico = correoElectronico;
        // Verificar si la contraseña es igual al nombre y/o apellidos
        if (contraseña.equals(nombreApellidos)) {
            throw new IllegalArgumentException("La contraseña no puede ser igual al nombre y/o apellidos del usuario.");
        }
        this.contraseña = contraseña;
        // Verificar si el número de teléfono contiene caracteres, excluyendo el "+"
        if (!numeroTelefono.matches("^\\+[0-9]+$")) {
            throw new IllegalArgumentException("El número de teléfono debe contener solo dígitos después del signo de más (+).");
        }
        this.numeroTelefono = numeroTelefono;
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

    // Métodos para obtener y establecer los valores de los atributos

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    private void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    private void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    private void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    private void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNumeroCuentaBancaria() {
        return numeroCuentaBancaria;
    }

    private void setNumeroCuentaBancaria(String numeroCuentaBancaria) {
        this.numeroCuentaBancaria = numeroCuentaBancaria;
    }

}