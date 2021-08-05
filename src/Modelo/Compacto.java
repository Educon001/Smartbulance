package Modelo;

public class Compacto extends Vehiculo{ //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    
    //SE PONDRÁN LOS CONSTRUCTORES AL ESTAR LISTAS LAS DEMÁS CLASES
    
    public Compacto(){}
    
    public Compacto(String serial, boolean enMantenimiento, boolean disponible){
        super(serial,enMantenimiento,disponible);
    }

    public Compacto(String serial, boolean enMantenimiento, boolean disponible, int codigo) {
        super(serial, enMantenimiento, disponible, codigo);
    }

    @Override
    public boolean asignar_Al_Equipo(PersonalConVehiculo per) {
        if (super.asignar_Al_Equipo(per))
            return true;
        if(per instanceof Paramedico){
            if(contarParamedicos()==0){
                personalActual.add(per);
                return true;
            }
        }
        return false;
    }
}
