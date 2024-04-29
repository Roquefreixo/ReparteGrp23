import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    public void testConstructor() {
        // Caso de prueba 1: Crear un usuario con valores válidos
        String nombreApellidos = "Juan Pérez";
        String correoElectronico = "juan@example.com";
        String numeroTelefono = "+123456789";
        String contraseña = "pass123";
        String numeroCuentaBancaria = "1234567890123456";

        Usuario usuario = new Usuario(nombreApellidos, correoElectronico, numeroTelefono, contraseña, numeroCuentaBancaria);

        // Verificar que los atributos se establecen correctamente
        assertEquals(nombreApellidos, usuario.getNombreApellidos());
        assertEquals(correoElectronico, usuario.getCorreoElectronico());
        assertEquals(numeroTelefono, usuario.getNumeroTelefono());
        assertEquals(contraseña, usuario.getContraseña());
        assertEquals(numeroCuentaBancaria, usuario.getNumeroCuentaBancaria());
    }

    @Test
    public void testConstructor_ContraseñaIgualNombreApellidos() {
        // Intentamos crear un usuario con una contraseña igual al nombre y apellidos
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Juan Pérez", "juan@example.com", "+123456789", "Juan Pérez", "1234567890123456");
        });
    }

    @Test
    public void testConstructor_NumeroTelefonoContieneCaracteres() {
        // Intentamos crear un usuario con un número de teléfono que contiene caracteres
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Nombre Apellidos", "correo@example.com", "+1234ABC6789", "password", "1234567890123456");
        });
    }
}
