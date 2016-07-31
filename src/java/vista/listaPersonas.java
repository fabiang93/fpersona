
package vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DAO;
import modelo.Persona;

/**
 *
 * @author Equipo
 */
@WebServlet(name = "listaPersonas", urlPatterns = {"/listaPersonas.view"})
public class listaPersonas extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
    response.setContentType("text/html;charset=UTF-8");
    
    DAO dao = new DAO();
    List<Persona> personas = dao.getAll();    
    
    PrintWriter out = response.getWriter();
    try {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Lista Personas</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>LISTA DE PERSONAS EXISTENTES</h1>");
        
        out.println("<table border='1'>");
            out.println("<tr>");      
                out.println("<td>Identificación</td>");      
                out.println("<td>Nombre Completo</td>");      
                out.println("<td>Estado Civil</td>");      
                out.println("<td>Ocupación</td>");      
            out.println("</tr>");
            for(Persona p : personas){
                out.println("<tr>");      
                    out.println("<td>"+p.getIdentificacion()+"</td>");      
                    out.println("<td>"+p.getNombre()+" "+p.getApellido()+"</td>");     
                    out.println("<td>"+p.getEcivil()+"</td>");      
                    out.println("<td>"+p.getOcupacion()+"</td>");      
                out.println("</tr>");                    
            }
        out.println("</table></br>");
        out.println("<a href='Menu.view'>Volver</a>");       
        out.println("</body>");
        out.println("</html>");
    } finally {            
        out.close();
    }
}       catch (FileNotFoundException ex) {
            Logger.getLogger(listaPersonas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(listaPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
