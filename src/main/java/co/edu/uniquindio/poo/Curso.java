package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Clase que agrupa los datos de un Curso
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class Curso {
    private final String nombre;
    private final Collection<Estudiante> estudiantes;

    /**
     * Método constructor de la clase Curso
     * 
     * @param nombre Nombre del curso
     */
    public Curso(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
        estudiantes = new LinkedList<>();
    }

    /**
     * Método para obtener el nombre del curso
     * 
     * @return Nombre del curso
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para agregar a un estudiante al curso
     * 
     * @param estudiante Estudiante que se desea agregar
     */
    public void agregarEstudiante(Estudiante estudiante) {
        assert validarNumeroIdentificacionExiste(estudiante.numeroIdentificacion()) == false
                : "El número de identificación ya existe.";
        estudiantes.add(estudiante);
    }

    /**
     * Método para buscar un estudiante dado el número de indicación
     * 
     * @param numeroIdenficacion Número de identificación del estudiante a buscar
     * @return Estudiante con el número de indicación indicado o null
     */
    public Optional<Estudiante> getEstudiante(String numeroIdenficacion) {
        Predicate<Estudiante> condicion = estudiante -> estudiante.numeroIdentificacion().equals(numeroIdenficacion);

        return estudiantes.stream().filter(condicion).findAny();
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso
     * 
     * @return la colección NO modificable de los estudiantes del curso
     */
    public Collection<Estudiante> getEstudiantes() {
        return Collections.unmodifiableCollection(estudiantes);
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso
     * en orden alfabético
     * 
     * @return la colección NO modificable de los estudiantes del curso en orden
     *         alfabético
     */
    public Collection<Estudiante> getListadoAlfabetico() {
        var comparador = Comparator.comparing(Estudiante::nombres);
        var estudiantesOrdenados = estudiantes.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso
     * en orden descendente de la edad
     * 
     * @return la colección NO modificable de los estudiantes del curso en
     *         descendente por edad.
     */
    public Collection<Estudiante> getListadoEdadDescente() {
        var comparador = Comparator.comparing(Estudiante::edad).reversed();
        var estudiantesOrdenados = estudiantes.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso
     * que son menores de edad
     * 
     * @return la colección NO modificable de los estudiantes del curso que son
     *         menores de edad.
     */
    public Collection<Estudiante> getListadoMenoresEdad() {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.edad() < 18)
                .toList();
    }

    /**
     * Método privado para determinar si ya existe un estudiante registro en el
     * mismo número de identificación
     * 
     * @param numeroIdentificacion Número de identificación a buscar
     * @return Valor boolean que indica si el número de identificación ya está o no
     *         registrado.
     */
    private boolean validarNumeroIdentificacionExiste(String numeroIdentificacion) {

        Predicate<Estudiante> condicion = estudiante -> estudiante.numeroIdentificacion().equals(numeroIdentificacion);
        return estudiantes.stream().filter(condicion).findAny().isPresent();
    }
}
