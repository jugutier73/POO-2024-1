package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar el funcionamiento del código de un curso
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class NotaParcialTest {
    private static final Logger LOG = Logger.getLogger(NotaParcialTest.class.getName());

    /**
     * Prueba para verificar que los datos de una nota parcial estén completos
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        var notaParcial = new NotaParcial("Parcial 1", 0.2);

        assertEquals("Parcial 1", notaParcial.nombre());
        assertEquals(0.2, notaParcial.porcentaje());

        LOG.info("Finalización datosCompletos");
    }

    /**
     * Prueba para verificar que el nombre de una nota parcial no sea nulo
     */
    @Test
    public void nombreNulo() {
        LOG.info("Inicio nombreNulo");

        assertThrows(Throwable.class, () -> new NotaParcial(null, 0.2));

        LOG.info("Finalización nombreNulo");
    }

    /**
     * Prueba para verificar que el nombre de una nota parcial no sea vacío
     */
    @Test
    public void nombreVacio() {
        LOG.info("Inicio nombreVacio");

        assertThrows(Throwable.class, () -> new NotaParcial("", 0.2));

        LOG.info("Finalización nombreVacio");
    }

    /**
     * Prueba para verificar que el porcentaje de una nota parcial no sea menor que
     * 0.0 (0%)
     */
    @Test
    public void porcentajeMenorCero() {
        LOG.info("Inicio porcentajeMenorCero");

        assertThrows(Throwable.class, () -> new NotaParcial("Parcial 1", -0.2));

        LOG.info("Finalización porcentajeMenorCero");
    }

    /**
     * Prueba para verificar que el porcentaje de una nota parcial no sea mayor que
     * 1.0 (100%)
     */
    @Test
    public void porcentajeMayorUno() {
        LOG.info("Inicio porcentajeMayorUno");

        assertThrows(Throwable.class, () -> new NotaParcial("Parcial 1", 3.2));

        LOG.info("Finalización porcentajeMayorUno");
    }
}
