/**
 * Clase para manejar la información de la agenda
 * @since Marzo 2024
 * @author Área de Programación UQ
 * @license GNU GPL v3
 */

package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.Predicate;

public class Agenda {
    private String nombre;
    private String descripcion;
    private Collection<Contacto> contactos;
    private Collection<Grupo> grupos;


    /**
     * Método constructor de la clase Agenda
     * 
     * @param nombre Nombre del dueño de la agenda
     * @param descripcion Descripción para la agenda (puede ser vacía)
     */
    public Agenda(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;

        contactos = new LinkedList<>();
        grupos = new LinkedList<>();
    }

    /**
     * Método para retornar el nombre de la agenda
     * 
     * @return nombre de la agenda
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para retornar la descripción de la agenda
     * 
     * @return descripción de la agenda
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método para adicionar un contacto a los contactos de la agenda
     * 
     * @param contacto contacto que se debe agregar a la agenda
     */
    public void agregarContacto(Contacto contacto) {
        assert !verificarContactoExiste(contacto);
        contactos.add(contacto);
    }

    /**
     * Método para obtener una colección no modificable de contactos
     * 
     * @return colección no modificable de contactos
     */
    public Collection<Contacto> getContactos() {
        return Collections.unmodifiableCollection(contactos);
    }

    /**
     * Método para obtener una colección no modificable de grupos
     * 
     * @return colección no modificable de grupos
     */
    public Collection<Grupo> getGrupos() {
        return Collections.unmodifiableCollection(grupos);
    }

    /**
     * Método para obtener la colección de contactos en orden alfabético por el
     * correo
     * 
     * @return Colección no modificable de los contactos ordenados por correo.
     */
    public Collection<Contacto> obtenerListadoContactosAlfabeticoCorreo() {
        var comparador = Comparator.comparing(Contacto::email);
        var contactosOrdenados = contactos.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(contactosOrdenados);
    }

    /**
     * Método private que determina si el contacto indicado ya existe dentro de los
     * contactos
     * 
     * @param contacto contacto que se desea buscar
     * @return true o false indicado si el contacto existe o no dentro de los
     *         contactos.
     */
    private boolean verificarContactoExiste(Contacto contacto) {
        Predicate<Contacto> condicion = c -> c.nombre() == contacto.nombre() && c.telefono() == contacto.telefono();
        return contactos.stream().filter(condicion).findAny().isPresent();
    }

}
