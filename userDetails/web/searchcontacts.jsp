<%@page import="java.util.List"%>
<%@page import="userclasses.Contact"%>
<%@page import="userclasses.Number"%>
<%@page import="utils.SearchCont"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Utils"%>
<table>
    <tr>
        <th>Name</th><th>Email</th>
        <%for (Utils.MobileTypes type : Utils.MobileTypes.values()) {%><th><%=type.name().toLowerCase()%></th><%}%>
    </tr>
    <%

        List<Contact> contacts = SearchCont.getSearchContacts(request.getParameter("searchword"), Integer.parseInt(request.getSession().getAttribute("userid").toString()));
    %>
    <%
        for(Contact con:contacts) {
    %>
    <tr>
        <td><%=con.getName() %></td>
        <td><%=con.getEmail() %></td>
        <%
            if (!con.getNumberList().isEmpty()) {
                
                for (Utils.MobileTypes types1 : Utils.MobileTypes.values()) {
                    boolean b=false;
                    for (Number n:con.getNumberList()) {
                        if (n.getType()== types1.value()) {
        %>
        <td><%=n.getNumber() %></td>
        <% b=true;break;
                            }
                    }
                    if(!b){
                        %><td></td><%
                    }
                }
            }else{
                for (Utils.MobileTypes types1 : Utils.MobileTypes.values()) {
                     %><td></td><%
                }
        }%>
    </tr>
    <% }
    %>
</table>
