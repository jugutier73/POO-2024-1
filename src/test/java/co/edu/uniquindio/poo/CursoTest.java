package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.List;
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

    /**
     * Prueba para verificar el obtener un listado alfabético
     */
    @Test
    public void obtenerListadoAlfabetico() {
        LOG.info("Inicio obtenerListadoAlfabetico");

        var curso = new Curso("Programación I");

        var camila = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", 15);
        var xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412", 31);
        var ana = new Estudiante("Ana Maria", "Quintero", "109498764", "anamaria@uniquindio.edu.co", "3137442312", 28);
        var yudi = new Estudiante("Yudi", "Pulgarin", "1092394924", "yudi@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(camila);
        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(yudi);

        Collection<Estudiante> listaEsperada = List.of(ana, camila, xiomara, yudi);

        assertIterableEquals(listaEsperada, curso.obtenerListadoAlfabetico());

        LOG.info("Finalización obtenerListadoAlfabetico");
    }

    /**
     * Prueba para verificar el obtener un listado por edad de forma descendente
     */
    @Test
    public void obtenerListadoEdadDescendente() {
        LOG.info("Inicio obtenerListadoEdadDescendente");

        var curso = new Curso("Programación I");

        var camila = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", 15);
        var xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412", 31);
        var ana = new Estudiante("Ana Maria", "Quintero", "109498764", "anamaria@uniquindio.edu.co", "3137442312", 28);
        var yudi = new Estudiante("Yudi", "Pulgarin", "1092394924", "yudi@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(camila);
        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(yudi);

        var listaEsperada = List.of(xiomara, ana, yudi, camila);

        assertIterableEquals(listaEsperada, curso.obtenerListadoEdadDescendente());

        LOG.info("Finalización obtenerListadoEdadDescendente");
    }

    /**
     * Prueba para verificar el obtener un listado de los menores de edad
     */
    @Test
    public void obtenerListadoMenoresEdad() {
        LOG.info("Inicio obtenerListadoMenoresEdad");

        var curso = new Curso("Programación I");

        var camila = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co", "315635674", 15);
        var xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412", 31);
        var ana = new Estudiante("Ana Maria", "Quintero", "109498764", "anamaria@uniquindio.edu.co", "3137442312", 28);
        var yudi = new Estudiante("Yudi", "Pulgarin", "1092394924", "yudi@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(camila);
        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(yudi);

        Collection<Estudiante> listaEsperada = List.of(camila, yudi);

        assertIterableEquals(listaEsperada, curso.obtenerListadoMenoresEdad());

        LOG.info("Finalización obtenerListadoMenoresEdad");
    }
}
