
package Modelo;

import java.time.LocalDate;

public class Reubicacion extends Movimiento{
    
    private String origen;
    private String destino;

    public Reubicacion(String destino, LocalDate fecha, Unidad[] unidades, String tipo) {
        super(fecha, unidades, tipo);
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
  
}
