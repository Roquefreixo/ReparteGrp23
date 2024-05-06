import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class GrupoTest {
	
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario liderGrupo;
    private Grupo grupo;

	
	@Test
    public void testCrearGrupo_Valido() {
        // Caso de prueba 1: Crear un grupo con valores válidos
        String nombre = "Grupo de Prueba";
        String fotoPerfil = "foto.jpg";
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456");

        Grupo grupo = new Grupo(nombre, fotoPerfil, liderGrupo);

        // Verificar que los atributos se inicializan correctamente
        assertEquals(nombre, grupo.getNombre());
        assertEquals(fotoPerfil, grupo.getFotoPerfil());
        assertEquals(liderGrupo, grupo.getLiderGrupo());
        assertTrue(grupo.getParticipantes().isEmpty(), "La lista de participantes debe estar vacía");
    }

    @Test
    public void testCrearGrupo_NombreNulo() {
        // Caso de prueba 2: Crear un grupo con nombre nulo
        String nombre = null;
        String fotoPerfil = "foto.jpg";
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456");

        assertThrows(IllegalArgumentException.class, () -> {new Grupo(nombre, fotoPerfil, liderGrupo);});
    }

    @Test
    public void testCrearGrupo_FotoPerfilNula() {
        // Caso de prueba 3: Crear un grupo con foto de perfil nula
        String nombre = "Grupo de Prueba";
        String fotoPerfil = null;
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456");

        assertThrows(IllegalArgumentException.class, () -> {new Grupo(nombre, fotoPerfil, liderGrupo); });
    }

    @Test
    public void testCrearGrupo_LiderGrupoNulo() {
        // Caso de prueba 4: Crear un grupo con líder de grupo nulo
        String nombre = "Grupo de Prueba";
        String fotoPerfil = "foto.jpg";
        Usuario liderGrupo = null;

        assertThrows(IllegalArgumentException.class, () -> { new Grupo(nombre, fotoPerfil, liderGrupo);});
    }
    
    
    @Test
    public void testAgregarParticipante() {
        usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890");
        usuario2 = new Usuario("María López", "maria@example.com", "+987654321", "password123", "0987654321");
        liderGrupo = new Usuario("Líder Grupo", "lider@example.com", "+111111111", "leaderpass", "0000000000");
        grupo = new Grupo("Grupo de Ejemplo", "foto.png", liderGrupo);

    	
        assertTrue(grupo.addUserGrp(usuario1));
        assertTrue(grupo.addUserGrp(usuario2));
        assertFalse(grupo.addUserGrp(usuario1)); // Intentar agregar un usuario que ya está en el grupo
    }

    @Test
    public void testEliminarParticipante() {
    	
        usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890");
        liderGrupo = new Usuario("Líder Grupo", "lider@example.com", "+111111111", "leaderpass", "0000000000");

        grupo = new Grupo("Grupo de Ejemplo", "foto.png", liderGrupo);

    	
        grupo.addUserGrp(usuario1);
        assertTrue(grupo.deleteUserGrp(usuario1));
        assertFalse(grupo.deleteUserGrp(usuario1)); // Intentar eliminar un usuario que no está en el grupo
    }


    @Test
    public void testGettersAndSetters() {
        // Crear un usuario de ejemplo
        Usuario usuario = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456");
        
        // Verificar los getters
        assertEquals("Juan Pérez", usuario.getNombreApellidos());
        assertEquals("juan@example.com", usuario.getCorreoElectronico());
        assertEquals("+123456789", usuario.getNumeroTelefono());
        assertEquals("password", usuario.getContraseña());
        assertEquals("1234567890123456", usuario.getNumeroCuentaBancaria());
        
        // Modificar los atributos usando setters
        usuario.setNombreApellidos("María García");
        usuario.setCorreoElectronico("maria@example.com");
        usuario.setNumeroTelefono("+987654321");
        usuario.setContraseña("newpassword");
        usuario.setNumeroCuentaBancaria("9876543210987654");

        // Verificar que los cambios se reflejen correctamente
        assertEquals("María García", usuario.getNombreApellidos());
        assertEquals("maria@example.com", usuario.getCorreoElectronico());
        assertEquals("+987654321", usuario.getNumeroTelefono());
        assertEquals("newpassword", usuario.getContraseña());
        assertEquals("9876543210987654", usuario.getNumeroCuentaBancaria());
    }
    
}