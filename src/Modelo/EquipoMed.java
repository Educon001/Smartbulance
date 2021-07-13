
package Modelo;

public class EquipoMed extends Suministro{

    private float capacidad;

    public EquipoMed() {}

    public EquipoMed(float capacidad, String nombre, String fIngreso, String fEgreso, String fVencimiento, boolean vencido) {
        super(nombre, fIngreso, fEgreso, fVencimiento, vencido);
        this.capacidad = capacidad;
    }


    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }
           
}
