
package Modelo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vehiculo {  //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    protected String serial;
    protected boolean enMantenimiento;
    protected boolean disponible;
    protected ArrayList<Mantenimiento> histMantenimiento;
    protected ArrayList<PersonalConVehiculo> personalActual;
    protected ArrayList<Turno> entradasSalidas;
    
    //CONSTRUCTORES
    public Vehiculo(){}
    
    public Vehiculo(String serial, boolean enMantenimiento, boolean disponible) {
        this.serial = serial;
        this.enMantenimiento = enMantenimiento;
        this.disponible = disponible;
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

    public ArrayList<Mantenimiento> getHistMantenimiento() {
        return histMantenimiento;
    }

    public void setHistMantenimiento(ArrayList<Mantenimiento> histMantenimiento) {
        this.histMantenimiento = histMantenimiento;
    }

    public ArrayList<PersonalConVehiculo> getPersonalActual() {
        return personalActual;
    }

    public void setPersonalActual(ArrayList<PersonalConVehiculo> personalActual) {
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
        for(PersonalConVehiculo per:personalActual){
            if(per instanceof Conductor)
                return true;
        }
        return false;
    }
    
    public int contarParamedicos(){
       int cont=0;
       for(PersonalConVehiculo per:personalActual){
            if(per instanceof Paramedico)
                cont+=1;
        }
        return cont;
    }
    
    public boolean asignar_Al_Equipo(PersonalConVehiculo per){
        if(per instanceof Conductor){
            if(poseeConductor()==false){
                personalActual.add(per);
                return true;
            }
        }
        return false;
    }   
    
}
