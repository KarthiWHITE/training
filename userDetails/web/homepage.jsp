<%-- 
    Document   : hompage.jsp
    Created on : 27 Jul, 2015, 6:29:58 PM
    Author     : cb-admin1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="utils.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <link rel="stylesheet" type="text/css"  href="style/design.css"/>
        <script type="text/javascript" src="js/jquery17.js"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                
                $(".cont-menu ul li").click(function(){
                    var cl=$(this).html().toLowerCase().replace(/\s+/g,'-');
                    $('.cont .sub-cont').hide(0,function(){$('.cont .'+cl).show();});
                    $('.cont .'+cl).show();
                    
                });
                $('.btn-update').click(function (){
                    $('.addrss-update').submit();
                });
                $('.btn-update-password').click(function (){
                    $('.update-password').submit();
                });
            });
        </script>
    </head>
    <body>
         <%
                        User user=(User)request.getAttribute("curuser");
                       if(user==null){
                           getServletConfig().getServletContext().getRequestDispatcher("/usrlogin").forward(request, response);
                       }
        %>
        <% if(request.getSession().getAttribute("userid")==null){
            response.sendRedirect("login.jsp");
        }else{ %>
        <div class="pageheading">Welcome Mr. <%=request.getSession(true).getAttribute("username").toString() %><a href="logout">Logout</a></div>
        <%}%>
       
        <div class="cont-wrapper">
            <div class="cont-menu">
                <ul>
                    <li>Change Address</li>
                    <li>Change Password</li>
                </ul>
            </div>
            <div class="cont">
                <div class="change-address sub-cont">
                    
                    <form class="addrss-update" method="post" action="updateaddress">
                        <input type="hidden" name="address" value="<%=user.addValid%>"/>
                        <div class="input-grp">
                            <label>First Name</label><input type="text" name="fname" value="<%=user.getFName()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>Last Name</label><input type="text" name="lname" value="<%=user.getLName()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>Email Id</label><input type="text" name="email" readonly value="<%=user.getEmail()%>"/>
                        </div> 
                        <div class="input-grp">
                            <label>Address Line 1</label>
                            <input type="text" name="addresslineone" value="<%=user.getLine1()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>Address Line 2</label>
                            <input type="text" name="addresslinetwo" value="<%=user.getLine2()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>City</label><br/>
                            <input type="text" name="city" value="<%=user.getCity()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>State</label><br/>
                            <input type="text" name="state" value="<%=user.getState()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>Country</label><br/>
                            <input type="text" name="country" value="<%=user.getCountry() %>"/>
                        </div>
                        <div class="input-grp">
                            <label>Zip code</label><br/>
                            <input type="text" name="zipcode" value="<%=user.getZip() %>"/>
                        </div>
                        <div class="btn btn-cancel">Cancel</div>
                        <div class="btn btn-update">Update</div>
                    </form>
                </div>
                <div class="change-password sub-cont">
                    <form class="update-password" method="post" action="updatepassword">
                        <div class="input-grp">
                            <label>Old Password</label>
                            <input type="password" name="oldpassword"/>
                        </div>
                        <div class="input-grp">
                            <label>New Password</label>
                            <input type="password" name="newpassword"/>
                        </div>
                        <div class="input-grp">
                            <label>Conform Password</label>
                            <input type="password" name="confrmpassword"/>
                        </div>   
                        <div class="btn btn-cancel-pass">Cancel</div>
                        <div class="btn btn-update-password">Update</div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
