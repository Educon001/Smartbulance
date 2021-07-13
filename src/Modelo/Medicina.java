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


public class Medicina extends Suministro{


    
    private String nombre;
    private int dosis;
    private int unidades;
    private int cantidad;
    
    public Medicina(){}

    public Medicina(String nombre, int dosis, int unidades, int cantidad, String fIngreso, String fEgreso, String fVencimiento, boolean vencido) {
        super(fIngreso, fEgreso, fVencimiento, vencido);
        this.nombre = nombre;
        this.dosis = dosis;
        this.unidades = unidades;
        this.cantidad = cantidad;
    }



    public String getNombre() {
        return nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

