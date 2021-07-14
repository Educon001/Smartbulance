
package Modelo;

public class Ambulancia extends Vehiculo { //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
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
    public boolean asignar_Al_Equipo(Personal per) {
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
