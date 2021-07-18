
package Modelo;

public class Entidad {
    protected String nombre;
    protected String telefono;
    protected String RIF;
    protected String ciudad;
    protected String estado;
    protected String direccion;
    

    public Entidad(){}

    public Entidad(String nombre, String RIF, String ciudad, String estado, String direccion) {
        this.nombre = nombre;
        this.RIF = RIF;
        this.ciudad = ciudad;
        this.estado = estado;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }    
}
