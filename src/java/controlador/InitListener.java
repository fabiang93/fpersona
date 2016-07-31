/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author Equipo
 */
@WebListener()
public class InitListener implements ServletContextListener {

    public static String RUTA_ARCHIVO_PERSONAS;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext sc =sce.getServletContext();
        //String rutaRelativa = "/WEB-INF/data/persona.dat";
        String rutaRelativa = "/WEB-INF/persona.dat";
        RUTA_ARCHIVO_PERSONAS = sc.getRealPath(rutaRelativa);
        System.out.println(RUTA_ARCHIVO_PERSONAS);       
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
