
package Controller;

import Modelo.Clinica;
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
    
    
    public boolean validarExpresionRegular(String patrón, String cadenaIndicada){
        Pattern pat = Pattern.compile(patrón);
        Matcher mat = pat.matcher(cadenaIndicada);
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
    
    public void vaciarDatosAmbulatorio(JTextField txtNombreAmbulatorio,JTextField txt8RIF,JTextField txt1RIF,JTextField txtTelf1,JTextField txtTelf2,JTextField txtCiudad,JTextField txtDir, JComboBox cboEstado){
       txtNombreAmbulatorio.setText(null);
       txt8RIF.setText(null);
       txt1RIF.setText(null);
       txtTelf1.setText(null);
       txtTelf2.setText(null);
       txtCiudad.setText(null);
       txtDir.setText(null);
       cboEstado.setSelectedIndex(0);
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
    
    public boolean confirmar(){
        int op = JOptionPane.showConfirmDialog(null, "¿Desea continuar con esta acción?","Confirme",JOptionPane.YES_NO_OPTION);
        if(op==JOptionPane.YES_OPTION) return true;
        return false;
    }
    
}
