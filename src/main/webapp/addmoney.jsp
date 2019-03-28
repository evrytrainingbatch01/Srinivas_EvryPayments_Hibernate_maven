<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Money</title>
</head>

<form action="./AddMoney" method="post">
	<body>
		<table align="center" cellpadding="10">
			<tr>
				<td>Enter Amount</td>
				<td><input type="text" name="balance" maxlength="30" /></td>
			</tr>
			<tr>
				<td>Enter Account ID</td>
				<td><input type="text" name="UID" maxlength="30" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Submit"></td>
			</tr>
		</table>
</form>

</body>
</html>