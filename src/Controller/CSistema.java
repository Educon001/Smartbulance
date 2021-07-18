
package Controller;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.*;

public class CSistema {
    //ATRIBUTOS
    private ArrayList<Clinica> listaClinicas;
    private ArrayList<Paciente> listaPacientes;
    
    //CONSTRUCTORES
    public CSistema() {
        listaClinicas = new ArrayList<>();
        listaPacientes = new ArrayList<>();  
    }
        
    //GETTERS Y SETTERS
    public ArrayList<Clinica> getListaClinicas() {
        return listaClinicas;
    }

    public void setListaClinicas(ArrayList<Clinica> listaClinicas) {
        this.listaClinicas = listaClinicas;
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }
    
    //OTROS MÉTODOS
    public void agregarClinica(Clinica cli){
        listaClinicas.add(cli);
    }
    
    public void agregarPaciente(Paciente pac){
        listaPacientes.add(pac);
    }
    
    public void eliminarPaciente(Paciente pac){
        listaPacientes.remove(pac);
    }
    
    public Clinica buscarClinica(Clinica cli){
        for(Clinica clinica : listaClinicas){
            if(cli.equals(clinica)) return clinica;
        }
        return null;
    } 
    
    public boolean seEncuentraRegistrada_RIF(String RIF){
        for(Clinica cli: listaClinicas){
            if(RIF.equals(cli.getRIF())) return true;
        }
        return false;
    }
    
    public boolean seEncuentraRegistrada_Telf(String telf){
        for(Clinica cli: listaClinicas){
            if(telf.equals(cli.getTelefono())) return true;
        }
        return false;
    }
    
    public void crearClinica(String nombre,JTextField txt8RIF,JTextField txt1RIF,JTextField txtTelf1,JTextField txtTelf2,String ciudad,String estado,String dir){        
        String RIF = "J-"+txt8RIF.getText()+"-"+txt1RIF.getText();
        String telf = txtTelf1+"-"+txtTelf2;
        if(telf.charAt(0)!='0') telf='0'+telf;
        Clinica clinica = new Clinica(nombre,telf,RIF,estado,ciudad,dir);
        agregarClinica(clinica);
    }
    
}
