
package Modelo;

import java.util.Date;

public class Mantenimiento extends Turno {
    
    private String taller;
    private String descripcion;

    public Mantenimiento() {
    }

    public Mantenimiento(String taller, String descripcion, Date entrada, Date salida) {
        super(entrada, salida);
        this.taller = taller;
        this.descripcion = descripcion;
    }

    public Mantenimiento(String taller, String descripcion, Date entrada) {
        super(entrada);
        this.taller = taller;
        this.descripcion = descripcion;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
