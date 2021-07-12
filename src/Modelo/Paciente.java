
package Modelo;

import java.util.ArrayList;

public class Paciente extends Persona{
    
    private boolean alDia;
    private ArrayList<Pago> pagos;

    public Paciente() {
        pagos = new ArrayList<>();
    }

    public boolean isAlDia() {
        return alDia;
    }

    public void setAlDia(boolean alDia) {
        this.alDia = alDia;
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
    
}
