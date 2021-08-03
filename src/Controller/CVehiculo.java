
package Controller;

import Modelo.*;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CVehiculo {
    
    private Vehiculo vehiculo;
    private Clinica clinica;

    public CVehiculo(Clinica clinica){
        this.clinica = clinica;
    }
    
    public boolean serialRegistrado(String serial){
        for (Ambulatorio am : clinica.getAmbulatorios()) {
            for (Vehiculo ve : am.getVehiculos()) {
                if (ve.getSerial().equals(serial))
                    vehiculo = ve;
                    return true;
            }
        }
        return false;
    }
    
    public void mostrarVehiculo(JLabel codigo, JLabel serial, JLabel tipo, JLabel disponible, JLabel labelMantenimiento, JLabel enMantenimiento,JTable personalActual){
        if (vehiculo instanceof Ambulancia)
            tipo.setText("Ambulancia"+" "+((Ambulancia) vehiculo).getTipo().toLowerCase());
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
    
    public Ambulatorio getAmbulatorio(){
        for (Ambulatorio am : clinica.getAmbulatorios()){
            for (Vehiculo ve : am.getVehiculos())
                if (ve.equals(vehiculo))
                    return am;
        }
        return null;
    }
    
    public void tablasAsignarPersonal(JTable asignados, JTable personal, JButton btnAgregar, JButton btnEliminar){
        String[] titulos = {"Tipo","Nombre","Cedula"};
        String[][] datos1 = new String[vehiculo.getPersonalActual().size()][3];
        String[][] datos2;
        int cont=0;
        Ambulatorio am = getAmbulatorio();
        for (Personal per : am.getPersonal()){
            if ((per instanceof Conductor || per instanceof Paramedico) && ((PersonalConVehiculo) per).getVehiculoActual() == null)
                cont++;
        }
        datos2 = new String[cont][3];
        for (int i = 0; i < vehiculo.getPersonalActual().size(); i++) {
            datos1[i][0] = vehiculo.getPersonalActual().get(i).getTipo();
            datos1[i][1] = vehiculo.getPersonalActual().get(i).getNombre();
            datos1[i][2] = vehiculo.getPersonalActual().get(i).getCedula();
        }
        for (int i = 0,j = 0; i < am.getPersonal().size(); i++) {
            if ((am.getPersonal().get(i) instanceof Conductor || am.getPersonal().get(i) instanceof Paramedico) && ((PersonalConVehiculo) am.getPersonal().get(i)).getVehiculoActual() == null){
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
        btnAgregar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void agregarPersonal(JTable asignados, JTable personal, JButton btnAgregar){
        int indice = personal.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) asignados.getModel();
        Object[] seleccionado = {personal.getModel().getValueAt(indice, 0),personal.getModel().getValueAt(indice, 1),personal.getModel().getValueAt(indice, 2)};
        boolean repetido=false;
        for (int i = 0; i < asignados.getRowCount(); i++) {
            if (asignados.getModel().getValueAt(i,2).equals(seleccionado[2])){
                repetido=true;
                break;
            }
        }
        if (!repetido){
            modelo.addRow(seleccionado);
            asignados.setModel(modelo);
            btnAgregar.setEnabled(false);
        }else
            JOptionPane.showMessageDialog(null, "La persona que eligio ya esta asignada al vehiculo", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void eliminarPersonal(JTable asignados, JTable personal, JButton btnEliminar){
        int indice = asignados.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) asignados.getModel();
        modelo.removeRow(indice);
        asignados.setModel(modelo);
        btnEliminar.setEnabled(false);
    }
    
    public void debloquearBotones(JTable asignados, JButton btnAgregar, JButton btnEliminar){
        if (!((asignados.getRowCount()==2 && vehiculo instanceof Compacto) || (asignados.getRowCount()==3 && vehiculo instanceof Ambulancia)))
            btnAgregar.setEnabled(true);
        if (asignados.getRowCount()!=0)
            btnEliminar.setEnabled(true);
    }
    
    public void asignarPersonal(JTable asignados){
        int num = asignados.getRowCount();
        Ambulatorio am = getAmbulatorio();
        if ((vehiculo instanceof Compacto && num<=2) || (vehiculo instanceof Ambulancia && num<=3)){
            for (PersonalConVehiculo pers : vehiculo.getPersonalActual()) {
                pers.setVehiculoActual(null);
            }
            vehiculo.getPersonalActual().clear();
            for (int i = 0; i < num; i++) {
                PersonalConVehiculo per = (PersonalConVehiculo) am.buscarPersonal(asignados.getModel().getValueAt(i, 2).toString());
                if (vehiculo instanceof Compacto){
                    if (!((Compacto) vehiculo).asignar_Al_Equipo(per)){
                        vehiculo.getPersonalActual().clear();                       
                        JOptionPane.showMessageDialog(null, "Los vehiculos compactos deben tener un (1) conductor y un (1) paramedico", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }else if (vehiculo instanceof Ambulancia){
                    if (!((Ambulancia) vehiculo).asignar_Al_Equipo(per)){
                        vehiculo.getPersonalActual().clear();
                        JOptionPane.showMessageDialog(null, "Las ambulancias deben tener un (1) conductor y dos (2) paramedicos", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }
            }
        }
        for (PersonalConVehiculo pers : vehiculo.getPersonalActual()) {
                pers.setVehiculoActual(vehiculo.getSerial());
            }
    }
    
    public void mostrarInventario(JTable tabla){
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
    
    public void mostrarMantenimiento(JTable tabla){
        String[] titulo = {"Taller","Descripción"};
        String matriz[][]=new String[vehiculo.getHistMantenimiento().size()][2];
        
        for (int i=0;i<vehiculo.getHistMantenimiento().size();i++){
            matriz[i][0] = (vehiculo.getHistMantenimiento().get(i)).getTaller();
            matriz[i][1] = (vehiculo.getHistMantenimiento().get(i)).getDescripcion();
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
    }
    
    public void registrarManenimiento(Date entrada, Date salida, String taller, String descripcion, JComboBox estado){
        if (vehiculo.isEnMantenimiento()){
            if (salida==null){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Mantenimiento man = vehiculo.getHistMantenimiento().get(vehiculo.getHistMantenimiento().size()-1);
            man.setSalida(salida);
            vehiculo.setEnMantenimiento(false);
            vehiculo.setDisponible(true);
        }else{
            if (entrada==null || taller==null || descripcion==null){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Mantenimiento man = new Mantenimiento(taller,descripcion,entrada);       
            if (estado.getSelectedIndex()==1){
                if (salida==null){
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "error", JOptionPane.ERROR_MESSAGE);
                    return;
                }   
                man.setSalida(salida);
                    vehiculo.registrarMantenimiento(man);
            }else if (estado.getSelectedIndex()==0){
                vehiculo.llevarMantenimiento(man);
            }
        }
    }
    
    public boolean vehiculoDisponible(){
        if (vehiculo.isDisponible())
            return true;
        else{
            JOptionPane.showMessageDialog(null, "Este vehiculo no se encuentra disponible en este momento", "Vehiculo no disponible", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
  
    public void estadoMantenimiento(JComboBox estado, JDateChooser fechaSalida){
        if (estado.getSelectedIndex()==0){
            fechaSalida.setEnabled(false);
            fechaSalida.setDate(null);
        }else
            fechaSalida.setEnabled(true);
    }
    
    public void ventanaMantenimiento(JTextField txt1RifTaller,JTextField txt2RifTaller, JTextArea txtDescripcion, JDateChooser fechaEntrada, JComboBox cboEstado){
        if (vehiculo.isEnMantenimiento()){
            Mantenimiento man = vehiculo.getHistMantenimiento().get(vehiculo.getHistMantenimiento().size()-1);
            txt1RifTaller.setEnabled(false);
            txt1RifTaller.setText(man.getTaller().substring(2, 9));
            txt2RifTaller.setEnabled(false);
            txt2RifTaller.setText(man.getTaller().substring(11));
            txtDescripcion.setEnabled(false);
            txtDescripcion.setText(man.getDescripcion());
            fechaEntrada.setEnabled(false);
            fechaEntrada.setDate(man.getEntrada());
            cboEstado.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Este vehiculo tiene un mantenimiento en progreso, registre la fecha de salida", "Manteniemiento en progreso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
