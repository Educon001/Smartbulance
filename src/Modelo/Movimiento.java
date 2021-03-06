
package Modelo;

import java.time.LocalDate;

public class Movimiento {
    protected LocalDate fecha;
    protected Unidad[] unidades;
    protected String tipo;

    public Movimiento() {
    }

    public Movimiento(LocalDate fecha, Unidad[] unidades, String tipo) {
        this.fecha = fecha;
        this.unidades = unidades;
        this.tipo = tipo;
    }
    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Unidad[] getUnidades() {
        return unidades;
    }

    public void setUnidades(Unidad[] unidades) {
        this.unidades = unidades;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad(){
        return unidades.length;
    }
    
}
