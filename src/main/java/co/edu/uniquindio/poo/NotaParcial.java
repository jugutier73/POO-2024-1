package co.edu.uniquindio.poo;

/**
 * Registro para manejar la información de una nota parcial
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public record NotaParcial(String nombre, double porcentaje) {  
    
    /**
     * Constructor del registro
     * @param nombre nombre de la nota parcial
     * @param porcentaje valor del peso (porcentaje) de la nota en el curso
     */
    public NotaParcial{
        assert nombre != null && !nombre.isBlank() : "El nombre no puede se nulo ni vacío";
        assert porcentaje > 0.0 : "El porcentaje no puede ser negativo";
        assert porcentaje <= 1.0 : "El porcentaje no puede ser mayor que 1.0 (100%)";
    }
}
