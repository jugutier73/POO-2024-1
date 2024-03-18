/**
 * Clase para manejar la información de los grupos.
 * @since Marzo 2024
 * @author Área de Programación UQ
 * @license GNU GPL v3
 */

package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;

public class Grupo {
    private Categoria categoria;
    private Collection<Contacto> contactos;

    /**
     * Método constructor de la clase Grupo
     * 
     * @param categoria categoría del grupo
     */
    public Grupo(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Método para obtener la categoría del grupo
     * 
     * @return categoría del grupo
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Método para adicionar un contacto al grupo
     * 
     * @param contacto contacto que se desea adicionar
     */
    public void addContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    /**
     * Método para obtener los contactos del grupo
     * 
     * @return Colección no modificable de los contactos del grupo.
     */
    public Collection<Contacto> getContactos() {
        return Collections.unmodifiableCollection(contactos);
    }
}
