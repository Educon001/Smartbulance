
package Modelo;

import java.util.ArrayList;

public class Ambulancia extends Vehiculo { //NOTA: FALTAN LOS METODOS PARA LLEVAR A CABO EL INVENTARIO
    private String tipo;
    
    //SE PONDRÁN LOS CONSTRUCTORES AL ESTAR LISTAS LAS DEMÁS CLASES

    public Ambulancia(String tipo) {
        //Se llama al constructor de Vehiculo
        super();
        //En el constructor de los suministros debe ir el nombre y la cantidad ideal de cada suministro
        Suministro suero = new Suministro(); 
        Suministro antialergico = new Suministro();
        Suministro dilatador = new Suministro();
        Suministro antiinflamatorio = new Suministro();
        Suministro bombonas = new Suministro(); 
        Suministro desfibrilador = new Suministro();
        Suministro camilla = new Suministro();
        Suministro mantas = new Suministro();
        Suministro vendajes = new Suministro(); 
        Suministro respirador = new Suministro();
        
        //Se agrega cada uno de los suministros al inventario de la ambulancia
        inventario.add(suero);
        inventario.add(antialergico);
        inventario.add(dilatador);
        inventario.add(antiinflamatorio);
        inventario.add(bombonas);
        inventario.add(desfibrilador);
        inventario.add(camilla);
        inventario.add(mantas);
        inventario.add(vendajes);
        inventario.add(respirador);
        
        this.tipo = tipo;
    }
    
    
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
