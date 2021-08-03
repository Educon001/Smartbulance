
package Modelo;

public class Ambulancia extends Vehiculo {
    private String tipo;
    
    //Constructores
    public Ambulancia(){}
    
    public Ambulancia(String serial, boolean enMantenimiento, boolean disponible, String tipo) {
        //Se llama al constructor de la superclase
        super(serial,enMantenimiento,disponible);
        //Atributo tipo de ambulancia (aérea o terrestre)
        this.tipo = tipo;
    }
    
    
    //GETTERS Y SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //OTROS MÉTODOS
    @Override
    public boolean asignar_Al_Equipo(PersonalConVehiculo per) {
        if (super.asignar_Al_Equipo(per))
            return true;
        if(per instanceof Paramedico){
            if(contarParamedicos()<2){
                personalActual.add(per);
                return true;
            }
        }
        return false;
    }
       
}
