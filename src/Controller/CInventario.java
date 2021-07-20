
package Controller;

import Modelo.Ambulatorio;
import Modelo.Suministro;
import Modelo.Unidad;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
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
    
    public void activarPaneles(int tipo, JPanel panel1, JPanel panel2){
        if (tipo==1) panel1.setVisible(false); //Tipo 1 representa el boton Ver detalle
        if (tipo==2) panel2.setVisible(false); //Tipo 2 representa el boton Registrar movimiento
    }
    
    public void mostrarUnidades(JTable tabla, JLabel label,Suministro sum){
        Unidad uni1 = new Unidad("almacen",LocalDate.of(2021, 7, 26));
        Unidad uni2 = new Unidad("ambu 1",LocalDate.of(2021, 9, 4));
        sum.getUnidades().add(uni1);
        sum.getUnidades().add(uni2);
        label.setText("Unidades de "+sum.getNombre());
        String[] titulos = {"No.","Fecha vencimiento","Ubicacion actual"};
        String[][] datos = new String[sum.getUnidades().size()][3];
        
        for (int i = 0; i < sum.getUnidades().size(); i++) {
            datos[i][0]=String.valueOf(i+1);
            datos[i][1]=sum.getUnidades().get(i).getfVencimiento().format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
            datos[i][2]=sum.getUnidades().get(i).getUbicacion();
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null); 
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    //Case 0 en el ActionPerformed del ComboBox
    public void tipoMovimientoEntrada(JTable tablaUnidades, JButton btnSeleccionarUni, JLabel labelFechaV, JDateChooser calendario, JComboBox comboAplica, JTextField txt1, JLabel labelCantidad, JTextField txtCantidad, JList lista, JScrollPane scroll){
        tablaUnidades.setEnabled(false);
        btnSeleccionarUni.setEnabled(false);
        labelFechaV.setText("Fecha de vencimiento:");
        calendario.setVisible(true);
        txt1.setVisible(false);
        labelCantidad.setText("Cantidad:");
        txtCantidad.setVisible(true);
        lista.setVisible(false);
        scroll.setVisible(false);     
    }
    
    //Case 1 en el ActionPerformed del ComboBox
    public void tipoMovimientoSalida(JTable tablaUnidades, JButton btnSeleccionarUni, JLabel labelArgumento, JDateChooser calendario, JComboBox tipoArgumento, JTextField txtNroEmergencia, JLabel labelObjetos, JTextField txtCantidad, JList lista, JScrollPane scroll){
        tablaUnidades.addMouseListener(new EventoMouse(btnSeleccionarUni)); //El boton tendría que estar Deshabilitado antes
        tablaUnidades.setEnabled(true);
        labelArgumento.setText("Argumento:");
        calendario.setVisible(false);
        txtNroEmergencia.setVisible(false);
        labelObjetos.setText("Objetos:");
        txtCantidad.setVisible(false);
        lista.setVisible(true);
        scroll.setVisible(true);
    }
    
    //Case 2 en el ActionPerformed del ComboBox
    public void tipoMovimientoReubicacion(JTable tablaUnidades, JButton btnSeleccionarUni, JLabel labelDestino, JDateChooser calendario, JComboBox comboDestinos, JTextField txt1, JLabel labelObjetos, JTextField txtCantidad, JList lista, JScrollPane scroll){
        tablaUnidades.addMouseListener(new EventoMouse(btnSeleccionarUni)); //El boton tendría que estar Deshabilitado antes
        tablaUnidades.setEnabled(true);
        labelDestino.setText("Destino:");
        calendario.setVisible(false);
        txt1.setVisible(false);
        labelObjetos.setText("Objetos:");
        txtCantidad.setVisible(false);
        lista.setVisible(true);
        scroll.setVisible(true);
    }
    
}
