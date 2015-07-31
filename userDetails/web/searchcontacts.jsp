<%@page import="utils.SearchCont"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="utils.Utils"%>
<table>
    <tr>
        <th>Name</th><th>Email</th>
        <%for (Utils.MobileTypes type : Utils.MobileTypes.values()) {%><th><%=type.name().toLowerCase()%></th><%}%>
    </tr>
    <%

        ResultSet set = SearchCont.getSearchContacts(request.getParameter("searchword"), Integer.parseInt(request.getSession().getAttribute("userid").toString()));
    %>
    <%
        while (set.next()) {
    %>
    <tr>
        <td><%=set.getString("name")%></td>
        <td><%=set.getString("email")%></td>
        <%
            String num = set.getString("num");
            String types = set.getString("types");
            if (num != null) {
                String[] numbers = num.split(", ");
                String[] tp = types.split(", ");

                for (Utils.MobileTypes types1 : Utils.MobileTypes.values()) {
                    boolean b=false;
                    for (int i = 0; i < numbers.length; i++) {
                        if (Integer.parseInt(tp[i]) == types1.value()) {
        %>
        <td><%=numbers[i]%></td>
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
