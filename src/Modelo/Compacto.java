package Modelo;

public class Compacto extends Vehiculo{ //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    
    //SE PONDRÁN LOS CONSTRUCTORES AL ESTAR LISTAS LAS DEMÁS CLASES
    
    //SE PONDRÁN LOS GETTERS Y SETTERS AL ESTAR LISTAS LAS DEMÁS CLASES
    
    public boolean asignar_Al_Equipo(Personal per){
        super.asignar_Al_Equipo(per);
        if(per instanceof Paramedico){
            if(contarParamedicos()==0){
                personalActual.add(per);
                return true;
            }
        }
        return false;
    }
}
