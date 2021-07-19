package Controller;

import Modelo.Entidad;
import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class CVentana {

    JFrame ventana;

    public CVentana(JFrame ventana) {
        this.ventana = ventana;
    }
    
    public CVentana() {
    }
    
    public void iniciarVentana(JFrame ventana, String ruta){
       ventana.setLocationRelativeTo(null);
       ventana.setIconImage(new ImageIcon(ruta).getImage()); 
       ventana.setResizable(false); 
       ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    public void entradasModificar_Entidad(Entidad entidad, JTextField txtNombre,JTextField txt8RIF,JTextField txt1RIF,JTextField txtTelf1,JTextField txtTelf2,JTextField txtCiudad,JComboBox cboEstado,JTextField txtDir){
        txtNombre.setText(entidad.getNombre());
        txt8RIF.setText(entidad.getRIF().substring(2,9));
        txt1RIF.setText(entidad.getRIF().substring(11));
        txtTelf1.setText(entidad.getTelefono().substring(0,4));
        txtTelf2.setText(entidad.getTelefono().substring(5));
        txtCiudad.setText(entidad.getCiudad());
        cboEstado.setSelectedItem(entidad.getEstado());
        txtDir.setText(entidad.getDireccion());
        txtNombre.setEnabled(false);
        txt8RIF.setEnabled(false);
        txt1RIF.setEnabled(false);
        txtTelf1.setEnabled(false);
        txtTelf2.setEnabled(false);
        txtCiudad.setEnabled(false);
        cboEstado.setEnabled(false);
        txtDir.setEnabled(false);
    }
    
    public void seleccionarBotonesRadio_Entidad(boolean seleccionar,JRadioButton boton1,JRadioButton boton2,JRadioButton boton3,JRadioButton boton4,JRadioButton boton5,JRadioButton boton6){
        boton1.setSelected(seleccionar);
        boton2.setSelected(seleccionar);
        boton3.setSelected(seleccionar);
        boton4.setSelected(seleccionar);
        boton5.setSelected(seleccionar);
        boton6.setSelected(seleccionar);
    }
    
    public void actualizarEntidad(Entidad entidad,JLabel labelNombre,JLabel labelRIF,JLabel labelTelf,JLabel labelCiudad,JLabel labelEstado,JLabel labelDir){
        labelNombre.setText(entidad.getNombre());
        labelRIF.setText(entidad.getRIF());
        labelTelf.setText(entidad.getTelefono());
        labelCiudad.setText(entidad.getCiudad());
        labelEstado.setText(entidad.getEstado());
        labelDir.setText(entidad.getDireccion());
    }
    
    
}
