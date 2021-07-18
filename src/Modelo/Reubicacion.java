
package Modelo;

public class Reubicacion extends Movimiento{
    
    private String destino;

    public Reubicacion() {
    }

    public String getOrigen() {
        return unidades[0].getUbicacion();
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
  
}
