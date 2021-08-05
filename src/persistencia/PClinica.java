package persistencia;

import Modelo.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.lang.model.util.ElementFilter;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class PClinica {
    private Element root;
    private String fileLocation = "src//archivos//Clinicas.xml";
    private Document doc;
    
    public PClinica() {
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
   
    //-----------------ENTIDAD A ELEMENTO XML--------------------------------------
    private void EntidadtoXMLElement(Element elementoEntidad, Entidad entidad) {
     
        Element nombre = new Element("nombre"); 
        nombre.setText(entidad.getNombre());
     
        Element telefono = new Element("telefono");
        telefono.setText(entidad.getTelefono());
     
        Element RIF = new Element("RIF");
        RIF.setText(entidad.getRIF());
     
        Element estado = new Element("estado");
        estado.setText(entidad.getEstado());
     
        Element ciudad = new Element("ciudad");
        ciudad.setText(entidad.getCiudad());
     
        Element direccion = new Element("direccion");
        direccion.setText(entidad.getDireccion());
        
        
        
        elementoEntidad.addContent(nombre); //se pasan los valores al documento XML
        elementoEntidad.addContent(telefono);
        elementoEntidad.addContent(RIF);
        elementoEntidad.addContent(estado);
        elementoEntidad.addContent(ciudad);
        elementoEntidad.addContent(direccion);
    }
    
    
    private Element ClinicatoXMLElement(Clinica clinica) {
        Element elementoClinica = new Element("Clinica");//nombre de la Clase
     
        EntidadtoXMLElement(elementoClinica,clinica);
        
        Element disponible = new Element("disponible");
        disponible.setText(Boolean.toString(clinica.isDisponible()));
        
        elementoClinica.addContent(disponible);

        return elementoClinica;
    }
    
    public boolean agregarClinica(Clinica clinica) {
        root.addContent(ClinicatoXMLElement(clinica));
        boolean  resultado = updateDocument();
        return resultado;
    }
    
    
    
    //------------GUARDAR AMBULATORIO---------------------
    private Element AmbulatoriotoXMLElement(Ambulatorio ambulatorio) {
        Element elementoAmbulatorio = new Element("Ambulatorio");//nombre de la Clase
     
        
        EntidadtoXMLElement(elementoAmbulatorio,ambulatorio);
        
        Element disponible = new Element("disponible");
        disponible.setText(Boolean.toString(ambulatorio.isDisponible()));
        
        elementoAmbulatorio.addContent(disponible);

        return elementoAmbulatorio;        
    }
    
    public boolean tieneAmbulatorios(Element clinica){
        List<Element> atributos = clinica.getChildren();
        for(Element elemento : atributos){
            if(elemento.getName().equals("ambulatorios"))
                return true;
        }
        return false;
    }
    
    public boolean agregarAmbulatorio(Element ambulatorio, String RIF){
        List<Element> listaElementos=root.getChildren();
        for (Element element : listaElementos) {
//                if (element.getName().equals("Clinica")) {
                    if(element.getChild("RIF").getText().equals(RIF)){
                        if(element.getChild("ambulatorios")==null){
                            Element ambulatorios = new Element("ambulatorios");
                            ambulatorios.addContent(ambulatorio);
                            element.addContent(ambulatorios);
                        }
                        else element.getChild("ambulatorios").addContent(ambulatorio);
                        boolean  resultado = updateDocument();
                        return resultado;
                    }
//                }
        }
        return false;
    }
    
    public void agregarAmbulatorio(Ambulatorio ambulatorio,String RIF){
        Element elementoAmbulatorio = AmbulatoriotoXMLElement(ambulatorio);
        agregarAmbulatorio(elementoAmbulatorio,RIF);
    }
    
    
    //-------------GUARDAR TALLERES------------------------
    private Element TallertoXMLElement(Taller taller) {
        Element elementoTaller = new Element("Taller");//nombre de la Clase

        EntidadtoXMLElement(elementoTaller,taller);

        Element mecanicos = new Element("mecanicos");
        
        for(int i=0; i<taller.getMecanicos().size(); i++){
            Element mecanico = new Element("mecanico");
            mecanico.setText(taller.getMecanicos().get(i));
            mecanicos.addContent(mecanico);
        }
 
        elementoTaller.addContent(mecanicos);
        
        
        return elementoTaller;
    }
    
    public boolean tieneTalleres(Element clinica){
        List<Element> atributos = clinica.getChildren();
        for(Element elemento : atributos){
            if(elemento.getName().equals("talleresAsociados"))
                return true;
        }
        return false;
    }
    
    public boolean agregarTaller(Element taller, String RIF){
        List<Element> listaElementos=root.getChildren();
        for (Element element : listaElementos) {
//                if (element.getName().equals("Clinica")) {
                    if(element.getChild("RIF").getText().equals(RIF)){
                        if(!tieneTalleres(element)){
                            Element talleresAsociados = new Element("talleresAsociados");
                            talleresAsociados.addContent(taller);
                            element.addContent(talleresAsociados);
                        }
                        else element.getChild("talleresAsociados").addContent(taller);
                        boolean  resultado = updateDocument();
                        return resultado;
                    }
//                }
        }
        return false;
    }
    
    public void agregarTaller(Taller ta,String RIF){
        Element taller = TallertoXMLElement(ta);
        agregarTaller(taller,RIF);
 
    }
    
    
    //--------------------GUARDAR VEHICULOS--------------------
    
    private void VehiculotoXMLElement(Element elementoVehiculo, Vehiculo vehiculo) {
     
        Element serial = new Element("serial"); 
        serial.setText(vehiculo.getSerial());
     
        Element enMantenimiento = new Element("enMantenimiento");
        enMantenimiento.setText(Boolean.toString(vehiculo.isEnMantenimiento()));
     
        Element disponible = new Element("disponible");
        disponible.setText(Boolean.toString(vehiculo.isDisponible()));
     
        Element codigo = new Element("codigo");
        codigo.setText(Integer.toString(vehiculo.getCodigo()));
        
        elementoVehiculo.addContent(serial); //se pasan los valores al documento XML
        elementoVehiculo.addContent(enMantenimiento);
        elementoVehiculo.addContent(disponible);
        elementoVehiculo.addContent(codigo);
    }
    
    private Element AmbulanciatoXMLElement(Ambulancia ambulancia){
        Element elementoAmbulancia = new Element("ambulancia");
        
        VehiculotoXMLElement(elementoAmbulancia,ambulancia);
        
        Element tipo = new Element("tipo");
        tipo.setText(ambulancia.getTipo());
        
        elementoAmbulancia.addContent(tipo);
        
        return elementoAmbulancia;
    }
    
    private Element CompactotoXMLElement(Compacto compacto){
        Element elementoCompacto = new Element("compacto");
        
        VehiculotoXMLElement(elementoCompacto,compacto);
        
        return elementoCompacto;
    }
    
    public boolean tieneVehiculos(Element ambulatorio){
        List<Element> atributos = ambulatorio.getChildren();
        for(Element elemento : atributos){
            if(elemento.getName().equals("vehiculos"))
                return true;
        }
        return false;
    }
    
    public void agregarVehiculo(Element elementoVehiculo, String RIF_Clinica, String RIF_Ambulatorio){
        List<Element> listaElementos=root.getChildren();
        for (Element element : listaElementos) {
                if (element.getName().equals("Clinica")) {
                    if(element.getChild("RIF").getText().equals(RIF_Clinica)){
                        List<Element> listaAmbulatorios = element.getChild("ambulatorios").getChildren();
                        for(Element ambulatorio : listaAmbulatorios){
                            if(ambulatorio.getChild("RIF").getText().equals(RIF_Ambulatorio)){
                                if(!tieneVehiculos(ambulatorio)){
                                    Element vehiculos = new Element("vehiculos");
                                    vehiculos.addContent(elementoVehiculo);
                                    ambulatorio.addContent(vehiculos);
                                }
                                else ambulatorio.getChild("vehiculos").addContent(elementoVehiculo);
                            }
                        }
                    }
                }
        }
    }
    
    public boolean agregarVehiculo(Vehiculo vehiculo,String RIF_Clinica,String RIF_Ambulatorio){
        Element elementoVehiculo = null;
        if(vehiculo instanceof Ambulancia){
            elementoVehiculo = AmbulanciatoXMLElement((Ambulancia) vehiculo);
        }
        else if(vehiculo instanceof Compacto) 
            elementoVehiculo = CompactotoXMLElement((Compacto) vehiculo);
        agregarVehiculo(elementoVehiculo,RIF_Clinica,RIF_Ambulatorio);
        boolean  resultado = updateDocument();
        System.out.println(resultado);
        return resultado;
    }
  
    
    //----------------------GUARDAR PERSONAL--------------------
    private void PersonatoXMLElement(Element elementoPersona, Persona persona) {
        Element cedula = new Element("cedula");
        cedula.setText(persona.getCedula());
        
        Element nombre = new Element("nombre");
        nombre.setText(persona.getNombre());
        
        Element correo = new Element("correo");
        correo.setText(persona.getCorreo());
        
        Element telefono = new Element("telefono");
        telefono.setText(persona.getTelefono());
        
        Element nacimiento = new Element("nacimiento");
        nacimiento.setText(persona.getNacimiento().toString());
        
        Element genero = new Element("genero");
        genero.setText(Character.toString(persona.getGenero()));
        
        elementoPersona.addContent(cedula);
        elementoPersona.addContent(nombre);
        elementoPersona.addContent(correo);
        elementoPersona.addContent(telefono);
        elementoPersona.addContent(nacimiento);
        elementoPersona.addContent(genero);
    }
    
    private void ConductortoXMLElement(Element elementoConductor, Conductor conductor){
        Element licencia = new Element("licencia");
        licencia.setText(Long.toString(conductor.getLicencia()));
        
        elementoConductor.addContent(licencia);
    }
    
    private void ParamedicotoXMLElement(Element elementoParamedico, Paramedico paramedico){
        Element asignadoDRS = new Element("asignadoDRS");
        asignadoDRS.setText(Boolean.toString(paramedico.isAsignadoDRS()));
        
        elementoParamedico.addContent(asignadoDRS);
    }
    
    private Element PersonaltoXMLElement(Personal personal) {
        Element elementoPersonal = new Element("personal");
        
        PersonatoXMLElement(elementoPersonal,personal);
        
        Element numCarnet = new Element("numCarnet");
        numCarnet.setText(Long.toString(personal.getNumCarnet()));
        
        Element activo = new Element("activo");
        activo.setText(Boolean.toString(personal.isActivo()));
        
        Element salario = new Element("salario");
        salario.setText(Double.toString(personal.getSalario()));
        
        Element fechaContrato = new Element("fechaContrato");
        fechaContrato.setText(personal.getFechaContrato().toString());
        
        Element tipo = new Element("tipo");
        tipo.setText(personal.getTipo());
        
        elementoPersonal.addContent(numCarnet);
        elementoPersonal.addContent(activo);
        elementoPersonal.addContent(salario);
        elementoPersonal.addContent(fechaContrato);
        elementoPersonal.addContent(tipo);
        
        return elementoPersonal;
    }
    
    public void agregarPersonal(Element elementoPersonal, String RIF_Clinica, String RIF_Ambulatorio){
        List<Element> listaElementos=root.getChildren();
        for (Element element : listaElementos) {
                if (element.getName().equals("Clinica")) {
                    if(element.getChild("RIF").getText().equals(RIF_Clinica)){
                        List<Element> listaAmbulatorios = element.getChild("ambulatorios").getChildren();
                        for(Element ambulatorio : listaAmbulatorios){
                            if(ambulatorio.getChild("RIF").getText().equals(RIF_Ambulatorio)){
                                if(ambulatorio.getChild("Personal")==null){
                                    Element Personal = new Element("Personal");
                                    Personal.addContent(elementoPersonal);
                                    ambulatorio.addContent(Personal);
                                }
                                else ambulatorio.getChild("Personal").addContent(elementoPersonal);
                            }
                        }
                    }
                }
        }
    }
    
    public boolean agregarPersonal(Personal personal,String RIF_Clinica,String RIF_Ambulatorio){
        Element elementoPersonal = PersonaltoXMLElement(personal);
        
        if(personal instanceof Paramedico)
            ParamedicotoXMLElement(elementoPersonal,(Paramedico) personal);
        else if(personal instanceof Conductor)
            ConductortoXMLElement(elementoPersonal,(Conductor) personal);
        agregarPersonal(elementoPersonal,RIF_Clinica,RIF_Ambulatorio);
        boolean  resultado = updateDocument();
        System.out.println(resultado);
        return resultado;
    }
    
    
    //---------------MODIFICACIÓN DE ENTIDADES------------------------------
    
    //MODIFICAR DATOS DE LA ENTIDAD
    public void modificarDatosEntidad(Element elementoEntidad,Entidad entidad,int mod){
        if(mod==1){
            elementoEntidad.getChild("nombre").setText(entidad.getNombre());
            elementoEntidad.getChild("telefono").setText(entidad.getTelefono());
            elementoEntidad.getChild("estado").setText(entidad.getEstado());
            elementoEntidad.getChild("ciudad").setText(entidad.getCiudad());
            elementoEntidad.getChild("direccion").setText(entidad.getDireccion());
        }
        if(mod==0){
            if(entidad instanceof Clinica)
                elementoEntidad.getChild("disponible").setText(Boolean.toString(((Clinica) entidad).isDisponible()));
            else if(entidad instanceof Ambulatorio)
                elementoEntidad.getChild("disponible").setText(Boolean.toString(((Ambulatorio) entidad).isDisponible()));
        }
           
    }
    
    //MODIFICAR ENTIDAD
    public boolean modificarEntidad(Entidad entidad,int mod){
        List<Element> listaElementos=root.getChildren();
        for(Element elementoClinica : listaElementos){
            if(elementoClinica.getChildText("RIF").equals(entidad.getRIF())){
               if(mod==1) modificarDatosEntidad(elementoClinica,entidad,1);
               if(mod==0) modificarDatosEntidad(elementoClinica,entidad,0);
               return updateDocument();
            }
            else if(elementoClinica.getChild("ambulatorios")!=null){
                List<Element> listaAmbulatorios = elementoClinica.getChild("ambulatorios").getChildren();
                for(Element elementoAmbulatorio : listaAmbulatorios){
                    if(elementoAmbulatorio.getChildText("RIF").equals(entidad.getRIF())){
                        if(mod==1) modificarDatosEntidad(elementoAmbulatorio,entidad,1);
                        if(mod==0) modificarDatosEntidad(elementoAmbulatorio,entidad,0);
                        return updateDocument();
                    }
                }
            }
        }
        return false;
    }
    
    
    //--------------ELIMINAR TALLER----------------------------
    public boolean hayTalleres(Element talleresAsociados){
        if(talleresAsociados.getChild("Taller")!=null)
            return true;
        return false;
    }
    
    //SE LLAMA DESDE EL ACTIONPERFORMED DEL BOTON DESASOCIAR EN EL MENU PRINICIPAL
    public boolean Taller_EliminarXMLElement(String RIF_Clinica,String RIF_Taller){
        List<Element> clinicas=root.getChildren();
        for(Element elementoClinica : clinicas){
            if(elementoClinica.getChildText("RIF").equals(RIF_Clinica)){
                List<Element> talleresAsociados = elementoClinica.getChild("talleresAsociados").getChildren();
                for(Element elementoTaller : talleresAsociados){
                    if(elementoTaller.getChildText("RIF").equals(RIF_Taller)){
                        elementoClinica.getChild("talleresAsociados").removeContent(elementoTaller);
//                        elementoTaller.detach();
                        if(!hayTalleres(elementoClinica.getChild("talleresAsociados"))) elementoClinica.removeChild("talleresAsociados");
                        return updateDocument();                        
                    }
                }                    
            }
        }            
        return false;
    }

    public boolean hayAmbulatorios(Element ambulatorios){
        if(ambulatorios.getChild("Ambulatorio")!=null)
            return true;
        return false;
    }

    //SE LLAMA DESDE EL ACTIONPERFORMED DEL BOTON ELIMINAR EN EL MENU PRINICIPAL
    public boolean Ambulatorio_EliminarXMLElement(String RIF_Clinica,String RIF_Ambulatorio){
        int cont = -1;
        List<Element> clinicas=root.getChildren();
        for(Element elementoClinica : clinicas){
            if(elementoClinica.getChildText("RIF").equals(RIF_Clinica)){
                List<Element> ambulatorios = elementoClinica.getChild("ambulatorios").getChildren();
                for(Element elementoAmbulatorio : ambulatorios){
                    cont++;
                    if(elementoAmbulatorio.getChildText("RIF").equals(RIF_Ambulatorio)){
                        elementoClinica.getChild("ambulatorios").getChildren().remove(cont);
                        if(!hayAmbulatorios(elementoClinica.getChild("ambulatorios"))) elementoClinica.removeChild("ambulatorios");
                        return updateDocument();                        
                    }
                }                    
            }
        }            
        return false;        
    }
    
    public boolean hayVehiculos(Element vehiculos){
        if(vehiculos.getChild("vehiculo")!=null)
            return true;
        return false;
    }
    
    //SE LLAMA DESDE EL ACTIONPERFORMED DEL BOTON ELIMINAR EN EL MENU PRINICIPAL    
    public boolean Vehiculo_EliminarXMLElement(String RIF_Clinica,String RIF_Ambulatorio,String serial){
        List<Element> clinicas=root.getChildren();
        for(Element elementoClinica : clinicas){
            if(elementoClinica.getChildText("RIF").equals(RIF_Clinica)){
                List<Element> ambulatorios = elementoClinica.getChild("ambulatorios").getChildren();
                for(Element elementoAmbulatorio : ambulatorios){
                    if(elementoAmbulatorio.getChildText("RIF").equals(RIF_Ambulatorio)){
                        List<Element> vehiculos = elementoAmbulatorio.getChild("vehiculos").getChildren();
                        for(Element elementoVehiculo : vehiculos){
                            if(elementoVehiculo.getChildText("serial").equals(serial)){
                                elementoAmbulatorio.getChild("vehiculos").removeContent(elementoVehiculo);
//                                elementoVehiculo.detach();
                                if(!hayVehiculos(elementoAmbulatorio.getChild("vehiculos"))) elementoAmbulatorio.removeChild("vehiculos");
                                return updateDocument();
                            }
                        }
                    }
                }                    
            }
        }            
        return false;        
    }
    
    
    private boolean hayPersonal(Element Personal){
        if(Personal.getChild("personal")!=null)
            return true;
        return false;
    }
    
    //SE LLAMA DESDE EL ACTIONPERFORMED DEL BOTON ELIMINAR EN EL MENU PRINICIPAL    
    public boolean Personal_EliminarXMLElement(String RIF_Clinica,String RIF_Ambulatorio,String cedula){
        List<Element> clinicas=root.getChildren();
        for(Element elementoClinica : clinicas){
            if(elementoClinica.getChildText("RIF").equals(RIF_Clinica)){
                List<Element> ambulatorios = elementoClinica.getChild("ambulatorios").getChildren();
                for(Element elementoAmbulatorio : ambulatorios){
                    if(elementoAmbulatorio.getChildText("RIF").equals(RIF_Ambulatorio)){
                        List<Element> Personal = elementoAmbulatorio.getChild("Personal").getChildren();
                        for(Element elementoPersonal : Personal){
                            if(elementoPersonal.getChildText("cedula").equals(cedula)){
                                elementoAmbulatorio.getChild("Personal").removeContent(elementoPersonal);
//                                elementoPersonal.detach();
                                if(!hayPersonal(elementoAmbulatorio.getChild("Personal"))) elementoAmbulatorio.removeChild("Personal");
                                return updateDocument();
                            }
                        }
                    }
                }                    
            }
        }            
        return false;        
    }
    
    
    
    
    //---------------CARGAR LISTA DE CLINICAS------------------- 
    private Clinica ClinicaToObject(Element element) {
        Clinica clinica = new Clinica(element.getChildText("nombre"),element.getChildText("telefono"),element.getChildText("RIF"),element.getChildText("estado"),element.getChildText("ciudad"),element.getChildText("direccion"));
        return clinica; 
    }
    
    public ArrayList<String> todosLosMecanicos(Element elementoMecanicos){
        ArrayList<String> mecanicos = new ArrayList<String>();
      
        for (Object it : elementoMecanicos.getChildren("mecanico")) {
            Element elementoMecanico = (Element) it;
            mecanicos.add(elementoMecanico.getText());
        }
        return mecanicos;
    }
    
    private Taller TallerToObject(Element elementoTaller) {
        ArrayList<String> mecanicos = todosLosMecanicos(elementoTaller.getChild("mecanicos"));
        Taller taller = new Taller(mecanicos,elementoTaller.getChildText("nombre"),elementoTaller.getChildText("telefono"),elementoTaller.getChildText("RIF"),elementoTaller.getChildText("estado"),elementoTaller.getChildText("ciudad"),elementoTaller.getChildText("direccion"));
        return taller; 
    }
    
    public ArrayList<Taller> todosLosTalleres(Element elementoClinica){
        ArrayList<Taller> talleres = new ArrayList<Taller>();
      
        for (Object it : elementoClinica.getChild("talleresAsociados").getChildren()) {
            Element elementoTaller = (Element) it;
            Taller taller = TallerToObject(elementoTaller);
            talleres.add(taller);
        }
        return talleres;
    }
    
    
    //ELEMENTO AMBULANCIA A OBJETO
    
    private Personal PersonaltoObject(Element elementoPersonal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
        long numCarnet = 0;
        double salario = 0;
        long licencia = 0;
        LocalDate nacimiento = null;
        LocalDate fechaContrato = null;
        
        numCarnet = Long.parseLong(elementoPersonal.getChildText("numCarnet"));
        salario = Double.parseDouble(elementoPersonal.getChildText("salario"));
        
        try{
            nacimiento = LocalDate.parse(elementoPersonal.getChild("nacimiento").getText(), formatter);
            fechaContrato = LocalDate.parse(elementoPersonal.getChild("fechaContrato").getText(), formatter);
        }
        catch(DateTimeParseException ex){
            System.out.println(nacimiento);
            System.out.println(fechaContrato);
        }
        
        
        if(elementoPersonal.getChildText("tipo").equals("Paramédico")){
            Paramedico paramedico = new Paramedico(numCarnet,Boolean.parseBoolean(elementoPersonal.getChildText("activo")),salario,fechaContrato,elementoPersonal.getChildText("tipo"),elementoPersonal.getChildText("cedula"),elementoPersonal.getChildText("nombre"),elementoPersonal.getChildText("correo"),elementoPersonal.getChildText("telefono"),nacimiento,elementoPersonal.getChildText("genero").charAt(0),Boolean.parseBoolean(elementoPersonal.getChildText("asignadoDRS")));
            return paramedico;
        }
        else if(elementoPersonal.getChildText("tipo").equals("Conductor")){
            licencia = Long.parseLong(elementoPersonal.getChildText("licencia"));
            Conductor conductor = new Conductor(licencia,numCarnet,Boolean.parseBoolean(elementoPersonal.getChildText("activo")),salario,fechaContrato,elementoPersonal.getChildText("tipo"),elementoPersonal.getChildText("cedula"),elementoPersonal.getChildText("nombre"),elementoPersonal.getChildText("correo"),elementoPersonal.getChildText("telefono"),nacimiento,elementoPersonal.getChildText("genero").charAt(0));
            return conductor;
         }
        
        Personal personal = new Personal(numCarnet,Boolean.parseBoolean(elementoPersonal.getChildText("activo")),salario,fechaContrato,elementoPersonal.getChildText("tipo"),elementoPersonal.getChildText("cedula"),elementoPersonal.getChildText("nombre"),elementoPersonal.getChildText("correo"),elementoPersonal.getChildText("telefono"),nacimiento,elementoPersonal.getChildText("genero").charAt(0));
        return personal;    
    }
    
    private ArrayList<Personal> todoElPersonal(Element elementoAmbulatorio){
        ArrayList<Personal> personal=new ArrayList<Personal>();
        Personal per;
        for(Object it : elementoAmbulatorio.getChild("Personal").getChildren()){
            Element elementoPersonal = (Element) it;
            per = PersonaltoObject(elementoPersonal); 
            personal.add(per);
        } 
        return personal;
    }
    
    private Ambulancia AmbulanciaToObject(Element elementoAmbulancia) {
        //String serial, boolean enMantenimiento, boolean disponible, String tipo
        Ambulancia ambulancia = new Ambulancia(elementoAmbulancia.getChildText("serial"),Boolean.parseBoolean(elementoAmbulancia.getChildText("enMantenimiento")),Boolean.parseBoolean(elementoAmbulancia.getChildText("disponible")),elementoAmbulancia.getChildText("tipo"));
        return ambulancia; 
    }
    
    private Compacto CompactoToObject(Element elementoCompacto) {
        //String serial, boolean enMantenimiento, boolean disponible, String tipo
        Compacto compacto = new Compacto(elementoCompacto.getChildText("serial"),Boolean.parseBoolean(elementoCompacto.getChildText("enMantenimiento")),Boolean.parseBoolean(elementoCompacto.getChildText("disponible")));
        return compacto; 
    }
    
    private ArrayList<Vehiculo> todosLosVehiculos(Element elementoAmbulatorio){
        ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        Vehiculo vehiculo=null;
        
        if(elementoAmbulatorio.getChild("vehiculos")!=null){
        for (Object it : elementoAmbulatorio.getChild("vehiculos").getChildren()) {
            Element elementoVehiculo = (Element) it;
            //Elemento a objeto
            if(elementoVehiculo.getName().equals("ambulancia"))
                vehiculo = AmbulanciaToObject(elementoVehiculo);
            else if(elementoVehiculo.getName().equals("compacto"))
                vehiculo = CompactoToObject(elementoVehiculo);
            //Agregar vehiculo a lista de vehiculos
            vehiculos.add(vehiculo);
        }
        }
        return vehiculos;
    }
    
    private Ambulatorio AmbulatorioToObject(Element elementoAmbulatorio) {
        Ambulatorio ambulatorio = new Ambulatorio(elementoAmbulatorio.getChildText("nombre"),elementoAmbulatorio.getChildText("telefono"),elementoAmbulatorio.getChildText("RIF"),elementoAmbulatorio.getChildText("estado"),elementoAmbulatorio.getChildText("ciudad"),elementoAmbulatorio.getChildText("direccion"));
        return ambulatorio; 
    }
    
    public ArrayList<Ambulatorio> todosLosAmbulatorios(Element elementoAmbulatorios){
        ArrayList<Ambulatorio> ambulatorios = new ArrayList<Ambulatorio>();
      
        for (Object it : elementoAmbulatorios.getChild("ambulatorios").getChildren()) {
            Element elementoAmbulatorio = (Element) it;
            Ambulatorio ambulatorio = AmbulatorioToObject(elementoAmbulatorio);
            ambulatorio.setVehiculos(todosLosVehiculos(elementoAmbulatorio));
            if(elementoAmbulatorio.getChild("Personal")!=null) ambulatorio.setPersonal(todoElPersonal(elementoAmbulatorio));
            ambulatorios.add(ambulatorio);
        }
        return ambulatorios;
    }
    
    public ArrayList<Clinica> todosLasClinicas(){
        ArrayList<Clinica> resultado = new ArrayList<Clinica>();
      
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            Clinica cli = ClinicaToObject(xmlElem);
            if(tieneTalleres(xmlElem)) cli.setTalleresAsociados(todosLosTalleres(xmlElem));
            else cli.setTalleresAsociados(new ArrayList<Taller>());
            if(tieneAmbulatorios(xmlElem)) cli.setAmbulatorios(todosLosAmbulatorios(xmlElem));
            else cli.setAmbulatorios(new ArrayList<Ambulatorio>());
            resultado.add(cli);
        }
        return resultado;
    }
    
    
    
    //-------------------ACTUALIZAR ARCHIVO-------------------
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
