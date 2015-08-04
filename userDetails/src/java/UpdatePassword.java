
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DbUtils;
import userclasses.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-admin1
 */
public class UpdatePassword extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        if(request.getSession().getAttribute("userid")==null){
            response.sendRedirect("login");
        }
        
        try {
            Connection con=DbUtils.getConnection();
            PreparedStatement stmt=con.prepareStatement("update user set password=? where id=? and password=?");
            stmt.setString(1, request.getParameter("newpassword"));
            stmt.setString(2, request.getSession().getAttribute("userid").toString());
            stmt.setString(3,request.getParameter("oldpassword"));
            int res=stmt.executeUpdate();
            request.setAttribute("curuser", User.getUser(request.getSession().getAttribute("userid").toString()));
            
            if(res>0){
                request.setAttribute("changepassword", "true");    
            }else{
                request.setAttribute("changepassword", "false");
            }
                response.sendRedirect("userabout");
        } catch (Exception ex) {
            request.setAttribute("servererror", "Sorry something went worng");
            request.getRequestDispatcher("userabout").forward(request, response);
            Logger.getLogger(UpdatePassword.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
}
