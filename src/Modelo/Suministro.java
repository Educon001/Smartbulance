
package Modelo;

import java.time.LocalDate;

class Suministro {
    //Atributos
    private String tipo;
    private String nombre_descripcion;
    private LocalDate fIngreso;
    private LocalDate fVencimiento;
    private int cantidad;
    private String mantenimiento;
    
    //Constructores
    public Suministro(){}

    public Suministro(String tipo, String nombre_descripcion, LocalDate fIngreso, LocalDate fVencimiento, int cantidad, String mantenimiento) {
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

    public LocalDate getfIngreso() {
        return fIngreso;
    }

    public void setfIngreso(LocalDate fIngreso) {
        this.fIngreso = fIngreso;
    }

    public LocalDate getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(LocalDate fVencimiento) {
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
    
    public boolean validarCantidad(int cantidad){
        return cantidad>=0;
    }
    
}

