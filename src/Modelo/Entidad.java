
package Modelo;


public class Entidad {
    protected String RIF;
    protected String ciudad;
    protected String direccion;

    public Entidad(){}
    
    public Entidad(String RIF, String ciudad, String direccion) {
        this.RIF = RIF;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }
    
    public String getRIF() {
        return RIF;
    }

    public void setRIF(String RIF) {
        this.RIF = RIF;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }   
    
}
