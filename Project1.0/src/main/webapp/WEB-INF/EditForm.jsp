<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<body>


        <h1>Edit loginform</h1>  
       <form:form method="POST" action="/editsave">    
        <table > 
        <tr>  
        <td></td>    
         <td><form:hidden  path="id"  name="id"/></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  name="name" /></td>  
         </tr>    
         <tr>    
          <td> pincode:</td>    
          <td><form:input path="pincode" name="pincode" /></td>  
         </tr>   
         <tr>    
          <td>adress :</td>    
          <td><form:input path="adress" nam="adress" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>
</html>