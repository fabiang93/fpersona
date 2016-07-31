/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo
 */
public class Usuario {
    
    private String user;
    private String pass;
    private List<verError> errores;

    public Usuario(String user, String pass) {
        this.user = user;
        this.pass = pass;
        errores = new ArrayList<verError>();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<verError> getErrores() {
        return errores;
    }

    public void setErrores(List<verError> errores) {
        this.errores = errores;
    }    
    
    public void agregarError(verError error){
        
        errores.add(error);        
    }
    
    public Boolean existeError(){
        return !errores.isEmpty();
    }
    
}
