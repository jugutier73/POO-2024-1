package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Clase para manejar la información de un Estudiante
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class Estudiante {
    private final String nombres;
    private final String apellidos;
    private final String numeroIdentificacion;
    private final String correo;
    private final String telefono;
    private final int edad;
    private final Collection<Asistencia> asistencias;

    /**
     * Método constructor de la clase Estudiante
     * 
     * @param nombres              nombres del estudiante
     * @param apellidos            apellidos del estudiante
     * @param numeroIdentificacion número de identificación del estudiante
     * @param correo               correo electrónico del estudiante
     * @param telefono             teléfono del estudiante
     * @param edad                 edad del estudiante
     */
    public Estudiante(String nombres, String apellidos, String numeroIdentificacion, String correo, String telefono,
            int edad) {
        assert nombres != null && !nombres.isBlank() : "El nombre debe ser diferente de null";
        assert apellidos != null && !apellidos.isBlank() : "El apellido debe ser diferente de null";
        assert numeroIdentificacion != null && !numeroIdentificacion.isBlank()
                : "El número de identificación debe ser diferente de null";
        assert correo != null && correo.contains("@") : "El correo electrónico debe contener el símbolo @";
        assert telefono != null : "El teléfono no puede ser null";
        assert edad > 0 : "La edad debe ser mayor a cero";

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.numeroIdentificacion = numeroIdentificacion;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;

        this.asistencias = new LinkedList<>();
    }

    /**
     * Método para obtener los nombres del estudiante
     * 
     * @return los nombres del estudiante
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método para obtener los apellidos del estudiante
     * 
     * @return los apellidos del estudiante
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Método para obtener el número de identificación del estudiante
     * 
     * @return número de identificación del estudiante
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Método para obtener el correo electrónico del estudiante
     * 
     * @return correo electrónico del estudiante
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método para obtener el teléfono del estudiante
     * 
     * @return teléfono del estudiante
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método para obtener la edad del estudiante
     * 
     * @return edad del estudiante
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Método para agregar una asistencia a un estudiante.
     * TODO evitar agregar más de una vez una misma asistencia.
     * 
     * @param asistencia asistencia del estudiante
     */
    public void agregarAsistencia(Asistencia asistencia) {
        assert asistencia != null : "Error la asistencia no puede nulo";

        asistencias.add(asistencia);
    }

    /**
     * Método para obtener la colección no modifiable de las asistencias.
     * 
     * @return colección no modificable de las asistencias.
     */
    public Collection<Asistencia> getAsistencias() {
        return Collections.unmodifiableCollection(asistencias);
    }

    /**
     * 
     * @param claseCurso
     * @return
     */
    public boolean asistioClase(ClaseCurso claseCurso) {
        Predicate<Asistencia> fechaIgual = j -> j.claseCurso().fechaClase().isEqual(claseCurso.fechaClase());
        Predicate<Asistencia> asistioPresente = j -> j.tipoAsistencia() == TipoAsistencia.PRESENTE;
        var asistencia = asistencias.stream().filter(fechaIgual.and(asistioPresente)).findAny();
        return asistencia.isPresent();
    }
}
