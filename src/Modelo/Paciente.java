
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


public class Paciente extends Persona{
    
    private ArrayList<Pago> pagos;

    public Paciente(){
        
    }
   
    public Paciente(String cedula, String nombre, String correo, String telefono, LocalDate nacimiento, char genero) {
        super( cedula,  nombre,  correo,  telefono,  nacimiento,  genero);        
        pagos = new ArrayList<>();
    }  

   

    public ArrayList<Pago> getPagos() {
        return pagos;
    }
    
    public void registrarPago(Pago pago){
       pagos.add(pago);
    }
    
    public Pago buscarPago(long fact){
        for (Pago pago: pagos)
            if (pago.getFactura() == fact)
                return pago;
        return null;
        
    }
    
    //Verifica si el último pago se realizó hace más de un mes
    public boolean alDia(){
        if(!pagos.isEmpty()){
            Date fechaActual = new Date();
            long difMili = fechaActual.getTime()-pagos.get(pagos.size()-1).getFecha().getTime();
            long difDias = difMili/1000/60/60/24;
            if(difDias>31) return false;
            return true;
        }
        return false;
    }
    
    //Verifica si el paciente tiene una emergencia abierta
    public boolean emergenciaAbierta(){
        if(entradaSalida.isEmpty())
            return false;
        else if((super.entradaSalida.get(entradaSalida.size()-1)).getSalida()==null)
            return true;
        return false;
    }
       
    public Emergencia retornarEmergencia(int codigo){
        for(Turno emg : super.entradaSalida){
            if(emg instanceof Emergencia){
                if(((Emergencia) emg).getCodigo()==codigo)
                    return (Emergencia) emg;
            }                      
        }
        return null;
    }
    
}
