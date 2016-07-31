
package modelo;

import controlador.InitListener;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Equipo
 */
public class DAO {
    
    private List<Persona> personas;
    
    public DAO() throws IOException, FileNotFoundException, ClassNotFoundException{
        File archivoPersonas 
                = new File(InitListener.RUTA_ARCHIVO_PERSONAS); 
        
        if(archivoPersonas.exists()){// si existe el archivo
            //Lo cargo a la lista//
            personas = (List)IO.leerObjetoDesde(InitListener.RUTA_ARCHIVO_PERSONAS);
        }else{
            //Si no, lo creo vacío//
            personas = new ArrayList<Persona>();
        }
    }
    
    public void create(Persona p) throws IOException{
        personas.add(p);
        IO.escribirObjetoEn(personas, InitListener.RUTA_ARCHIVO_PERSONAS);
    }
    
    public List<Persona> getAll(){
        return personas;
    } 
    
    public Usuario existe (Usuario u){       
        
        
        
        //Comprueba los distintos casos
        //Usuario incorrecto
        //Contraseña incorrecta
        //Usuario y contraseña incorrectos
        if(!u.getUser().equalsIgnoreCase("correoprueba@prueba.com")
                && !u.getPass().equalsIgnoreCase("prueba1")){
            u.agregarError(new verError("3","Usuario y contraseña incorrectos"));
            return u;   
        }else if(u.getUser().equalsIgnoreCase("correoprueba@prueba.com")){
            if (u.getPass().equalsIgnoreCase("prueba1")) {
            return new Usuario(u.getUser(), u.getPass());                
            }else{
                Usuario nuevo = new Usuario(u.getUser(), u.getPass());  
                nuevo.agregarError(new verError("1", "Contraseña Incorrecta")) ;
                return nuevo;
            }         
        }else {
            Usuario nuevo = new Usuario(u.getUser(), u.getPass());  
            nuevo.agregarError(new verError("2", "Usuario Incorrecto")) ;
            return nuevo;
        }
        
    }
    
}
