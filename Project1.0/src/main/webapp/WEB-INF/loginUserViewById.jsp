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


<h1>User By id</h1>
<table border="2" width="70%" cellpadding="2">
<tr>

<th>name</th>
 <th>Adress</th> 
 <th>Pincode</th>
</tr>
<%-- <c:forEach var="loginuser" items="${list}">  --%> 
<tr>
<tr>
 
   <td>${list.name}</td>   
   <td>${list.pincode}</td>  
   <td>${list.adress}</td>  

 </tr>
<%--  </c:forEach>   --%>

</table>

<a href="/viewallusers">Do you want All user</a></a>

</body>
</html>


