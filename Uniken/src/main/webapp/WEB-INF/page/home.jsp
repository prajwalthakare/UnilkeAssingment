<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import ="java.util.ArrayList" %>

<%@page import ="com.java.entity.Corporate1" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corporate list</title>
</head>
<body>
<% ArrayList<Corporate1> corlist=(ArrayList<Corporate1>)request.getAttribute("list"); %>

<%
String msg=(String)request.getAttribute("msg");

out.println(msg);
%>	
	<center>
	<h2>Corporate List</h2>

	<table border="1">
	
	
	<tr>
		<th>Id</th>
		<th>Corporate Name </th>
		<th>Account Numbers</th>
		<th>Corporate ID</th>
		
		
	</tr>
	<%
	
	for(Corporate1 cor:corlist)
	{
	%>
	<tr>
		<td><%out.println(cor.getSrNo()); %></td>
		<td><%out.println(cor.getCorporateName()); %></td>
		<td><%out.println(cor.getAccountNumbers()); %></td>
		<td><%out.println(cor.getCorporateId()); %></td>
		
		
		
		<td><a href="deletecorp?SrNo=<%=cor.getSrNo() %>">Delete</a></td>
		
	<td><a href="addcor?SrNo=<%=cor.getSrNo() %>">AddCorporate</a></td>
	<td><a href="update?SrNo=<%=cor.getSrNo()%>">Update</a></td>
	
	</tr>
	<%
	}
	%>
	</table>
	
	</center>
</body>
</html>