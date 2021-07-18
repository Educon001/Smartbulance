package Controller;

import Modelo.Ambulatorio;
import Modelo.Clinica;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
    
}