
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
                        
  
 <style>
         .mapouter
         {  
             position:relative;
             text-align:right;
             left:1px;
             bottom: 25%;
             right:30%;
             height:500px;
             width:600px;
         }
         .gmap_canvas
         {
             overflow:hidden;
             background:none!important;
             height:500px;
             width:600px;
         }
       


h1 {
    font-size: 35px;
    left:60px;
    text-transform: uppercase;
    font-family: monospace;
    font-weight: 600;
    margin-bottom: 30px;
  }
 
.p1{
    font-size: 12px;
    text-transform: uppercase;
    font-family: arial;
    font-weight: 600;
    margin-bottom: 30px;
    color:#ff6600;
  }
  .p2{
    font-size: 25px;
    text-transform: uppercase;
    font-family: monospace;
    font-weight: 600;
    margin-bottom: 30px;
    color:#ff6600;
    font-stretch: semi-expanded;
  }
  p{
      font-size:30px;
      font-family:monospace;
  }
.navbar {
  overflow: hidden;
  background-color: rgba(0,0,0, 0.4);
}

.navbar a {
  float: left;
  top:10%;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 10px;
  text-decoration: none;
}
.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}
.navbar a.logo {
  font-size: 25px;
  font-weight: bold;
  font-family: monospace;
}
.navbar-right {
  float: right;
  font-family: monospace;
  font-size: 25px;
}
 
.dropdown {
  float: right;
  font-size: 20%;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
    letter-spacing: 4px;
    border-radius: 0;
    font-family: Montserrat, sans-serif;
}

.dropdown .dropbtn {
 
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color:  #ff471a;
}

.dropdown:hover .dropdown-content {
  display: block;
}

 html,body {
    height:100%;
    width:100%;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
 .bg
            {
                height: 100%; 
         
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }

  .jumbotron {
    
   
    font-family: Montserrat, sans-serif;
   
  }

  .bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0.4); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  font-size: 40px;
  font-family: harrington;
  border: 7px solid #f1f1f1;
  position: absolute;
  top: 34%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 500px;
  padding: 5px;
  text-align: center;
  
}
.bg-tx {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  font-size: 40px;
  font-family: harrington;
  
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 20%;
  padding: 5px;
  text-align: center;
  
}
* {
  box-sizing: border-box;
}

.container2 {
  position: absolute;
  width: 600px;
  height: 50%;
  top:15%;
  right:200%;
  left: -1%;
  
  margin: 0 auto;
}

.container2 img {vertical-align: middle;}

.container2 .content 
{
  position: absolute;
  top:16%;
  
  background: rgb(0, 0, 0); /* Fallback color */
  background: rgba(0, 0, 0, 0.6); /* Black background with 0.5 opacity */
  color: #f1f1f1;
  width: 500%;
  padding: 111px;
}
.div2{
    float:left;
    text-align: left;
}
.open-button {
  background-color: #29a329;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: absolute;
  width: 280px;
  float: left;
  left:44%;
  overflow: hidden;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container2 {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container2 input[type=text], .form-container2 input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container2 input[type=text]:focus, .form-container2 input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container2 .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container2 .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container2 .btn:hover, .open-button:hover {
  opacity: 1;
}
p{
    color:white;
    font-size: 40px;
    font-family: monospace;
}
 td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

 tr:nth-child(even){background-color: #f2f2f2;}

 tr:hover {background-color: #ddd;}
 th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

 </style>
      
    </head>
<body background="beach2.jpg" class="bg">

<div class="navbar">
     <a href="#default" class="logo">GnT Travels</a>
     <h3> <mark>WELCOME ${username}</mark></h3>
    <div class="navbar-right">
        <a href="home2.jsp">Home</a> &nbsp;&nbsp;&nbsp;
        <a href="maps.html">Resource Locator</a>&nbsp;&nbsp;&nbsp;
        <a href="Cost.html">Cost Estimation</a>
    <div class="dropdown">
    <button class="dropbtn">
      <i class='fas fa-gift' style='font-size:34px'></i>Packages 
    </button>
    <div class="dropdown-content">
      <a href="booking.html">Domestic</a>
      <a href="inter1.html">International</a>
     
    </div>
  </div> 
    <a href="LogoutServlet1">Logout</a>
  </div>
</div>
    <div class="form-popup" id="myForm">
  <form action="editinfo" class="form-container2">
      
    <h1>Edit Info</h1>
    
    <label ><b>User_Id</b></label>
    <input type="text" placeholder="Name" name="u_id" required>
    
    <label ><b>Name</b></label>
    <input type="text" placeholder="Name" name="name" required>
    
    <label><b>Age</b></label>
    <input type="text" placeholder="Age" name="age" required>
    
    <label><b>Address</b></label>
    <input type="text" placeholder="Address" name="address" required>
    
    <label for="psw"><b>Country</b></label>
    <input type="text" placeholder="Country" name="country" required>
    
    <label for="psw"><b>Email</b></label>
    <input type="email" placeholder="Email Id" name="email" required><br>
    
    <label for="psw"><b>Contact no</b></label>
    <input type="text" placeholder="contact" name="contact" required>
    
    <label for="psw"><b>Login Id</b></label>
    <input type="login id" placeholder="Loginid" name="loginid" required>
    
   
    <button type="submit" class="btn">Edit</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
    <%
  
     String uid = request.getParameter("id");        
    String password = request.getParameter("password");
    String name="",age="",address="",country="",emailid="",contact="",loginid="",ticket="",from="",to="",hotel="",transport="",guide="",startdate="",enddate="",userid="",email="",bookingid="";

    session.setAttribute("id",uid);
    session.setAttribute("password", password);
    
    
    %>
 <%  
     try
   {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
        PreparedStatement ps = con.prepareStatement("select * from user_login  inner join booking on user_login.u_id=booking.u_id where user_login.u_id =? ");
            
          ps.setString(1,uid);
 
          ResultSet rs = ps.executeQuery();
          while(rs.next())
          {
                    /* name=rs.getString(2);
                    age=rs.getString(3);
                    address=rs.getString(4);
                    country=rs.getString(5);
                    emailid=rs.getString(6);
                    contact=rs.getString(7);
                    loginid=rs.getString(8);
                    from=rs.getString(10);
                    to=rs.getString(11);
                    startdate=rs.getString(12);
                    enddate=rs.getString(13);
                    hotel=rs.getString(14);
                    transport=rs.getString(15);
                    ticket=rs.getString(16);
                    bookingid=rs.getString(18);
                    guide=rs.getString(20);*/
                    
                    name=rs.getString(2);
                     age=rs.getString(3);
                    address=rs.getString(4);
                    country=rs.getString(5);
                    emailid=rs.getString(6);
                    contact=rs.getString(7);
                    loginid=rs.getString(8);
                    from=rs.getString(10);
                    to=rs.getString(11);
                    startdate=rs.getString(12);
                    enddate=rs.getString(13);
                    hotel=rs.getString(14);
                    transport=rs.getString(15);
                    ticket=rs.getString(16);
                    bookingid=rs.getString(18);
                    guide=rs.getString(20);
                
              
              
          } 
           out.println("<br><center><h1 style='font-family:Mongolian Baiti;color: #99ff99;'><u><mark>Your Profile:</mark></u> </h1><center>");
           out.println("<center><h3 style='font-family:monotype;color:white;size:33px'><p> NAME : " +name+ "<br>"+
                        "AGE :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+age+     "<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ADDRESS : " +     address+     "<br>"+
                        "COUNTRY :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+country+     "<br>"+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EMAIL :&nbsp; &nbsp;&nbsp;&nbsp;"                +      emailid+    "<br>"+
                        "&nbsp;&nbsp;&nbsp;CONTACT : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +contact+     "<br>"+
                        "LOGIN_ID :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "   +loginid+     "<br>"+
                       
                       "<p>"+"</h3><center>");
           out.println("<center> <button  class='open-button' onclick='openForm()'>Edit Info</button></center>");
           out.println("<br><br>");
            out.println("<br><center><h1 style='font-family:Mongolian Baiti;color:#088A85;size:30px'><u>Your Booking Details </u></h1><center>");
            out.println("<table id='customers' border=1 width=20% height=60% align=center>"
                        +"<th> From</th>"
                        +"<th>To </th>"
                        +"<th>Start Date </th>"
                        +"<th>End Date </th>"
                        +"<th>Hotel </th>"

                        +"<th>Transport </th>"

                         + "<th>No Of People </th>"

                        +"<th>Booking Id </th>"
                         
                        +"<th>Guide </th>"


                        +"</tr>");
            out.println("<tr style=color:#ff3399;size=30px>"
             +"<td style=color:#ff3399;size=30px>" + from +"</td>"
                        + "<td>" + to + "</td>"
                        +"<td>" + startdate +"</td>"
                        +"<td>" + enddate +"</td>"
                        +"<td>" + hotel +"</td>"
                        +"<td>" + transport +"</td>"
                        +"<td>" + ticket +"</td>"
                       
                        +"<td>" + bookingid +"</td>"
                        
                        +"<td>" + guide +"</td>"
                        + "</tr>");
        }
 catch(Exception e)
{
out.println("Exception : "+e);
}
%>
    </body>
</html>
