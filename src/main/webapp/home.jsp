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
			<h1>Result Page</h1>
			<b>This is Sample Result Page</b><br />
			<%=new Date()%></br>
			<%
				Customer customer = (Customer) session.getAttribute("customer");
			%>
			<b>Welcome <%=customer.getCustomerName()%></b>
			<br /> <a href="logout.jsp">Logout</a>
			</p>

			<table>
				<thead>
					<tr>
						<th>Customer Name</th>
						<th>Age</th>
						<th>Email</th>
						<th>Address</th>
						<th>Mobile No</th>
					</tr>
				</thead>
				<tbody>
					<%
						LoginService loginService = new LoginService();
						List<Customer> list = loginService.getListOfCustomers();
						for (Customer u : list) {
							%>
					<tr>
						<td><%=u.getCustomerName()%></td>
						<td><%=u.getAge()%></td>
						<td><%=u.getEmail()%></td>
						<td><%=u.getAddress()%></td>
						<td><%=u.getMobileno()%></td>
					</tr>
					<%
						}
					%>
				
				<tbody>
			</table>
			<br />
		</div>
	</center>
</body>
</html>
