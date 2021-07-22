
package Controller;

import Modelo.Clinica;
import Modelo.Entidad;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRegistro {
    private CSistema controlSistema; 
    
    public CRegistro() {
    }    

    public CRegistro(CSistema controlSistema) {
        this.controlSistema = controlSistema;
    }
    
    
    public boolean validarSerial(String serial){
        Pattern pat = Pattern.compile("[A-Z0-9]{17}",Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(serial);
        if(!mat.matches()) JOptionPane.showMessageDialog(null,"El serial del vehiculo debe tener 17 caracteres entre letras y numeros","Error",JOptionPane.ERROR_MESSAGE);
        return mat.matches();
    }
    
    public boolean datoEsNumerico(JTextField txt){
        try {
               Long.parseLong(txt.getText());
        }
        catch (NumberFormatException error) {
             JOptionPane.showMessageDialog(null,"Formato de dato no es numérico","Error", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        return true;
    }    
    
    public boolean formatoRIFCompleto(String RIF){
        if(RIF.matches("[J]-\\d{8}-\\d{1}")) return true;
        JOptionPane.showMessageDialog(null,"El dato introducido no cumple con el formato RIF.\nEjemplo válido: J-11223344-1", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean validarRIF(JTextField txtRIF,int dig){
        if(txtRIF.getText().isEmpty()==false){
            if(datoEsNumerico(txtRIF)==false) return false;
            if(dig==8 && txtRIF.getText().matches("\\d{8}")==false){
                JOptionPane.showMessageDialog(null,"Debe introducir los primeros 8 dígitos del RIF.","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }   
            if(dig==1 && txtRIF.getText().matches("\\d{1}")==false){
                JOptionPane.showMessageDialog(null,"Debe introducir el último dígito del RIF.","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }   
        }
        return true;
    }
    
    public boolean validarTelf(JTextField txtTelf,int dig){
        if(txtTelf.getText().isEmpty()==false){
            if(datoEsNumerico(txtTelf)==false) return false;
            if(dig==4 && txtTelf.getText().matches("[0]?\\d{3}")==false){
                JOptionPane.showMessageDialog(null,"Debe introducir un prefijo telefónico.\nEjemplo: 0212 ó 212","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }   
            if(dig==7 && txtTelf.getText().matches("\\d{7}")==false){
                JOptionPane.showMessageDialog(null,"Debe introducir los últimos 7 dígitos del número telefónico.","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }   
        }
        return true;
    }
    
    public void vaciarDatosEntidad(JTextField txtNombreAmbulatorio,JTextField txt8RIF,JTextField txt1RIF,JTextField txtTelf1,JTextField txtTelf2,JTextField txtCiudad,JTextField txtDir, JComboBox cboEstado){
       txtNombreAmbulatorio.setText(null);
       txt8RIF.setText(null);
       txt1RIF.setText(null);
       txtTelf1.setText(null);
       txtTelf2.setText(null);
       txtCiudad.setText(null);
       txtDir.setText(null);
       cboEstado.setSelectedIndex(0);
    }
    
    public boolean validarNombreEntidad(JTextField txtNombre){
        if(txtNombre.getText().isEmpty()==false){
            if(txtNombre.getText().matches("^([A-Za-zñáéíóúü0-9]+[ ]?){1,4}$")==false){
                JOptionPane.showMessageDialog(null,"El nombre no puede tener números y/o caracteres especiales.","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public boolean validarNombre(JTextField txtNombre){
        if(txtNombre.getText().isEmpty()==false){
            if(txtNombre.getText().matches("^([A-Za-zñáéíóúü]+[ ]?){1,4}$")==false){
                JOptionPane.showMessageDialog(null,"El nombre no puede tener números y/o caracteres especiales.","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
    
    public boolean validarCorreo(String correo){
        Pattern pat = Pattern.compile("[A-Z0-9._-]+@[A-Z0-9.-]+\\.([A-Z]{2,4})+",Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher(correo);
        if(!mat.matches())
            JOptionPane.showMessageDialog(null,"No cumple con el formato de un correo electrónico.\nFormato válido: usuario@servidor.dominio","Error", JOptionPane.ERROR_MESSAGE);
        return mat.matches();
    }
    
    public boolean validarCI (String ci){
        try{
            long ced = Long.parseLong(ci);
            if(ced<0){
                JOptionPane.showMessageDialog(null,"La cédula debe ser mayor a cero.","Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Fomato de dato no es numérico.","Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean validarSalario (String salario){
        try{
            double sal = Double.parseDouble(salario);
            if(sal>0) return true;
            else JOptionPane.showMessageDialog(null,"El salario debe ser un número positivo mayor que cero.","Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Formato de dato no es numérico.","Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean confirmar(){
        int op = JOptionPane.showConfirmDialog(null, "¿Desea continuar con esta acción?","Confirme",JOptionPane.YES_NO_OPTION);
        if(op==JOptionPane.YES_OPTION) return true;
        return false;
    }
    
    public boolean camposVaciosEntidad(JTextField txtNombre,JTextField txt8RIF,JTextField txt1RIF,JTextField txtTelf1,JTextField txtTelf2,JTextField txtCiudad,JTextField txtDir){
        if(txtNombre.getText().isEmpty() || txt8RIF.getText().isEmpty() || txt1RIF.getText().isEmpty() || txtTelf1.getText().isEmpty() || txtTelf2.getText().isEmpty() || txtCiudad.getText().isEmpty() || txtDir.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Asegúrese de llenar todos los campos solicitados","Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        return false;
    }
    
    public boolean camposVaciosVehiculo(JRadioButton radioAmbulancia,JRadioButton radioCompacto,JTextField txtSerial,JRadioButton radioMantenimiento_SI,JRadioButton radioMantenimiento_NO,JRadioButton radioDis_SI,JRadioButton radioDis_NO,JRadioButton radioTer,JRadioButton radioAerea){
        if(radioAmbulancia.isSelected() && (radioMantenimiento_SI.isSelected() || radioMantenimiento_NO.isSelected()) && (radioDis_SI.isSelected() || radioDis_NO.isSelected()) && (radioTer.isSelected() || radioAerea.isSelected()) && !txtSerial.getText().isEmpty())
            return false;
        if(radioCompacto.isSelected() && (radioMantenimiento_SI.isSelected() || radioMantenimiento_NO.isSelected()) && (radioDis_SI.isSelected() || radioDis_NO.isSelected()) && !txtSerial.getText().isEmpty())
            return false;
        JOptionPane.showMessageDialog(null,"Asegúrese de llenar todos los campos solicitados","Error", JOptionPane.ERROR_MESSAGE);        
        return true;
    }
    
    public boolean camposVaciosPersonal(JComboBox tipoPersonal,JTextField txtCI,JTextField txtNombre,JTextField txtCorreo,JTextField txtTelf1,JTextField txtTelf2,JDateChooser chooserFN,JRadioButton radioMasc,JRadioButton radioFem,JRadioButton radioActivo_SI,JRadioButton radioActivo_NO,JTextField txtSalario,JDateChooser chooserFC,JTextField txtLicencia,JRadioButton radioAsignado_SI,JRadioButton radioAsignado_NO){
        if(!txtCI.getText().isEmpty() && !txtNombre.getText().isEmpty() && !txtCorreo.getText().isEmpty() && !txtTelf1.getText().isEmpty() && !txtTelf2.getText().isEmpty() && chooserFN.getDate()!=null && (radioMasc.isSelected() || radioFem.isSelected()) && (radioActivo_SI.isSelected() || radioActivo_NO.isSelected()) && !txtSalario.getText().isEmpty() && chooserFC.getDate()!=null){
            if(tipoPersonal.getSelectedIndex()==2 && (radioAsignado_SI.isSelected() || radioAsignado_NO.isSelected())) return false;
            else if(tipoPersonal.getSelectedIndex()==3 && !txtLicencia.getText().isEmpty()) return false;
            else if(tipoPersonal.getSelectedIndex()!=2 && tipoPersonal.getSelectedIndex()!=3) return false;            
        }
        JOptionPane.showMessageDialog(null,"Asegúrese de llenar todos los campos solicitados","Error", JOptionPane.ERROR_MESSAGE);
        return true;
    }
    
    public String construirRIF(JTextField txt1,JTextField txt2){
        return "J-"+txt1.getText()+"-"+txt2.getText();
    }
   
    public String construirTelf(JTextField txt1, JTextField txt2){
        String telf = txt1.getText()+"-"+txt2.getText();
        if(telf.charAt(0)!='0') telf='0'+telf;
        return telf;
    }
    
    public String construirCedula(JComboBox origen,JTextField numero){
        return origen.getSelectedItem().toString().toString()+"-"+numero.getText();
    }
            
    public void actualizarEtiquetas_Entidad(Entidad entidad,JLabel labelNombre,JLabel labelRIF,JLabel labelTelf,JLabel labelCiudad,JLabel labelEstado,JLabel labelDir){
        labelNombre.setText(entidad.getNombre());
        labelRIF.setText(entidad.getRIF());
        labelTelf.setText(entidad.getTelefono());
        labelCiudad.setText(entidad.getCiudad());
        labelEstado.setText(entidad.getEstado());
        labelDir.setText(entidad.getDireccion());
    }        
    
    public void actualizarEntidad(Entidad entidad,JTextField txtNombreEntidad,String RIF,String telf,JTextField txtCiudadEntidad,JComboBox cboEstadoEntidad,JTextField txtDirEntidad){
        entidad.setNombre(txtNombreEntidad.getText());
        entidad.setRIF(RIF);
        entidad.setTelefono(telf);
        entidad.setCiudad(txtNombreEntidad.getText());
        entidad.setCiudad(txtCiudadEntidad.getText());
        entidad.setEstado(cboEstadoEntidad.getSelectedItem().toString());
        entidad.setDireccion(txtDirEntidad.getText());
    }
    
    public void seleccionTipoPersonal(JComboBox cboTipo,JLabel labelLicencia,JLabel labelAsignado,JTextField txtLicencia,JRadioButton radioSI, JRadioButton radioNO){
        boolean conductor=false, paramedico=false;
        if(cboTipo.getSelectedIndex()==2) paramedico=true;
        else if(cboTipo.getSelectedIndex()==3) conductor=true;
        
        labelLicencia.setVisible(conductor);
        txtLicencia.setVisible(conductor);
        labelAsignado.setVisible(paramedico);
        radioSI.setVisible(paramedico);
        radioNO.setVisible(paramedico);
    }
    
    public boolean textAreaVacio(JTextArea txtArea){
        return txtArea.getText().isEmpty();
    }
    
    public void vaciarDatosAmbulancia(JRadioButton radioAmbulancia,JRadioButton radioCompacto,JTextField txtSerial,JRadioButton radioMantenimiento_SI,JRadioButton radioMantenimiento_NO,JRadioButton radioDisponibleAmbulancia_SI,JRadioButton radioDisponibleAmbulancia_NO,JRadioButton radioAmbTerrestre,JRadioButton radioAmbAerea){
        radioAmbulancia.setSelected(false);
        radioCompacto.setSelected(false);
        txtSerial.setText(null);
        radioMantenimiento_SI.setSelected(false);
        radioMantenimiento_NO.setSelected(false);
        radioDisponibleAmbulancia_SI.setSelected(false);
        radioDisponibleAmbulancia_NO.setSelected(false);
        radioAmbTerrestre.setSelected(false);
        radioAmbAerea.setSelected(false);
    }
    
    public void vaciarDatosPersonal(JTextField txtCI,JTextField txtNombre,JTextField txtCorreo,JTextField txtTelf1,JTextField txtTelf2,JDateChooser fN,JRadioButton masc,JRadioButton fem,JRadioButton act_SI,JRadioButton act_NO,JTextField txtSalario,JDateChooser fC,JComboBox cboTipo,JRadioButton drs_SI,JRadioButton drs_NO, JTextField txtLicencia){
        txtCI.setText(null);
        txtNombre.setText(null);
        txtCorreo.setText(null);
        txtTelf1.setText(null);
        txtTelf2.setText(null);
        fN.setDate(null);
        masc.setSelected(false);
        fem.setSelected(false);
        act_SI.setSelected(false);
        act_NO.setSelected(false);
        txtSalario.setText(null);
        fC.setDate(null);
        cboTipo.setSelectedIndex(0);
        drs_SI.setVisible(false);
        drs_NO.setVisible(false);
        txtLicencia.setVisible(false);
        
    }
}
