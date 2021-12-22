<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1>Welcome  to testyantra</h1>
<h1>Welcome  to ${msg}</h1>
<h1>Welcome   to testyantra ${signal}</h1>
</body> --%>


	<%-- 	<%
if(${empcreated} == null || empcreated == ""){
	
}
%> --%>

	${empcreated}


	<h1>Add New Employee</h1>
	<form method="post" action="/save">
		<table>
			<tr>
				<td>ID :</td>
				<td><input id="id" name="id" /></td>
			</tr>

			<!--  <tr>
            <td>Email Id :</td>
            <td><input path="emailId" id="emailId"/></td>
        </tr> -->

			<tr>
				<td>name :</td>
				<td><input id="name" name="name" /></td>
			</tr>
			<tr>
				<td>pincode :</td>
				<td><input id="pincode" name="pincode" /></td>
			</tr>
			<tr>
				<td>adress :</td>
				<td><input id="adress" name="adress" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>

	<!-- <form method="post" action="/deleteById">
	<table>
	<tr>
				<td>delete :</td>
				<td><input id="id" name="id" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="delete" /></td>
			</tr>
	</table>
	</form> -->
	<a href="/viewallusers">View all Enployee</a>
	<br>
	<a href="sinleuser">view only single user</a>
</html>