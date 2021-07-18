
package Modelo;

public class Entidad {
    protected String nombre;
    protected String telefono;
    protected String RIF;
    protected String estado;
    protected String ciudad;
    protected String direccion;
    
    public Entidad(){}

    public Entidad(String nombre, String telefono, String RIF, String estado, String ciudad, String direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.RIF = RIF;
        this.estado = estado;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRIF() {
        return RIF;
    }

    public void setRIF(String RIF) {
        this.RIF = RIF;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
