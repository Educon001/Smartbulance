/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import Modelo.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.lang.model.util.ElementFilter;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;


/**
 *
 * @author familia
 * 
 */
public class PPaciente {
    private Element root;
    private String fileLocation = "src//archivos//Pacientes.xml";
    private Document doc;

    public PPaciente() throws IOException, JDOMException {
        try {
            SAXBuilder builder = new SAXBuilder(false); //parse que maneja el XMl
            Document doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } 
    }
    
    //-----------------ELEMENTOS A XML---------------------------------
    
    //Paciente a XML
    private Element PacientetoXMLElement(Paciente paciente) {
        Element elementoPaciente = new Element("Paciente");//nombre de la Clase
        
        Element cedula = new Element("cedula");
        cedula.setText(paciente.getCedula());
        
        Element nombre = new Element("nombre");
        nombre.setText(paciente.getNombre());
        
        Element correo = new Element("correo");
        correo.setText(paciente.getCorreo());
        
        Element telefono = new Element("telefono");
        telefono.setText(paciente.getTelefono());
        
        Element nacimiento = new Element("nacimiento");
        nacimiento.setText(paciente.getNacimiento().toString());
        
        Element genero = new Element("genero");
        genero.setText(Character.toString(paciente.getGenero()));       
        
        elementoPaciente.addContent(cedula);
        elementoPaciente.addContent(nombre);
        elementoPaciente.addContent(correo);
        elementoPaciente.addContent(telefono);
        elementoPaciente.addContent(nacimiento);
        elementoPaciente.addContent(genero);
        
        return elementoPaciente;
    }
    
    public boolean agregarPaciente(Paciente paciente) {
        root.addContent(PacientetoXMLElement(paciente));
        boolean  result = updateDocument();
        return result;
    }
    
    
    //AGREGAR PAGO
    private Element PagotoXMLElement(Pago pago){
        Element elementoPago = new Element("pago");//nombre de la Clase
        
        Element factura = new Element("factura");
        factura.setText(Long.toString(pago.getFactura()));
        
        Element fecha = new Element("fecha");
        fecha.setText(pago.getFecha().toString());
        
        Element monto = new Element("monto");
        monto.setText(Double.toString(pago.getMonto()));
        
        elementoPago.addContent(factura);
        elementoPago.addContent(fecha);
        elementoPago.addContent(monto);
        
        return elementoPago;
    }
    
    private boolean agregarPago(String cedula,Element elementoPago){
        List<Element> listaPacientes = root.getChildren();
        
        for(Element elementoPaciente : listaPacientes){
            if(elementoPaciente.getChildText("cedula").equals(cedula)){
                if(elementoPaciente.getChild("pagos")==null){
                    Element pagos = new Element("pagos");
                    pagos.addContent(elementoPago);
                    elementoPaciente.addContent(pagos);
                }
                else elementoPaciente.getChild("pagos").addContent(elementoPago);
                return updateDocument();
            }
        }
        return false;
    }
    
    public void agregarPago(String cedula,Pago pago){
        Element elementoPago = PagotoXMLElement(pago);
        agregarPago(cedula,elementoPago);
    }
    
    
    //AGREGAR EMERGENCIA 
    private Element EmergenciatoXMLElement(Emergencia emg){
        Element elementoEmergencia = new Element("emergencia");//nombre de la Clase
        
        Element descripcion = new Element("descripcion");
        descripcion.setText(emg.getDescripcion());
        
        Element respuestaRapida = new Element("respuestaRapida");
        respuestaRapida.setText(Boolean.toString(emg.isRespuestaRapida()));
        
        Element ambulatorio = new Element("ambulatorio");
        ambulatorio.setText(Boolean.toString(emg.isAmbulatorio()));
        
        Element clinica = new Element("clinica");
        clinica.setText(Boolean.toString(emg.isClinica()));
        
        Element rifAmbulatorio = new Element("rifAmbulatorio");
        rifAmbulatorio.setText(emg.getRifAmbulatorio());
        
        Element vehiculo = new Element("vehiculo");
        vehiculo.setText(emg.getVehiculo());
        
        Element codigo = new Element("codigo");
        codigo.setText(Integer.toString(emg.getCodigo()));
        
        elementoEmergencia.addContent(descripcion);
        elementoEmergencia.addContent(respuestaRapida);
        elementoEmergencia.addContent(ambulatorio);
        elementoEmergencia.addContent(clinica);
        elementoEmergencia.addContent(rifAmbulatorio);
        elementoEmergencia.addContent(vehiculo);
        elementoEmergencia.addContent(codigo);
        
        return elementoEmergencia;
    }
    
    private boolean agregarEmergencia(String cedula,Element elementoEmergencia){
        List<Element> listaPacientes = root.getChildren();
        
        for(Element elementoPaciente : listaPacientes){
            if(elementoPaciente.getChildText("cedula").equals(cedula)){
                if(elementoPaciente.getChild("emergencias")==null){
                    Element emergencias = new Element("emergencias");
                    emergencias.addContent(elementoEmergencia);
                    elementoPaciente.addContent(emergencias);
                }
                else elementoPaciente.getChild("emergencias").addContent(elementoEmergencia);
                return updateDocument();
            }
        }
        return false;
    }
    
    public void agregarEmergencia(String cedula,Emergencia emg){
        Element elementoEmergencia = EmergenciatoXMLElement(emg);
        agregarEmergencia(cedula,elementoEmergencia);
    }
    
    
    //----------------ELIMINAR PACIENTE------------------------------
    public boolean eliminarPaciente(String cedula){
        List<Element> listaPacientes = root.getChildren();
        for(Element elementoPaciente : listaPacientes){
            if(elementoPaciente.getChildText("cedula").equals(cedula)){
                listaPacientes.remove(elementoPaciente);
                return updateDocument();
            }
        }
        return false;
    }
    
    
    //-----------------CARGAR LISTA DE PACIENTES-------------------------------
    public Pago PagoToObject(Element elementoPago) throws ParseException{
        long factura = 0;
        Date fecha = null;
        double monto = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
        
        try{
            factura = Long.parseLong(elementoPago.getChildText("factura"));
            monto = Double.parseDouble(elementoPago.getChildText("monto"));
            fecha = formatter.parse(elementoPago.getChildText("fecha"));  
        } catch(NumberFormatException ex){}
        catch(ParseException ex1){}

        
        
        Pago pago = new Pago(factura,fecha,monto);
        return pago;
    }
    
    public void todosLosPagos(Paciente paciente,Element pagos) throws ParseException{
        List<Element> listaPagos = pagos.getChildren();
        for(Element elementoPago : listaPagos){
            paciente.registrarPago(PagoToObject(elementoPago));
        }
    }
    
    public Emergencia EmergenciaToObject(Element elementoEmergencia){
        int codigo = 0;
        Date entrada=null,salida=null;
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy");
        try{
            codigo = Integer.parseInt(elementoEmergencia.getChildText("codigo"));
        }catch(NumberFormatException ex){}
        
        try{
            entrada = formatter.parse(elementoEmergencia.getChildText("entrada"));  
            salida = formatter.parse(elementoEmergencia.getChildText("salida"));  
        }catch(ParseException ex1){}
        
        Emergencia emg = new Emergencia(elementoEmergencia.getChildText("descripcion"),Boolean.parseBoolean(elementoEmergencia.getChildText("respuestaRapida")),Boolean.parseBoolean(elementoEmergencia.getChildText("ambulatorio")),Boolean.parseBoolean(elementoEmergencia.getChildText("clinica")),elementoEmergencia.getChildText("rifAmbulatorio"),elementoEmergencia.getChildText("vehiculo"),Integer.parseInt(elementoEmergencia.getChildText("codigo")),entrada,salida);
        
        return emg;
    }
    
    public void todasLasEmergencias(Paciente paciente,Element emergencias){
        List<Element> listaEmergencias = emergencias.getChildren();
        for(Element elementoEmergencia : listaEmergencias){
            paciente.registrarEntradaSalida((Emergencia) EmergenciaToObject(elementoEmergencia));
        }
    }
    
    public Paciente PacienteToObject(Element elementoPaciente){
        LocalDate nacimiento=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        try{
            nacimiento = LocalDate.parse(elementoPaciente.getChild("nacimiento").getText(), formatter);
        }
        catch(DateTimeParseException ex){}
        
        Paciente paciente = new Paciente(elementoPaciente.getChildText("cedula"),elementoPaciente.getChildText("nombre"),elementoPaciente.getChildText("correo"),elementoPaciente.getChildText("telefono"),nacimiento,elementoPaciente.getChildText("genero").charAt(0));
        
        return paciente;
    }
    
    public ArrayList<Paciente> todosLosPacientes() throws ParseException{
        ArrayList<Paciente> resultado = new ArrayList<Paciente>();
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            Paciente paciente = PacienteToObject(xmlElem);
            if(xmlElem.getChild("emergencias")!=null) todasLasEmergencias(paciente,xmlElem.getChild("emergencias"));
            if(xmlElem.getChild("pagos")!=null) todosLosPagos(paciente,xmlElem.getChild("pagos"));
            resultado.add(paciente);
        }
        return resultado;
    }
    
    
    //-------------------ACTUALIZAR DOCUMENTO------------------------------------------
    private boolean updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
            return true;
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            return false;
        }
    }

    
    
}