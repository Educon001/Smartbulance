
package Controller;

import Modelo.Ambulatorio;
import javax.swing.*;
import javax.swing.table.*;

public class CAmbulatorio implements ICEntidad{
    
    private Ambulatorio ambulatorio;

    public CAmbulatorio(Ambulatorio ambulatorio){
        this.ambulatorio = ambulatorio;
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
    
    public void mostrarInventario(JTable tabla){
    }
}
