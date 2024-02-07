package co.edu.uniquindio.poo;

/**
 * Registro que agrupa los datos de un Estudiante
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 * Licencia GNU/GPL V3.0
 * (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public record Estudiante(String nombres, String apellidos, String numeroIdentificacion, String correo, String telefono, int edad) {

    public Estudiante {
        assert nombres != null;
        assert apellidos != null;
        assert numeroIdentificacion != null;
        assert correo != null && correo.contains("@");
        assert telefono != null;
        assert edad > 0;
    }

}
