<%-- 
    Document   : signup.php
    Created on : 29 Jun, 2015, 3:56:11 PM
    Author     : cb-admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" type="text/css" href="style/design.css"/>

        <script type="text/javascript" src="js/jquery17.js"></script>
        <script type="text/javascript" src="js/signupScript.js"></script>
    </head>
    <body>
        <div class="singnupForm">
            <span>Sign up with us</span>
            <% if (request.getSession().getAttribute("userid") != null) {
                    response.sendRedirect("userabout");
                }%>
            <form method="post" action="signup" >
                <div class="input-grp">
                    <label>User Name</label>                <br/>
                    <input type="text" name="username" class="cb-input username" placeholder="User name" /> <br/>
                </div>
                <div class="input-grp">
                    <label>Email</label><br/>
                    <input id="user-email" type="email" name="email" class="cb-input email"/>
                    <div class="email-status"></div>
                </div>
                <div class="input-grp">
                    <label>Conform Email</label><br/>
                    <input type="email" name="con_email" class="cb-input confrm-email"/><br/>
                    <div class="email-match-status"></div>
                </div>
                <div class="input-grp">
                    <label>Pass word</label><br/>
                    <input type="password" name="password" class="cb-input password"/><br/>
                </div>
                <div class="input-grp">
                    <label>Conform Password</label><br/>
                    <input type="password" name="con_password" class="cb-input confrm-password"/>
                    <div class="password-status"></div>
                </div>
                <div class="input-grp">
                    <label>Phone number</label><br/>
                    <input type="text" name="phone" class="cb-input"/><br/>
                </div>
                <div class="input-grp">
                    <input type="reset" value="Reset" style="margin-right: 20px;"/><input id="submitBtn" type="submit" value="Sign up"/><br/>
                </div>
            </form>
            <div class="form-status"></div>
        </div>
        <div style="position: absolute;    right: 20px;    top: 20px;"><a href="login">User Login</a></div>
    </body>
</html>
