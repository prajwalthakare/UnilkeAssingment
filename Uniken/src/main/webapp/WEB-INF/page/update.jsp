<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@page import ="com.java.entity.Corporate1" %>
     <%@ page import="java.util.List" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Data</title>
</head>

<% List<Corporate1> list=(List<Corporate1>)request.getAttribute("list");  %>
<body>
	<center>
	<h2>Update Corporate</h2>
	<form action="updateparticularpro">
	<%
	for(Corporate1 prj:list)
	{
	 %>
	<table border="1">
	<tr>
		<td>Enter SrNo:-</td>
		<td><input type="text" name="Idprojects" value="<%out.println(prj.getSrNo());%>"></td>
	</tr>
	<tr>
		<td>Enter Corporate Name:-</td>
		<td><input type="text" name="Projectname" value="<%out.println(prj.getCorporateName());%>"></td>
	</tr>
	<tr>
		<td>Enter Account Number:-</td>
		<td><input type="text" name="Startdate" value="<%out.println(prj.getAccountNumbers());%>"></td>
	</tr>
	<tr>
		<td>Enter Corporate ID-</td>
		<td><input type="text" name="Enddate" value="<%out.println(prj.getCorporateId());%>"></td>
	</tr>
	
	
	<tr>
		<td></td>
		<td><input type="submit" value="Submit"></td>
	</tr>
	</table>
	<%
	
	}
	%>
	</form>
	
	</center>
</body>
</html>