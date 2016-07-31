/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vista.Error;
import modelo.DAO;
import modelo.Usuario;
import modelo.verError;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Equipo
 */
@WebServlet(name = "Iniciar", urlPatterns = {"/Iniciar.xml"})
public class Iniciar extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            //Obtener la sesión        
            HttpSession session = request.getSession();
            DAO dao = new DAO();
            String user, pass;
            user = request.getParameter("txtUser");
            pass = request.getParameter("txtPass");        
            Usuario u = new Usuario(user, pass);
            Usuario u2 = dao.existe(u);
            
            //Ir a la pantalla de errores si existen, si no ir a la pantalla menú
            if(u2.existeError()){
                List<verError> errores = u2.getErrores();
                session.setAttribute("errores", errores);  
                
                request.getRequestDispatcher("Error.view").forward(request, response);
            }else{
                session.setAttribute("usuario", u2);
                request.getRequestDispatcher("Menu.view").forward(request, response);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
