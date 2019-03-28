<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Balance</title>
</head>
<body>
<form action="./CheckBalance" method="post">
<% 
Integer balance=0;
 balance=(Integer)request.getSession().getAttribute("customerBalance"); %>
<p>Check your Balance: <b><%= balance %></b></p>
</form><br>
</body>
</html>