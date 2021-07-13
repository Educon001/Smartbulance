package Modelo;

import java.util.ArrayList;

public class Ambulatorio extends Entidad{
    //ATRIBUTOS
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Personal> personal;
    private ArrayList<Paciente> histPacientes;
    private ArrayList<Suministro> inventario;

    //CONSTRUCTORES
    public Ambulatorio() {
    }
    
    public Ambulatorio(ArrayList<Vehiculo> vehiculos, ArrayList<Personal> personal, ArrayList<Paciente> histPacientes, ArrayList<Suministro> inventario, String RIF, String ciudad, String direccion) {
        super(RIF, ciudad, direccion);
        this.vehiculos = vehiculos;
        this.personal = personal;
        this.histPacientes = histPacientes;
        this.inventario = inventario;
    }
    
    
    //GETTERS Y SETTERS
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
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
    
    
    //MÉTODOS
    public void agregarVehiculo(Vehiculo veh){
        vehiculos.add(veh);
    }
    
    public void suspenderVehiculo(Vehiculo veh){
        vehiculos.remove(veh);
    }
    
    public void registrarPersonal(Personal per){
        personal.add(per);
    }
    
    public void registrarPaciente(Paciente pac){
        histPacientes.add(pac);
    }
    
    public Paciente buscarPaciente(long ced){
        for (Paciente pac: histPacientes){
            if (pac.getCedula()==ced)
                return pac;
        }
      return null; 
    }
   
}
