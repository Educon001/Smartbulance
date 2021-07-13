/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author familia
 */



public class EquipoMed extends Suministro{

    
    private String tipo;
    private float capacidad;

    public EquipoMed() {}

    public EquipoMed(String tipo, float capacidad, String fIngreso, String fEgreso, String fVencimiento, boolean vencido) {
        super(fIngreso, fEgreso, fVencimiento, vencido);
        this.tipo = tipo;
        this.capacidad = capacidad;
    }


    public String getTipo() {
        return tipo;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(float capacidad) {
        this.capacidad = capacidad;
    }
    
    
    
    
}
