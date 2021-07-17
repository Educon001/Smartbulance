
package Controller;

import Modelo.Ambulatorio;
import Modelo.Clinica;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class CClinica {
    private JLabel nombre;
    private JLabel RIF;
    private Clinica clinica;
    private ArrayList<Ambulatorio> listaAmbulatorios;

    public CClinica() {
        //nombre = clinica.get;
        RIF.setText(clinica.getRIF());
        clinica=new Clinica();
        listaAmbulatorios = clinica.getAmbulatorios();
       
    }
    public void mostrarAmbulatorios(JTable tabla){
        String titulo[]={"RIF","Ciudad","Dirección"};
        String matris[][]=new String[listaAmbulatorios.size()][3];
        
        
        for (int i=0;i<listaAmbulatorios.size();i++){
            matris[i][0]=listaAmbulatorios.get(i).getRIF();
            matris[i][1]=listaAmbulatorios.get(i).getCiudad();
            matris[i][2]=listaAmbulatorios.get(i).getDireccion();
     
        }
        
        TableModel model = new DefaultTableModel(matris,titulo);
        tabla.setModel(model);
        
    
    }
    
    
    
    
}
