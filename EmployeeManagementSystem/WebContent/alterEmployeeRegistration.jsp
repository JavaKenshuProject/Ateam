<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>従業員情報変更登録完了</title>
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
			<h3>従業員情報変更完了</h3>
			<form action="./MenuServlet" method="get">
				<input type="submit" name="menu" value="メニューへ戻る">
			</form>
		</div>
	</body>
</html>