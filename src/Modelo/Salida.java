
package Modelo;

import java.time.LocalDate;

public class Salida extends Movimiento {
    
    private String argumento;

    public Salida(String argumento, LocalDate fecha, Unidad[] unidades, String tipo) {
        super(fecha, unidades, tipo);
        this.argumento = argumento;
    }

    public String getArgumento() {
        return argumento;
    }

    public void setArgumento(String argumento) {
        this.argumento = argumento;
    }
    
}
