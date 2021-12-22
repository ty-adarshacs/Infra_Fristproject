<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> loginuserList</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>id</th><th>name</th><th>pincode</th><th>adress</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="loginuser" items="${list}">   
   <tr>  
   <td>${loginuser.id}</td>  
   <td>${loginuser.name}</td>  
   <td>${loginuser.pincode}</td>  
   <td>${loginuser.adress}</td>  
   <td><a href="editemp/${loginuser.id}">Edit</a></td>  
   <td><a href="deleteById/${loginuser.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/login">Add New Employee</a>  




</body>
</html>