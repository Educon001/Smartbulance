package Controller;

import Modelo.*;
import Vista.DescripcionEmergencia;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CEmergencia {
    
    //------------------REGISTRO DE EMERGENCIA-------------------------
    public void llenarListaAmbDisp(Clinica clinica,ArrayList<Ambulatorio> ambDisp){
        for(Ambulatorio amb : clinica.getAmbulatorios()){
            if(amb.isDisponible()) ambDisp.add(amb);
        }
    }
    
    public void mostrarAmbDisp(JTable tabla,Clinica clinica){        
        //Lista de ambulatorios disponibles
        ArrayList<Ambulatorio> ambDisp = new ArrayList<Ambulatorio>();
        llenarListaAmbDisp(clinica,ambDisp);
        
        String[] titulos = {"Nombre","Ciudad","Dirección","Teléfono"};
        String[][] datos = new String[ambDisp.size()][4];
        
        for (int i = 0; i < ambDisp.size(); i++) {
            datos[i][0]=ambDisp.get(i).getNombre();
            datos[i][1]=ambDisp.get(i).getCiudad();
            datos[i][2]=ambDisp.get(i).getDireccion();
            datos[i][3]=ambDisp.get(i).getTelefono();
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void titulosTablaAmbSelec(JTable tabla){
        String[] titulos = {"Nombre","Ciudad","Dirección","Teléfono"};
        TableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
    }
    
    
    public void mostrarAmbulatorioSeleccionado(JTable tabla,Ambulatorio amb){        
        //DATOS DEL AMBULATORIO SELECCIONADO
        String[] titulos = {"Nombre","Ciudad","Dirección","Teléfono"};
        String[][] datos = new String[1][4];
        
        datos[0][0]=amb.getNombre();
        datos[0][1]=amb.getCiudad();
        datos[0][2]=amb.getDireccion();
        datos[0][3]=amb.getTelefono();

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void mostrarVehiculosDisponibles(JTable tabla,ArrayList<Vehiculo> vehiculos){
        String[] titulos = {"Código","Serial","Tipo"};
        String[][] datos = new String[vehiculos.size()][3];
        
        for(int i=0; i<vehiculos.size(); i++){
            datos[i][0]=Integer.toString(vehiculos.get(i).getCodigo());
            datos[i][1]=vehiculos.get(i).getSerial();
            if(vehiculos.get(i) instanceof Ambulancia)
                datos[i][2]=((Ambulancia)vehiculos.get(i)).getTipo();
            if(vehiculos.get(i) instanceof Compacto)
                datos[i][2]="Respuesta rápida";
        }

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void llenarListaAmbulanciasDisp(Ambulatorio ambulatorio,ArrayList<Vehiculo> ambulanciasDisp){
        for(Vehiculo veh : ambulatorio.getVehiculos()){
            if(veh instanceof Ambulancia && veh.isDisponible() && veh.getPersonalActual()!=null)
                ambulanciasDisp.add((Ambulancia) veh);
        }
    }
    
    
    public Vehiculo vehiculoSeleccionado(JTable tabla,Ambulatorio ambulatorio){
        String serial = pasarAtributo_DeTabla(tabla,1);
        return ambulatorio.buscarVehiculo(serial);
    }
    
    public void titulosTablaVehSelec(JTable tabla){
        String[] titulos = {"Código","Serial","Tipo"};
        TableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
    }
    
    public void mostrarVehiculoSeleccionado(JTable tabla,Vehiculo veh){
        String[] titulos = {"Código","Serial","Tipo"};
        String[][] datos = new String[1][3];
        
        datos[0][0]=Integer.toString(veh.getCodigo());
        datos[0][1]=veh.getSerial();
        if(veh instanceof Ambulancia)
            datos[0][2]=((Ambulancia)veh).getTipo();
        if(veh instanceof Compacto)
            datos[0][2]="Respuesta rápida";

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public void ambulancias_disponibles_conEquipo(JTable tabla,Ambulatorio ambulatorio){
        ArrayList<Vehiculo> ambulanciasDisp = new ArrayList<Vehiculo>();
        llenarListaAmbulanciasDisp(ambulatorio,ambulanciasDisp); 
        try{
            mostrarVehiculosDisponibles(tabla,ambulanciasDisp);
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Este ambulatorio no tiene ambulancias disponibles en este momento.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void llenarListaCompactosDisp(Ambulatorio ambulatorio,ArrayList<Vehiculo> compactosDisp){
        for(Vehiculo veh : ambulatorio.getVehiculos()){
            if(veh instanceof Compacto && veh.isDisponible() && veh.getPersonalActual()!=null)
                compactosDisp.add((Compacto) veh);
        }
    }
    
    public void compactos_disponibles_conEquipo(JTable tabla,Ambulatorio ambulatorio){
        ArrayList<Vehiculo> compactosDisp = new ArrayList<Vehiculo>();
        llenarListaCompactosDisp(ambulatorio,compactosDisp);
        try{
            mostrarVehiculosDisponibles(tabla,compactosDisp);
        }
        catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null,"Este ambulatorio no tiene vehículos compactos disponibles en este momento.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
   //
    public String pasarAtributo_DeTabla(JTable tablaEntidad,int columna){
        int indice = tablaEntidad.getSelectedRow();
        TableModel modelo = tablaEntidad.getModel();
        try{
            String atributo = modelo.getValueAt(indice,columna).toString();
            return atributo;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un item de la tabla.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    //Sobrecarga del método anterior. Se usa cuando ya se seleccionó el objeto
    public String pasarAtributo_DeTabla(int columna,JTable tablaEntidad){
        int indice = 0;
        TableModel modelo = tablaEntidad.getModel();
        try{
            String atributo = modelo.getValueAt(indice,columna).toString();
            return atributo;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null,"Debe seleccionar un item de la tabla.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    //Se usa para pasar el ambulatorio seleccionado de una tabla a otra
    public Ambulatorio ambulatorioSeleccionado(JTable tabla,Clinica clinica){
        String telf = pasarAtributo_DeTabla(tabla,3);
        return clinica.retornarAmbulatorio_Telf(telf);
    }
    
    //Se usa para usar la lista de vehiculos del ambulatorio seleccionado
    public Ambulatorio ambulatorioSeleccionado(Clinica clinica,JTable tabla){
        String telf = pasarAtributo_DeTabla(3,tabla);
        return clinica.retornarAmbulatorio_Telf(telf);
    }
    
    
    public void panelRegistro(JTabbedPane pest){
        pest.setSelectedIndex(0);
    }
    
    //MENSAJES DE ERROR
    public void pacienteNoEncontrado(){
        JOptionPane.showMessageDialog(null,"No se encuentra un paciente registrado con esta cédula.","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void pacienteNoAlDia(){
        JOptionPane.showMessageDialog(null,"El paciente introducido no se encuentra al día con sus pagos.","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void pacienteConEmergenciaAbierta(){
        JOptionPane.showMessageDialog(null,"El paciente introducido tiene una emergencia abierta, la cual se debe cerrar para continuar.","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    //SE CREA DEL OBJETO EMERGENCIA Y SE AGREGA A LA LISTA DE EMERGENCIAS DEL PACIENTE PASADO
    public void crearEmergencia(Paciente pac,JTextArea txtAreaDescripcion,Ambulatorio ambulatorio,JRadioButton radioAmb,JRadioButton radioClinica,JRadioButton radioResp,Vehiculo veh){
        int codigo = pac.getEntradaSalida().size()-1;
        Date entrada = new Date();
        //CONSTRUCTOR EMERGENCIA
        Emergencia emg = new Emergencia(txtAreaDescripcion.getText(), radioResp.isSelected(),radioAmb.isSelected(), radioClinica.isSelected(),ambulatorio.getRIF(),veh.getSerial(),codigo,entrada,null); 
        //SE AGREGA A LA LISTA DE EMERGENCIAS DEL PACIENTE
        pac.getEntradaSalida().add(emg);
    }
    
    
    //-------------HISTORIAL DE EMERGENCIAS----------------------
    
    //
    public void mostrarSoloTitulosEmergencia(JTable tabla){
        String[] titulos = {"Código","Destino","Ambulatorio (RIF)","Vehículo (Serial)","Fecha de Entrada","Fecha Salida"};
        TableModel modelo = new DefaultTableModel(null,titulos);
        tabla.setModel(modelo);
    }
    //Muestra todas las emergencias cerradas.
    public void mostrarHistorial(JTable tabla,ArrayList<Emergencia> emergencias){
        String[] titulos = {"Código","Destino","Ambulatorio (RIF)","Vehículo (Serial)","Fecha de Entrada","Fecha Salida"};
        String[][] datos = new String[emergencias.size()][3];
        
        for(int i=0; i<emergencias.size(); i++){
            if(emergencias.get(i).getSalida()!=null){
                datos[i][0] = Integer.toString(emergencias.get(i).getCodigo());
                if(emergencias.get(i).isAmbulatorio())
                    datos[i][1] = "Ambulatorio";
                if(emergencias.get(i).isClinica())
                    datos[i][1] = "Clínica";
                if(emergencias.get(i).isRespuestaRapida())
                    datos[i][1] = "Respuesta rápida";
                datos[i][2] = emergencias.get(i).getRifAmbulatorio();
                datos[i][3] = emergencias.get(i).getVehiculo();
                datos[i][4] = emergencias.get(i).getEntrada().toString();
                datos[i][5] = emergencias.get(i).getSalida().toString();
            }
        }

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    //Muestra la última emergencia abierta
    //FALTA CONFIRMAR TAMAÑO DE COLUMNAS
    public void mostrarHistorial(JTable tabla,Emergencia emergencia){
        String[] titulos = {"Código","Destino","Ambulatorio (RIF)","Vehículo (Serial)","Fecha de Entrada","Fecha Salida"};
        String[][] datos = new String[1][3];
        
        
        datos[0][0] = Integer.toString(emergencia.getCodigo());
        if(emergencia.isAmbulatorio())
            datos[0][1] = "Ambulatorio";
        if(emergencia.isClinica())
            datos[0][1] = "Clínica";
        if(emergencia.isRespuestaRapida())
            datos[0][1] = "Respuesta rápida";
        datos[0][2] = emergencia.getRifAmbulatorio();
        datos[0][3] = emergencia.getVehiculo();
        datos[0][4] = emergencia.getEntrada().toString();
        datos[0][5] = "No se ha cerrado";

        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
   
    
    public Emergencia emergenciaAbierta(JTable tabla,Paciente paciente){
        int  codigo=-5;
        try{
            codigo = Integer.parseInt(pasarAtributo_DeTabla(0,tabla));
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Formato de dato no es numérico.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return paciente.retornarEmergencia(codigo);
    }
    
    public Emergencia emergenciaSeleccionada(JTable tabla,Paciente paciente){
        int  codigo=-5;
        try{
            codigo = Integer.parseInt(pasarAtributo_DeTabla(tabla,0));
        }
        catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Formato de dato no es numérico.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return paciente.retornarEmergencia(codigo);
    }
    
    public void mostrarDescripcion(String descripcion){
        DescripcionEmergencia ventanaDescrip = new DescripcionEmergencia(descripcion);
    }
    
    public void cerrarEmergencia(JTable tablaUlt,Emergencia emg){
        emg.setSalida(new Date());
        mostrarSoloTitulosEmergencia(tablaUlt);
    }
    
}
