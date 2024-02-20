
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar el funcionamiento del código de la clase de un curso
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class ClaseCursoTest {
    private static final Logger LOG = Logger.getLogger(ClaseCursoTest.class.getName());

    /**
     * Prueba para verificar que los datos de un estudiante estén completos
     */
    @Test
    public void claseCursoFechaActual() {
        LOG.info("Inicio claseCursoFechaActual");

        var fechaActual = LocalDateTime.now();
        var claseCurso = new ClaseCurso(fechaActual);

        assertEquals(fechaActual, claseCurso.fechaClase());
        LOG.info("Finalización claseCursoFechaActual");
    }

    /**
     * Prueba para verificar que los datos de un estudiante no estén nulos
     */
    @Test
    public void fechaNula() {
        LOG.info("Inicio fechaNula");
        assertThrows(Throwable.class, () -> new ClaseCurso(null));
        LOG.info("Finalización fechaNula");
    }

}
