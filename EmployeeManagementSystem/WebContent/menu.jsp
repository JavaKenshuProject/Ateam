<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"href="menu.css"type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
%>
<div class="header">　　従業員管理システム</div>
<h1>MENU</h1>
<table style="table-layout:fixed;" width="100%">
	<tr>
		<td>
			<div class="button-panel1">
				<form action="./AllEmployeeServlet" method="get">
					<input type="submit" class="button1" name="menu" value="従業員一覧"
					style="background-color: #afeeee" onmouseover="this.style.background='#f5f5f5'" onmouseout="this.style.background=' #afeeee'">
				</form>
			</div>
		</td>
		<td>
			<div class="button-panel2">
				<form action="./MenuServlet" method="get">
					<input type="submit" class="button2" name="menu" value="従業員登録"
					style="background-color: #b0e0e6" onmouseover="this.style.background='#dcdcdc'" onmouseout="this.style.background=' #b0e0e6'">
				</form>
			</div>
		</td>
		<td>
			<div class="button-panel3">
				<form action="./MenuServlet" method="get">
					<input type="submit" class="button3" name="menu" value="システム利用者登録"
					style="background-color: #87cefa" onmouseover="this.style.background='#d3d3d3'" onmouseout="this.style.background=' #87cefa'">
				</form>
			</div>
		</td>
	</tr>
	<tr>
		<td class="d1">従業員情報の変更、削除</td>
		<td class="d2">従業員情報の登録</td>
		<td class="d3">システム利用者の登録</td>
	</tr>
	<tr>
		<td>
			<div class="button-panel4">
				<form action="./MenuServlet" method="get">
					<input type="submit" class="button4" name="menu" value="資格取得"
					style="background-color: #00bfff" onmouseover="this.style.background='#c0c0c0'" onmouseout="this.style.background=' #00bfff'">
				</form>

			</div>
		</td>
		<td>
			<div class="button-panel5">
				<form action="./MenuServlet" method="get">
					<input type="submit" class="button5" name="menu" value="資格追加"
					style="background-color: #1e90ff" onmouseover="this.style.background='#a9a9a9'" onmouseout="this.style.background=' #1e90ff'">
				</form>
			</div>
		</td>
		<td>
			<div class="button-panel6">
				<form action="./LogoutServlet" method="post">
					<input type="submit" class="button6" name="menu" value="ログアウト"
					style="background-color: #006eb0" onmouseover="this.style.background='#a9a9a9'" onmouseout="this.style.background=' #006eb0'">
				</form>
			</div>
		</td>
</tr>
<tr>
<td class="d4">従業員情報に保有資格を追加</td>
<td class="d5">資格情報に新たな資格を追加</td>
<td class="d6">ログアウト</td>

</tr>
</table>
<div class="footer"><br><br>Produced by team A　</div>
</body>
</html>