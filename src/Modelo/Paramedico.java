
package Modelo;

import java.time.LocalDate;

public class Paramedico extends PersonalConVehiculo {
    
    private boolean asignadoDRS;

    

    public Paramedico(long numCarnet, boolean activo,double salario,LocalDate fechaContrato,String tipo,String cedula,String nombre,String correo,String telefono,LocalDate nacimiento,char genero,boolean asignadoDRS) {
        super(numCarnet, activo, salario, fechaContrato, tipo, cedula, nombre, correo, telefono, nacimiento, genero);
        this.asignadoDRS = asignadoDRS;
    }

    
    
    public boolean isAsignadoDRS() {
        return asignadoDRS;
    }

    public void setAsignadoDRS(boolean asignadoDRS) {
        this.asignadoDRS = asignadoDRS;
    }
    
}
