
package Modelo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehiculo {  //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    protected String serial;
    protected boolean enMantenimiento;
    protected boolean disponible;
    protected ArrayList<Suministro> inventario;
    protected ArrayList<Mantenimiento> histMantenimiento;
    protected ArrayList<Personal> personalActual;
    protected ArrayList<Turno> entradasSalidas;
    
    //CONSTRUCTORES
    public Vehiculo(){}
    
    public Vehiculo(String serial, boolean enMantenimiento, boolean disponible) {
        this.serial = serial;
        this.enMantenimiento = enMantenimiento;
        this.disponible = disponible;
        inventario = new ArrayList<>();
        histMantenimiento = new ArrayList<>();
        personalActual = new ArrayList<>();
        entradasSalidas = new ArrayList<>();
    }
    
    
    //GETTERS Y SETTERS

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public boolean isEnMantenimiento() {
        return enMantenimiento;
    }

    public void setEnMantenimiento(boolean enMantenimiento) {
        this.enMantenimiento = enMantenimiento;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<Suministro> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Suministro> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<Mantenimiento> getHistMantenimiento() {
        return histMantenimiento;
    }

    public void setHistMantenimiento(ArrayList<Mantenimiento> histMantenimiento) {
        this.histMantenimiento = histMantenimiento;
    }

    public ArrayList<Personal> getPersonalActual() {
        return personalActual;
    }

    public void setPersonalActual(ArrayList<Personal> personalActual) {
        this.personalActual = personalActual;
    }

    public ArrayList<Turno> getEntradasSalidas() {
        return entradasSalidas;
    }

    public void setEntradasSalidas(ArrayList<Turno> entradasSalidas) {
        this.entradasSalidas = entradasSalidas;
    }
    
    
    
    //OTROS METODOS
    public void registrarMantenimiento(Mantenimiento mantenimiento){
        histMantenimiento.add(mantenimiento);
    }
    
    public void llevarMantenimiento(Mantenimiento mantenimiento){
        enMantenimiento=true;
        disponible=false;
        registrarMantenimiento(mantenimiento);
    }
    
    public void registrarES(Turno io){
        entradasSalidas.add(io);
    }
   
    public boolean poseeConductor(){
        for(Personal per:personalActual){
            if(per instanceof Conductor)
                return true;
        }
        return false;
    }
    
    public int contarParamedicos(){
       int cont=0;
       for(Personal per:personalActual){
            if(per instanceof Paramedico)
                cont+=1;
        }
        return cont;
    }
    
    public boolean asignar_Al_Equipo(Personal per){
        if(per instanceof Conductor){
            if(poseeConductor()==false){
                personalActual.add(per);
                return true;
            }
        }
        return false;
    }   
    
    public boolean validarSerial(String serial){
        Pattern pat = Pattern.compile("[A-Z0-9]{17}",Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(serial);
        return mat.matches();
    }
}
