import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

class GastosTest {

	@Nested
	class testeargastos{
		@Test
	    public void testCalcularHaberesDeberes() {
	        // Preparación de datos de prueba
			Usuario lider = new Usuario("Líder", "lider@example.com", "+123456789", "password", "1234567890123456121213");
			ArrayList<Usuario> lista = new ArrayList<>();
			lista.add(lider);
	        Grupo grupo = new Grupo("NombreGrupo", "foto.jpg", lider, lista);
	        Usuario usuarioQueHaPagado = new Usuario("Usuario1", "usuario1@example.com", "+987654321", "password", "1234567890123456121213");
	        List<Usuario> listaDeUsuariosPagadores = new ArrayList<>();
	        listaDeUsuariosPagadores.add(new Usuario("Usuario2", "usuario2@example.com", "+111111111", "password", "1234567890123456121213"));
	        listaDeUsuariosPagadores.add(new Usuario("Usuario3", "usuario3@example.com", "+333333333", "password", "1234567890123456121213"));
	        double monto = 100.0;
	        String descripcion = "Descripción del gasto";
	        Date fecha = new Date();
	        String actividad = "Actividad del gasto";
	        
	        // Creación de instancia de Gastos
	        Gastos gastos = new Gastos(grupo, usuarioQueHaPagado, listaDeUsuariosPagadores, monto, descripcion, fecha, actividad);
	        
	        // Mapa para almacenar los montos de los usuarios después de calcular los haberes y deberes
	        Map<Usuario, Double> montosUsuarios = new HashMap<>();
	        gastos.calcularHaberesDeberes(montosUsuarios);
	        
	        // Verificación de resultados
	        double montoPorUsuario = monto / listaDeUsuariosPagadores.size();
	        for (Usuario usuario : listaDeUsuariosPagadores) {
	            if (usuario.equals(usuarioQueHaPagado)) {
	                assertEquals(montoPorUsuario, montosUsuarios.get(usuario));
	            } else {
	                assertEquals(-montoPorUsuario, montosUsuarios.get(usuario));
	            }
	        }
	    }
	    
	    @Test
	    public void testSettersAndGetters() {
	        // Mocking de objetos Grupo y Usuario
	        Grupo grupoMock = mock(Grupo.class);
	        Usuario usuarioQueHaPagadoMock = mock(Usuario.class);
	        List<Usuario> listaDeUsuariosPagadoresMock = new ArrayList<>();
	        listaDeUsuariosPagadoresMock.add(mock(Usuario.class));
	        listaDeUsuariosPagadoresMock.add(mock(Usuario.class));
	        
	        // Datos de prueba
	        double monto = 100.0;
	        String descripcion = "Descripción del gasto";
	        Date fecha = new Date();
	        String actividad = "Actividad del gasto";
	        
	        // Creación de instancia de Gastos
	        Gastos gastos = new Gastos(grupoMock, usuarioQueHaPagadoMock, listaDeUsuariosPagadoresMock, monto, descripcion, fecha, actividad);
	        
	        // Verificación de getters
	        assertEquals(grupoMock, gastos.getGrupo());
	        assertEquals(usuarioQueHaPagadoMock, gastos.getUsuarioQueHaPagado());
	        assertEquals(listaDeUsuariosPagadoresMock, gastos.getListaDeUsuariosPagadores());
	        assertEquals(monto, gastos.getMonto());
	        assertEquals(descripcion, gastos.getDescripcion());
	        assertEquals(fecha, gastos.getFecha());
	        assertEquals(actividad, gastos.getActividad());
	        
	        // Cambio de valores utilizando setters
	        Grupo nuevoGrupo = mock(Grupo.class);
	        gastos.setGrupo(nuevoGrupo);
	        assertEquals(nuevoGrupo, gastos.getGrupo());
	        
	        Usuario nuevoUsuario = mock(Usuario.class);
	        gastos.setUsuarioQueHaPagado(nuevoUsuario);
	        assertEquals(nuevoUsuario, gastos.getUsuarioQueHaPagado());
	        
	        List<Usuario> nuevaLista = new ArrayList<>();
	        nuevaLista.add(mock(Usuario.class));
	        gastos.setListaDeUsuariosPagadores(nuevaLista);
	        assertEquals(nuevaLista, gastos.getListaDeUsuariosPagadores());
	        
	        double nuevoMonto = 200.0;
	        gastos.setMonto(nuevoMonto);
	        assertEquals(nuevoMonto, gastos.getMonto());
	        
	        String nuevaDescripcion = "Nueva descripción";
	        gastos.setDescripcion(nuevaDescripcion);
	        assertEquals(nuevaDescripcion, gastos.getDescripcion());
	        
	        Date nuevaFecha = new Date();
	        gastos.setFecha(nuevaFecha);
	        assertEquals(nuevaFecha, gastos.getFecha());
	        
	        String nuevaActividad = "Nueva actividad";
	        gastos.setActividad(nuevaActividad);
	        assertEquals(nuevaActividad, gastos.getActividad());
	    }
	    
	}
    
    
}

