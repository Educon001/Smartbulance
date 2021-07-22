package Modelo;

public class Compacto extends Vehiculo{ //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    
    //SE PONDRÁN LOS CONSTRUCTORES AL ESTAR LISTAS LAS DEMÁS CLASES
    
    public Compacto(){}
    
    public Compacto(String serial, boolean enMantenimiento, boolean disponible){
        super(serial,enMantenimiento,disponible);
    }

    //SE PONDRÁN LOS GETTERS Y SETTERS AL ESTAR LISTAS LAS DEMÁS CLASES
    public boolean asignar_Al_Equipo(PersonalConVehiculo per) {
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
