
package Modelo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Turno {
    protected Date entrada, salida;

    public Turno() {
    }

    public Turno(Date entrada, Date salida) {
        this.entrada = entrada;
        this.salida = salida;
    }
    
    
    
    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }
    
    public long duracion(){
        return TimeUnit.MILLISECONDS.toHours(salida.getTime()-entrada.getTime());
    }
}
