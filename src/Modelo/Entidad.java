
package Modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public boolean validarRif(String sRif) {
    boolean bResultado = false;
    int iFactor = 0;

    sRif = sRif.replace("-", "");
    if (sRif.length() < 10) {
    sRif = sRif.toUpperCase().substring(0, 1) + padLeft(sRif.substring(1, sRif.length() - 1), "0", 9);
    }

        String sPrimerCaracter = sRif.substring(0, 1).toUpperCase();

        switch (sPrimerCaracter) {
        case "V": iFactor = 1; break;
        case "E": iFactor = 2; break;
        case "J": iFactor = 3; break;
        case "P": iFactor = 4; break;
        case "G": iFactor = 5; break;
        }
        if (iFactor > 0) {
        int suma;
        suma = ((Integer.parseInt(sRif.substring(8, 9))) * 2)
        + ((Integer.parseInt(sRif.substring(7, 8))) * 3)
        + ((Integer.parseInt(sRif.substring(6, 7))) * 4)
        + ((Integer.parseInt(sRif.substring(5, 6))) * 5)
        + ((Integer.parseInt(sRif.substring(4, 5))) * 6)
        + ((Integer.parseInt(sRif.substring(3, 4))) * 7)
        + ((Integer.parseInt(sRif.substring(2, 3))) * 2)
        + ((Integer.parseInt(sRif.substring(1, 2))) * 3)
        + (iFactor * 4);

        int resto = 11 - (suma % 11);
        if (resto >= 10 || resto < 1){
        resto = 0;
        }
        if (sRif.substring(9, 10).equals(Integer.toString(resto))) {
        bResultado = true;
        }
    }
return bResultado;
}

public static String padLeft(String valor,String relleno,int longitud) {
String resultado=valor;
int x = longitud-valor.length(), i=0;
while (i<x){
resultado=relleno+resultado;
i++;
}
return resultado;
}
    

}
