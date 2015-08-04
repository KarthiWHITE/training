<%-- 
    Document   : login
    Created on : 27 Jul, 2015, 4:06:56 PM
    Author     : cb-admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
        <link rel="stylesheet" type="text/css" href="style/design.css"/>
    </head>
    <body>
        <%if (request.getSession(true).getAttribute("username") != null) {
                response.sendRedirect("userabout");
            }
            if (request.getAttribute("usersignup") != null && request.getAttribute("usersignup").equals("success")) {
        %>
        <div class="heading">User sign up successful</div>
        <% } %>
        <div style="width: 240px;margin: 0 auto;">
            <div class="heading">User Login</div>
            <form method="post" action="usrlogin">
                <div class="input-grp">
                    <label>User Name(email)</label><input type="text" name="email" value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>"/>
                </div>
                <div class="input-grp">
                    <label>Password</label><input type="password" name="password"/>
                </div>
                <div class="input-grp"><input type="reset" value="Reset"/> <input type="submit" value="Login"/></div>
            </form>
            <%if (request.getAttribute("login") != null && request.getAttribute("login").equals("fail")) {%>
            <div class="error">Email or Password incorrect</div><%
                }%>
        </div>
        <div style="position: absolute;right: 20px; top: 20px;"><a href="usrsignup">User sign up</a></div>
    </body>
</html>