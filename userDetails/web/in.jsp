<%-- 
    Document   : in.jsp
    Created on : 30 Jul, 2015, 5:33:27 PM
    Author     : cb-admin1
--%>

<%@page import="utils.Utils"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            for(Utils.MobileTypes s:Utils.MobileTypes.values()){
                %>
                <%=s%>
        <%
            }
        %>
    </body>
</html>
