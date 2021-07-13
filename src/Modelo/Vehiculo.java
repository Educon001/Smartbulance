
package Modelo;

import java.util.ArrayList;

public class Vehiculo {  //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
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
    
}
