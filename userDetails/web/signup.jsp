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
        <style type="text/css">
            .singnupForm{
                width: 239px;
                margin: auto;
            }
            .singnupForm span{
                font-size: 37px;
                color: #0F85E8;
            }
            .singnupForm label{
                margin-left: 10px;
            }
            .cb-input{
                margin-left: 30px;
            }
            .input-grp{
                margin-bottom: 2px;
                background-color: #163E64;
                width: 219px;
                padding: 10px;
                color: #fff;
                font-weight: bold;
            }
        </style>
        <script type="text/javascript" src="js/jquery17.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#submitBtn').click(function() {
                    return frmValidation();
                });
            });
            function frmValidation(){
                if($('.password').val()!==$('.confrm-password').val()){
                    alert("Password mismatch");
                    return false;
                }
                if($('.email').val()!==$('.confrm-email').val()){
                    alert("email mismatch");
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div class="singnupForm">
            <span>Sign up with us</span>
            <form method="post" action="signup" >
                <div class="input-grp">
                    <label>User Name</label>                <br/>
                    <input type="text" name="username" class="cb-input"/> <br/>
                </div>
                <div class="input-grp">
                    <label>Email</label><br/>
                    <input type="email" name="email" class="cb-input email"/><br/>
                </div>
                <div class="input-grp">
                    <label>Conform Email</label><br/>
                    <input type="email" name="con_email" class="cb-input confrm-email"/><br/>
                </div>
                <div class="input-grp">
                    <label>Pass word</label><br/>
                    <input type="password" name="password" class="cb-input password"/><br/>
                </div>
                <div class="input-grp">
                    <label>Conform Password</label><br/>
                    <input type="password" name="con_password" class="cb-input confrm-password"/><br/>
                </div>
                <div class="input-grp">
                    <label>Phone number</label><br/>
                    <input type="number" name="phone" class="cb-input"/><br/>
                </div>
                <div class="input-grp">
                    <input type="reset" value="Reset" style="margin-right: 20px;"/><input id="submitBtn" type="submit" value="Sign up"/><br/>
                </div>
            </form>
        </div>
    </body>
</html>
