
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import persistencia.PClinica;

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
        movimientos = new ArrayList<>();
        unidades = new ArrayList<>();
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
    
    public void registrarMovimiento(Movimiento mov, String RIFCli, String RIFAmb){
        movimientos.add(mov);
        if (mov.getTipo().equals("Entrada")){
            for (Unidad uni : mov.getUnidades()) {
                unidades.add(uni);
                PClinica persistencia = new PClinica();
                persistencia.agregarUnidad(uni, RIFCli, RIFAmb, String.valueOf(codigo));
            }
        }
        else if (mov.getTipo().equals("Salida")){
            for (Unidad uni : mov.getUnidades()){
                PClinica persistencia = new PClinica();
                persistencia.Unidad_EliminarXMLElement(RIFCli, RIFAmb, String.valueOf(codigo),String.valueOf(uni.getCodigo()));
            }
            unidades.removeAll(Arrays.asList(mov.getUnidades()));
        }
        else{
            for (int i = 0; i < mov.getUnidades().length; i++) {
                for (Unidad uni : unidades){
                    if (uni.equals(mov.getUnidades()[i])){
                        uni.setUbicacion(((Reubicacion) mov).getDestino());
                        PClinica persistencia = new PClinica();
                        persistencia.modificarUnidad(uni, RIFCli, RIFAmb, String.valueOf(codigo),uni.getCodigo());
                        break;
                    }
                }
            }
        }
        asignarCodigos(RIFCli,RIFAmb);
    }
    
    public Unidad buscarUnidad(int cod){
        for (Unidad uni : unidades) {
            if (uni.getCodigo()==cod)
                return uni;
        }            
        return null;
    }
    
    private void asignarCodigos(String RIFCli, String RIFAmb){
        int i=1;
        for (Unidad uni : unidades) {
            PClinica persistencia = new PClinica();
            persistencia.modificarUnidad(uni, RIFCli, RIFAmb, String.valueOf(codigo),i);
            uni.setCodigo(i);
            i++;
        }
    }
    
}
