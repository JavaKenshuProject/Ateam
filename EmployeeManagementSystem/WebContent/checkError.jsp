<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>チェックエラー</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
%>
<h1>選択してください！！！！！！！！！！！！！！！！！</h1>
	<form action = "./MenuServlet" method = "post">
		<input type="submit" name="menu" value="戻る">
		<input type="hidden" name="from" value="チェックエラー">
	</form>
</body>
</html>