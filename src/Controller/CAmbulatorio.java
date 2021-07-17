
package Controller;

import Modelo.Ambulatorio;
//import Modelo.Personal;
import javax.swing.*;
import javax.swing.table.*;

public class CAmbulatorio extends CEntidad{
    
    private Ambulatorio ambulatorio; //= new Ambulatorio("A","a","ª");

    public CAmbulatorio(Ambulatorio ambulatorio){
        this.ambulatorio = ambulatorio;
    }

    /*public CAmbulatorio() {
    }*/
    
    public void mostrarPersonal(JTable tabla){
        /*Personal per1 = new Personal(1,true,0,null,null,"doc","1","Eduardo","a","1",null,null,'M');
        Personal per2 = new Personal(2,true,0,null,null,"enf","2","Marco","b","2",null,null,'M');
        Personal per3 = new Personal(3,true,0,null,null,"par","3","Jesus","c","3",null,null,'M');
        Personal per4 = new Personal(4,true,0,null,null,"con","4","Jose","d","4",null,null,'F');
        Personal per5 = new Personal(5,true,0,null,null,"sec","5","Steiker","e","5",null,null,'F');
        ambulatorio.registrarPersonal(per1);
        ambulatorio.registrarPersonal(per2);
        ambulatorio.registrarPersonal(per3);
        ambulatorio.registrarPersonal(per4);
        ambulatorio.registrarPersonal(per5);*/
        
        String[] titulos = {"Nombre","Cedula","Numero de Carnet","Tipo"};
        String[][] datos = new String[ambulatorio.getPersonal().size()][4];
        
        for (int i = 0; i < ambulatorio.getPersonal().size(); i++) {
            datos[i][0]=ambulatorio.getPersonal().get(i).getNombre();
            datos[i][1]=ambulatorio.getPersonal().get(i).getCedula();
            datos[i][2]=String.valueOf(ambulatorio.getPersonal().get(i).getNumCarnet());
            datos[i][4]=ambulatorio.getPersonal().get(i).getTipo();
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
    }
    
}
