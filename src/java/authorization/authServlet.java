/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package authorization;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cw1491
 */
@WebServlet(name = "authServlet", urlPatterns = {"/authServlet"})
public class authServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String targetServlet = (String)request.getAttribute("targetPage");    
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AuthorizationServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            if (request.getAttribute("badUserName")!=null){
                out.println("<span style=\"color:red\"><b>Incorrect User Name</b></span><br/>");
            }
            if (request.getAttribute("badPassword")!=null){
                out.println("<span style=\"color:red\"><b>Incorrect Password</b></span><br/>");
            }
            out.println("<form action=\""+targetServlet+"\" method=\"GET\">");
            out.println("User Name<input type=\"textbox\" name=\"loginId\"/><br/>");
            out.println("Password<input type=\"password\" name=\"password\"/><br/>");
            out.println("<input type=\"submit\" value=\"Login\"/></form>");
            out.println("</body>");
            out.println("</html>");
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
