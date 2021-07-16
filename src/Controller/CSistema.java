
package Controller;

import Modelo.Clinica;
import java.util.ArrayList;

public class CSistema {
    //ATRIBUTOS
    private ArrayList<Clinica> listaClinicas;
    
    //CONSTRUCTORES

    public CSistema() {
        listaClinicas = new ArrayList<>();
    }
    
    public void agregarClinica(Clinica cli){
        listaClinicas.add(cli);
    }
    
}
