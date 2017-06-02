<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員登録</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}else{
%>
<div align="center">
<h1>登録したい従業員情報を入力してください。</h1>
<form method = "POST" action = "./NewEmployeeServlet">
	従業員コード:<input type = "text" name = "empCode"><hr>
	氏:			<input type = "text" name = "lName">名:<input type = "text" name = "fName"><hr>
	氏（カナ）:	<input type = "text" name = "lRubyName">名（カナ）:<input type = "text" name = "fRubyName"><hr>
	<p>性別:	<input type = "radio" value = "1" name = "sex" checked>男
				<input type = "radio" value = "2" name = "sex">女</p><hr>
	<p>生年月日:<select name = "birthYear">
					<%for( int y=1950; y<=2000; y++ ){%>
						<option value="<%= y %>/"><%= y %></option>
					<% } %>
				</select>
				年
				<select name = "birthMonth">
					<%for( int m=1; m<=12; m++ ){%>
						<%if( m<10){%>
							<option value="0<%= m %>/">0<%= m %></option>
						<% } else {%>
							<option value="<%= m %>/"><%= m %></option>
						<% } %>
					<% } %>
				</select>
				月
				<select name = "birthDate">
					<%for( int d=1; d<=31; d++ ){%>
						<%if( d<10){%>
							<option value="0<%= d %>">0<%= d %></option>
						<% } else {%>
							<option value="<%= d %>"><%= d %></option>
						<% } %>
					<% } %>
				</select>
				日
	</p><hr>
	所属部署名:	<select name = "section">
					<option value = "経理部">経理部</option>
					<option value = "営業部">営業部</option>
					<option value = "製造部">製造部</option>
					<option value = "販売部">販売部</option>
					<option value = "開発部">開発部</option>
					<option value = "人事部">人事部</option>
				</select>
	<hr>
	<p>入社日:	<select name = "empYear">
					<%for( int y=1950; y<=2017; y++ ){%>
						<option value="<%= y %>/"><%= y %></option>
					<% } %>
				</select>
				年
				<select name = "empMonth">
					<%for( int m=1; m<=12; m++ ){%>
						<%if( m<10){%>
							<option value="0<%= m %>/">0<%= m %></option>
						<% } else {%>
							<option value="<%= m %>/"><%= m %></option>
						<% } %>
					<% } %>
				</select>
				月
				<select name = "empDate">
					<%for( int d=1; d<=31; d++ ){%>
						<%if( d<10){%>
							<option value="0<%= d %>">0<%= d %></option>
						<% } else {%>
							<option value="<%= d %>"><%= d %></option>
						<% } %>
					<% } %>
				</select>
				日
	</p>
  	資格名:<select name = "license">
		<option value = "no">資格なし</option>
		<option value = "ITパスポート">ITパスポート</option>
		<option value = "基本情報">基本情報</option>
		<option value = "応用情報">応用情報</option>
		<option value = "Oracle Master Bronze">Oracle Master Bronze</option>
		<option value = "Oracle Master Silver">Oracle Master Silver</option>
		<option value = "Oracle Master Gold">Oracle Master Gold</option>
		<option value = "OJC-P">OJC-P</option>
		<option value = "OJC-WS">OJC-WS</option>
		<option value = "OCUP-F">OCUP-F</option>
		<option value = "OCUP-I">OCUP-I</option>
		<option value = "OCUP-A">OCUP-A</option>
	</select><br>
	<input type = "submit" value = "登録">
</form>
</div>
<%
	}
%>
</body>
</html>