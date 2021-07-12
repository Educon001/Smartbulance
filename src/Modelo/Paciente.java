
package Modelo;

import java.util.ArrayList;

public class Paciente extends Persona{
    
    private ArrayList<Pago> pagos;

    public Paciente() {
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
