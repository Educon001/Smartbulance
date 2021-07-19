
package Controller;

import javax.swing.JButton;

public class EventoMouse extends java.awt.event.MouseAdapter{
    
    JButton boton;

    public EventoMouse(JButton boton) {
        this.boton = boton;
    }  
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt){
        boton.setEnabled(true);
    }
      
}