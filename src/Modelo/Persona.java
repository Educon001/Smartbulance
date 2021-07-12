
package Modelo;

import java.util.ArrayList;
import java.util.Date;

public class Persona {
    
    protected long cedula;
    protected String nombre, correo, telefono;
    protected Date nacimiento;
    protected ArrayList<Turno> entradaSalida;

    public Persona() {
        entradaSalida = new ArrayList<>();
    }
    
    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Turno> getEntradaSalida() {
        return entradaSalida;
    }
    
    public void registrarEntradaSalida(Turno turno){
        entradaSalida.add(turno);
    }
    
    public Turno ultimaEntradaSalida(){
        return entradaSalida.get(entradaSalida.size()-1);
    }

}
