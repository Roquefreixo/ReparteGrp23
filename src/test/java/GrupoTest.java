import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map; 


class GrupoTest {
	
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario liderGrupo;
    private Grupo grupo;

	@Nested
	class primerSprint{
		@Nested
		class crearGrupo{
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
				participantes.add(liderGrupo);

		        
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
		    public void testCrearGrupo_Valido_participantesNoVacia_LiderDentro() {
		        // Caso de prueba 1: Crear un grupo con valores válidos
		        String nombre = "Grupo de Prueba";
		        String fotoPerfil = "foto.jpg";
		        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");

		        Usuario usuario1 = mock(Usuario.class);
		        Usuario usuario2 = mock(Usuario.class);
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
				participantes.add(liderGrupo);
		        
		        Grupo grupo = new Grupo(nombre, fotoPerfil, liderGrupo, participantes);

		        // Verificar que los atributos se inicializan correctamente
		        assertEquals(nombre, grupo.getNombre());
		        assertEquals(fotoPerfil, grupo.getFotoPerfil());
		        assertEquals(liderGrupo, grupo.getLiderGrupo());
				assertTrue(grupo.getParticipantes().contains(liderGrupo));
		        
		        
		        
		    }

			@Test
		    public void testCrearGrupo_Valido_participantesNoVacia_LiderNoDentro() {
		        // Caso de prueba 1: Crear un grupo con valores válidos
		        String nombre = "Grupo de Prueba";
		        String fotoPerfil = "foto.jpg";
		        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");

		        Usuario usuario1 = mock(Usuario.class);
		        Usuario usuario2 = mock(Usuario.class);
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);

				// Verificar que los atributos se inicializan correctamente
		        assertEquals(nombre, grupo.getNombre());
		        assertEquals(fotoPerfil, grupo.getFotoPerfil());
		        assertEquals(liderGrupo, grupo.getLiderGrupo());
				assertThrows(IllegalArgumentException.class, () -> { new Grupo(nombre, fotoPerfil, liderGrupo, participantes);});
		        
		        
		        
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
		        
		        Grupo grupo1 = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, null);

		        assertEquals(0,grupo1.getParticipantes().size());
		    }
		}
		
		@Nested
		class agregarEliminarParticipantes{
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
		      
		    }

		    @Test
		    public void testEliminarParticipante2() {
		    	
		        usuario1 = new Usuario("Juan Pérez", "juan@example.com", "+123456789", "password", "1234567890123456121213");
		        liderGrupo = new Usuario("Líder Grupo", "lider@example.com", "+111111111", "leaderpass", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        grupo = new Grupo("Grupo de Ejemplo", "foto.png", liderGrupo, participantes);
		        grupo.addUserGrp(usuario1);
		        grupo.addUserGrp(liderGrupo);
		        List<Usuario> participantes2 = new ArrayList<>();
		        participantes2.add(liderGrupo);  
		        double monto = 100.0;
		        String descripcion = "Descripción del gasto";
		        Date fecha = new Date();
		        String actividad = "Actividad relacionada";
		        grupo.añadirGasto(grupo, usuario1, participantes2, monto, descripcion, fecha, actividad);
		        assertFalse(grupo.deleteUserGrp(liderGrupo));//explicar que no funciona porque no se modifican bien los gastos.
		    }
		}
		
		@Nested
		class gestionarGastos{
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
		        
		        
		        assertEquals(monto/2, montos.get(usuarioQueHaPagado));
		        
		        
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
		    void testAñadirGastoPagadorNoEnGrupo() {
		        // Crear usuarios para el grupo
		        Usuario liderGrupo = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(liderGrupo);
		        Usuario pagadorNoEnGrupo = new Usuario("Deudor", "deudor@example.com", "+987654321", "password", "1234567890123456121213");
		        // Crear el grupo
		        Grupo grupo = new Grupo("Grupo de Prueba", "foto.jpg", liderGrupo, participantes);

		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {grupo.añadirGasto(grupo, pagadorNoEnGrupo, participantes, 100.0, "Descripción", new Date(), "Actividad");});
		        assertEquals("El usuario que ha pagado no pertenece al grupo.", exception.getMessage());
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
		        grupo.addUserGrp(usuarioQueHaPagadoMock);
		        // Intentar añadir un gasto con deudores que no están en el grupo
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		            grupo.añadirGasto(grupo, usuarioQueHaPagadoMock, Collections.singletonList(deudorNoEnGrupo), 100.0, "Descripción", new Date(), "Actividad");
		        });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("Los deudores especificados no están en el grupo.", exception.getMessage());
		    }

		    @Test
		    void testAgregarGastoYRepartir() {
		        
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        
		        // Crear un Grupo
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		  
		        
		        grupo.añadirGasto(grupo, usuario1, participantes, 100.0, "Descripción", new Date(), "Actividad");
		        
		        // Verificar que el monto del gasto se ha repartido correctamente entre los participantes del grupo
		        Map<Usuario, Double> montos = grupo.getMontos();
		        double montoEsperadoPorUsuario = 100 / 2;
		        //para el usuario 1 que ha pagado +50 y para el 2 que esta en deuda -50
		        assertEquals(montoEsperadoPorUsuario, grupo.getMontos().get(usuario1));
		        assertEquals(-montoEsperadoPorUsuario, grupo.getMontos().get(usuario2));
		        
		    }
		    
		    /*@Test
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
		        
		        }*/
		}
		
		
		@Test
	    public void testAceptacion() {
	    	Usuario usuarioEva = new Usuario ("Eva", "eva@example.com", "+123456789", "contraseña123", "1234567890123456789012");
	    	Usuario usuarioLuis = new Usuario ("Luis", "luis@example.com", "+987654321", "contraseña456", "9876543210123456789012");
	    	Usuario usuarioMarta = new Usuario ("Marta", "marta@example.com", "+111111111", "contraseña789", "1111111110123456789012");
	    	Usuario usuarioJuan = new Usuario ("Juan", "juan@example.com", "+222222222", "contraseñaabc", "2222222220123456789012");
	        
	        List<Usuario> participantes= new ArrayList<>();
	        participantes.add(usuarioEva);
	        participantes.add(usuarioLuis);
	        participantes.add(usuarioMarta);
	        participantes.add(usuarioJuan);
	        
	        Grupo g1 = new Grupo("Los mejores", "foto.jpg", usuarioEva, participantes);
	        g1.añadirGasto(g1, usuarioEva, participantes, 11.30, "Descripción del gasto", new Date(), "Actividad");
	        g1.añadirGasto(g1, usuarioEva, participantes, 23.15, "Descripción del gasto", new Date(), "Actividad");
	        g1.añadirGasto(g1, usuarioEva, participantes, 2.05, "Descripción del gasto", new Date(), "Actividad");
	        g1.añadirGasto(g1, usuarioLuis, participantes, 12.00, "Descripción del gasto", new Date(), "Actividad");
	        g1.añadirGasto(g1, usuarioLuis, participantes, 17.49, "Descripción del gasto", new Date(), "Actividad");
	        g1.añadirGasto(g1, usuarioMarta, participantes, 20.22, "Descripción del gasto", new Date(), "Actividad");
	        g1.añadirGasto(g1, usuarioMarta, participantes, 5.75, "Descripción del gasto", new Date(), "Actividad");
	        for (Usuario user: participantes) {
	        	user.imprimirMensajes();
	        }
	    }
	    
		
		
	}
	
	@Nested
	class segundoSprint{
		
		
		@Test
	    void testReclamarDeuda_UsuarioPerteneceAlGrupo() {
	        // Crear un Grupo
	        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
	        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
	        List<Usuario> participantes = new ArrayList<>();
	        participantes.add(usuario1);
	        participantes.add(usuario2);
	        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
	        
	        // Llamar al método reclamarDeuda con un usuario que pertenece al grupo
	        assertTrue(grupo.reclamarDeuda(usuario1));
	        
	        // Verificar que se han enviado mensajes a todos los participantes del grupo
	        for (Usuario participante : participantes) {
	            assertEquals(1, participante.getMensajes().size());
	        }
	        //el reclamador no pertenece al grupo
	        Usuario usuario3 = new Usuario("Usuario 3", "usuario3@", "+987654322", "password2", "1234567890123456121213");
	        assertFalse(grupo.reclamarDeuda(usuario3));
	        
	        //el reclamador es nulo
	        assertFalse(grupo.reclamarDeuda(null));
	        
	    }
		
		@Nested
		class añadirActividad{
			///Pruebas de añadir actividad
		    @Test
		    public void testAñadirActividadValida() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        assertTrue(grupo.añadirActividad("Canoa",new Date(1), 180,"el rio", "En esta actividad iremos en canoa por el rio"));
		        
		        
		    }
		    
		   
		    
		    @Test
		    public void testAñadirActividadConNombreNulo() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        	grupo.añadirActividad(null,new Date(1), 180,"el rio", "En esta actividad iremos en canoa por el rio"); });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("Los campos de la actividad no pueden ser nulos.", exception.getMessage());
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConFechaNulo() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		   
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        	grupo.añadirActividad("Canoa",null, 180,"el rio", "En esta actividad iremos en canoa por el rio"); });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("Los campos de la actividad no pueden ser nulos.", exception.getMessage());

		        
		    }
		    
		    @Test
		    public void testAñadirActividadConLugarNulo() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        	grupo.añadirActividad("Canoa",new Date(1), 180,null, "En esta actividad iremos en canoa por el rio"); });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("Los campos de la actividad no pueden ser nulos.", exception.getMessage());
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConDuracionCero() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        	grupo.añadirActividad("Canoa",new Date(1), 0,"el rio", "En esta actividad iremos en canoa por el rio"); });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("La duracion de la actividad debe ser positiva.", exception.getMessage());
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConDescripcion5() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        	grupo.añadirActividad("Canoa",new Date(1), 5,"el rio", "Holas"); });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("La longitud de la descripcion debe ser mayor a 5 y menor a 151.", exception.getMessage());
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConDescripcion151() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        	grupo.añadirActividad("Canoa",new Date(1), 5,"el rio", "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y relevante en el mercado actu"); });

		        // Verificar que se lance una excepción adecuada
		        assertEquals("La longitud de la descripcion debe ser mayor a 5 y menor a 151.", exception.getMessage());
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConDescripcion6() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		      
		        assertTrue(grupo.añadirActividad("Canoa",new Date(1), 5,"el rio", "Estasi"));
		    
		        
		    }
		    @Test
		    public void testAñadirActividadConDescripcion150() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		      
		        assertTrue(grupo.añadirActividad("Canoa",new Date(1), 5,"el rio", "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu"));
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConCalendarioLleno() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        grupo.añadirActividad("Canoa",new Date(1), 5,"el rio", "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu");
		        
		        assertTrue(grupo.añadirActividad("Canoa",new Date(3), 5,"mi casa", "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu"));
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConCalendarioLlenoYFechaIgual() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        Date mifecha= new Date(1);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        grupo.añadirActividad("Canoa",mifecha, 5,"el rio", "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu");
		        
		        assertFalse(grupo.añadirActividad("Canoa",mifecha, 5,"mi casa", "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu"));
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConCalendarioLlenoYLugarIgual() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        String misitio= "el rio";
		        
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        grupo.añadirActividad("Canoa",new Date(1), 5,misitio, "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu");
		        
		        assertFalse(grupo.añadirActividad("Canoa",new Date(2), 5,misitio, "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu"));
		    
		        
		    }
		    
		    @Test
		    public void testAñadirActividadConCalendarioLlenoYLasDosIgual() {
		    	// Crear un Grupo
		        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        String misitio= "el rio";
		        Date mifecha= new Date(1);
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        grupo.añadirActividad("Canoa",mifecha, 5,misitio, "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu");
		        
		        assertFalse(grupo.añadirActividad("Canoa",mifecha, 5,misitio, "En un mundo donde la tecnología avanza a pasos agigantados, es crucial adaptarse rápidamente para mantenerse competitivo y rlevante en el mercado actu"));
		    
		        
		    }
		}
		
		
		@Nested
		class visualizarActividades{

		    @Test
		    public void testVisualizarCalendarioVacio() {
		    	Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        String resultadoEsperado = "No hay actividades en el calendario.";
		        assertEquals(resultadoEsperado, grupo.visualizarActividades());
		   
		    }
		    
		    
		    @Test
		    public void testVisualizarCalendarioLLeno() {
		    	Usuario usuario1 = new Usuario("Usuario 1", "usuario1@", "+987654321", "password1", "1234567890123456121213");
		        Usuario usuario2 = new Usuario("Usuario 2", "usuario2@", "+987654322", "password2", "1234567890123456121213");
		        List<Usuario> participantes = new ArrayList<>();
		        participantes.add(usuario1);
		        participantes.add(usuario2);
		        
		        Grupo grupo = new Grupo("Nombre", "FotoPerfil", usuario1, participantes);
		        
		        grupo.añadirActividad("Actividad 1", new Date(1), 10, "Esto es asi", "el rio");
		        // Esperamos un resultado que contiene los detalles de las actividades
		        String resultadoEsperado = "Actividades en el calendario:\n" +
		                                   "Nombre: Actividad 1\n" +
		                                   "Fecha de inicio: 01-01-1970\n" +
		                                   "Duración: 10.0 horas\n" +
		                                   "Lugar: Esto es asi\n" +
		                                   "Descripción: el rio\n" +
		                                   "-----------------------------\n";
		        assertEquals(resultadoEsperado, grupo.visualizarActividades());
		        
		    }
		}
		
		
		@Test
		public void pruebaAceptacion2() {
			System.out.println("---------------ACEPTACION-----------------");
			Usuario usuarioEva = new Usuario ("Eva", "eva@example.com", "+123456789", "contraseña123", "1234567890123456789012");
	    	Usuario usuarioLuis = new Usuario ("Luis", "luis@example.com", "+987654321", "contraseña456", "9876543210123456789012");
	    	Usuario usuarioMarta = new Usuario ("Marta", "marta@example.com", "+111111111", "contraseña789", "1111111110123456789012");
	    	Usuario usuarioJuan = new Usuario ("Juan", "juan@example.com", "+222222222", "contraseñaabc", "2222222220123456789012");
	        
	        List<Usuario> participantes= new ArrayList<>();
	        participantes.add(usuarioEva);
	        participantes.add(usuarioLuis);
	        participantes.add(usuarioMarta);
	        participantes.add(usuarioJuan);
	        
	        Grupo g1 = new Grupo("Los mejores", "foto.jpg", usuarioEva, participantes);
	        //g1.añadirGasto(g1, usuarioEva, participantes, 11.30, "Descripción del gasto", new Date(), "Actividad");
	        g1.reclamarDeuda(usuarioEva);
	        Date fecha = new Date(02-01-1970);
	        
	        g1.añadirActividad("Visita al museo del Prado", new Date(1),120, "Museo del Prado","Visistaremos el hermoso Museo del Prado");
	        g1.añadirActividad("Canoa",new Date(86400000) , 90, "El rio", "Iremos en canoa por el río ");
	        
	        System.out.println("--------------------------------");
	        g1.visualizarActividades();
	        System.out.println("---------------ACEPTACION-----------------");
		}
		
	}
	

}