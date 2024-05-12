import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map; 


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
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");

        Usuario usuario1 = mock(Usuario.class);
        Usuario usuario2 = mock(Usuario.class);
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(usuario1);
        participantes.add(usuario2);
        
        Grupo grupo = new Grupo(nombre, fotoPerfil, liderGrupo, participantes);

        // Verificar que los atributos se inicializan correctamente
        assertEquals(nombre, grupo.getNombre());
        assertEquals(fotoPerfil, grupo.getFotoPerfil());
        assertEquals(liderGrupo, grupo.getLiderGrupo());
        
        
        
    }

    @Test
    public void testCrearGrupo_NombreNulo() {
        // Caso de prueba 2: Crear un grupo con nombre nulo
        String nombre = null;
        String fotoPerfil = "foto.jpg";
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");

        Usuario usuario1 = mock(Usuario.class);
        Usuario usuario2 = mock(Usuario.class);
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(usuario1);
        participantes.add(usuario2);
        assertThrows(IllegalArgumentException.class, () -> {new Grupo(nombre, fotoPerfil, liderGrupo, participantes);});
    }

    @Test
    public void testCrearGrupo_FotoPerfilNula() {
        // Caso de prueba 3: Crear un grupo con foto de perfil nula
        String nombre = "Grupo de Prueba";
        String fotoPerfil = null;
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");

        Usuario usuario1 = mock(Usuario.class);
        Usuario usuario2 = mock(Usuario.class);
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(usuario1);
        participantes.add(usuario2);
        assertThrows(IllegalArgumentException.class, () -> {new Grupo(nombre, fotoPerfil, liderGrupo, participantes); });
    }

    @Test
    public void testCrearGrupo_LiderGrupoNulo() {
        // Caso de prueba 4: Crear un grupo con líder de grupo nulo
        String nombre = "Grupo de Prueba";
        String fotoPerfil = "foto.jpg";
        Usuario liderGrupo = null;

        Usuario usuario1 = mock(Usuario.class);
        Usuario usuario2 = mock(Usuario.class);
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(usuario1);
        participantes.add(usuario2);
        assertThrows(IllegalArgumentException.class, () -> { new Grupo(nombre, fotoPerfil, liderGrupo, participantes);});
    }
    
    
    @Test
    public void testAgregarParticipante() {
        usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456121213");
        usuario2 = new Usuario("María López", "maria@example.com", "+987654321", "password123", "1234567890123456121213");
        liderGrupo = new Usuario("Líder Grupo", "lider@example.com", "+111111111", "leaderpass", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        grupo = new Grupo("Grupo de Ejemplo", "foto.png", liderGrupo, participantes);

    	
        assertTrue(grupo.addUserGrp(usuario1));
        assertTrue(grupo.addUserGrp(usuario2));
        assertFalse(grupo.addUserGrp(usuario1)); // Intentar agregar un usuario que ya está en el grupo
        assertThrows(IllegalArgumentException.class, () -> {grupo.addUserGrp(null);}); //agregar un usuario nulo
    }

    @Test
    public void testEliminarParticipante() {
    	
        usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456121213");
        liderGrupo = new Usuario("Líder Grupo", "lider@example.com", "+111111111", "leaderpass", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        grupo = new Grupo("Grupo de Ejemplo", "foto.png", liderGrupo, participantes);

    	
        grupo.addUserGrp(usuario1);
        assertTrue(grupo.deleteUserGrp(usuario1));
        assertFalse(grupo.deleteUserGrp(usuario1)); // Intentar eliminar un usuario que no está en el grupo
        assertThrows(IllegalArgumentException.class, () -> {grupo.deleteUserGrp(null);}); //eliminar un usuario nulo
      //Prueba de un usuario con haberes al eliminar
        
        List<Usuario> participantes2 = new ArrayList<>();
        participantes2.add(liderGrupo);
        grupo.añadirGasto(grupo, usuario1, participantes2, 15.0, null, null, null);  
        assertFalse(grupo.deleteUserGrp(liderGrupo));//explicar que no funciona porque no se modifican bien los gastos.
        
    }


    @Test
    public void testGettersAndSetters() {
        // Crear un usuario de ejemplo
        Usuario usuario = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456121213");
        
        // Verificar los getters
        assertEquals("Juan Pérez", usuario.getNombreApellidos());
        assertEquals("juan@example.com", usuario.getCorreoElectronico());
        assertEquals("+123456789", usuario.getNumeroTelefono());
        assertEquals("password", usuario.getContraseña());
        assertEquals("1234567890123456121213", usuario.getNumeroCuentaBancaria());
        
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
    
    @Test
    void testSettersAndGettersGrupo() {
        // Crear objetos necesarios para la prueba
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(new Usuario("Usuario 1", "usuario1@example.com", "+987654321", "password1", "1234567890123456121213"));
        participantes.add(new Usuario("Usuario 2", "usuario2@example.com", "+987654322", "password2", "1234567890123456121213"));

        // Crear objeto Grupo
        Grupo grupo = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, participantes);

        // Verificar los valores iniciales con los getters
        assertEquals("Grupo de Prueba", grupo.getNombre());
        assertEquals("foto.jpg", grupo.getFotoPerfil());
        assertEquals(liderGrupo, grupo.getLiderGrupo());
        assertEquals(participantes, grupo.getParticipantes());
        assertNotNull(grupo.getMontos());
        assertNotNull(grupo.getGastos());

        // Modificar los valores con los setters
        grupo.setNombre("Nuevo Nombre de Grupo");
        grupo.setFotoPerfil("nueva_foto.jpg");

        // Verificar los nuevos valores con los getters
        assertEquals("Nuevo Nombre de Grupo", grupo.getNombre());
        assertEquals("nueva_foto.jpg", grupo.getFotoPerfil());
    }
    
    @Test
    public void testAñadirGastoValido() {
        // Crear usuarios y grupo reales para el test
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        Usuario usuarioQueHaPagado = new Usuario("Usuario Pagador", "pagador@example.com", "+987654321", "password", "1234567890123456121213");
        List<Usuario> listaDeUsuariosPagadores = new ArrayList<>();
        listaDeUsuariosPagadores.add(liderGrupo);
        listaDeUsuariosPagadores.add(usuarioQueHaPagado);

        // Crear el grupo
        Grupo grupo = new Grupo("Nombre", "FotoPerfil", liderGrupo, listaDeUsuariosPagadores);

        // Llamar al método a probar
        double monto = 100.0;
        String descripcion = "Descripción del gasto";
        Date fecha = new Date();
        String actividad = "Actividad relacionada";
        grupo.añadirGasto(grupo, usuarioQueHaPagado, listaDeUsuariosPagadores, monto, descripcion, fecha, actividad);

        // Verificar que el gasto se ha agregado correctamente
        List<Gastos> gastos = grupo.getGastos();
        assertEquals(1, gastos.size());

        // Verificar que el monto del gasto se haya reflejado en el grupo
        Map<Usuario, Double> montos = grupo.getMontos();
        
        
        assertEquals(monto, montos.get(usuarioQueHaPagado));
        
        
    }

    
    @Test
    public void testTodosLosMontosSonCero() {
        // Crear un mapa con montos todos iguales a cero
        Map<Usuario, Double> montosCero = new HashMap<>();
        montosCero.put(mock(Usuario.class), 0.0);
        montosCero.put(mock(Usuario.class), 0.0);
        montosCero.put(mock(Usuario.class), 0.0);

        // Crear un mapa con al menos un monto diferente de cero
        Map<Usuario, Double> montosNoCero = new HashMap<>();
        montosNoCero.put(mock(Usuario.class), 0.0);
        montosNoCero.put(mock(Usuario.class), 50.0);
        montosNoCero.put(mock(Usuario.class), 0.0);

        // Instanciar el objeto Grupo y probar el método todosLosMontosSonCero con ambos mapas
        Grupo grupo = new Grupo("Nombre", "FotoPerfil", mock(Usuario.class), new ArrayList<>());
        assertTrue(grupo.todosLosMontosSonCero(montosCero));
        assertFalse(grupo.todosLosMontosSonCero(montosNoCero));
    }
    
    @Test
    void testAñadirGastoNuloAlGrupo() {
        // Crear usuarios para el grupo
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(liderGrupo);
        Usuario user1 = new Usuario("Otro", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        
        participantes.add(user1);
        // Crear el grupo
        Grupo grupo = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, participantes);

        // Intentar añadir un gasto nulo al grupo
        
        Exception exceptionNulo = assertThrows(IllegalArgumentException.class, () -> {
            grupo.añadirGasto(grupo, liderGrupo, participantes,0.0, "hola", null,"hola");
        });

        // Verificar que se lance una excepción adecuada para gasto nulo
        assertEquals("El monto del gasto debe ser mayor que 0.", exceptionNulo.getMessage());
    }
    
    @Test
    void testAñadirGastoSinPagador() {
        // Crear usuarios para el grupo
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(liderGrupo);

        // Crear el grupo
        Grupo grupo = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, participantes);

        // Intentar añadir un gasto sin indicar el pagador
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            grupo.añadirGasto(grupo, null, participantes, 100.0, "Descripción", new Date(), "Actividad");
        });

        // Verificar que se lance una excepción adecuada
        assertEquals("El usuario que ha pagado el gasto no puede ser nulo.", exception.getMessage());
    }
    
    @Test
    void testAñadirGastoSinDeudores() {
        // Crear usuarios para el grupo
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(liderGrupo);
        Usuario usuarioQueHaPagadoMock = mock(Usuario.class);
        participantes.add(usuarioQueHaPagadoMock);
        // Crear el grupo
        Grupo grupo = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, participantes);

        // Intentar añadir un gasto sin indicar los deudores
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            grupo.añadirGasto(grupo, usuarioQueHaPagadoMock, new ArrayList<>(), 100.0, "Descripción", new Date(), "Actividad");
        });
        
        
        
        // Verificar que se lance una excepción adecuada
        assertEquals("La lista de usuarios pagadores no puede estar vacía.", exception.getMessage());
        
      
    }

    @Test
    void testAñadirGastoDeudoresNoEnGrupo() {
        // Crear usuarios para el grupo
        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
        List<Usuario> participantes = new ArrayList<>();
        participantes.add(liderGrupo);
        Usuario usuarioQueHaPagadoMock = mock(Usuario.class);
        Usuario deudorNoEnGrupo = new Usuario("Deudor", "deudor@example.com", "+987654321", "password", "1234567890123456121213");
        // Crear el grupo
        Grupo grupo = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, participantes);

        // Intentar añadir un gasto con deudores que no están en el grupo
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            grupo.añadirGasto(grupo, usuarioQueHaPagadoMock, Collections.singletonList(deudorNoEnGrupo), 100.0, "Descripción", new Date(), "Actividad");
        });

        // Verificar que se lance una excepción adecuada
        assertEquals("Los deudores especificados no están en el grupo.", exception.getMessage());
    }

    
    @Test
    void testCalcularTransaccionesMinimas() {
        // Crear un mock de Grupo
        Grupo grupoMock = mock(Grupo.class);
        
        // Crear usuarios de prueba
        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@example.com", "+987654321", "password1", "1234567890123456121213");
        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@example.com", "+987654322", "password2", "1234567890123456121213");
        
        // Crear el objeto Grupo
        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, new ArrayList<>());
        
        // Montos de cada usuario
        Map<Usuario, Double> montosUsuarios = new HashMap<>();
        montosUsuarios.put(usuario1, 100.0);
        montosUsuarios.put(usuario2, -100.0);
        
        // Mockear el método getMontos
        when(grupoMock.getMontos()).thenReturn(montosUsuarios);
        
        // Llamar al método calcularTransaccionesMinimas
        grupo.calcularTransaccionesMinimas();
        
        // Verificar que las transacciones mínimas se hayan calculado correctamente
        List<Gastos> gastos = grupo.getGastos();
        
        
        assertNotNull(gastos);
        assertEquals(1, gastos.size());
        
        }
}