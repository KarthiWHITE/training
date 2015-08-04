
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-admin1
 */
public class Details extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        if(request.getSession(false).getAttribute("username")==null){
            request.getRequestDispatcher("login").forward(request, response);
            return;
        }
        request.getRequestDispatcher("useraboutcont").forward(request, response);
        //response.sendRedirect("useraboutcont");
    }
}
