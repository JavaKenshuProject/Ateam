<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"href="logout.css"type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログアウト</title>
</head>
<body>
<div class="header">　　従業員管理システム</div>
<center>
<p>
	<span class="under"><br><br><br>お疲れさまでした。</span>
</p>
<br>
<div class="button-panel1">
	<form action="./LoginServlet" method="get">
		<input type="submit" class="button1"value="ログイン画面へ戻る"
		style="background-color: #afeeee" onmouseover="this.style.background='#f5f5f5'" onmouseout="this.style.background=' #afeeee'">
	</form>
</div>
</center>
<div class="footer"><br><br>Produced by team A　</div>
</body>
</html>