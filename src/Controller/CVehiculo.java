
package Controller;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CVehiculo {
    
    private Vehiculo vehiculo;
    private Clinica clinica;

    public CVehiculo(Vehiculo vehiculo,Clinica clinica){
        this.vehiculo = vehiculo;
        this.clinica = clinica;
    }
    
    private void mostrarVehiculo(JLabel codigo, JLabel serial, JLabel tipo, JLabel disponible, JLabel labelMantenimiento, JLabel enMantenimiento,JTable personalActual){
        if (vehiculo instanceof Ambulancia)
            tipo.setText("Ambulancia"+((Ambulancia) vehiculo).getTipo());
        else if (vehiculo instanceof Compacto)
            tipo.setText("Vehiculo compacto");
        if (vehiculo.isDisponible()){
            codigo.setText(String.valueOf(vehiculo.getCodigo()));
            serial.setText(vehiculo.getSerial());
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
        String[] titulos = {"Tipo","Nombre","Cedula"};
        String[][] datos = new String[vehiculo.getPersonalActual().size()][3];
        for (int i = 0; i < vehiculo.getPersonalActual().size(); i++) {
            datos[i][0] = vehiculo.getPersonalActual().get(i).getTipo();
            datos[i][1] = vehiculo.getPersonalActual().get(i).getNombre();
            datos[i][2] = vehiculo.getPersonalActual().get(i).getCedula();        
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
    
    private void asignarPersonal(JTable asignados, JTable personal){
        String[] titulos = {"Tipo","Nombre","Cedula"};
        String[][] datos1 = new String[vehiculo.getPersonalActual().size()][3];
        String[][] datos2;
        int cont=0;
        Ambulatorio am = getAmbulatorio();
        for (Personal per : am.getPersonal()){
            if (per instanceof PersonalConVehiculo)
                cont++;
        }
        datos2 = new String[cont][3];
        for (int i = 0; i < vehiculo.getPersonalActual().size(); i++) {
            datos1[i][0] = vehiculo.getPersonalActual().get(i).getTipo();
            datos1[i][1] = vehiculo.getPersonalActual().get(i).getNombre();
            datos1[i][2] = vehiculo.getPersonalActual().get(i).getCedula();
        }
        for (int i = 0,j = 0; i < am.getPersonal().size(); i++) {
            if (am.getPersonal().get(i) instanceof PersonalConVehiculo && ((PersonalConVehiculo) am.getPersonal().get(i)).getVehiculoActual() != null){
                datos2[j][0] = am.getPersonal().get(i).getTipo();
                datos2[j][1] = am.getPersonal().get(i).getNombre();
                datos2[j][2] = am.getPersonal().get(i).getCedula();
                j++;
            }
        }
        DefaultTableModel modelo1 = new DefaultTableModel(datos1,titulos);
        DefaultTableModel modelo2 = new DefaultTableModel(datos2,titulos);
        asignados.setModel(modelo1);
        asignados.setDefaultEditor(Object.class, null); 
        asignados.getTableHeader().setReorderingAllowed(false);
        personal.setModel(modelo2);
        personal.setDefaultEditor(Object.class, null); 
        personal.getTableHeader().setReorderingAllowed(false);
    }
    
    private void mostrarInventario(JTable tabla){
        String[] titulos = {"Tipo","Nombre","Descripción","Cantidad","Codigo"};
        ArrayList<String[]> datos = new ArrayList<>();
        Ambulatorio am = getAmbulatorio();
        for (Suministro sum : am.getInventario()) {
            int i=0;
            for (Unidad uni : sum.getUnidades()){
                if (uni.getUbicacion().equals("Ambulancia "+String.valueOf(vehiculo.getCodigo())) || uni.getUbicacion().equals("Compacto "+String.valueOf(vehiculo.getCodigo())))
                    i++;
            }
            if (i>0){
                String[] dato = new String[5];
                dato[0] = sum.getTipo();
                dato[1] = sum.getNombre();
                dato[2] = sum.getDescripción();
                dato[3] = String.valueOf(i);
                String cod = String.valueOf(sum.getCodigo());
                if (cod.length()==1)
                    cod="00"+cod;
                else if (cod.length()==2)
                    cod="0"+cod;
                dato[4] = cod;
                datos.add(dato);
            }               
        }
        String[][] arrayDatos = new String[datos.size()][5];
        for (int i = 0; i < datos.size(); i++) {
            arrayDatos[i]=datos.get(i);
        }
        TableModel modelo = new DefaultTableModel(arrayDatos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null); 
        tabla.getTableHeader().setReorderingAllowed(false);
    }
  
}
