
package Modelo;

import java.util.ArrayList;

public abstract class Vehiculo {
    protected String serial;
    protected boolean enMantenimiento;
    protected boolean disponible;
    protected ArrayList<Suministro> inventario;
    protected ArrayList<Mantenimiento> histMantenimiento;
    protected ArrayList<Personal> personalActual;
    protected ArrayList<Turno> entradasSalidas;
    
    //CONSTRUCTORES, NO LOS PONGO PORQUE FALTAN LAS DEMAS CLASES
    
    //GETTERS Y SETTERS, NO LOS PONGO PORQUE FALTAN LAS DEMAS CLASES
    
    
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
   
    //MÉTODO ABSTRACTO, SE TIENEN CADA TIPO DE VEHÍCULO TIENE UN TIPO DE EQUIPO
    public abstract void asignarEquipo();   
    
    
}
