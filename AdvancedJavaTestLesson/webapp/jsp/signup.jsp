<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/layout.css">
<style>
div{
	text-align: center;
	font-size: 30px;
	font-family: 'Playfair Display', serif;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String email = request.getParameter("email");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String country = request.getParameter("country");
	String gender = request.getParameter("gender");
%>

<div>
<hr>
<h1> Hi! <%=name %>, Welcome to LOLO VÈVÈ </h1><br>
<hr>
<h2>User Info</h2>

		E-mail : <%=email %> <br>
		Phone Number : <%=phone1%> - <%=phone2%> - <%=phone3%> <br>
		Country : <%=country %> <br>
		Gender : <%=gender %> <br>
</div>

</body>
</html>