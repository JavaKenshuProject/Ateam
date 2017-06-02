<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://use.fontawesome.com/739e61d5c1.js"></script>
<link rel="stylesheet"href="login.css"type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<div class="header">　　従業員管理システム</div>
<center>
<form action="./LoginServlet" method="post">
<table>
	<tr>
		<th></th>
	</tr>
	<tr>
		<td>
			<i class="fa fa-user-circle fa-2x" aria-hidden="true"></i>
				<input type="text" name="id"  style="color:gray" value="Username">
		</td>
	</tr>
	<tr>
		<td>
			<i class="fa fa-key fa-2x" aria-hidden="true"></i>
			<input type="password" name="pass"  style="color:gray" value="Password">
		</td>
	</tr>
	<tr>
		<td>
		<center>
		<div class="button-panel">
				<input type="submit"value="Enter" class="button"
					style="background-color:#001e43" onmouseover="this.style.background='#a9a9a9'" onmouseout="this.style.background='#001e43'">
		</div>
		</center>
		</td>
	</tr>
</table>
</form>
<div class="footer"><br><br>Produced by team A　</div>
</center>
</body>