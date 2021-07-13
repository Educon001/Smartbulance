
package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Personal extends Persona {
    
    protected long numCarnet;
    protected boolean activo;
    protected double salario;
    protected Date fechaContrato;
    protected ArrayList<Turno> turnoSemanal;
    protected String tipo;

    public Personal() {
        super();
        turnoSemanal = new ArrayList<>();
    }

    public long getNumCarnet() {
        return numCarnet;
    }

    public void setNumCarnet(long numCarnet) {
        this.numCarnet = numCarnet;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Turno> getTurnoSemanal() {
        return turnoSemanal;
    }

}
