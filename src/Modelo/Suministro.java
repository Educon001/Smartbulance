
package Modelo;

class Suministro {
    
    protected String nombre;
    protected String fIngreso;
    protected String fEgreso;
    protected String fVencimiento;
    protected boolean vencido;
    
    public Suministro(){}

    public Suministro(String nombre, String fIngreso, String fEgreso, String fVencimiento, boolean vencido) {
        this.nombre = nombre;
        this.fIngreso = fIngreso;
        this.fEgreso = fEgreso;
        this.fVencimiento = fVencimiento;
        this.vencido = vencido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

