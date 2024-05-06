import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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
    void testGetMensajes() {
        // Crear un usuario de prueba
        Usuario usuario = new Usuario("Nombre Apellido", "correo@example.com", "+123456789", "password", "1234567890123456");

        // Crear una lista de mensajes de prueba
        List<String> mensajes = new ArrayList<>();
        mensajes.add("Mensaje 1");
        mensajes.add("Mensaje 2");
        mensajes.add("Mensaje 3");

        // Establecer los mensajes en el usuario
        usuario.setMensajes(mensajes);

        // Obtener los mensajes usando getMensajes()
        List<String> mensajesObtenidos = usuario.getMensajes();

        // Verificar que los mensajes obtenidos son los mismos que los establecidos
        assertEquals(mensajes, mensajesObtenidos);
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
    
    

    @Test
    void testImprimirMensajes() {
        // Crear un usuario de prueba
        Usuario usuario = new Usuario("Nombre Apellido", "correo@example.com", "+123456789", "password", "1234567890123456");

        // Crear una lista de mensajes de prueba
        List<String> mensajes = new ArrayList<>();
        mensajes.add("Mensaje 1");
        mensajes.add("Mensaje 2");
        mensajes.add("Mensaje 3");

        // Establecer los mensajes en el usuario
        usuario.setMensajes(mensajes);

        // Redirigir la salida estándar a un ByteArrayOutputStream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Llamar al método imprimirMensajes
        usuario.imprimirMensajes();

        // Verificar que la salida contiene los mensajes de prueba
        String printedOutput = outContent.toString();
        assertTrue(printedOutput.contains("Mensaje 1"));
        assertTrue(printedOutput.contains("Mensaje 2"));
        assertTrue(printedOutput.contains("Mensaje 3"));
    }

}
