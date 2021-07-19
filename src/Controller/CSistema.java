
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
 
    public Clinica buscarClinica(String RIF){
        for(Clinica clinica : listaClinicas){
            if(RIF.equals(clinica.getRIF())) return clinica;
        }
        return null;
    } 
    
    public void mensajeEntidad_RIFRegistrado(){
        JOptionPane.showMessageDialog(null,"Ya se encuentra una entidad registrada con este RIF.","Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mensajeEntidad_TelfRegistrado(){
        JOptionPane.showMessageDialog(null,"Ya se encuentra una entidad registrada con este número telefónico.","Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public boolean seEncuentraRegistrada_RIF(String RIF, boolean inicio){
        for(Clinica cli: listaClinicas){
            if(RIF.equals(cli.getRIF())){
                if(!inicio) mensajeEntidad_RIFRegistrado();
                return true;
            }
            else{
                for(Ambulatorio amb : cli.getAmbulatorios()){
                    if(RIF.equals(amb.getRIF())){
                        mensajeEntidad_RIFRegistrado();
                        return true;
                    }
                }
                for(Taller taller : cli.getTalleresAsociados()){
                    if(RIF.equals(taller.getRIF())){
                        mensajeEntidad_RIFRegistrado();
                        return true;
                    }
                }
            }
        }
        if(inicio) JOptionPane.showMessageDialog(null,"No hay clínica registrada con este RIF.","Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    public boolean seEncuentraRegistrada_Telf(String telf){
        for(Clinica cli: listaClinicas){
            if(telf.equals(cli.getTelefono())){
                mensajeEntidad_TelfRegistrado();
                return true;
            } else{
                for(Ambulatorio amb : cli.getAmbulatorios()){
                    if(telf.equals(amb.getTelefono())){
                        mensajeEntidad_TelfRegistrado();
                        return true;
                    }
                }
                for(Taller taller : cli.getTalleresAsociados()){
                    if(telf.equals(taller.getTelefono())){
                        mensajeEntidad_TelfRegistrado();
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void crearClinica(String nombre,String RIF,String telf,String ciudad,String estado,String dir){        
        Clinica clinica = new Clinica(nombre,telf,RIF,estado,ciudad,dir);
        agregarClinica(clinica);
    }
    
}
