/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Paciente;
import Modelo.Pago;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    

    
    
    public void mostrarPacientes(JTable tabla,ArrayList<Paciente> listaPacientes, JButton Detalles,JButton eliminar){
        
        
        

      
        String[] titulos = {"Cedula","Nombre","Correo","Telefono","Fecha De Nacimiento","Genero"};
        String[][] datos = new String[listaPacientes.size()][6];
        
        for (int i = 0; i < listaPacientes.size(); i++) {
            datos[i][0]=listaPacientes.get(i).getCedula();
            datos[i][1]=listaPacientes.get(i).getNombre();
            datos[i][2]=listaPacientes.get(i).getCorreo();
            datos[i][3]=listaPacientes.get(i).getTelefono();
            datos[i][4]=listaPacientes.get(i).getNacimiento().toString();
            datos[i][5]=String.valueOf(listaPacientes.get(i).getGenero());
            
        }
        
        
        TableModel model = new DefaultTableModel(datos,titulos);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new EventoMouse(Detalles));
        tabla.addMouseListener(new EventoMouse(eliminar));

        
    }
    
    public boolean validarCedula(JTextField txtCedula){
        String cedula = txtCedula.getText();
        int cant;
        try{
            cant = Integer.parseInt(cedula);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Introduzca un valor numerico", "Error Cedula", JOptionPane.ERROR_MESSAGE);
            txtCedula.setText(null);
            return false;
        }
        
        return true;
    }
    public boolean validarCorreo(JTextField txtCorreo){
        String correo = txtCorreo.getText();

        Pattern pat = Pattern.compile("[A-Z0-9._-]+@[A-Z0-9.-]+\\.([A-Z]{2,4})+",Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(correo);
        return mat.matches();
    }
        
    
    
    
   
    
    
    public void mostrarPagos(JTable tabla,ArrayList<Pago> listaPagos){
        
        
        

      
        String[] titulos = {"Factura","Fecha","Monto"};
        String[][] datos = new String[listaPagos.size()][3];
        
        for (int i = 0; i < listaPagos.size(); i++) {
            datos[i][0]=String.valueOf(listaPagos.get(i).getFactura());
            datos[i][1]=String.valueOf(listaPagos.get(i).getFecha());
            datos[i][2]=String.valueOf(listaPagos.get(i).getMonto());
            
            
        }
        
        
        TableModel model = new DefaultTableModel(datos,titulos);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
        
       

        
        
        
        
        
        
    }
    

    
    public void mostrarDetalles(Paciente paciente,JLabel jCedula,JLabel jNombre,JLabel jCorreo,JLabel jTelefono,JLabel jNacimiento, JLabel jGenero){
       
        jCedula.setText(paciente.getCedula());
        jNombre.setText(paciente.getNombre());
        jCorreo.setText(paciente.getCorreo());
        jTelefono.setText(paciente.getTelefono());
        String Fecha = paciente.getNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));

        jNacimiento.setText(Fecha);
        jGenero.setText(String.valueOf(paciente.getGenero()));
        
        
        
   
    }
     
     public Paciente obtenerPacienteSeleccionado(CSistema sis,JTable tabla){
        int indice = tabla.getSelectedRow();   
        String cod = tabla.getModel().getValueAt(indice,0).toString();
        Paciente paciente;
        paciente = sis.buscarPaciente(String.valueOf(cod));
        return paciente;
    }
   
    public void eliminarPaciente(CSistema sis,JTable tabla){
        
        int indice = tabla.getSelectedRow();   
        String cod = tabla.getModel().getValueAt(indice,0).toString();
        Paciente paciente;
        paciente = sis.buscarPaciente(String.valueOf(cod));
        ArrayList<Paciente> lista = sis.getListaPacientes();
        lista.remove(paciente);
        sis.setListaPacientes(lista);
    }

}
