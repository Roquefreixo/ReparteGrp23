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
        assertThrows(IllegalArgumentException.class, () -> {new Usuario("Juan Pérez", "juan@example.com", "+123456789", "Juan Pérez", "1234567890123456");});
    }

    @Test
    public void testConstructor_NumeroTelefonoContieneCaracteres() {
        // Intentamos crear un usuario con un número de teléfono que contiene caracteres
        assertThrows(IllegalArgumentException.class, () -> {new Usuario("Nombre Apellidos", "correo@example.com", "+1234ABC6789", "password", "1234567890123456");});
    }
    
    @Test
    public void testConstructor_ValoresNulos() {
        // Intentamos crear un usuario con valores nulos
        assertThrows(IllegalArgumentException.class, () -> {new Usuario(null, "correo@example.com", "+123456789", "password", "1234567890123456");});
        assertThrows(IllegalArgumentException.class, () -> {new Usuario("Nombre Apellidos", null, "+123456789", "password", "1234567890123456");});
        assertThrows(IllegalArgumentException.class, () -> {new Usuario("Nombre Apellidos", "correo@example.com", null, "password", "1234567890123456");});
        assertThrows(IllegalArgumentException.class, () -> {new Usuario("Nombre Apellidos", "correo@example.com", "+123456789", null, "1234567890123456");});
        assertThrows(IllegalArgumentException.class, () -> {new Usuario("Nombre Apellidos", "correo@example.com", "+123456789", "password", null);});
    }
    
    @Test
    public void testGettersAndSetters() {
        // Crear un usuario de ejemplo
        Usuario usuario = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");

        // Modificar los atributos usando setters
        usuario.setNombreApellidos("María García");
        usuario.setCorreoElectronico("maria@example.com");
        usuario.setNumeroTelefono("+987654321");
        usuario.setContraseña("newpassword");
        usuario.setNumeroCuentaBancaria("9876543210987654");

        // Verificar que los cambios se reflejen correctamente usando los getters
        assertEquals("María García", usuario.getNombreApellidos());
        assertEquals("maria@example.com", usuario.getCorreoElectronico());
        assertEquals("+987654321", usuario.getNumeroTelefono());
        assertEquals("newpassword", usuario.getContraseña());
        assertEquals("9876543210987654", usuario.getNumeroCuentaBancaria());
    }
    @Test
    public void testEquals_SameObject() {
        Usuario usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        assertTrue(usuario1.equals(usuario1)); // Comprobando el mismo objeto
    }

    @Test
    public void testEquals_NullObject() {
        Usuario usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        assertFalse(usuario1.equals(null)); // Comprobando con un objeto nulo
    }

    @Test
    public void testEquals_DifferentClass() {
        Usuario usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        assertFalse(usuario1.equals("Juan Pérez")); // Comprobando con un objeto de una clase diferente
    }

    @Test
    public void testEquals_SameAttributes() {
        Usuario usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        Usuario usuario2 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        assertTrue(usuario1.equals(usuario2)); // Comprobando dos objetos con los mismos atributos
    }

    @Test
    public void testEquals_DifferentAttributes() {
        Usuario usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        Usuario usuario2 = new Usuario("María García", "maria@example.com", "+987654321", "newpassword", "9876543210987654");
        assertFalse(usuario1.equals(usuario2)); // Comprobando dos objetos con diferentes atributos
    }
}
