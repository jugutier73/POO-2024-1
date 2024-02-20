
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Clase para probar el funcionamiento del código de la clase de un Asistencia
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class AsistenciaTest {
    private static final Logger LOG = Logger.getLogger(AsistenciaTest.class.getName());

    /**
     * Prueba para verificar la presencia de un estudiante
     */
    @Test
    public void asistenciaPresente() {
        LOG.info("Inicio asistenciaPresente");

        var fechaOchoDiasAntes = LocalDateTime.now().minusDays(8);
        var claseCurso = new ClaseCurso(fechaOchoDiasAntes);
        var asistencia = new Asistencia(claseCurso, TipoAsistencia.PRESENTE);

        assertEquals(TipoAsistencia.PRESENTE, asistencia.tipoAsistencia());
        assertEquals(fechaOchoDiasAntes, asistencia.claseCurso().fechaClase());
        LOG.info("Finalización asistenciaPresente");
    }

    /**
     * Prueba para verificar la ausencia de un estudiante
     */
    @Test
    public void asistenciaAusencia() {
        LOG.info("Inicio asistenciaAusencia");

        var fechaUnMesAntes = LocalDateTime.now().minusMonths(1);
        var claseCurso = new ClaseCurso(fechaUnMesAntes);
        var asistencia = new Asistencia(claseCurso, TipoAsistencia.AUSENTE);

        assertEquals(TipoAsistencia.AUSENTE, asistencia.tipoAsistencia());
        assertEquals(fechaUnMesAntes, asistencia.claseCurso().fechaClase());
        LOG.info("Finalización asistenciaAusencia");
    }

    /**
     * Prueba para verificar que NO se puede crear una asistencia con nulo en la
     * ClaseCurso
     */
    @Test
    public void claseCursoNulo() {
        LOG.info("Inicio claseCursoNulo");
        assertThrows(Throwable.class, () -> new Asistencia(null, TipoAsistencia.AUSENTE));
        LOG.info("Finalización claseCursoNulo");
    }

}
