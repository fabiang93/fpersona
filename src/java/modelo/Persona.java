
package modelo;

import java.io.Serializable;

/**
 *
 * @author Equipo
 */
public class Persona implements Serializable{
    
    private int identificacion;
    private String nombre;
    private String apellido;
    private String ecivil;
    private String ocupacion;

    public Persona(int identificacion, String nombre, String apellido, String ecivil, String ocupacion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ecivil = ecivil;
        this.ocupacion = ocupacion;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEcivil() {
        return ecivil;
    }

    public void setEcivil(String ecivil) {
        this.ecivil = ecivil;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
}
