
package Modelo;

public class Medicina extends Suministro{

    private int dosis;
    private int unidades;
    private int cantidad;
    
    public Medicina(){}

    public Medicina(int dosis, int unidades, int cantidad, String nombre, String fIngreso, String fEgreso, String fVencimiento, boolean vencido) {
        super(nombre, fIngreso, fEgreso, fVencimiento, vencido);
        this.dosis = dosis;
        this.unidades = unidades;
        this.cantidad = cantidad;
    }

    public int getDosis() {
        return dosis;
    }

    public int getUnidades() {
        return unidades;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
    
}

