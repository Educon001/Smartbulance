
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
    protected int codigo;
    
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

    public Vehiculo(String serial, boolean enMantenimiento, boolean disponible, int codigo) {
        this.serial = serial;
        this.enMantenimiento = enMantenimiento;
        this.disponible = disponible;
        this.codigo = codigo;
    }
  
    //GETTERS Y SETTERS
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
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
                per.setVehiculoActual(serial);
                return true;
            }
        }
        return false;
    }
    
    public void asignarDRS(){
        Paramedico para = null;
        for (PersonalConVehiculo per : personalActual) {
            if (per instanceof Paramedico){
                if (para == null)
                    para = (Paramedico) per;
                else
                    if (per.getNacimiento().isBefore(para.getNacimiento()))
                        para=(Paramedico) per;
            }
        }
        if (para!=null)
            para.setAsignadoDRS(true);
    }
    
}
