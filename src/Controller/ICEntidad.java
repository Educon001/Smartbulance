
package Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;

public interface ICEntidad {

    public abstract void mostrarEntidad(JLabel nombre, JLabel RIF,JLabel estado, JLabel ciudad, JLabel dirección);

    public abstract void editarEntidad(JTextField nombre, JTextField RIF,JTextField estado, JTextField ciudad, JTextField dirección);

}
