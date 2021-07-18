
package Modelo;

public class Emergencia extends Turno{
    
    private String descripcion;
    private boolean respuestaRapida, ambulatorio, clinica;
    private String vehiculo;
    private long codigo;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRespuestaRapida() {
        return respuestaRapida;
    }

    public void setRespuestaRapida(boolean respuestaRapida) {
        this.respuestaRapida = respuestaRapida;
    }

    public boolean isAmbulatorio() {
        return ambulatorio;
    }

    public void setAmbulatorio(boolean ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public boolean isClinica() {
        return clinica;
    }

    public void setClinica(boolean clinica) {
        this.clinica = clinica;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
}
