
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-admin1
 */
public class UserLogout extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
      HttpSession session = request.getSession(false);
      if (session != null) {
          session.removeAttribute("userid");
          session.removeAttribute("username");
          session.invalidate();
        }  
      request.getRequestDispatcher("login").forward(request, response);
      //response.sendRedirect("login");
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        doPost(request, response);
    }
    
}
