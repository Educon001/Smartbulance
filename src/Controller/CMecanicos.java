package Controller;

import Modelo.Taller;
import Modelo.Turno;
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

    public void mostrarTurnos(ArrayList<Turno> turnos, JTable tablaTurnos){
        String[] titulo = {"Entradas","Salidas"};
        String matriz[][]=new String[turnos.size()][2];
        
        for (int i=0;i<turnos.size();i++){
            matriz[i][0]=turnos.get(i).getEntrada().toString();
            if(turnos.get(i).getSalida()==null) matriz[i][1]="No ha terminado";
            else matriz[i][1]=turnos.get(i).getSalida().toString();
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tablaTurnos.setModel(model);
        tablaTurnos.setDefaultEditor(Object.class, null);
    }
    
}
