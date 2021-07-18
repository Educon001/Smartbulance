
package Modelo;

import java.time.LocalDate;

public class Unidad {
    
    private String ubicacion;
    private LocalDate fVencimiento;

    public Unidad(String ubicacion, LocalDate fVencimiento) {
        this.ubicacion = ubicacion;
        this.fVencimiento = fVencimiento;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(LocalDate fVencimiento) {
        this.fVencimiento = fVencimiento;
    }
    
    
}
