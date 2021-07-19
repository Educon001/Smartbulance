
package Controller;

import javax.swing.JLabel;
import javax.swing.JTextField;

public interface ICEntidad {

    public abstract void mostrarEntidad(JLabel nombre, JLabel telefono,JLabel RIF,JLabel estado, JLabel ciudad, JLabel dirección);

    public abstract void editarEntidad(JTextField nombre, JTextField telefono,JTextField estado, JTextField ciudad, JTextField dirección);

}
