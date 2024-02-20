
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar el funcionamiento del código de un curso - parte 1
 * @author Área de programación UQ
 * @since 2024-01
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
public class CursoTest {
    private static final Logger LOG = Logger.getLogger(CursoTest.class.getName());

    /**
     * Prueba para verificar que los datos de un estudiante estén completos
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        var curso = new Curso("Programación I");

        assertEquals("Programación I", curso.getNombre());

        LOG.info("Finalización datosCompletos");
    }

    /**
     * Prueba para verificar que se agregue un estudiante
     */
    @Test
    public void agregarEstudiante() {
        LOG.info("Inicio agregarEstudiante");

        var curso = new Curso("Programación I");
        var estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674",
                18);

        curso.agregarEstudiante(estudiante);

        assertTrue(curso.getEstudiantes().contains(estudiante));
        assertEquals(1, curso.getEstudiantes().size());

        LOG.info("Finalización agregarEstudiante");
    }

    /**
     * Prueba para verificar que los datos de un curso no estén nulos
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio datosNulos");

        assertThrows(Throwable.class, () -> new Curso(null));

        LOG.info("Finalización datosNulos");
    }

    /**
     * Prueba para verificar que los datos de un curso no estén nulos
     */
    @Test
    public void agregarEstudianteRepetido() {
        LOG.info("Inicio agregarEstudianteRepetido");

        var curso = new Curso("Programación I");

        var estudiante1 = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674",
                18);
        var estudiante2 = new Estudiante("Rodrigo", "Calderon", "109453264", "rodrigo@uniquindio.edu.co", "3223451278",
                19);

        curso.agregarEstudiante(estudiante1);

        assertThrows(Throwable.class, () -> curso.agregarEstudiante(estudiante2));

        LOG.info("Finalización agregarEstudianteRepetido");
    }

    }
