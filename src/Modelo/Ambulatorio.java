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
        vehiculos = new ArrayList<>();
        personal = new ArrayList<>();
        histPacientes = new ArrayList<>();
        inventario = new ArrayList<>();
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
    
    public Paciente buscarPaciente(String ced){
        for (Paciente pac: histPacientes){
            if (pac.getCedula().equals(ced))
                return pac;
        }
      return null; 
    }
    
    public Vehiculo buscarVehiculo(String serial){
        for (Vehiculo veh: vehiculos){
            if (veh.getSerial().equals(serial))
                return veh;
            
        }
      return null; 
    }
   
}
