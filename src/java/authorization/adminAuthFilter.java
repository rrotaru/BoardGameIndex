/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package authorization;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * This filter protects all pages with the extension ".jsp"
 * If a jsp is requested this page first checks to see if the user is
 * authenticated and if not redirects them to the authentication page
 * 
 */
@WebFilter(filterName = "adminAuthFilter", urlPatterns = {"/faces/boardgameAdd.xhtml"})
public class adminAuthFilter implements Filter{

    @Resource(name="jdbc/FinalProjectDB")
    private DataSource dataSource;
        
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String user = "";
        int passHash = 0;
        PrintWriter out = response.getWriter();
        try { 
            Connection connection = dataSource.getConnection();
            String selectSQL = "select ADMINUSER from ADMIN";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            user = resultSet.getString("ADMINUSER");
            
            selectSQL = "select PASSHASH from ADMIN";
            selectStatement = connection.prepareStatement(selectSQL);
            resultSet = selectStatement.executeQuery();
            resultSet.next();
            passHash = resultSet.getInt(1);
            
            resultSet.close();
            selectStatement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        HttpServletRequest servRequest =(HttpServletRequest)request;
        HttpSession session = servRequest.getSession();

        boolean authorized = session.getAttribute("authorized")!=null;
        // check to see if they provided login credentials
        
        if (!authorized && (request.getParameter("loginId")!=null)&& (request.getParameter("password")!=null)){
            // Check creditials
            String userPass = (String)request.getParameter("password");
            int userPassHash = userPass.hashCode();
            if (request.getParameter("loginId").equals(user)&& userPassHash == passHash){
                session.setAttribute("authorized", new Boolean(true));
                authorized=true;
            }else if (!request.getParameter("loginId").equals(user)&& userPassHash == passHash){
                request.setAttribute("badUserName", "");
            }else if (request.getParameter("loginId").equals(user)&& userPassHash != passHash){
                request.setAttribute("badPassword", "");
            }
            else{
                request.setAttribute("badUserName", "");
                request.setAttribute("badPassword", "");
            }
        }
        // if authorized
        if (authorized){
            chain.doFilter(request, response);
        }else{
            request.setAttribute("targetPage", servRequest.getRequestURI());
            request.getRequestDispatcher("authServlet").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        // do nothing
    }
    
}
