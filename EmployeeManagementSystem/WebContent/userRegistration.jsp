<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>システム利用者登録</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
%>
システム利用者登録
<br>
<form action="./urs" method="post">
<input type="text" name="id" style="color:gray">
<br>
<input type="password" name="password" style="color:gray">
<br>
<input type="submit" name="menu" value="完了">
</form>
</body>
</html>