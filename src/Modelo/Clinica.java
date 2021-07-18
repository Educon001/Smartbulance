
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
    public Clinica(ArrayList<Ambulatorio> ambulatorios, ArrayList<Paciente> histPacientes, ArrayList<Taller> talleresAsociados, ArrayList<Suministro> inventario, boolean disponible) {
        this.ambulatorios = ambulatorios;
        this.histPacientes = histPacientes;
        this.talleresAsociados = talleresAsociados;
        this.inventario = inventario;
        this.disponible = disponible;
    }

    public Clinica(String nombre, String RIF, String ciudad, String estado, String direccion) {    
        super(nombre, RIF, ciudad, estado, direccion);
        ambulatorios = new ArrayList<>();
        histPacientes = new ArrayList<>();
        talleresAsociados = new ArrayList<>();
        inventario = new ArrayList<>();
    }

    public Clinica() {
        ambulatorios = new ArrayList<>();
        histPacientes = new ArrayList<>();
        talleresAsociados = new ArrayList<>();
        inventario = new ArrayList<>();
    }

    
    //GETTERS Y SETTERS
    public ArrayList<Ambulatorio> getAmbulatorios() {
        return ambulatorios;
    }

    public void setAmbulatorios(ArrayList<Ambulatorio> ambulatorios) {
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
   
    public Paciente buscarPaciente(String ced){
        for (Paciente pac: histPacientes){
            if (pac.getCedula().equals(ced))
                return pac;
        }
      return null; 
    }
    
}
