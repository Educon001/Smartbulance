
package Controller;

import Modelo.*;
import java.util.ArrayList;
import javax.swing.*;

public class CSistema {
    //ATRIBUTOS
    private ArrayList<Clinica> listaClinicas;
    private ArrayList<Paciente> listaPacientes;
    private ArrayList<Emergencia> listaEmergencias;
    
    Clinica prueba = new Clinica("Clinic","0212-9435176","J-12345678-1","Amazonas","Maracaibo","Calle 13");
    
    //CONSTRUCTORES
    public CSistema() {
        listaClinicas = new ArrayList<>();
        listaClinicas.add(prueba);
        listaPacientes = new ArrayList<>();  
        listaEmergencias = new ArrayList<>();
    }
       // String nombre, String telefono, String RIF, String estado, String ciudad, String direccion
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

    public ArrayList<Emergencia> getListaEmergencias() {
        return listaEmergencias;
    }

    public void setListaEmergencias(ArrayList<Emergencia> listaEmergencias) {
        this.listaEmergencias = listaEmergencias;
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
    
    public void agregarEmergencia(Emergencia em){
        listaEmergencias.add(em);
        em.setCodigo(listaEmergencias.size());
    }
 
    public Clinica buscarClinica(String RIF){
        for(Clinica clinica : listaClinicas){
            if(RIF.equals(clinica.getRIF())) return clinica;
        }
        return null;
    }
    
    public Paciente buscarPaciente(String ced){
        for (Paciente pac: listaPacientes){
            if (pac.getCedula().equals(ced))
                return pac;
        }
        return null; 
    }
    
    public long generarFactura(){
        long mayor;
        mayor = 0;        
        for (Paciente pac : listaPacientes){
            for (Pago pag : pac.getPagos()){
              if (pag.getFactura()>mayor){
                mayor=pag.getFactura();               
            }
          }          
        }
     return 1+mayor;
    }
    
    public Emergencia buscarEmergencia(int cod){
        for (Emergencia em : listaEmergencias) {
            if (em.getCodigo()==cod)
                return em;
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
            else if(!inicio){
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
