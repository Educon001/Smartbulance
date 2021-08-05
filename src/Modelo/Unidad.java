
package Modelo;


public class Unidad {
    
    private int codigo;
    private String ubicacion;
    private String fVencimiento;

    public Unidad(String ubicacion, String fVencimiento) {
        this.ubicacion = ubicacion;
        this.fVencimiento = fVencimiento;
    }

    public Unidad(int codigo, String ubicacion, String fVencimiento) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.fVencimiento = fVencimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    } 
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(String fVencimiento) {
        this.fVencimiento = fVencimiento;
    }
    
}
