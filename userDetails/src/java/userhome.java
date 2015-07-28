
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class userhome extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.write(request.getSession().getAttribute("userid").toString());
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
            
        
    }
}
