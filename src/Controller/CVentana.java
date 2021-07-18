package Controller;

import javax.swing.*;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class CVentana {

    JFrame ventana;

    public CVentana(JFrame ventana) {
        this.ventana = ventana;
    }
    
    public CVentana() {
    }
    
    public void iniciarVentana(JFrame ventana, String ruta){
       ventana.setLocationRelativeTo(null);
       ventana.setIconImage(new ImageIcon(ruta).getImage()); 
       ventana.setResizable(false); 
       ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
}
