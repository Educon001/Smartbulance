
package Controller;

import Modelo.Ambulatorio;
import Modelo.Suministro;
import javax.swing.*;
import javax.swing.table.*;

public class CInventario {
    
    private Ambulatorio ambulatorio;

    public CInventario(Ambulatorio ambulatorio) {
        this.ambulatorio = ambulatorio;
    }
    
    public void mostrarinventario(JTable tabla,JButton boton){
        Suministro sum1 = new Suministro("1","A","10mg");
        Suministro sum2 = new Suministro("2","B","20mg");
        Suministro sum3 = new Suministro("3","C","30mg");
        Suministro sum4 = new Suministro("4","D","40mg");
        
        ambulatorio.agregarSuministro(sum1);
        ambulatorio.agregarSuministro(sum2);
        ambulatorio.agregarSuministro(sum3);
        ambulatorio.agregarSuministro(sum4);
        
        String[] titulos = {"Tipo","Nombre","Descripción","Cantidad","Codigo"};
        String[][] datos = new String[ambulatorio.getInventario().size()][5];
        
        for (int i = 0; i < ambulatorio.getInventario().size(); i++) {
            datos[i][0]=ambulatorio.getInventario().get(i).getTipo();
            datos[i][1]=ambulatorio.getInventario().get(i).getNombre();
            datos[i][2]=ambulatorio.getInventario().get(i).getDescripción();
            datos[i][3]=String.valueOf(ambulatorio.getInventario().get(i).getCantidad());
            datos[i][4]=String.valueOf(ambulatorio.getInventario().get(i).getCodigo());
            if (datos[i][4].length()==1)
                datos[i][4]="00"+datos[i][4];
            else if (datos[i][4].length()==2)
                datos[i][4]="0"+datos[i][4];
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.addMouseListener(new EventoMouse(boton));
    }
    
    public void registrarSuministro(String tipo, String nombre, String descripcion){
        Suministro sum = new Suministro(tipo,nombre,descripcion);
        ambulatorio.agregarSuministro(sum);
    }
    
    public void verDetalle(JTable tabla){
        int indice = tabla.getSelectedRow();   
        String cod = tabla.getModel().getValueAt(indice,4).toString();
        Suministro sum = ambulatorio.buscarSuministro(Integer.parseInt(cod));
        System.out.println("00"+sum.getCodigo()+"  "+ sum.getNombre());
    }
    
}
