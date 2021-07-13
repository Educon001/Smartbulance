
package Modelo;

import java.util.ArrayList;

public class Ambulancia extends Vehiculo { //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    private String tipo;
    
    //SE PONDRÁN LOS CONSTRUCTORES AL ESTAR LISTAS LAS DEMÁS CLASES
    
    //SE PONDRÁN LOS GETTERS Y SETTERS AL ESTAR LISTAS LAS DEMÁS CLASES
         
    @Override
    public boolean asignar_Al_Equipo(Personal per){
        super.asignar_Al_Equipo(per);
        if(per instanceof Paramedico){
            if(contarParamedicos()<2){
                personalActual.add(per);
                return true;
            }
        }
        return false;
    }
    
}
