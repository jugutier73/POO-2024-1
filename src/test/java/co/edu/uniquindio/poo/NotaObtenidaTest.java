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
public class NotaObtenidaTest {
    private static final Logger LOG = Logger.getLogger(NotaObtenidaTest.class.getName());

    /**
     * Prueba para verificar que los de una nota obtenida estén completos
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);

        assertEquals(notaParcial, notaObtenida.getNotaParcial());
        assertEquals(3.5, notaObtenida.getNotaObtenida());

        LOG.info("Finalización datosCompletos");
    }

    /**
     * Prueba para verificar que la nota parcial no sea null
     */
    @Test
    public void notaParcialNull() {
        LOG.info("Inicio notaParcialNull");

        assertThrows(Throwable.class, () -> new NotaObtenida(null, 3.5));

        LOG.info("Finalización notaParcialNull");
    }

    /**
     * Prueba para verificar que la nota obtenida no sea menor que 0.0
     */
    @Test
    public void notaObtenidaMenoCero() {
        LOG.info("Inicio notaObtenidaMenoCero");

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        assertThrows(Throwable.class, () -> new NotaObtenida(notaParcial, -2.5));

        LOG.info("Finalización notaObtenidaMenoCero");
    }

    /**
     * Prueba para verificar que la nota obtenida no sea mayor que 5.0
     */
    @Test
    public void notaObtenidaMayorCinco() {
        LOG.info("Inicio notaObtenidaMayorCinco");

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        assertThrows(Throwable.class, () -> new NotaObtenida(notaParcial, 7.8));

        LOG.info("Finalización notaObtenidaMayorCinco");
    }
}
