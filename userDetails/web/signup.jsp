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
        <script type="text/javascript">
            var submitStatus = true;
            $(document).ready(function() {

                $('#submitBtn').click(function() {
                    return frmValidation();
                });

                $(".confrm-password").blur(function() {
                    if ($('.password').val() !== $('.confrm-password').val()) {
                        addInvalidClass('.password-status', "Password Mismatch");
                        submitStatus = false;
                    } else {
                        addValidClass('.password-status', "Password Matched");
                        submitStatus = true;
                    }
                });
                $(".confrm-email").blur(function() {
                    if ($('.email').val() !== $('.confrm-email').val()) {
                        addInvalidClass('.email-match-status', "Email Mismatch");
                        submitStatus = false;
                    } else {
                        addValidClass('.email-match-status', "Email Matched");
                        submitStatus = true;
                    }
                });

                $('#user-email').blur(function() {
                    if ($(this).val()!=''){
                        $.ajax({
                            url: 'chkuser',
                            type: 'POST',
                            data: {email: $(this).val()},
                            success: function(data) {
                                if (data.toString() === "1") {
                                    addInvalidClass('.singnupForm .email-status', "Email already exist");
                                     submitStatus = true;
                                    $('#user-email').val("");
                                } else {
                                    addValidClass('.singnupForm .email-status', "Email available");
                                    submitStatus = false;
                                }

                            },
                            error: function(e) {
                                alert("Error while accessing server");
                            }
                        });
                    }else{
                        addInvalidClass('.singnupForm .email-status', "Email is empty");
                         submitStatus = false;
                    }
                });


            });
            function frmValidation() {
                if (!submitStatus||$('.password').val() ==='' ) {
                    addInvalidClass('.form-status', 'Error while submitting form');
                    return false;
                }

                return true;

            }

            function addValidClass(className, value) {
                $(className).removeClass("status-invalid");
                $(className).addClass("status-valid");
                $(className).html(value);
            }
            function addInvalidClass(className, value) {
                $(className).removeClass("status-valid");
                $(className).addClass("status-invalid");
                $(className).html(value);
            }

        </script>
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
                    <input type="text" name="username" class="cb-input"/> <br/>
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
