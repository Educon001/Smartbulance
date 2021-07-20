package Controller;

import Modelo.Taller;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CMecanicos {
   
    public void iniciarVentana(JFrame ventana,String ruta){
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(new ImageIcon(ruta).getImage()); 
        ventana.setResizable(false); 
    }
    
    public void mostrarMecanicos(ArrayList<String> mecanicos, JTable tablaMecanicos){
        String[] titulo = {"Mecánicos"};
        String matriz[][]=new String[mecanicos.size()][1];
        
        for (int i=0;i<mecanicos.size();i++){
            matriz[i][0]=mecanicos.get(i);
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tablaMecanicos.setModel(model);
        tablaMecanicos.setDefaultEditor(Object.class, null);
    }
    
}
