/**
 * Clase para probar el funcionamiento de la clase Agenda
 * @author Área de programación UQ
 * @since 2024-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AgendaTest {
    private static final Logger LOG = Logger.getLogger(AgendaTest.class.getName());

    @Test
    public void contactosIguales() {
        LOG.info("Iniciado test contactosIguales");

        Agenda agenda = new Agenda("Personal", "Amigos y Familia");

        Contacto contacto1 = new Contacto("Raul", "Yulbra", "Cr 10 N", "12345", "ryrivera@uniquindio.edu.co");
        Contacto contacto2 = new Contacto("Raul", "El flaco", "Calle 100", "12345", "rarias@uniquindio.edu.co");

        agenda.agregarContacto(contacto1);

        assertThrows(Throwable.class, () -> agenda.agregarContacto(contacto2));

        LOG.info("Finalizando test contactosIguales");
    }

    @Test
    public void obtenerListadoContactosAlfabetico() {
        LOG.info("Inicio obtenerListadoContactosAlfabetico");

        Agenda agenda = new Agenda("Programación I", "Esta es la agenda para guardar los contactos del vicerrector");

        Contacto camila = new Contacto("Camila", "Camila", "Km 2", "3221593403", "camila@uniquindio.edu.co");
        Contacto xiomara = new Contacto("Xiomara", "Xiomi", "avenida 20 # 13-80", "3148763412", "xiomara@uniquindio.edu.co");
        Contacto ana = new Contacto("Ana Maria", "Anita", "Carrera 20", "3137442312", "anamaria@uniquindio.edu.co");

        agenda.agregarContacto(camila);
        agenda.agregarContacto(xiomara);
        agenda.agregarContacto(ana);

        Collection<Contacto> listaEsperada = List.of(ana, camila, xiomara);

        assertIterableEquals(listaEsperada, agenda.obtenerListadoContactosAlfabeticoCorreo());

        LOG.info("Finalización obtenerListadoContactosAlfabetico");
    }

}
