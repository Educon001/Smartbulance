
package Modelo;

import java.util.Date;

public class Emergencia extends Turno{
    
    private String descripcion;
    private boolean respuestaRapida, ambulatorio, clinica;
    private String rifAmbulatorio;
    private String vehiculo;
    private int codigo;

    public Emergencia(String descripcion, boolean respuestaRapida, boolean ambulatorio, boolean clinica, String rifAmbulatorio, String vehiculo, int codigo, Date entrada, Date salida) {
        super(entrada, salida);
        this.descripcion = descripcion;
        this.respuestaRapida = respuestaRapida;
        this.ambulatorio = ambulatorio;
        this.clinica = clinica;
        this.rifAmbulatorio = rifAmbulatorio;
        this.vehiculo = vehiculo;
        this.codigo = codigo;
    }

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRifAmbulatorio() {
        return rifAmbulatorio;
    }

    public void setRifAmbulatorio(String rifAmbulatorio) {
        this.rifAmbulatorio = rifAmbulatorio;
    }  
    
}
