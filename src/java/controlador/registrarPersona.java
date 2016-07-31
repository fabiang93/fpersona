
package controlador;

import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.DAO;
import modelo.Persona;

/**
 *
 * @author Equipo
 */
@WebServlet(name = "registrarPersona", urlPatterns = {"/registrarPersona.xml"})
public class registrarPersona extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");            
            
            int ide;
            String nom, ape, eci, ocu;
            
            ide = Integer.parseInt(request.getParameter("txtId"));
            nom = request.getParameter("txtNombre");
            ape = request.getParameter("txtApellido");
            eci = request.getParameter("txtECvil");
            ocu = request.getParameter("txtOcupacion");
            
            Persona nueva = new Persona(ide, nom, ape, eci, ocu);
            
            DAO dao = new DAO();            
            dao.create(nueva);            
            request.getRequestDispatcher("formPersona.jsp").forward(request, response);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(registrarPersona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registrarPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

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
