
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DbUtils;
import utils.Utils;

public class AddContact extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("contactname") != null) {
            String userid = Utils.getUserID(request);
            try {

                PreparedStatement stmt = DbUtils.getPreparedStatement("insert into contacts (userid,name,email)values(?,?,?)", Statement.RETURN_GENERATED_KEYS);

                stmt.setString(1, userid);
                stmt.setString(2, request.getParameter("contactname"));
                stmt.setString(3, request.getParameter("contactemail"));
                Long contactid = DbUtils.insertAndGetId(stmt);

                for (Utils.MobileTypes type:Utils.MobileTypes.values()) {
                    String mnumber = request.getParameter(type.name());
                    if (!mnumber.isEmpty()) {
                        String sql = "insert into numbers(contactid,number,type)values(?,?,?)";
                        stmt = DbUtils.getPreparedStatement(sql);
                        stmt.setString(1, contactid.toString());
                        stmt.setString(2, mnumber);
                        stmt.setString(3, type.value()+"");
                        stmt.execute();
                    }
                }
                response.sendRedirect("/userabout");
            } catch (Exception ex) {
                Logger.getLogger(AddContact.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
    }

}
