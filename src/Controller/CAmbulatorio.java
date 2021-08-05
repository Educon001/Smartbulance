
package Controller;

import Modelo.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import persistencia.PClinica;

public class CAmbulatorio implements ICEntidad{
    
    private Ambulatorio ambulatorio;
    private String RIF_Clinica;

    public CAmbulatorio(Ambulatorio ambulatorio, String RIF_Clinica){
        this.ambulatorio = ambulatorio;
        this.RIF_Clinica = RIF_Clinica;
    }
    
    public CAmbulatorio(){}

    public Ambulatorio getAmbulatorio() {
        return ambulatorio;
    }
    
    
    /*public CAmbulatorio() {
    }*/
        @Override
    public void mostrarEntidad(JLabel nombre, JLabel telefono,JLabel RIF, JLabel estado, JLabel ciudad, JLabel direccion) {
        nombre.setText(ambulatorio.getNombre());
        RIF.setText(ambulatorio.getRIF());
        estado.setText(ambulatorio.getEstado());
        ciudad.setText(ambulatorio.getCiudad());
        direccion.setText(ambulatorio.getDireccion());
    }

    @Override
    public void editarEntidad(JTextField nombre, JTextField telefono,JTextField estado, JTextField ciudad, JTextField dirección) {
    }
    
    
    public void mostrarPersonal(JTable tabla){
        
        String[] titulos = {"Nombre","Cedula","Numero de Carnet","Tipo"};
        String[][] datos = new String[ambulatorio.getPersonal().size()][4];
        
        for (int i = 0; i < ambulatorio.getPersonal().size(); i++) {
            datos[i][0]=ambulatorio.getPersonal().get(i).getNombre();
            datos[i][1]=ambulatorio.getPersonal().get(i).getCedula();
            datos[i][2]=String.valueOf(ambulatorio.getPersonal().get(i).getNumCarnet());
            datos[i][3]=ambulatorio.getPersonal().get(i).getTipo();
        }
        
        TableModel modelo = new DefaultTableModel(datos,titulos);
        tabla.setModel(modelo);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);
    }
    
    public boolean seEncuentraPersonal_CI(String cedula){
        for(Personal per : ambulatorio.getPersonal()){
            if(cedula.equals(per.getCedula())){
                JOptionPane.showMessageDialog(null,"Ya se encuentra un miembro del personal con esta cédula.","Error", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }
    
    public boolean seEncuentraPersonal_Licencia(String licencia){
        for(Personal per : ambulatorio.getPersonal()){
            if(per instanceof Conductor && licencia.equals(((Conductor) per).getLicencia())){
                JOptionPane.showMessageDialog(null,"Ya se encuentra un conductor registrado con este número de licencia.","Error", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }
    
    public void crearAmbulancia(boolean enMantenimiento, String serial, boolean disponible,JRadioButton radioTerrestre){
        String tipoAmbulancia;
        
        if(radioTerrestre.isSelected()) tipoAmbulancia = "Terrestre";
        else tipoAmbulancia = "Aerea";
        
        Ambulancia amb = new Ambulancia(serial,enMantenimiento,disponible,tipoAmbulancia);
        ambulatorio.agregarVehiculo(amb);       
        PClinica persistencia = new PClinica();
        persistencia.agregarVehiculo(amb,RIF_Clinica,ambulatorio.getRIF());
    }
    
    public void crearCompacto(boolean enMantenimiento, String serial, boolean disponible){
        Compacto comp = new Compacto(serial,enMantenimiento,disponible);
        ambulatorio.agregarVehiculo(comp);
        PClinica persistencia = new PClinica();
        persistencia.agregarVehiculo(comp,RIF_Clinica,ambulatorio.getRIF());
    }
    
    public void crearVehiculo(JRadioButton radioAmb,JTextField txtSerial,JRadioButton radioTerrestre){
        boolean disponible=true, enMantenimiento=false;
        String serial;

        serial = txtSerial.getText();
        
        if(radioAmb.isSelected()) crearAmbulancia(enMantenimiento,serial,disponible,radioTerrestre);
        else crearCompacto(enMantenimiento,serial,disponible);
    }
    
    
    public void crearPersonal(String ci,String nombre,String correo,String telf,Date fN,JRadioButton masc,JRadioButton fem,JRadioButton act_SI,JRadioButton act_NO,String salario,Date fC,String tipo,String licencia,JRadioButton DRS_SI,JRadioButton DRS_NO){
        Personal per;
        long lic;
        boolean activo,drs;
        char genero=' ';
        LocalDate nacimiento = fN.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate contrato = fC.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
      
        int numCarnets=ambulatorio.getPersonal().size();
        double sal = Double.parseDouble(salario);
        
        if(masc.isSelected()) genero='M';
        if(fem.isSelected()) genero='F';
        
        activo = act_SI.isSelected();
        
        if(tipo.equals("Paramédico")){
            drs=DRS_SI.isSelected();
            per = new Paramedico(numCarnets,activo,sal,contrato,tipo,ci,nombre,correo,telf,nacimiento,genero,drs);
        }
        else if(tipo.equals("Conductor")){
            lic = Long.parseLong(licencia);
            per = new Conductor(lic,numCarnets,activo,sal,contrato,tipo,ci,nombre,correo,telf,nacimiento,genero);
        }
        else per = new Personal(numCarnets,activo,sal,contrato,tipo,ci,nombre,correo,telf,nacimiento,genero);
        
        ambulatorio.registrarPersonal(per);
        PClinica persistencia = new PClinica();
        persistencia.agregarPersonal(per,RIF_Clinica,ambulatorio.getRIF());
    }
    
    
    public void mostrarTablaVehiculos(JTable tablaVehiculos){
        String titulo[]={"Tipo","Serial","En Mantenimiento","Disponible","Tipo ambulancia","Código"};
        String matriz[][]=new String[ambulatorio.getVehiculos().size()][6];

        for (int i=0;i<ambulatorio.getVehiculos().size();i++){
            if(ambulatorio.getVehiculos().get(i) instanceof Compacto){
                matriz[i][0]="Compacto";
                matriz[i][4]="No aplica";
            }
            if(ambulatorio.getVehiculos().get(i) instanceof Ambulancia){
                matriz[i][0]="Ambulancia";
                matriz[i][4]= ((Ambulancia) ambulatorio.getVehiculos().get(i)).getTipo();
            }
            
            matriz[i][1]=ambulatorio.getVehiculos().get(i).getSerial();
            
            if(ambulatorio.getVehiculos().get(i).isEnMantenimiento()) matriz[i][2]="Sí";
            else matriz[i][2]="No";
            
            if(ambulatorio.getVehiculos().get(i).isDisponible()) matriz[i][3]="Sí";
            else matriz[i][3]="No";
            
            matriz[i][5] = Integer.toString(ambulatorio.getVehiculos().get(i).getCodigo());
        }
        
        TableModel model = new DefaultTableModel(matriz,titulo);
        tablaVehiculos.setModel(model);
        tablaVehiculos.setDefaultEditor(Object.class, null);
        tablaVehiculos.getTableHeader().setReorderingAllowed(false);
        tablaVehiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaVehiculos.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
    }
    

    public String pasarAtributo_DeTabla(JTable tablaEntidad,int columna){
        int indice = tablaEntidad.getSelectedRow();
        TableModel modelo = tablaEntidad.getModel();
        try{
            String atributo = modelo.getValueAt(indice,columna).toString();
            return atributo;
        }
        catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showConfirmDialog(null,"Debe seleccionar un item de la tabla.","Error",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public Personal personalSeleccionado(JTable tablaPersonal){
        String ci = pasarAtributo_DeTabla(tablaPersonal,1);
        if(ci!=null){
            return ambulatorio.buscarPersonal(ci);
        }
        return null;
    }
   
    public Vehiculo vehiculoSeleccionado(JTable tablaVehiculos){
        String serial = pasarAtributo_DeTabla(tablaVehiculos,1);
        if(serial!=null){
            return ambulatorio.buscarVehiculo(serial);
        }
        return null;
    }
    
    public void crearTurnoNuevo(Personal per, Date hora){
        Turno turno = new Turno(hora,null);
        per.registrarEntradaSalida(turno);
        System.out.println(per.ultimaEntradaSalida().getEntrada());
    }
    
    public void registrarTurno(Personal per){
       Date hora = new Date();
       if(per.getEntradaSalida().isEmpty() || per.ultimaEntradaSalida().getSalida()!=null)
            crearTurnoNuevo(per,hora);
       else
            per.ultimaEntradaSalida().setSalida(hora);
    }
    
    public void ambulatorioDisponible(JToggleButton disp){
        ambulatorio.setDisponible(disp.isSelected());
        PClinica persistencia = new PClinica();
        persistencia.modificarEntidad(ambulatorio,0);
    }
 
}
