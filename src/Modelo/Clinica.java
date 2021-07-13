
package Modelo;

import java.util.ArrayList;


public class Clinica extends Entidad{
    //ATRIBUTOS
    private ArrayList<Ambulatorio> ambulatorios;
    private ArrayList<Paciente> histPacientes;
    private ArrayList<Taller> talleresAsociados;
    private ArrayList<Suministro> inventario;
    private boolean disponible;

    
    //CONSTRUCTORES
    public Clinica(ArrayList<Paciente> histPacientes, ArrayList<Suministro> inventario, boolean disponible, String RIF, String ciudad, String direccion) {
        super(RIF, ciudad, direccion);
        this.histPacientes = histPacientes;
        this.inventario = inventario;
        this.disponible = disponible;
    }

    public Clinica() {
    }

    
    //GETTERS Y SETTERS
    public Ambulatorio[] getAmbulatorios() {
        return ambulatorios;
    }

    public void setAmbulatorios(Ambulatorio[] ambulatorios) {
        this.ambulatorios = ambulatorios;
    }

    public ArrayList<Paciente> getHistPacientes() {
        return histPacientes;
    }

    public void setHistPacientes(ArrayList<Paciente> histPacientes) {
        this.histPacientes = histPacientes;
    }

    public ArrayList<Suministro> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Suministro> inventario) {
        this.inventario = inventario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
    //MÉTODOS
    public void incorporarAmbulatorio(Ambulatorio amb){
        if(ambulatorios.size()<10) ambulatorios.add(amb);
    }
    
    public void desincorporarAmbulatorio(Ambulatorio amb){
        ambulatorios.remove(amb);
    }
    
    public void asociarTaller(Taller taller){
        talleresAsociados.add(taller);
    }
    
    public void desasociarTaller(Taller taller){
        talleresAsociados.remove(taller);
    }
   
    public Paciente buscarPaciente(long ced){
        for (Paciente pac: histPacientes){
            if (pac.getCedula()==ced)
                return pac;
        }
      return null; 
    }
    
}
