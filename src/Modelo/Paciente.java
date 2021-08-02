
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;



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
    
    //public boolean alDia(){ Hay que hacer este método
       
}
