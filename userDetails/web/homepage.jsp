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
<%@page import="utils.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
        <link rel="stylesheet" type="text/css"  href="style/design.css"/>
        <script type="text/javascript" src="js/jquery17.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {

                $.ajax({
                    url: '/search',
                    type: 'POST',
                    data: {searchword: ''},
                    success: function(data) {
                        $('.search-result').html(data.toString());
                    },
                    error: function(e) {
                        $('.search-result').html(e.responseText);
                    }
                });

                $('.searchbox').blur(function() {

                    $.ajax({
                        url: '/search',
                        type: 'POST',
                        data: {searchword: $(this).val()},
                        success: function(data) {
                            $('.search-result').html(data.toString());
                        },
                        error: function(e) {
                            $('.search-result').html(e.responseText);
                        }
                    });

                });

                $('.contact-heading').click(function() {
                    $(this).parent('.contact').parent('.contacts').children('.contact').children('.contact-details').hide(300);
                    $(this).parent('.contact').children('.contact-details').toggle(300);
                });
                $(".cont-menu ul li").click(function() {
                    var cl = $(this).html().toLowerCase().replace(/\s+/g, '-');
                    $('.cont .sub-cont').hide(0, function() {
                        $('.cont .' + cl).show();
                    });
                    // $('.cont .' + cl).show();


                });
                $('.btn-update').click(function() {
                    $('.addrss-update').submit();
                });
                $('.btn-update-password').click(function() {

                    if ($('.newpassword').val() !== $('.confrmpassword').val()) {
                        alert("Password is mismatch");
                        return;
                    }

                    if ($('.newpassword').val() === "" || $('.oldpassword').val() === "") {
                        alert("one or more field(s) are empty");
                        return;
                    }
                    $('.update-password').submit();
                });
            });
        </script>
        <style type="text/css">
            .contact-heading .btn{
                float: right;
                margin-top: -2px;
                height: 17px;
                font-size: 16px;
                padding: 2px 10px 2px 10px;
            }
            /*    .btn-delete{
                    position: relative;
                    top: -37px;
                    left: 88px;
                }*/
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
                <div class="user-details sub-cont">
                    <div class="user">
                        <ul>
                            <li><span>First Name:</span> <%=user.getFName()%></li>
                            <li><span>Last Name :</span> <%=user.getLName()%></li>
                            <li><span>Email :</span><%=user.getEmail()%></li>
                            <li><span>Address Line1: </span><%=user.getLine1()%></li>
                            <li><span>Address Line2: </span><%=user.getLine2()%></li>
                            <li><span>City :</span><%=user.getCity()%></li>
                            <li><span>State :</span><%=user.getState()%></li>
                            <li><span>Country :</span><%=user.getCountry()%></li>
                            <li><span>Zip code :</span><%=user.getZip()%></li>

                        </ul>  
                    </div>

                </div>
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
                            <input type="text" name="country" value="<%=user.getCountry()%>"/>
                        </div>
                        <div class="input-grp">
                            <label>Zip code</label><br/>
                            <input type="text" name="zipcode" value="<%=user.getZip()%>"/>
                        </div>
                        <div class="btn btn-cancel">Cancel</div>
                        <div class="btn btn-update">Update</div>
                    </form>
                </div>
                <div class="change-password sub-cont">
                    <form class="update-password" method="post" action="updatepassword">
                        <div class="input-grp">
                            <label>Old Password</label>
                            <input class="oldpassword" type="password" name="oldpassword"/>
                        </div>
                        <div class="input-grp">
                            <label>New Password</label>
                            <input class="newpassword" type="password" name="newpassword"/>
                        </div>
                        <div class="input-grp">
                            <label>Conform Password</label>
                            <input class="confrmpassword" type="password" name="confrmpassword"/>
                        </div>   
                        <div class="btn btn-cancel-pass">Cancel</div>
                        <div class="btn btn-update-password">Update</div>
                    </form>
                </div>

                <div class="contacts sub-cont">
                    <div contact-heading>Search: <input type="text" class="searchbox"></div>

                    <div class="search-result">

                    </div>
                    <!-- <div class="contact">
                         <div class="contact-heading">Karthikeyan
                             <div class="btn">Edit</div><div class="btn btn-delete">Delete</div>
                         </div>
                         <div class="contact-details">
                             <div class="lbl">Name : Karthikeyan</div>
                             <div class="lbl">Email : Karthikeyan@chargebee.com</div>
                             <div class="lbl">Phone : 9994901398</div>
                             <div class="lbl">Home : 144564576434</div>
                             <div class="lbl">Home : 144564576434</div>
                             <div class="lbl">Home : 144564576434</div>
 
                         </div>
                     </div>
                     <div class="contact">
                         <div class="contact-heading">Karthikeyan</div>
                         <div class="contact-details">  
                         </div>
                     </div>
                     <div class="contact">
                         <div class="contact-heading">Karthikeyan</div>
                         <div class="contact-details">
 
                         </div>
                     </div>-->
                    
                </div>
                <div class="add-contact sub-cont">
                    <form method="post" action="addcontact">
                        <div class="input-grp">
                            <label>Name :</label> <input type="text" name="contactname"/>
                        </div>
                        <div class="input-grp">
                            <label>Email :</label><input type="email" name="contactemail"/>
                        </div>

                        <%
                            for (Utils.MobileTypes type : Utils.MobileTypes.values()) {
                        %>
                        <div class="input-grp">
                            <label><%=type.name().toLowerCase()%> : </label><input type="text" name="<%=type.name()%>"/>
                        </div> 
                        <%
                            }
                        %>
                        <input type="reset" value="Clear"/>
                        <input style="margin-left: 10px;" type="submit" value="Add"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
