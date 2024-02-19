package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar el funcionamiento del código de un estudiante
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class EstudianteTest2 {
    private static final Logger LOG = Logger.getLogger(EstudianteTest2.class.getName());

    /**
     * Prueba para verificar que se puede obtener una nota obtenida existente
     */
    @Test
    public void obtenerNotaObtenidaExistente() {
        LOG.info("Inicio obtenerNotaObtenidaExistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);

        assertEquals(notaObtenida, estudiante.getNotaObtenida("Parcial 1"));

        LOG.info("Finalización obtenerNotaObtenidaExistente");
    }

    /**
     * Prueba para verificar que NO se puedan registrar más de una nota a una nota
     * parcial
     */
    @Test
    public void registrarMasUnaNotaParcial() {
        LOG.info("Inicio registrarMasUnaNotaParcial");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida1 = new NotaObtenida(notaParcial, 3.5);
        var notaObtenida2 = new NotaObtenida(notaParcial, 4.2);
        estudiante.adicionarNotaObtenida(notaObtenida1);

        assertThrows(Throwable.class, () -> estudiante.adicionarNotaObtenida(notaObtenida2));

        LOG.info("Finalización registrarMasUnaNotaParcial");
    }

    /**
     * Prueba para verificar que se puede obtener una nota obtenida que NO existente
     */
    @Test
    public void obtenerNotaObtenidaNOExistente() {
        LOG.info("Inicio obtenerNotaObtenidaNOExistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        assertThrows(Throwable.class, () -> estudiante.getNotaObtenida("Parcial 2"));

        LOG.info("Finalización obtenerNotaObtenidaNOExistente");
    }

    /**
     * Prueba para verificar que se puede actualizar una nota obtenida existente
     */
    @Test
    public void actualizarNotaObtenidaExistente() {
        LOG.info("Inicio obtenerNotaObtenidaExistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);
        estudiante.setNotaObtenida("Parcial 1", 4.8);

        assertEquals(notaObtenida, estudiante.getNotaObtenida("Parcial 1"));
        assertEquals(4.8, estudiante.getNotaObtenida("Parcial 1").getNotaObtenida(), App.PRECISION);

        LOG.info("Finalización obtenerNotaObtenidaExistente");
    }

    /**
     * Prueba para verificar que se puede actualizar una nota obtenida existente
     */
    @Test
    public void actualizarNotaObtenidaInexistente() {
        LOG.info("Inicio actualizarNotaObtenidaInexistente");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        assertThrows(Throwable.class, () -> estudiante.setNotaObtenida("Parcial 2", 2.5));

        LOG.info("Finalización actualizarNotaObtenidaInexistente");
    }

    /**
     * Prueba para verificar que se puede actualizar una nota obtenida con una nota
     * mayor a 5.0
     */
    @Test
    public void actualizarNotaObtenidaMayorCinco() {
        LOG.info("Inicio actualizarNotaObtenidaMayorCinco");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);

        assertThrows(Throwable.class, () -> estudiante.setNotaObtenida("Parcial 1", 9.2));

        LOG.info("Finalización actualizarNotaObtenidaMayorCinco");
    }

    /**
     * Prueba para verificar que se puede actualizar una nota obtenida con una nota
     * menor a 0.0
     */
    @Test
    public void actualizarNotaObtenidaMenorCero() {
        LOG.info("Inicio actualizarNotaObtenidaMenorCero");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial = new NotaParcial("Parcial 1", 0.2);
        var notaObtenida = new NotaObtenida(notaParcial, 3.5);
        estudiante.adicionarNotaObtenida(notaObtenida);

        assertThrows(Throwable.class, () -> estudiante.setNotaObtenida("Parcial 1", -2.1));

        LOG.info("Finalización actualizarNotaObtenidaMenorCero");
    }

    /**
     * Prueba para verificar la definitiva cuando se tienen varias notas parciales
     */
    @Test
    public void notaDefinitivaVariasNotas() {
        LOG.info("Inicio notaDefinitivaVariasNotas");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial1 = new NotaParcial("Parcial 1", 0.2);
        var notaParcial2 = new NotaParcial("Parcial 2", 0.3);
        var notaParcial3 = new NotaParcial("Parcial 3", 0.5);

        var notaObtenida1 = new NotaObtenida(notaParcial1, 3.2);
        var notaObtenida2 = new NotaObtenida(notaParcial2, 4.2);
        var notaObtenida3 = new NotaObtenida(notaParcial3, 4.0);

        estudiante.adicionarNotaObtenida(notaObtenida1);
        estudiante.adicionarNotaObtenida(notaObtenida2);
        estudiante.adicionarNotaObtenida(notaObtenida3);

        assertEquals(3.9, estudiante.getDefinitiva(), App.PRECISION);

        LOG.info("Finalización notaDefinitivaVariasNotas");
    }

    /**
     * Prueba para verificar la definitiva cuando NO se tienen varias notas
     * parciales
     */
    @Test
    public void notaDefinitivaSinNotas() {
        LOG.info("Inicio notaDefinitivaSinNotas");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        assertThrows(Throwable.class, () -> estudiante.getDefinitiva());

        LOG.info("Finalización notaDefinitivaSinNotas");
    }

    /**
     * Prueba para verificar la definitiva cuando se tienen varias notas parciales y
     * sus porcentajes no suman 1.0 (100%)
     */
    @Test
    public void notaDefinitivaVariasNotasNo100Porciento() {
        LOG.info("Inicio notaDefinitivaVariasNotasNo100Porciento");

        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 15);

        var notaParcial1 = new NotaParcial("Parcial 1", 0.1);
        var notaParcial2 = new NotaParcial("Parcial 2", 0.2);
        var notaParcial3 = new NotaParcial("Parcial 3", 0.3);

        var notaObtenida1 = new NotaObtenida(notaParcial1, 3.2);
        var notaObtenida2 = new NotaObtenida(notaParcial2, 4.2);
        var notaObtenida3 = new NotaObtenida(notaParcial3, 4.0);

        estudiante.adicionarNotaObtenida(notaObtenida1);
        estudiante.adicionarNotaObtenida(notaObtenida2);
        estudiante.adicionarNotaObtenida(notaObtenida3);

        assertThrows(Throwable.class, () -> estudiante.getDefinitiva());

        LOG.info("Finalización notaDefinitivaVariasNotasNo100Porciento");
    }

}
