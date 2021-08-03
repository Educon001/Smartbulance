
package Controller;

import Modelo.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.*;

public class CClinica {

    private Clinica clinica;

    public CClinica(Clinica clinica) {
        this.clinica=clinica;      
    }

    public Clinica getClinica() {
        return clinica;
    }
    
    
    public void mostrarTablaAmbulatorios(ArrayList<Ambulatorio> ambulatorios, JTable tabla){
        String titulo[]={"Nombre","RIF","Teléfono","Ciudad","Estado","Dirección"};
        String matriz[][]=new String[ambulatorios.size()][6];

        for (int i=0;i<ambulatorios.size();i++){
            matriz[i][0]=ambulatorios.get(i).getNombre();
            matriz[i][1]=ambulatorios.get(i).getRIF();
            matriz[i][2]=ambulatorios.get(i).getTelefono();
            matriz[i][3]=ambulatorios.get(i).getCiudad();
            matriz[i][4]=ambulatorios.get(i).getEstado();
            matriz[i][5]=ambulatorios.get(i).getDireccion();  
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void mostrarTablaTalleres(ArrayList<Taller> talleres, JTable tabla){
        String titulo[]={"Nombre","RIF","Teléfono","Ciudad","Estado","Dirección"};
        String matriz[][]=new String[talleres.size()][6];

        for (int i=0;i<talleres.size();i++){
            matriz[i][0]=talleres.get(i).getNombre();
            matriz[i][1]=talleres.get(i).getRIF();
            matriz[i][2]=talleres.get(i).getTelefono();
            matriz[i][3]=talleres.get(i).getCiudad();
            matriz[i][4]=talleres.get(i).getEstado();
            matriz[i][5]=talleres.get(i).getDireccion();  
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void crearAmbulatorio(Clinica clinica,String nombreAmbulatorio,String RIF,String telefono,String ciudad,String estado,String direccion){
        Ambulatorio amb = new Ambulatorio(nombreAmbulatorio,telefono,RIF,estado,ciudad,direccion);        
        clinica.incorporarAmbulatorio(amb);
    }
    
    public void crearTaller(Clinica clinica,String nombreTaller,String RIF,String telefono,String ciudad,String direccion,String estado,JTextArea txtAreaMecanicos){
        ArrayList<String> mecanicos =new ArrayList<>(Arrays.asList(txtAreaMecanicos.getText().split("\n")));
        mecanicos.remove(0);
        Taller taller = new Taller(mecanicos,nombreTaller,telefono,RIF,estado,ciudad,direccion);       
        clinica.asociarTaller(taller);
    }
    
    
    public boolean seEncuentraRegistradoRIF_Ambulatorio(String RIF, boolean inicio){
        //if(!inicio){
            if(clinica.buscarAmbulatorio_RIF(RIF)){
                if(!inicio) JOptionPane.showMessageDialog(null,"Ya se encuentra un ambulatorio registrado con este RIF.","Error", JOptionPane.ERROR_MESSAGE);
                return true;
          //  } 
        }
        if(inicio) JOptionPane.showMessageDialog(null,"No se encuentra un ambulatorio registrado con este RIF.","Error", JOptionPane.ERROR_MESSAGE);
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
    
    public String pasarAtributo_DeTabla(JTable tablaEntidad,int columna){
        int indice = tablaEntidad.getSelectedRow();
        TableModel modelo = tablaEntidad.getModel();
        try{
            String atributo = modelo.getValueAt(indice,columna).toString();
            return atributo;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showConfirmDialog(null,"Debe seleccionar un item de la tabla.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public Taller tallerSeleccionado(JTable tablaEntidad){
        String RIF = pasarAtributo_DeTabla(tablaEntidad,1);
        if(RIF!=null){
            System.out.println(RIF+" RIF PASADO");
            return clinica.buscarTaller(RIF);
        }
        return null;
    }
    
    public Ambulatorio ambulatorioSeleccionado(JTable tablaEntidad){
        String RIF = pasarAtributo_DeTabla(tablaEntidad,1);
        if(RIF!=null){
            return clinica.retornarAmbulatorio(RIF);
        }
        return null;
    }
    
    public boolean buscarVehiculo(String serial){
        for(Ambulatorio amb : clinica.getAmbulatorios()){
            for(Vehiculo veh : amb.getVehiculos()){
                if(serial.equals(veh.getSerial())){
                    JOptionPane.showMessageDialog(null,"Ya se encuentra un vehículo registrado con este serial.","Error",JOptionPane.ERROR_MESSAGE);
                    return true;
                }
            }
        }
        return false;   
    }
    
    public void clinicaDisponible(JToggleButton disp){
        clinica.setDisponible(disp.isSelected());
    }
    
    public boolean tallerRegistrado(String RIF){
        if (clinica.buscarTaller(RIF)!=null)
            return true;
        JOptionPane.showMessageDialog(null, "El taller que ingresó no se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
}