
import java.io.IOException;
import java.io.PrintWriter;
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
public class Test extends HttpServlet{
    static int i=0;
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
       i++;
       response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.print(i);
    }
   
}
