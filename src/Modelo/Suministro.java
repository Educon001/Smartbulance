
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Suministro {
    //Atributos
    private String tipo;
    private String nombre;
    private String descripción;
    private int codigo;
    private ArrayList<Movimiento> movimientos;
    private ArrayList<Unidad> unidades;
    
    //Constructores
    public Suministro(String tipo, String nombre, String descripción){
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripción = descripción;
        movimientos = new ArrayList<>();
        unidades = new ArrayList<>();
    }

    public Suministro(String tipo, String nombre, String descripción, int codigo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripción = descripción;
        this.codigo = codigo;
    }
    
    //Getters y setters

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(ArrayList<Unidad> unidades) {
        this.unidades = unidades;
    }
    
    public int getCantidad() {
        int cantidad = unidades.size();
        return cantidad;
    }
    
    public void registrarMovimiento(Movimiento mov){
        movimientos.add(mov);
        if (mov.getTipo().equals("Entrada")){
            for (Unidad uni : mov.getUnidades()) {
                unidades.add(uni);                
            }
        }
        else if (mov.getTipo().equals("Salida")){
            unidades.removeAll(Arrays.asList(mov.getUnidades()));
        }
        else{
            for (int i = 0; i < mov.getUnidades().length; i++) {
                for (Unidad uni : unidades){
                    if (uni.equals(mov.getUnidades()[i])){
                        uni.setUbicacion(((Reubicacion) mov).getDestino());
                        break;
                    }
                }
            }
        }
        asignarCodigos();
    }
    
    public Unidad buscarUnidad(int cod){
        for (Unidad uni : unidades) {
            if (uni.getCodigo()==cod)
                return uni;
        }            
        return null;
    }
    
    private void asignarCodigos(){
        int i=1;
        for (Unidad uni : unidades) {
            uni.setCodigo(i);
            i++;
        }
    }
    
}
