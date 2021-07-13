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
class Suministro {
    protected String fIngreso;
    protected String fEgreso;
    protected String fVencimiento;
    protected boolean vencido;
    
    public Suministro(){}

    public Suministro(String fIngreso, String fEgreso, String fVencimiento, boolean vencido) {
        this.fIngreso = fIngreso;
        this.fEgreso = fEgreso;
        this.fVencimiento = fVencimiento;
        this.vencido = vencido;
    }

    public String getfIngreso() {
        return fIngreso;
    }

    public String getfEgreso() {
        return fEgreso;
    }

    public String getfVencimiento() {
        return fVencimiento;
    }

    public boolean isVencido() {
        return vencido;
    }

    public void setfIngreso(String fIngreso) {
        this.fIngreso = fIngreso;
    }

    public void setfEgreso(String fEgreso) {
        this.fEgreso = fEgreso;
    }

    public void setfVencimiento(String fVencimiento) {
        this.fVencimiento = fVencimiento;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }
    
    
    
    
    
    
    
    
}

