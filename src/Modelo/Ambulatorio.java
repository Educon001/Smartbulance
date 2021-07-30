package Modelo;

import java.util.ArrayList;

public class Ambulatorio extends Entidad{
    //ATRIBUTOS
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Personal> personal;
    private ArrayList<Suministro> inventario;

    //CONSTRUCTORES
    public Ambulatorio() {
        vehiculos = new ArrayList<>();
        personal = new ArrayList<>();
        inventario = new ArrayList<>();
    }
    
    public Ambulatorio(String nombre, String telefono, String RIF, String estado, String ciudad, String direccion){
        super(nombre,telefono,RIF,estado,ciudad,direccion);
        vehiculos = new ArrayList<>();
        personal = new ArrayList<>();
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

    public ArrayList<Suministro> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Suministro> inventario) {
        this.inventario = inventario;
    }
    
    
    //MÉTODOS
    public void agregarVehiculo(Vehiculo veh){
        if (vehiculos.isEmpty())
            veh.setCodigo(1);
        else
            veh.setCodigo(vehiculos.get(vehiculos.size()-1).getCodigo()+1);
        vehiculos.add(veh);
    }
    
    public void suspenderVehiculo(Vehiculo veh){
        vehiculos.remove(veh);
    }
    
    public void registrarPersonal(Personal per){
        personal.add(per);
    }
   
    public Vehiculo buscarVehiculo(String serial){
        for (Vehiculo veh: vehiculos){
            if (veh.getSerial().equals(serial))
                return veh;
            
        }
      return null; 
    }
    
    public Vehiculo buscarVehiculo(int codigo){
        for (Vehiculo veh: vehiculos){
            if (veh.getCodigo()==codigo)
                return veh;
        }
        return null;
    }

    public void agregarSuministro(Suministro sum){
        sum.setCodigo(inventario.size());
        inventario.add(sum);
    }
    
    public Suministro buscarSuministro(int codigo){
        for (Suministro sum : inventario) {
            if(sum.getCodigo()==codigo)
                return sum;
        }
        return null;
    }
    
    public Personal buscarPersonal(String ci){
        for (Personal per : personal) {
            if(ci.equals(per.getCedula()))
                return per;
        }
        return null;
    }
    
    public void eliminarPersonal(Personal per){
        personal.remove(per);
    }
    
    public void eliminarVehiculo(Vehiculo veh){
        vehiculos.remove(veh);
    }
    
}
