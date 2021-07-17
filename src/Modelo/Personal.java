
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Personal extends Persona {
    
    protected long numCarnet;
    protected boolean activo;
    protected double salario;
    protected LocalDate fechaContrato;
    protected ArrayList<Turno> turnoSemanal;
    protected String tipo;

    public Personal() {
        super();
        turnoSemanal = new ArrayList<>();
    }

    public Personal(long numCarnet, boolean activo, double salario, LocalDate fechaContrato, String tipo, String cedula, String nombre, String correo, String telefono, LocalDate nacimiento, ArrayList<Turno> entradaSalida, char genero) {
        super(cedula, nombre, correo, telefono, nacimiento, genero);
        this.numCarnet = numCarnet;
        this.activo = activo;
        this.salario = salario;
        this.fechaContrato = fechaContrato;
        this.tipo = tipo;
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

    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
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
    
    public boolean validarCarnet(long carnet){
        return carnet>0;
    }

}
