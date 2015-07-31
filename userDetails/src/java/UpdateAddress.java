
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DbUtils;
import utils.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author cb-admin1
 */
public class UpdateAddress extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
   
        if(request.getSession().getAttribute("userid")==null){
            response.sendRedirect("login");
        }
        
        if(request.getParameter("fname")!=null){
            try {
                Connection con=DbUtils.getConnection();
                String sql="";
                PreparedStatement stmt=null;
                if(request.getParameter("address").equals("true")){
                   sql="update address set fname=?,lname=?,line1=?,line2=?,city=?,state=?,country=?,zip=? where userid=?"; 
                   stmt=con.prepareStatement(sql);
                   stmt.setString(1, request.getParameter("fname"));
                   stmt.setString(2, request.getParameter("lname"));
                   stmt.setString(3, request.getParameter("addresslineone"));
                   stmt.setString(4, request.getParameter("addresslinetwo"));
                   stmt.setString(5, request.getParameter("city"));
                   stmt.setString(6, request.getParameter("state"));
                   stmt.setString(7, request.getParameter("country"));
                   stmt.setString(8, request.getParameter("zipcode"));
                   stmt.setString(9, request.getSession().getAttribute("userid").toString());
                   stmt.execute();
                }else{
                   sql="insert into address (userid,line1,line2,city,state,country,zip,fname,lname) values(?,?,?,?,?,?,?,?,?)";
                   stmt=con.prepareStatement(sql);
                   stmt.setString(1, request.getSession().getAttribute("userid").toString());
                   stmt.setString(2, request.getParameter("addresslineone"));
                   stmt.setString(3, request.getParameter("addresslinetwo"));
                   stmt.setString(4, request.getParameter("city"));
                   stmt.setString(5, request.getParameter("state"));
                   stmt.setString(6, request.getParameter("country"));
                   stmt.setString(7, request.getParameter("zipcode"));
                   stmt.setString(8, request.getParameter("fname"));
                   stmt.setString(9, request.getParameter("lname"));
                   stmt.execute();
                   sql=stmt.toString();
                    System.out.println(sql);
                }
                
                
                con.close();
                request.setAttribute("curuser", User.getUser( request.getSession().getAttribute("userid").toString()));
               // getServletConfig().getServletContext().getRequestDispatcher("userabout").forward(request, response);
                response.sendRedirect("userabout");
                
            } catch (SQLException ex) {
                Logger.getLogger(UpdateAddress.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UpdateAddress.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        
    }
    
}
