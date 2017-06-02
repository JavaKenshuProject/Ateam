<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>登録完了</title>
</head>

<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
%>
	<div align = "center">
		<h1>保有資格を登録しました</h1>
	</div>

	<div align = "center">
	<form action="./MenuServlet" method="get">
		<input type="submit" name="menu" value="メニューへ戻る">
	</form>
	</div>
</body>

</html>