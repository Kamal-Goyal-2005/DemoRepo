<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Integer id = Integer.parseInt(request.getParameter("id")); %>
<form action="update">
Employee No <input type="text" name="empno" value="<%= id %>" readonly><br>
Employee Name <input type="text" name="ename"><br>
Employee Phone <input type="text" name="phone"><br>
<input type="submit" value="update employee name">


</form>
</body>
</html>