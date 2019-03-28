<%@page import="java.util.List"%>
<%@page import="com.evrydemo.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.evrydemo.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Result Page</title>
</head>
<body>
	<center>
		<div id="container">
			<h1>Transaction Management</h1>
			<%=new Date()%></br>
			<%
				Customer customer = (Customer) session.getAttribute("customer");
			%>
			<b>Welcome <%=customer.getCustomerName()%></b><br />
			<h4>Please Select the operation you want to do</h4>
			<br />
			<form action="./addmoney.jsp" method="GET">
				<input type="submit" class="button" name="addmoney"
					value="Add Money">
			</form></br></br>
			<form action="./checkbalance.jsp" method="GET">
				<input type="submit" class="button" name="checkbalance"
					value="Check Balance">
			</form></br></br>
			<form action="./transfer.jsp" method="GET">
				<input type="submit" class="button" name="transfer"
					value="Transfer Money">
			</form></br></br>

			<br /> <a href="logout.jsp">Logout</a>

		</div>
	</center>
</body>
</html>
