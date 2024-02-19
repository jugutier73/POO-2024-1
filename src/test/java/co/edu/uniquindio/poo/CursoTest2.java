package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
public class CursoTest2 {
    private static final Logger LOG = Logger.getLogger(CursoTest2.class.getName());

    /**
     * Prueba para verificar obtener una nota parcial existente
     */
    @Test
    public void obtenterNotaParcialExistente() {
        LOG.info("Inicio obtenterNotaParcialExistente");

        var curso = new Curso("Programación I");
        var notaParcial = new NotaParcial("Parcial 3", 0.5);

        curso.adicionarNotaParcial(notaParcial);

        assertEquals(notaParcial, curso.getNotaParcial("Parcial 3"));

        LOG.info("Finalización obtenterNotaParcialExistente");
    }

    /**
     * Prueba para verificar obtener una nota parcial inexistente
     */
    @Test
    public void obtenterNotaParcialInexistente() {
        LOG.info("Inicio obtenterNotaParcialInexistente");

        var curso = new Curso("Programación I");
        var notaParcial = new NotaParcial("Parcial 3", 0.5);

        curso.adicionarNotaParcial(notaParcial);

        assertThrows(Throwable.class, () -> curso.getNotaParcial("Parcial 1"));

        LOG.info("Finalización obtenterNotaParcialInexistente");
    }

    /**
     * Prueba para obtener listado de estudiantes mayor nota.
     */
    @Test
    public void obtenerListadoMayorNota() {
        LOG.info("Inicio obtenerListadoMayorNota");

        var curso = new Curso("Programación I");

        var notaParcial1 = new NotaParcial("Parcial 1", 0.1);
        var notaParcial2 = new NotaParcial("Parcial 2", 0.2);
        var notaParcial3 = new NotaParcial("Parcial 3", 0.3);
        var notaParcial4 = new NotaParcial("Parcial 4", 0.4);

        curso.adicionarNotaParcial(notaParcial1);
        curso.adicionarNotaParcial(notaParcial2);
        curso.adicionarNotaParcial(notaParcial3);
        curso.adicionarNotaParcial(notaParcial4);

        var xiomara = new Estudiante("Xiomara", "x", "1", "x@", "0", 15);
        var ana = new Estudiante("Ana", "a", "2", "a@", "0", 18);
        var jorge = new Estudiante("Jorge", "j", "3", "j@", "0", 16);
        var david = new Estudiante("David", "d", "4", "d@", "0", 23);
        var catalina = new Estudiante("Catalina", "c", "5", "c@", "0", 31);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(jorge);
        curso.agregarEstudiante(david);
        curso.agregarEstudiante(catalina);

        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 2.0));
        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 1.3));
        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 4.8));
        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 4.5));

        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 4.5));
        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 3.2));
        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 2.5));
        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 4.5));

        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 1.4));
        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 2.2));
        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 3.1));
        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 1.9));

        david.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 4.8));
        david.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 4.0));
        david.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 3.1));
        david.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 3.8));

        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 2.3));
        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 3.1));
        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 1.9));
        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 3.1));

        Collection<Estudiante> listaEsperada = List.of(xiomara, david);

        assertIterableEquals(listaEsperada, curso.obtenerListadoMayorNota());

        LOG.info("Finalización obtenerListadoMayorNota");
    }

    /**
     * Prueba para obtener listado alfabético de estudiantes que perdieron.
     */
    @Test
    public void obtenerListadoAlfabeticoPerdieron() {
        LOG.info("Inicio obtenerListadoAlfabeticoPerdieron");

        var curso = new Curso("Programación I");

        var notaParcial1 = new NotaParcial("Parcial 1", 0.1);
        var notaParcial2 = new NotaParcial("Parcial 2", 0.2);
        var notaParcial3 = new NotaParcial("Parcial 3", 0.3);
        var notaParcial4 = new NotaParcial("Parcial 4", 0.4);

        curso.adicionarNotaParcial(notaParcial1);
        curso.adicionarNotaParcial(notaParcial2);
        curso.adicionarNotaParcial(notaParcial3);
        curso.adicionarNotaParcial(notaParcial4);

        var xiomara = new Estudiante("Xiomara", "x", "1", "x@", "0", 15);
        var ana = new Estudiante("Ana", "a", "2", "a@", "0", 18);
        var jorge = new Estudiante("Jorge", "j", "3", "j@", "0", 16);
        var david = new Estudiante("David", "d", "4", "d@", "0", 23);
        var catalina = new Estudiante("Catalina", "c", "5", "c@", "0", 31);

        curso.agregarEstudiante(xiomara);
        curso.agregarEstudiante(ana);
        curso.agregarEstudiante(jorge);
        curso.agregarEstudiante(david);
        curso.agregarEstudiante(catalina);

        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 2.0));
        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 1.3));
        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 4.8));
        xiomara.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 4.5));

        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 4.5));
        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 3.2));
        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 2.5));
        ana.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 4.5));

        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 1.4));
        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 2.2));
        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 3.1));
        jorge.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 1.9));

        david.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 4.8));
        david.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 4.0));
        david.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 3.1));
        david.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 3.8));

        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial1, 2.3));
        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial2, 3.1));
        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial3, 1.9));
        catalina.adicionarNotaObtenida(new NotaObtenida(notaParcial4, 3.1));

        Collection<Estudiante> listaEsperada = List.of(catalina, jorge);

        assertIterableEquals(listaEsperada, curso.obtenerListadoAlfabeticoPerdieron());

        LOG.info("Finalización obtenerListadoAlfabeticoPerdieron");
    }

    /**
     * Prueba para validar que el porcentaje de las notas sea 1.0 (100%)
     */
    @Test
    public void validarPorcentaje100Porciento() {
        LOG.info("Inicio validarPorcentaje100Porciento");

        var curso = new Curso("Programación I");

        curso.adicionarNotaParcial(new NotaParcial("Parcial 1", 0.1));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 2", 0.2));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 3", 0.3));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 4", 0.4));

        assert (curso.validarPorcentajes());

        LOG.info("Finalización validarPorcentaje100Porciento");
    }

    /**
     * Prueba para validar que el porcentaje de las notas sea diferente 1.0 (100%)
     */
    @Test
    public void validarPorcentajeDiferente100Porciento() {
        LOG.info("Inicio validarPorcentajeDiferente100Porciento");

        var curso = new Curso("Programación I");

        curso.adicionarNotaParcial(new NotaParcial("Parcial 1", 0.3));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 2", 0.2));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 3", 0.01));
        curso.adicionarNotaParcial(new NotaParcial("Parcial 4", 0.4));
        System.out.println(curso.validarPorcentajes());

        assert (!curso.validarPorcentajes());

        LOG.info("Finalización validarPorcentajeDiferente100Porciento");
    }
}
