
package Controller;

import Modelo.*;
import javax.swing.*;
import javax.swing.table.*;

public class CAmbulatorio implements ICEntidad{
    
    private Ambulatorio ambulatorio;

    public CAmbulatorio(Ambulatorio ambulatorio){
        this.ambulatorio = ambulatorio;
    }
    
    public CAmbulatorio(){}

    public Ambulatorio getAmbulatorio() {
        return ambulatorio;
    }
    
    
    /*public CAmbulatorio() {
    }*/
        @Override
    public void mostrarEntidad(JLabel nombre, JLabel telefono,JLabel RIF, JLabel estado, JLabel ciudad, JLabel direccion) {
        nombre.setText(ambulatorio.getNombre());
        RIF.setText(ambulatorio.getRIF());
        estado.setText(ambulatorio.getEstado());
        ciudad.setText(ambulatorio.getCiudad());
        direccion.setText(ambulatorio.getDireccion());
    }

    @Override
    public void editarEntidad(JTextField nombre, JTextField telefono,JTextField estado, JTextField ciudad, JTextField dirección) {
    }
    
    
    public void mostrarPersonal(JTable tabla){
        
        String[] titulos = {"Nombre","Cedula","Numero de Carnet","Tipo"};
        String[][] datos = new String[ambulatorio.getPersonal().size()][4];
        
        for (int i = 0; i < ambulatorio.getPersonal().size(); i++) {
            datos[i][0]=ambulatorio.getPersonal().get(i).getNombre();
            datos[i][1]=ambulatorio.getPersonal().get(i).getCedula();
            datos[i][2]=String.valueOf(ambulatorio.getPersonal().get(i).getNumCarnet());
            datos[i][3]=ambulatorio.getPersonal().get(i).getTipo();
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void crearAmbulancia(boolean enMantenimiento, String serial, boolean disponible,JRadioButton radioTerrestre){
        String tipoAmbulancia;
        
        if(radioTerrestre.isSelected()) tipoAmbulancia = "Terrestre";
        else tipoAmbulancia = "Aerea";
        
        Ambulancia amb = new Ambulancia(serial,enMantenimiento,disponible,tipoAmbulancia);
        ambulatorio.agregarVehiculo(amb);
    }
    
    public void crearCompacto(boolean enMantenimiento, String serial, boolean disponible){
        Compacto comp = new Compacto(serial,enMantenimiento,disponible);
        ambulatorio.agregarVehiculo(comp);
    }
    
    public void crearVehiculo(JRadioButton radioAmb,JTextField txtSerial,JRadioButton radioMant_SI,JRadioButton radioDis_SI,JRadioButton radioTerrestre){
        boolean disponible=false, enMantenimiento=false;
        String serial;
        
        if(radioMant_SI.isSelected()) enMantenimiento=true;
        if(radioDis_SI.isSelected()) disponible=true;
        serial = txtSerial.getText();
        
        if(radioAmb.isSelected()) crearAmbulancia(enMantenimiento,serial,disponible,radioTerrestre);
        else crearCompacto(enMantenimiento,serial,disponible);
    }
    
    public void mostrarTablaVehiculos(JTable tablaVehiculos){
        String titulo[]={"Tipo","Serial","En Mantenimiento","Disponible","Tipo ambulancia"};
        String matriz[][]=new String[ambulatorio.getVehiculos().size()][6];

        for (int i=0;i<ambulatorio.getVehiculos().size();i++){
            if(ambulatorio.getVehiculos().get(i) instanceof Compacto){
                matriz[i][0]="Compacto";
                matriz[i][4]="No aplica";
            }
            if(ambulatorio.getVehiculos().get(i) instanceof Ambulancia){
                matriz[i][0]="Ambulancia";
                matriz[i][4]= ((Ambulancia) ambulatorio.getVehiculos().get(i)).getTipo();
            }
            
            matriz[i][1]=ambulatorio.getVehiculos().get(i).getSerial();
            
            if(ambulatorio.getVehiculos().get(i).isEnMantenimiento()) matriz[i][2]="Sí";
            else matriz[i][2]="No";
            
            if(ambulatorio.getVehiculos().get(i).isDisponible()) matriz[i][3]="Sí";
            else matriz[i][3]="No";
            
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tablaVehiculos.setModel(model);
        tablaVehiculos.setDefaultEditor(Object.class, null);
    }
}
