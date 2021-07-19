
package Controller;

import Modelo.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.*;

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

    public CClinica(Clinica clinica) {
        this.clinica=clinica;      
    }

    public Clinica getClinica() {
        return clinica;
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
     
    public void crearAmbulatorio(Clinica clinica,String nombreAmbulatorio,String RIF,String telefono,String ciudad,String estado,String direccion){
        Ambulatorio amb = new Ambulatorio(nombreAmbulatorio,telefono,RIF,estado,ciudad,direccion);        
        clinica.incorporarAmbulatorio(amb);
    }
    
    public void crearTaller(Clinica clinica,String nombreTaller,String RIF,String telefono,String ciudad,String estado,String direccion,ArrayList<String> mecanicos){
        Taller taller = new Taller(mecanicos,nombreTaller,telefono,RIF,estado,ciudad,direccion);        
        clinica.asociarTaller(taller);
        prueba(clinica.getTalleresAsociados().get(0));
    }
    
    
    public boolean seEncuentraRegistradoRIF_Ambulatorio(String RIF, boolean inicio){
        if(!inicio){
            if(clinica.buscarAmbulatorio_RIF(RIF)){
                JOptionPane.showMessageDialog(null,"Ya se encuentra un ambulatorio registrado con este RIF.","Error", JOptionPane.ERROR_MESSAGE);
                return true;
            } 
        }
        return false;
    }
    
    public boolean seEncuentraRegistradoTelf_Ambulatorio(String telf, boolean inicio){
        if(!inicio){
            if(clinica.buscarAmbulatorio_Telf(telf)){
                JOptionPane.showMessageDialog(null,"Ya se encuentra un ambulatorio registrado con este número telefónico.","Error", JOptionPane.ERROR_MESSAGE);
                return true;
            } 
        }
        return false;
    }
    
    public void prueba(Taller taller){
        for(String mec : taller.getMecanicos()){
            System.out.println(mec+"\n");
        }
        
    }
    
}
