package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

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
    public Estudiante obtenerEstudiante(String numeroIdenficacion) {
        Estudiante estudianteInteres = null;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.numeroIdentificacion().equals(numeroIdenficacion)) {
                estudianteInteres = estudiante;
            }
        }
        return estudianteInteres;
    }

    /**
     * Método para obtener el listado de estudiantes
     * 
     * @return Lista no modificable de los estudiantes registrados en el curso
     */
    public Collection<Estudiante> getEstudiantes() {
        return Collections.unmodifiableCollection(estudiantes);
    }

    /**
     * Método para obtener el listado de estudiantes en orden alfabético
     * 
     * @return Lista no modificable de los estudiantes registrados en el curso en
     *         orden alfabético
     */
    public Collection<Estudiante> obtenerListadoAlfabetico() {
        var comparador = Comparator.comparing(Estudiante::nombres);
        var estudiantesOrdenados = estudiantes.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    /**
     * Método para obtener el listado de estudiantes en orden descendente de la edad
     * 
     * @return Lista no modificable de los estudiantes registrados en el curso en
     *         descendente por edad.
     */
    public Collection<Estudiante> obtenerListadoEdadDescente() {
        var comparador = Comparator.comparing(Estudiante::edad).reversed();
        var estudiantesOrdenados = estudiantes.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    /**
     * Método para obtener el listado de estudiantes que son menores de edad
     * 
     * @return Lista no modificable de los estudiantes registrados en el curso que
     *         son menores de edad.
     */
    public Collection<Estudiante> obtenerListadoMenoresEdad() {
        var estudiantesMenoresEdad = new LinkedList<Estudiante>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.edad() < 18) {
                estudiantesMenoresEdad.add(estudiante);
            }
        }
        return Collections.unmodifiableCollection(estudiantesMenoresEdad);
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
        boolean existe = false;

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.numeroIdentificacion().equals(numeroIdentificacion)) {
                existe = true;
            }
        }

        return existe;
    }
}
