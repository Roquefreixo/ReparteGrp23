import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.Nested;

public class ActividadTest {
	
	@Nested
	class testearActividad{
		@Test
	    public void testConstructor() {
	        // Caso de prueba: Crear una actividad con valores válidos
	        String nombreActividad = "Visita Museo";
	        Date fechaInicio = new Date();
	        float duracion = 1.5f;
	        String lugar = "Museo del Prado";
	        String descripcion = "Visita guiada al museo del Prado";

	        Actividad actividad = new Actividad(nombreActividad, fechaInicio, duracion, lugar, descripcion);

	        // Verificar que los atributos se establecen correctamente
	        assertEquals(nombreActividad, actividad.getNombreActividad());
	        assertEquals(fechaInicio, actividad.getFechaInicio());
	        assertEquals(duracion, actividad.getDuracion(), 0.001); // Margen de error de 0.001
	        assertEquals(lugar, actividad.getLugar());
	        assertEquals(descripcion, actividad.getDescripcion());
	    }

	    @Test
	    public void testConstructor_ValoresNulos() {
	        // Intentamos crear una actividad con valores nulos
	    	Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Actividad(null, new Date(1), 1.5f, "Lugar", "Descripción");});
	        assertEquals("Ningún parámetro puede ser nulo.", exception.getMessage());
	        
	        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {new Actividad("Nombre", null, 1.5f, "Lugar", "Descripción");});
	        assertEquals("Ningún parámetro puede ser nulo.", exception2.getMessage());
	        Exception exception3 = assertThrows(IllegalArgumentException.class, () -> {new Actividad("Nombre", new Date(1), 1.5f, null, "Descripción");});
	        assertEquals("Ningún parámetro puede ser nulo.", exception3.getMessage());
	        Exception exception4 = assertThrows(IllegalArgumentException.class, () -> {new Actividad("Nombre", new Date(1), 1.5f, "Lugar", null);});
	        assertEquals("Ningún parámetro puede ser nulo.", exception4.getMessage());
	    }
	    
	    @Test
	    public void testGettersAndSetters() {
	        // Crear una actividad de ejemplo
	        Actividad actividad = new Actividad("Visita Museo", new Date(1), 1.5f, "Museo del Prado", "Visita guiada al museo del Prado");

	        // Modificar los atributos usando setters
	        actividad.setNombreActividad("Visita Ayuntamiento");
	        Date nuevaFecha = new Date(2);
	        actividad.setFechaInicio(nuevaFecha);
	        actividad.setDuracion(2.0f);
	        actividad.setLugar("Madrid");
	        actividad.setDescripcion("Visita al ayuntamiento de Madrid");

	        // Verificar que los cambios se reflejen correctamente usando los getters
	        assertEquals("Visita Ayuntamiento", actividad.getNombreActividad());
	        assertEquals(nuevaFecha, actividad.getFechaInicio());
	        assertEquals(2.0f, actividad.getDuracion(), 0.001); // Margen de error de 0.001
	        assertEquals("Madrid", actividad.getLugar());
	        assertEquals("Visita al ayuntamiento de Madrid", actividad.getDescripcion());

	    }
	}
	
	
}
