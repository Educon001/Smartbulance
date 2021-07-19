
package Modelo;

import java.util.ArrayList;

public class Taller extends Entidad{
    private ArrayList<String> mecanicos;

    public Taller(ArrayList<String> mecanicos, String nombre, String telefono, String RIF, String estado, String ciudad, String direccion) {
        super(nombre, telefono, RIF, estado, ciudad, direccion);
        this.mecanicos = mecanicos;
    }

    
    public ArrayList<String> getMecanicos() {
        return mecanicos;
    }
    
    public void setMecanicos(ArrayList<String> mecanicos) {
        this.mecanicos = mecanicos;
    }
}
