
package Controller;

import Modelo.Ambulatorio;
import Modelo.Clinica;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class CClinica implements ICEntidad{
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
        String matriz[][]=new String[listaAmbulatorios.size()][3];

        for (int i=0;i<listaAmbulatorios.size();i++){
            matriz[i][0]=listaAmbulatorios.get(i).getRIF();
            matriz[i][1]=listaAmbulatorios.get(i).getCiudad();
            matriz[i][2]=listaAmbulatorios.get(i).getDireccion();     
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);    
    }
     
    public void agregarAmbulatorio(Clinica clinica, JTextField txtNombreAmbulatorio,JTextField txt8RIF,JTextField txt1RIF,JTextField txtTelf1,JTextField txtTelf2,JTextField txtCiudad,JTextField txtDir, JComboBox cboEstado){
        Ambulatorio amb = new Ambulatorio();
        amb.setNombre(txtNombreAmbulatorio.getText());
        String RIF = "J-"+txt8RIF.getText()+"-"+txt1RIF.getText();  
        amb.setRIF(RIF);
       
        String telf = txtTelf1+"-"+txtTelf2;
        if(telf.charAt(0)!='0') telf = "0"+telf;
        amb.setTelefono(telf);
        
        amb.setCiudad(txtCiudad.getText().toUpperCase());
        amb.setDireccion(txtDir.getText());
        amb.setEstado(cboEstado.getSelectedItem().toString());
        
        clinica.incorporarAmbulatorio(amb);
    }

    public void mostrarEntidad(JLabel nombre, JLabel RIF, JLabel estado, JLabel ciudad, JLabel dirección) {
    }

    public void editarEntidad(JTextField nombre, JTextField RIF, JTextField estado, JTextField ciudad, JTextField dirección) {
    }
    
}
