
package Modelo;

import java.util.ArrayList;

class Suministro {
    //Atributos
    private String tipo;
    private String nombre_descripcion;
    private String fIngreso;
    private String fVencimiento;
    private int cantidad;
    private String mantenimiento;
    
    //Constructores
    public Suministro(){}

    public Suministro(String tipo, String nombre_descripcion, String fIngreso, String fVencimiento, int cantidad, String mantenimiento) {
        this.tipo = tipo;
        this.nombre_descripcion = nombre_descripcion;
        this.fIngreso = fIngreso;
        this.fVencimiento = fVencimiento;
        this.cantidad = cantidad;
        this.mantenimiento = mantenimiento;
    }
    
    //Getters y setters
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre_descripcion() {
        return nombre_descripcion;
    }

    public void setNombre_descripcion(String nombre_descripcion) {
        this.nombre_descripcion = nombre_descripcion;
    }

    public String getfIngreso() {
        return fIngreso;
    }

    public void setfIngreso(String fIngreso) {
        this.fIngreso = fIngreso;
    }

    public String getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(String fVencimiento) {
        this.fVencimiento = fVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(String mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    
}

