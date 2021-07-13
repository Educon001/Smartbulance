package Modelo;

public class Compacto extends Vehiculo{ //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    
    //SE PONDRÁN LOS CONSTRUCTORES AL ESTAR LISTAS LAS DEMÁS CLASES
    
    public Compacto(){
        //Se llama al constructor de Vehiculo
        super();
        //En el constructor de los suministros debe ir el nombre y la cantidad ideal de cada suministro
        Suministro sueros = new Suministro(); 
        Suministro antialergico = new Suministro();
        Suministro dilatador = new Suministro();
        Suministro antiinflamatorio = new Suministro();
        Suministro inyectadoras = new Suministro(); 
        Suministro carretesHilo = new Suministro();
        Suministro guantes = new Suministro();
        Suministro botellasAlcohol = new Suministro();
        Suministro gasa = new Suministro();
        
        //Se agrega cada uno de los suministros al inventario de la ambulancia
        inventario.add(sueros);
        inventario.add(antialergico);
        inventario.add(dilatador);
        inventario.add(antiinflamatorio);
        inventario.add(inyectadoras);
        inventario.add(carretesHilo);
        inventario.add(guantes);
        inventario.add(botellasAlcohol);
        inventario.add(gasa);
    }

    //SE PONDRÁN LOS GETTERS Y SETTERS AL ESTAR LISTAS LAS DEMÁS CLASES
    public boolean asignar_Al_Equipo(Personal per) {
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
