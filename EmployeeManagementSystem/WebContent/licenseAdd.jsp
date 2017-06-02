<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>資格追加</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
%>
<div align="center">
<h1>資格追加</h1>
<form action="./AddLicenseServlet" method="post">
	資格コード：<input type="text" name="licensecode">
	<br><br>
	資格名：<input type="text" name="licensename">
	<br><br><br>
	<input type="submit" value="登録">
</form>
</div></body>
</html>