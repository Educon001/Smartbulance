
package Controller;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CVehiculo {
    
    private Vehiculo vehiculo;
    private Clinica clinica;

    public CVehiculo(Vehiculo vehiculo,Clinica clinica){
        this.vehiculo = vehiculo;
        this.clinica = clinica;
    }
    
    private void mostrarVehiculo(JLabel tipo, JLabel disponible, JLabel labelMantenimiento, JLabel enMantenimiento,JTable personalActual){
        if (vehiculo instanceof Ambulancia)
            tipo.setText("Ambulancia"+((Ambulancia) vehiculo).getTipo());
        else if (vehiculo instanceof Compacto)
            tipo.setText("Vehiculo compacto");
        if (vehiculo.isDisponible()){
            disponible.setText("Si");
            labelMantenimiento.setVisible(false);
            enMantenimiento.setVisible(false);
        }
        else{
            disponible.setText("No");
            if (vehiculo.isEnMantenimiento())
                enMantenimiento.setText("Si");
            else
                enMantenimiento.setText("No");
        }
        String[] titulos = {"Tipo","Cedula","Nombre"};
        String[][] datos = new String[vehiculo.getPersonalActual().size()][3];
        for (int i = 0; i < vehiculo.getPersonalActual().size(); i++) {
            datos[i][0] = vehiculo.getPersonalActual().get(i).getTipo();
            datos[i][1] = vehiculo.getPersonalActual().get(i).getCedula();
            datos[i][2] = vehiculo.getPersonalActual().get(i).getNombre();
        }
        DefaultTableModel modelo = new DefaultTableModel(datos,titulos); 
        personalActual.setModel(modelo);
        personalActual.setDefaultEditor(Object.class, null); 
        personalActual.getTableHeader().setReorderingAllowed(false);
    }
    
    private Ambulatorio getAmbulatorio(){
        for (Ambulatorio am : clinica.getAmbulatorios()){
            for (Vehiculo ve : am.getVehiculos())
                if (ve.equals(vehiculo))
                    return am;
        }
        return null;
    }
    
    private void asignarPersonal(){
        
    }
    
    private void mostrarInventario(JTable tabla){
        String[] titulos = {"Tipo","Nombre","Descripción","Cantidad","Codigo"};
        ArrayList<String[]> datos = new ArrayList<>();
        Ambulatorio am = getAmbulatorio();
        for (Suministro sum : am.getInventario()) {
            String[] dato = new String[5];
            int i=0;
            for (Unidad uni : sum.getUnidades()){
                if (uni.getUbicacion().equals("Ambulancia "+vehiculo.getSerial()) || uni.getUbicacion().equals("Compacto "+vehiculo.getSerial()))
                    i++;
            }
            if (i>0){
                dato[0] = sum.getTipo();
                dato[1] = sum.getNombre();
                dato[2] = sum.getDescripción();
                dato[3] = String.valueOf(i);
                dato[4] = String.valueOf(sum.getCodigo());
            }
                
        }

            
        }
  
}
