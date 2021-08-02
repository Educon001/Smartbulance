package Controller;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CEmergencia {
    
    public void llenarListaAmbDisp(Clinica clinica,ArrayList<Ambulatorio> ambDisp){
        for(Ambulatorio amb : clinica.getAmbulatorios()){
            if(amb.isDisponible()) ambDisp.add(amb);
        }
    }
    
    public void mostrarAmbDisp(JTable tabla,Clinica clinica){        
        //Lista de ambulatorios disponibles
        ArrayList<Ambulatorio> ambDisp = new ArrayList<Ambulatorio>();
        llenarListaAmbDisp(clinica,ambDisp);
        
        String[] titulos = {"Nombre","Ciudad","Dirección","Teléfono"};
        String[][] datos = new String[ambDisp.size()][4];
        
        for (int i = 0; i < ambDisp.size(); i++) {
            datos[i][0]=ambDisp.get(i).getNombre();
            datos[i][1]=ambDisp.get(i).getCiudad();
            datos[i][2]=ambDisp.get(i).getDireccion();
            datos[i][3]=ambDisp.get(i).getTelefono();
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void titulosTablaAmbSelec(JTable tabla){
        String[] titulos = {"Nombre","Ciudad","Dirección","Teléfono"};
        TableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
    }
    
    
    public void mostrarAmbulatorioSeleccionado(JTable tabla,Ambulatorio amb){        
        //DATOS DEL AMBULATORIO SELECCIONADO
        String[] titulos = {"Nombre","Ciudad","Dirección","Teléfono"};
        String[][] datos = new String[1][4];
        
        datos[0][0]=amb.getNombre();
        datos[0][1]=amb.getCiudad();
        datos[0][2]=amb.getDireccion();
        datos[0][3]=amb.getTelefono();

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void mostrarVehiculosDisponibles(JTable tabla,ArrayList<Vehiculo> vehiculos){
        String[] titulos = {"Código","Serial","Tipo"};
        String[][] datos = new String[vehiculos.size()][3];
        
        for(int i=0; i<vehiculos.size(); i++){
            datos[i][0]=Integer.toString(vehiculos.get(i).getCodigo());
            datos[i][1]=vehiculos.get(i).getSerial();
            if(vehiculos.get(i) instanceof Ambulancia)
                datos[i][2]=((Ambulancia)vehiculos.get(i)).getTipo();
            if(vehiculos.get(i) instanceof Compacto)
                datos[i][2]="Respuesta rápida";
        }

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void llenarListaAmbulanciasDisp(Ambulatorio ambulatorio,ArrayList<Vehiculo> ambulanciasDisp){
        for(Vehiculo veh : ambulatorio.getVehiculos()){
            if(veh instanceof Ambulancia && veh.isDisponible() && veh.getPersonalActual()!=null)
                ambulanciasDisp.add((Ambulancia) veh);
        }
    }
    
    
    public Vehiculo vehiculoSeleccionado(JTable tabla,Ambulatorio ambulatorio){
        String serial = pasarAtributo_DeTabla(tabla,1);
        return ambulatorio.buscarVehiculo(serial);
    }
    
    public void titulosTablaVehSelec(JTable tabla){
        String[] titulos = {"Código","Serial","Tipo"};
        TableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
    }
    
    public void mostrarVehiculoSeleccionado(JTable tabla,Vehiculo veh){
        String[] titulos = {"Código","Serial","Tipo"};
        String[][] datos = new String[1][3];
        
        datos[0][0]=Integer.toString(veh.getCodigo());
        datos[0][1]=veh.getSerial();
        if(veh instanceof Ambulancia)
            datos[0][2]=((Ambulancia)veh).getTipo();
        if(veh instanceof Compacto)
            datos[0][2]="Respuesta rápida";

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void ambulancias_disponibles_conEquipo(JTable tabla,Ambulatorio ambulatorio){
        ArrayList<Vehiculo> ambulanciasDisp = new ArrayList<Vehiculo>();
        llenarListaAmbulanciasDisp(ambulatorio,ambulanciasDisp); 
        try{
            mostrarVehiculosDisponibles(tabla,ambulanciasDisp);
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Este ambulatorio no tiene ambulancias disponibles en este momento.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarListaCompactosDisp(Ambulatorio ambulatorio,ArrayList<Vehiculo> compactosDisp){
        for(Vehiculo veh : ambulatorio.getVehiculos()){
            if(veh instanceof Compacto && veh.isDisponible() && veh.getPersonalActual()!=null)
                compactosDisp.add((Compacto) veh);
        }
    }
    
    public void compactos_disponibles_conEquipo(JTable tabla,Ambulatorio ambulatorio){
        ArrayList<Vehiculo> compactosDisp = new ArrayList<Vehiculo>();
        llenarListaCompactosDisp(ambulatorio,compactosDisp);
        try{
            mostrarVehiculosDisponibles(tabla,compactosDisp);
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Este ambulatorio no tiene vehículos compactos disponibles en este momento.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
   //
    public String pasarAtributo_DeTabla(JTable tablaEntidad,int columna){
        int indice = tablaEntidad.getSelectedRow();
        TableModel modelo = tablaEntidad.getModel();
        try{
            String atributo = modelo.getValueAt(indice,columna).toString();
            return atributo;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un item de la tabla.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    //Sobrecarga del método anterior. Se usa cuando ya se seleccionó el objeto
    public String pasarAtributo_DeTabla(int columna,JTable tablaEntidad){
        int indice = 0;
        TableModel modelo = tablaEntidad.getModel();
        try{
            String atributo = modelo.getValueAt(indice,columna).toString();
            return atributo;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un item de la tabla.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    //Se usa para pasar el ambulatorio seleccionado de una tabla a otra
    public Ambulatorio ambulatorioSeleccionado(JTable tabla,Clinica clinica){
        String telf = pasarAtributo_DeTabla(tabla,3);
        return clinica.retornarAmbulatorio_Telf(telf);
    }
    
    //Se usa para usar la lista de vehiculos del ambulatorio seleccionado
    public Ambulatorio ambulatorioSeleccionado(Clinica clinica,JTable tabla){
        String telf = pasarAtributo_DeTabla(3,tabla);
        return clinica.retornarAmbulatorio_Telf(telf);
    }
    
    
    public void panelRegistro(JTabbedPane pest){
        pest.setSelectedIndex(0);
    }
    
    public void pacienteNoEncontrado(){
        JOptionPane.showMessageDialog(null,"No se encuentra un paciente registrado con esta cédula.","Error",JOptionPane.ERROR_MESSAGE);
    }
}
