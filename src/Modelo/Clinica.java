
package Modelo;

import java.util.ArrayList;


public class Clinica extends Entidad{
    //ATRIBUTOS
    private ArrayList<Ambulatorio> ambulatorios;
    private ArrayList<Taller> talleresAsociados;
    private boolean disponible;
    
    //CONSTRUCTORES
    public Clinica() {
        ambulatorios = new ArrayList<>();
        talleresAsociados = new ArrayList<>();
    }

    public Clinica(String nombre, String telefono, String RIF, String estado, String ciudad, String direccion) {
        super(nombre, telefono, RIF, estado, ciudad, direccion);
        ambulatorios = new ArrayList<>();
        talleresAsociados = new ArrayList<>();
    }      
    
    //GETTERS Y SETTERS
    public ArrayList<Ambulatorio> getAmbulatorios() {
        return ambulatorios;
    }

    public void setAmbulatorios(ArrayList<Ambulatorio> ambulatorios) {
        this.ambulatorios = ambulatorios;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<Taller> getTalleresAsociados() {
        return talleresAsociados;
    }

    public void setTalleresAsociados(ArrayList<Taller> talleresAsociados) {
        this.talleresAsociados = talleresAsociados;
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
    
    public boolean buscarAmbulatorio_RIF(String RIF){
        for(Ambulatorio amb : ambulatorios){
            if(RIF.equals(amb.getRIF())) return true;
        }
        return false;
    }
    
    public boolean buscarAmbulatorio_Telf(String telf){
        for(Ambulatorio amb : ambulatorios){
            if(telf.equals(amb.getTelefono())) return true;
        }
        return false;
    }
    
    public Ambulatorio retornarAmbulatorio(String RIF){
        for(Ambulatorio amb : ambulatorios){
            if(RIF.equals(amb.getRIF())) return amb;
        }
        return null;
    }
    
}
