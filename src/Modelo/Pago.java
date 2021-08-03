
package Modelo;

import java.util.Date;

public class Pago {
    
    private long factura;
    private Date fecha;
    private double monto;
    
    public Pago() {     
    }

    public Pago(long factura,Date fecha,double monto) {
        this.factura=factura;
        this.fecha=fecha;
        this.monto=monto;
    }

    public long getFactura() {
        return factura;
    }

    public void setFactura(long factura) {
        this.factura = factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
