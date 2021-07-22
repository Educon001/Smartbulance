
package Controller;

import Modelo.*;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;

public class CInventario {
    
    private Ambulatorio ambulatorio;

    public CInventario(Ambulatorio ambulatorio) {
        this.ambulatorio = ambulatorio;
    }

    public CInventario() {
    }
  
    
    public void mostrarInventario(JTable tabla,JButton botonMovimiento,JButton botonDetalles){
        
        String[] titulos = {"Tipo","Nombre","Descripción","Cantidad","Codigo"};
        String[][] datos = new String[ambulatorio.getInventario().size()][5];
        
        for (int i = 0; i < ambulatorio.getInventario().size(); i++) {
            datos[i][0]=ambulatorio.getInventario().get(i).getTipo();
            datos[i][1]=ambulatorio.getInventario().get(i).getNombre();
            datos[i][2]=ambulatorio.getInventario().get(i).getDescripción();
            datos[i][3]=String.valueOf(ambulatorio.getInventario().get(i).getCantidad());
            datos[i][4]=String.valueOf(ambulatorio.getInventario().get(i).getCodigo());
            if (datos[i][4].length()==1)
                datos[i][4]="00"+datos[i][4];
            else if (datos[i][4].length()==2)
                datos[i][4]="0"+datos[i][4];
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new EventoMouse(botonDetalles));
        tabla.addMouseListener(new EventoMouse(botonMovimiento));
    }
    
    public void registrarSuministro(String tipo, String nombre, String descripcion){
        Suministro sum = new Suministro(tipo,nombre,descripcion);
        ambulatorio.agregarSuministro(sum);
    }
    
    public Suministro obtenerObjetoSeleccionado(JTable tabla){
        int indice = tabla.getSelectedRow();   
        String cod = tabla.getModel().getValueAt(indice,4).toString();
        Suministro sum = ambulatorio.buscarSuministro(Integer.parseInt(cod));
        return sum;
    }
    
    public void mostrarUnidades(JTable tabla, JLabel label,Suministro sum){
        label.setText("Unidades de "+sum.getNombre());
        String[] titulos = {"No.","Fecha vencimiento","Ubicacion actual"};
        String[][] datos = new String[sum.getUnidades().size()][3];
        
        for (int i = 0; i < sum.getUnidades().size(); i++) {
            sum.getUnidades().get(i).setCodigo(i+1);
            datos[i][0]=String.valueOf(sum.getUnidades().get(i).getCodigo());
            datos[i][1]=sum.getUnidades().get(i).getfVencimiento();
            datos[i][2]=sum.getUnidades().get(i).getUbicacion();
        }       
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null); 
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    //Case 0 en el ActionPerformed del ComboBox
    public void tipoMovimientoEntrada(JTable tablaUnidades, JButton btnSeleccionarUni, JLabel labelFechaV, JDateChooser calendario, JComboBox comboAplica, JTextField txt1, JLabel labelCantidad, JTextField txtCantidad, JList lista, JScrollPane scroll, JButton btnEliminar){
        tablaUnidades.setEnabled(false);
        btnSeleccionarUni.setEnabled(false);
        labelFechaV.setText("Vencimiento:");
        calendario.setVisible(true);
        txt1.setVisible(false);
        labelCantidad.setText("Cantidad:");
        txtCantidad.setVisible(true);
        lista.setVisible(false);
        scroll.setVisible(false);
        btnEliminar.setVisible(false);
        comboAplica.removeAllItems();
        String[] opciones = {"Aplica","No aplica"};
        for (String op : opciones) {
            comboAplica.addItem(op);
        }
    }
    
    //Case 1 en el ActionPerformed del ComboBox
    public void tipoMovimientoSalida(JTable tablaUnidades, JButton btnSeleccionarUni, JLabel labelArgumento, JDateChooser calendario, JComboBox tipoArgumento, JTextField txtNroEmergencia, JLabel labelObjetos, JTextField txtCantidad, JList lista, JScrollPane scroll, JButton btnEliminar){
        tablaUnidades.setEnabled(true);
        labelArgumento.setText("Argumento:");
        calendario.setVisible(false);
        btnSeleccionarUni.setEnabled(false);
        txtNroEmergencia.setVisible(false);
        labelObjetos.setText("Objetos:");
        txtCantidad.setVisible(false);
        lista.setVisible(true);
        scroll.setVisible(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(false);
        tipoArgumento.removeAllItems();
        String[] opciones = {"Ajuste inventario","Emergencia Nro:","Otro:"};
        for (String op : opciones) {
            tipoArgumento.addItem(op);
        }
    }
    
    //Case 2 en el ActionPerformed del ComboBox
    public void tipoMovimientoReubicacion(JTable tablaUnidades, JButton btnSeleccionarUni, JLabel labelDestino, JDateChooser calendario, JComboBox comboDestinos, JTextField txt1, JLabel labelObjetos, JTextField txtCantidad, JList lista, JScrollPane scroll, JButton btnEliminar){
        tablaUnidades.setEnabled(true);
        labelDestino.setText("Destino:");
        calendario.setVisible(false);
        btnSeleccionarUni.setEnabled(false);
        txt1.setVisible(false);
        labelObjetos.setText("Objetos:");
        txtCantidad.setVisible(false);
        lista.setVisible(true);
        scroll.setVisible(true);
        btnEliminar.setVisible(true);
        btnEliminar.setEnabled(false);
        comboDestinos.removeAllItems();
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("Almacen");
        for (Vehiculo v : ambulatorio.getVehiculos()){
            if (v instanceof Ambulancia)
                opciones.add("Ambulancia "+v.getCodigo());
            if (v instanceof Compacto)
                opciones.add("Compacto "+v.getCodigo());
        }
        for (String op : opciones) {
            comboDestinos.addItem(op);
        }
    }
    
    public void agregarUnidad(JTable tabla, DefaultListModel modelo, JList lista, JButton btnEliminar, JComboBox combo){
    try{
        int indice = tabla.getSelectedRow();
        int cod = Integer.parseInt(tabla.getModel().getValueAt(indice,0).toString());
        if (combo.getSelectedIndex() == 2){
            try{
            if (!tabla.getModel().getValueAt(indice, 2).toString().equals(tabla.getModel().getValueAt(Integer.parseInt(modelo.getElementAt(0).toString())-1, 2))){
                JOptionPane.showMessageDialog(null, "Debe seleccionar objetos que esten en la misma ubicación", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            }catch(ArrayIndexOutOfBoundsException ex){}
        }
        boolean repetido=false;
        for (int i = 0; i < modelo.getSize(); i++) {
            if (modelo.elementAt(i).toString().equals(String.valueOf(cod)))
                repetido=true;
        }
        if (!repetido)
            modelo.addElement(cod);
        else
            JOptionPane.showMessageDialog(null,"El elemento ya se encuentra registrado en la lista","Error",JOptionPane.ERROR_MESSAGE);
    }catch(ArrayIndexOutOfBoundsException ex){
        JOptionPane.showMessageDialog(null, "Debe seleccionar un objeto", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void validarEmergencia(CSistema con, JTextField txtEmergencia){
        String texto = txtEmergencia.getText();
        int numero;
        try{
            numero = Integer.parseInt(texto);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Introduzca un valor numerico", "Error", JOptionPane.ERROR_MESSAGE);
            txtEmergencia.setText(null);
            return;
        }
        if (con.buscarEmergencia(numero)==null){
            JOptionPane.showMessageDialog(null, "La emergencia que ingreso no esta registrada", "Error", JOptionPane.ERROR_MESSAGE); 
            txtEmergencia.setText(null);
        }
    }
    
    public void validarCantidad(JTextField txtCantidad){
        String cantidad = txtCantidad.getText();
        int cant;
        try{
            cant = Integer.parseInt(cantidad);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Introduzca un valor numerico", "Error", JOptionPane.ERROR_MESSAGE);
            txtCantidad.setText(null);
            return;
        }
        if (cant<1){
            JOptionPane.showMessageDialog(null, "Introduzca una cantidad valida", "Error", JOptionPane.ERROR_MESSAGE); 
            txtCantidad.setText(null);
        }
    }
    
    public boolean validarDestino(String destino, int indice, JTable tabla){
        return !destino.equals(tabla.getValueAt(indice, 2));
    }
    
    public void eliminarUnidad(JList lista, DefaultListModel modelo, JButton btnEliminar){
    try{
        int indice = lista.getSelectedIndex();
        modelo.removeElementAt(indice);
        if (modelo.size()==0)
            btnEliminar.setEnabled(false);
    }catch(ArrayIndexOutOfBoundsException ex){
        JOptionPane.showMessageDialog(null, "Debe seleccionar un objeto", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    public void registrarEntrada(String comboAplica, Date fVencimiento, int cantidad, Suministro sum){
        Unidad uni = null;
        if (comboAplica.equals("Aplica")){
            String patron = "dd/MM/yyyy";
            DateFormat formato = new SimpleDateFormat(patron);
            uni = new Unidad("Almacen",formato.format(fVencimiento));
        }else if (comboAplica.equals("No aplica"))
            uni = new Unidad("Almacen",comboAplica);
        Unidad[] unidades = new Unidad[cantidad];
        for (int i = 0; i < unidades.length; i++) {
            unidades[i]=uni;
        }
        Movimiento mov = new Movimiento(LocalDate.now(),unidades,"Entrada");
        sum.registrarMovimiento(mov);
    }
    
    public void registrarSalida(String comboArgumento, String txtArgumento, Object[] objetos, Suministro sum, JTable tabla){
        String argumento = comboArgumento + " ";
        if (!comboArgumento.equals("Ajuste inventario"))
            argumento += txtArgumento;
        Unidad[] unidades = new Unidad[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            unidades[i]=sum.buscarUnidad(Integer.parseInt(objetos[i].toString()));
        }
        Movimiento mov = new Salida(argumento,LocalDate.now(),unidades,"Salida");
        sum.registrarMovimiento(mov);
    }
    
    public void registrarReubicacion(String destino, Object[] objetos, Suministro sum, JTable tabla){
        if (validarDestino(destino, Integer.parseInt(objetos[0].toString())-1, tabla)){
            Unidad[] unidades = new Unidad[objetos.length];
            for (int i = 0; i < objetos.length; i++) {
                unidades[i]=sum.buscarUnidad(Integer.parseInt(objetos[i].toString()));
            }
            Movimiento mov = new Reubicacion(destino,LocalDate.now(),unidades,"Reubicacion");
            sum.registrarMovimiento(mov);
        }else
            JOptionPane.showMessageDialog(null, "El destino debe ser diferente al origen", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostrarMovimientos(Suministro sum, JTable tablaEnt, JTable tablaSal, JTable tablaReu){
        String[] titulosEnt = {"Fecha","Cantidad"};
        String[] titulosSal = {"Fecha","Argumento","Cantidad"};
        String[] titulosReu = {"Fecha","Origen","Destino","Cantidad"};
        String[][] datosEnt,datosSal,datosReu;
        int numEnt=0, numSal=0,numReu=0;
        for (Movimiento mov : sum.getMovimientos()) {
            if (mov.getTipo().equals("Entrada"))
                numEnt++;
            else if (mov.getTipo().equals("Salida"))
                numSal++;
            else if (mov.getTipo().equals("Reubicacion"))
                numReu++;
        }
        datosEnt = new String[numEnt][2];
        datosSal = new String[numSal][3];
        datosReu = new String[numReu][4];
        numEnt = 0;
        numSal = 0;
        numReu = 0; 
        for (Movimiento mov : sum.getMovimientos()) {
            if (mov.getTipo().equals("Entrada")){
                datosEnt[numEnt][0] = mov.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                datosEnt[numEnt][1] = String.valueOf(mov.getCantidad());
                numEnt++;
            }
            else if (mov.getTipo().equals("Salida")){
                datosSal[numSal][0] = mov.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                datosSal[numSal][1] = ((Salida) mov).getArgumento();
                datosSal[numSal][2] = String.valueOf(mov.getCantidad());
                numSal++;
            }
            else if (mov.getTipo().equals("Reubicacion")){
                datosReu[numReu][0] = mov.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
                datosReu[numReu][1] = ((Reubicacion) mov).getOrigen();
                datosReu[numReu][2] = ((Reubicacion) mov).getDestino();
                datosReu[numReu][3] = String.valueOf(mov.getCantidad());
                numReu++;
            }
        }
        TableModel modeloEnt = new DefaultTableModel(datosEnt,titulosEnt);
        TableModel modeloSal = new DefaultTableModel(datosSal,titulosSal);
        TableModel modeloReu = new DefaultTableModel(datosEnt,titulosReu);
        tablaEnt.setModel(modeloEnt);
        tablaSal.setModel(modeloSal);
        tablaReu.setModel(modeloReu);
        tablaEnt.setDefaultEditor(Object.class, null); 
        tablaEnt.getTableHeader().setReorderingAllowed(false);
        tablaSal.setDefaultEditor(Object.class, null); 
        tablaSal.getTableHeader().setReorderingAllowed(false);
        tablaReu.setDefaultEditor(Object.class, null); 
        tablaReu.getTableHeader().setReorderingAllowed(false);
    }
}
