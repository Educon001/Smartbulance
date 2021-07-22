
package Modelo;

import java.time.LocalDate;

public class PersonalConVehiculo extends Personal {
    
    protected String vehiculoActual;

    public PersonalConVehiculo(String vehiculoActual) {
        this.vehiculoActual = vehiculoActual;
    }

    public PersonalConVehiculo(String vehiculoActual, long numCarnet, boolean activo, double salario, LocalDate fechaContrato, String tipo, String cedula, String nombre, String correo, String telefono, LocalDate nacimiento, char genero) {
        super(numCarnet, activo, salario, fechaContrato, tipo, cedula, nombre, correo, telefono, nacimiento, genero);
        this.vehiculoActual = vehiculoActual;
    }

    
    
    public void setVehiculoActual(String vehiculoActual) {
        this.vehiculoActual = vehiculoActual;
    }

    public String getVehiculoActual() {
        return vehiculoActual;
    }
    
            
}
