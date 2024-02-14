/**
 * Clase para probar el funcionamiento del código de un estudiante
 * @author Área de programación UQ
 * @since 2024-01
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class EstudianteTest {
    private static final Logger LOG = Logger.getLogger(EstudianteTest.class.getName());

    /**
     * Prueba para verificar que los datos de un estudiante estén completos
     */
    @Test
    public void datosCompletos() {
        LOG.info("Inicio datosCompletos");

        Estudiante estudiante = new Estudiante("Camila", "Alzate Rios", "109453264", "camila@uniquindio.edu.co",
                "315635674", 18);

        assertEquals("Camila", estudiante.nombres());
        assertEquals("Alzate Rios", estudiante.apellidos());
        assertEquals("109453264", estudiante.numeroIdentificacion());
        assertEquals("camila@uniquindio.edu.co", estudiante.correo());
        assertEquals("315635674", estudiante.telefono());
        assertEquals(18, estudiante.edad());
        LOG.info("Finalización datosCompletos");
    }

    /**
     * Prueba para verificar que los datos de un estudiante no estén nulos
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio datosNulos");
        assertThrows(Throwable.class, () -> new Estudiante(null, null, null, null, null, 18));
        LOG.info("Finalización datosNulos");
    }

    /**
     * Prueba para verificar que los datos de un estudiante no estén vacios
     */
    @Test
    public void datosVacios() {
        LOG.info("Inicio datosVacios");
        assertThrows(Throwable.class, () -> new Estudiante("", "", "", "camila@uniquindio.edu.co", "", (byte)18));
        LOG.info("Finalización datosVacios");
    }

    /**
     * Prueba para verificar que el correo del estudiante este correcto
     */
    @Test
    public void edadNegativa() {
        LOG.info("Inicio datosNegativos");
        assertThrows(Throwable.class, () -> new Estudiante("Camila", "Alzate Rios", "109453264",
                "camila@uniquindio.edu.co", "315635674", -18));
        LOG.info("Finalización datosNegativos");
    }

    /**
     * Prueba para verificar que el correo del estudiante esté correcto
     */
    @Test
    public void correoInvalido() {
        LOG.info("Inicio correoInvalido");
        assertThrows(Throwable.class,
                () -> new Estudiante("Camila", "Alzate Rios", "109453264", "cami", "315635674", 18));
        LOG.info("Finalización correoInvalido");
    }

}
