
package Modelo;

class Mantenimiento extends Turno {
    
    private String taller;
    private String descripcion;

    public Mantenimiento() {
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
