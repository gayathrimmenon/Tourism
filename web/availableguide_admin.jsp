<%-- 
    Document   : availableguide_admin
    Created on : Apr 27, 2019, 9:33:46 AM
    Author     : KHSCI5MCA16122
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
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
  left:4%;
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
  padding: 13px 15px;
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
    <body>
          <div class="form-popup" id="myForm">
  <form action="updatebooking" class="form-container2">
      
    <h1>Edit Info</h1>
    
    <label ><b>Booking_Id</b></label>
    <input type="text" placeholder="ID" name="b_id" required>
    
    <label ><b>Available</b></label>
    <input type="text" placeholder="TAKEN OR NOT" name="avail" required>
    
    <label ><b>Guide_id</b></label>
    <input type="text" placeholder="ID" name="g_id" required>
  
   
    <button type="submit" class="btn">Edit</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>
<button  class='open-button' onclick='openForm()'>Update</button>
<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
<%
     try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement stmt=con.prepareStatement("select * from availableguide");
                ResultSet rs=stmt.executeQuery(); 
               
                       
            out.println("<center>");
           out.println("<h1 style='font-family:'arial';font-color:'maroon' '>Available Guide</h1>");
            out.println("<table border=1 width=10% height=50% align=center>"
                    
                    
                    +"<tr><th> From</th>"
                    
                    +"<th>To </th>"
                    +"<th>Start Date </th>"
                    +"<th>End Date </th>"
                   
                    +"<th>Booking Id </th>"
                     
                     +"<th>Guide_Id </th>"
                    
                   
                  
                    +"</tr>");
            String ticket,from,to,hotel,transport,guide,startdate,enddate,userid,email,bookingid;
            while(rs.next())
                {
                    
                    
                    from=rs.getString(1);
                    to=rs.getString(2);
                    startdate=rs.getString(3);
                    enddate=rs.getString(4);
                   
                    bookingid=rs.getString(5);
                    
                     guide=rs.getString(6);
                   
               
                    out.println("<tr style=color:crimson red>"
                        
                        +"<td>" + from +"</td>"
                        + "<td>" + to + "</td>"
                        +"<td>" + startdate +"</td>"
                        +"<td>" + enddate +"</td>"
                       
                        +"<td>" + bookingid +"</td>"
                       
                        +"<td>" + guide +"</td>"
                                
                        
                       
                        + "</tr>");
                    
                    
                }
            
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            out.println("</table>");
%>
    </body>
</html>
