
package Modelo;


public class Unidad {
    
    private String ubicacion;
    private String fVencimiento;

    public Unidad(String ubicacion, String fVencimiento) {
        this.ubicacion = ubicacion;
        this.fVencimiento = fVencimiento;
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
