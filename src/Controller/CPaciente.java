/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Paciente;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author familia
 */

public class CPaciente {
    JTable tablaPacientes=new JTable();
    DefaultTableModel modelo= (DefaultTableModel)tablaPacientes.getModel();

    

    
    
    public void mostrarPacientes(JTable tabla,ArrayList<Paciente> listaPacientes){
        
        

      
        String[] titulos = {"Cedula","Nombre","Correo"};
        String[][] datos = new String[listaPacientes.size()][5];
        
        for (int i = 0; i < listaPacientes.size(); i++) {
            datos[i][0]=listaPacientes.get(i).getCedula();
            datos[i][1]=listaPacientes.get(i).getNombre();
            datos[i][2]=listaPacientes.get(i).getCorreo();
            
        }
        
        
        TableModel model = new DefaultTableModel(datos,titulos);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
        
        
        
    }
    

   
    public ArrayList<Paciente> agregarPaciente(Paciente paciente,ArrayList<Paciente> listaPacientes) {
        
      
        listaPacientes.add(paciente);
        return listaPacientes;
        
        
        }
     
   
    
}
