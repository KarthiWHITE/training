<%-- 
    Document   : hompage.jsp
    Created on : 27 Jul, 2015, 6:29:58 PM
    Author     : cb-admin1
--%>

<%@page import="utils.Utils"%>
<%--<%@page import="utils.Utils.MobileTypes"%>--%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.*" %>
<%@page import="utils.DbUtils"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="userclasses.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <link rel="stylesheet" type="text/css"  href="style/design.css"/>
        <script type="text/javascript" src="js/jquery17.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <style type="text/css">
            .contact-heading .btn{
                float: right;
                margin-top: -2px;
                height: 17px;
                font-size: 16px;
                padding: 2px 10px 2px 10px;
            }
        </style>
    </head>
    <body>
        <% User user = (User) request.getAttribute("curuser");
        %>

        <% if (request.getSession().getAttribute("userid") == null) {
                response.sendRedirect("login");
                return;
            } else {
                if (user == null) {
                    user = User.getUser(request.getSession().getAttribute("userid").toString());
                }
        %>
        <div class="pageheading">Welcome <%=request.getSession(true).getAttribute("username").toString()%><a class="logout" href="logout">Logout</a></div>
        <%}%>
        <div class="cont-wrapper">
            <div class="cont-menu">
                <ul>
                    <li>User Details</li>
                    <li>Change Address</li>
                    <li>Change Password</li>
                    <li>Contacts</li>
                    <li>Add Contact</li>
                </ul>
            </div>
            <div class="cont">
                <%@ include file="jspfs/userdetails.jspf" %>
                <%@include file="jspfs/updateaddress.jspf" %>
                <%@include  file="jspfs/changepassword.jspf" %>
                <%@include file="jspfs/searchcontacts.jspf" %>
                <%@include file="jspfs/addcontact.jspf" %>
            </div>
        </div>
        <% if (request.getAttribute("servererror") != null) { %>
        <script>
            $('body').append('<div class="error-status"><div class = "status" > Sorry Something went wrong </div></div>');
            setTimeout(function() {
                $(".error-status").hide(500)
            }, 5000);
        </script>
        <% }%>
    </body>
</html>
