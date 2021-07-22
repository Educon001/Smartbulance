
package Modelo;

import java.time.LocalDate;

public class Conductor extends PersonalConVehiculo{
    
    private long licencia;

    public Conductor(long licencia, String vehiculoActual) {
        super(vehiculoActual);
        this.licencia = licencia;
    }

    public Conductor(long licencia, String vehiculoActual, long numCarnet, boolean activo, double salario, LocalDate fechaContrato, String tipo, String cedula, String nombre, String correo, String telefono, LocalDate nacimiento, char genero) {
        super(vehiculoActual, numCarnet, activo, salario, fechaContrato, tipo, cedula, nombre, correo, telefono, nacimiento, genero);
        this.licencia = licencia;
    }

    

    public long getLicencia() {
        return licencia;
    }

    public void setLicencia(long licencia) {
        this.licencia = licencia;
    }
    
}
