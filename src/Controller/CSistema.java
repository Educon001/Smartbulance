
package Controller;

import Modelo.Clinica;
import Modelo.Paciente;
import java.util.ArrayList;

public class CSistema {
    //ATRIBUTOS
    private ArrayList<Clinica> listaClinicas;
    private ArrayList<Paciente> listaPacientes;
    
    //CONSTRUCTORES

    public CSistema() {
        listaClinicas = new ArrayList<>();
        listaPacientes = new ArrayList<>();
    }
    
    public void agregarClinica(Clinica cli){
        listaClinicas.add(cli);
    }
    
    public void agregarPaciente(Paciente pac){
        listaPacientes.add(pac);
    }
    
    public void eliminarPaciente(Paciente pac){
        listaPacientes.remove(pac);
    }
    
}
