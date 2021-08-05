package Controller;

import Modelo.*;
import Modelo.Entidad;
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.util.Date;
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
        txt8RIF.setText(entidad.getRIF().substring(2,10));
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
    
    public void seleccionarBotonesRadio_Entidad(boolean seleccionar,JRadioButton boton1,JRadioButton boton2,JRadioButton boton3,JRadioButton boton4,JRadioButton boton5){
        boton1.setSelected(seleccionar);
        boton2.setSelected(seleccionar);
        boton3.setSelected(seleccionar);
        boton4.setSelected(seleccionar);
        boton5.setSelected(seleccionar);
    }
    
    public void seleccionarBotonesRadio_Paciente(boolean seleccionar,JRadioButton boton1,JRadioButton boton2,JRadioButton boton3,JRadioButton boton4,JRadioButton boton5){
        boton1.setSelected(seleccionar);
        boton2.setSelected(seleccionar);
        boton3.setSelected(seleccionar);
        boton4.setSelected(seleccionar);
        boton5.setSelected(seleccionar);
    }    
    
    public void pestClinica(JButton boton1,JButton boton2,JButton boton3,JTextArea txtArea){
        boton1.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        txtArea.setEnabled(false);
    }    
    
    public void botonClinica_DatosEntidad(Entidad entidad, JLabel labelNombre_DeLaClinica,JLabel labelRIF_DeLaClinica,JLabel labelTelf_DeLaClinica,JLabel labelCiudad_DeLaClinca,JLabel labelEstado_DeLaClinica,JLabel labelDir_DeLaClinica,JToggleButton disp){
        labelNombre_DeLaClinica.setText(entidad.getNombre());
        labelRIF_DeLaClinica.setText(entidad.getRIF());
        labelTelf_DeLaClinica.setText(entidad.getTelefono());
        labelCiudad_DeLaClinca.setText(entidad.getCiudad());
        labelEstado_DeLaClinica.setText(entidad.getEstado());
        labelDir_DeLaClinica.setText(entidad.getDireccion());
        if(entidad instanceof Clinica){
            if(((Clinica) entidad).isDisponible()) disp.setText("Sí");
            else disp.setText("No");
        }
        if(entidad instanceof Ambulatorio){
            if(((Ambulatorio) entidad).isDisponible()) disp.setText("Sí");
            else disp.setText("No");
        }
    }
    
      public void entradasModificar_Paciente(Paciente paciente,JComboBox nacionalidad,JTextField txtCedula, JTextField txtNombre,JTextField txtCorreo,JTextField txtTelf1,JTextField txtTelf2,JDateChooser DateFecha,JComboBox boxGenero){
        if (paciente.getCedula().charAt(0)=='V'){
          nacionalidad.setSelectedIndex(0);
        }else if (paciente.getCedula().charAt(0)=='E'){
          nacionalidad.setSelectedIndex(1);  
        }        
        txtCedula.setText(paciente.getCedula().substring(2));
        txtNombre.setText(paciente.getNombre());
        txtCorreo.setText(paciente.getCorreo());   
        txtTelf1.setText(paciente.getTelefono().substring(0,4));
        txtTelf2.setText(paciente.getTelefono().substring(5));
        ZoneId defaultZoneId = ZoneId.systemDefault();
        DateFecha.setDate(Date.from(paciente.getNacimiento().atStartOfDay(defaultZoneId).toInstant()));    
        if (paciente.getGenero()=='M'){
            boxGenero.setSelectedIndex(0);         
        }else if (paciente.getGenero()=='F'){
            boxGenero.setSelectedIndex(1);           
        }
        nacionalidad.setEnabled(false);
        txtCedula.setEnabled(false);
        txtNombre.setEnabled(false);
        txtCorreo.setEnabled(false);  
        txtTelf1.setEnabled(false);
        txtTelf2.setEnabled(false);
        DateFecha.setEnabled(false);   
        boxGenero.setEnabled(false);      
    }
      
}
