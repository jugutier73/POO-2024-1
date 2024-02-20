package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar el funcionamiento del código de un estudiante - Parte 2
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
     * Prueba para verificar el registro de clases a un curso
     */
    @Test
    public void registrarClases() {
        LOG.info("Inicio registrarClases");

        var curso = new Curso("Programación 1");

        var primeraClase = new ClaseCurso(LocalDateTime.now().minusDays(15));
        var segundaClase = new ClaseCurso(LocalDateTime.now().minusDays(8));
        var terceraClase = new ClaseCurso(LocalDateTime.now());

        curso.programarClase(primeraClase);
        curso.programarClase(segundaClase);
        curso.programarClase(terceraClase);

        assertEquals(3, curso.getClases().size());

        LOG.info("Finalización registrarClases");
    }

    // TODO ¿Cómo hacer más cortos las siguientes pruebas?

    /**
     * Prueba para verificar que se obtiene la lista de asistentes a una clase
     */
    @Test
    public void listaAsistentes() {
        LOG.info("Inicio listaAsistentes");

        var curso = new Curso("Programación 1");

        var xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412", 31);
        var ana = new Estudiante("Ana", "Quintero", "109498764", "ana@uniquindio.edu.co", "3137442312", 28);
        var juan = new Estudiante("Juan", "Botero", "1092394924", "juan@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(juan);

        var primeraClase = new ClaseCurso(LocalDateTime.now().minusDays(15));
        var segundaClase = new ClaseCurso(LocalDateTime.now().minusDays(8));
        var terceraClase = new ClaseCurso(LocalDateTime.now());

        curso.programarClase(primeraClase);
        curso.programarClase(segundaClase);
        curso.programarClase(terceraClase);

        xiomara.agregarAsistencia(new Asistencia(primeraClase, TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(segundaClase, TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        ana.agregarAsistencia(new Asistencia(primeraClase, TipoAsistencia.PRESENTE));
        ana.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        juan.agregarAsistencia(new Asistencia(segundaClase, TipoAsistencia.AUSENTE));
        juan.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        Collection<Estudiante> listaEsperada = List.of(xiomara, ana);

        assertIterableEquals(listaEsperada, curso.getAsistentes(primeraClase));

        LOG.info("Finalización listaAsistentes");
    }

    /**
     * Prueba para verificar que se obtiene la lista de ausentes a una clase
     */
    @Test
    public void listaAusentes() {
        LOG.info("Inicio listaAusentes");

        var curso = new Curso("Programación 1");

        var xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412", 31);
        var ana = new Estudiante("Ana", "Quintero", "109498764", "ana@uniquindio.edu.co", "3137442312", 28);
        var juan = new Estudiante("Juan", "Botero", "1092394924", "juan@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(juan);

        var primeraClase = new ClaseCurso(LocalDateTime.now().minusDays(15));
        var segundaClase = new ClaseCurso(LocalDateTime.now().minusDays(8));
        var terceraClase = new ClaseCurso(LocalDateTime.now());

        curso.programarClase(primeraClase);
        curso.programarClase(segundaClase);
        curso.programarClase(terceraClase);

        xiomara.agregarAsistencia(new Asistencia(primeraClase, TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(segundaClase, TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        ana.agregarAsistencia(new Asistencia(primeraClase, TipoAsistencia.PRESENTE));
        ana.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        juan.agregarAsistencia(new Asistencia(segundaClase, TipoAsistencia.AUSENTE));
        juan.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        Collection<Estudiante> listaEsperada = List.of(ana, juan);

        assertIterableEquals(listaEsperada, curso.getAusentes(segundaClase));

        LOG.info("Finalización listaAusentes");
    }

    /**
     * Prueba para verificar el porcentaje de asistencia a una clase
     */
    @Test
    public void porcentajeAsistencia() {
        LOG.info("Inicio porcentajeAsistencia");

        var curso = new Curso("Programación 1");

        var xiomara = new Estudiante("Xiomara", "Gomez", "109445634", "xiomara@uniquindio.edu.co", "3148763412", 31);
        var ana = new Estudiante("Ana", "Quintero", "109498764", "ana@uniquindio.edu.co", "3137442312", 28);
        var juan = new Estudiante("Juan", "Botero", "1092394924", "juan@uniquindio.edu.co", "3218341234", 17);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(juan);

        var primeraClase = new ClaseCurso(LocalDateTime.now().minusDays(15));
        var segundaClase = new ClaseCurso(LocalDateTime.now().minusDays(8));
        var terceraClase = new ClaseCurso(LocalDateTime.now());

        curso.programarClase(primeraClase);
        curso.programarClase(segundaClase);
        curso.programarClase(terceraClase);

        xiomara.agregarAsistencia(new Asistencia(primeraClase, TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(segundaClase, TipoAsistencia.PRESENTE));
        xiomara.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        ana.agregarAsistencia(new Asistencia(primeraClase, TipoAsistencia.PRESENTE));
        ana.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        juan.agregarAsistencia(new Asistencia(segundaClase, TipoAsistencia.AUSENTE));
        juan.agregarAsistencia(new Asistencia(terceraClase, TipoAsistencia.PRESENTE));

        assertEquals(0.666, curso.calcularPorcentajeAsistencia(primeraClase), App.PRECISION);

        LOG.info("Finalización porcentajeAsistencia");
    }

}
