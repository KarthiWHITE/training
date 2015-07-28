
import utils.DbUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CheckEmail extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
      processRequest(request, response);
        
    }
    
    @Override
    protected  void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
          
       processRequest(request, response);
        
    }
    
    
    private void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException{
    
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        try {
            Connection con=DbUtils.getConnection();
            
            PreparedStatement stmt=con.prepareStatement("select name from user where email = ?");
            stmt.setString(1, request.getParameter("email"));
            ResultSet set=stmt.executeQuery();
            if(set.next()){
               out.write("1");
            }else{
                out.write("0");
            }
        } catch (SQLException ex) {
           out.write(ex.toString());
        } catch (ClassNotFoundException ex) {
            out.write(ex.toString());
        }
    }
}
