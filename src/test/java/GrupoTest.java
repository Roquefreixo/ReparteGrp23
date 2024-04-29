import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrupoTest {

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

        assertThrows(IllegalArgumentException.class, () -> {
            new Grupo(nombre, fotoPerfil, liderGrupo);
        });
    }

    @Test
    public void testCrearGrupo_FotoPerfilNula() {
        // Caso de prueba 3: Crear un grupo con foto de perfil nula
        String nombre = "Grupo de Prueba";
        String fotoPerfil = null;
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456");

        assertThrows(IllegalArgumentException.class, () -> {
            new Grupo(nombre, fotoPerfil, liderGrupo);
        });
    }

    @Test
    public void testCrearGrupo_LiderGrupoNulo() {
        // Caso de prueba 4: Crear un grupo con líder de grupo nulo
        String nombre = "Grupo de Prueba";
        String fotoPerfil = "foto.jpg";
        Usuario liderGrupo = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new Grupo(nombre, fotoPerfil, liderGrupo);
        });
    }

}
