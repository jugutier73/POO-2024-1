package co.edu.uniquindio.poo;

/**
 * Clase para manejar la información de la nota obtenida por un estudiante.
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
public class NotaObtenida {
    private final NotaParcial notaParcial;
    private double notaObtenida;

    /**
     * Método constructor de la clase NotaOntenida
     * 
     * @param notaParcial  nota parcial a al que la nota obtenida está asociada
     * @param notaObtenida valor de la nota obtenida
     */
    public NotaObtenida(NotaParcial notaParcial, double notaObtenida) {
        assert notaParcial != null : "La nota parcial no puede ser null";
        validarValorNota(notaObtenida);

        this.notaParcial = notaParcial;
        this.notaObtenida = notaObtenida;
    }

    /**
     * Método para obtener la nota parcial asociada a la nota obtenida
     * 
     * @return nota parcial asociada a la nota obtenida
     */
    public NotaParcial getNotaParcial() {
        return notaParcial;
    }

    /**
     * Método para obtener el valor de la nota obtenida
     * 
     * @return valor de la nota obtenida
     */
    public double getNotaObtenida() {
        return notaObtenida;
    }

    /**
     * Método que permite actualizar el valor de la nota obtenida
     * 
     * @param notaObtenida nuevo valor de la nota obtenida
     */
    public void setNotaObtenida(double notaObtenida) {
        validarValorNota(notaObtenida);
        this.notaObtenida = notaObtenida;
    }

    /**
     * Método de apoyo (privado) que permite estar seguro que el nuevo valor está en
     * los valores válidos
     * 
     * @param notaObtenida valor de nota obtenida a validar
     */
    private void validarValorNota(double notaObtenida) {
        assert notaObtenida >= 0.0 : "La nota obtenida no puede ser menor que 0.0";
        assert notaObtenida <= 5.0 : "La nota obtenida no puede ser mayor que 5.0";
    }

}
