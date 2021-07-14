
package Modelo;

import java.util.ArrayList;
import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    
    protected String cedula;
    protected String nombre, correo, telefono;
    protected LocalDate nacimiento;
    protected ArrayList<Turno> entradaSalida;
    protected char genero;

    public Persona() {
        entradaSalida = new ArrayList<>();
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
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

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
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
    
    public Turno buscarTurnoPorDia(LocalDate dia){
        for (Turno turno: entradaSalida){
            LocalDate entrada = turno.getEntrada()
                    .toInstant().atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if (entrada == dia){
                return turno;
            }
        }
        return null;
    }
    
    public boolean validarNombre(String nombre){
        Pattern pat = Pattern.compile("[a-zA-Z ']{5,50}");
        Matcher mat = pat.matcher(nombre);
        return mat.matches();
    }
    
    public boolean validarCorreo(String correo){
        Pattern pat = Pattern.compile("[A-Z0-9._-]+@[A-Z0-9.-]+\\.([A-Z]{2,4})+",Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(correo);
        return mat.matches();
    }
    
}
