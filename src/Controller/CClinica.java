
package Controller;

import Modelo.Ambulatorio;
import Modelo.Clinica;
import java.util.ArrayList;
import javax.swing.JLabel;

public class CClinica {
    private JLabel nombre;
    private JLabel RIF;
    private Clinica clinica;
    private ArrayList<Ambulatorio> listaAmbulatorios;

    public CClinica(JLabel nombre, JLabel RIF,Clinica clinica) {
        this.nombre = nombre;
        this.RIF = RIF;
        this.clinica=clinica;
        listaAmbulatorios = clinica.getAmbulatorios();
       
    }
    public void mostrarAmbulatorios(){
        for (int i=0;i<listaAmbulatorios.size();i++) {
            
            nombre.setText(listaAmbulatorios.get(i).getRIF());
            nombre.setText(listaAmbulatorios.get(i).getCiudad());
            for(int x=0;x<listaAmbulatorios.get(i).getVehiculos().size();x++ ){
                
                nombre.setText(listaAmbulatorios.get(i).getVehiculos().get(x).getSerial());              
                            
            
            }
      
        }  
    
    }
    
    
    
    
}
