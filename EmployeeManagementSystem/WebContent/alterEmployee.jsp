<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="entity.EmployeeBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"href="alterEmployee.css"type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員情報変更</title>
</head>
<body>
	<div class="header">　　従業員管理システム</div>
	<% HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute("user") == null){
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else{
			EmployeeBean employee = (EmployeeBean)httpSession.getAttribute("employee");
			String empCode = employee.getEmpCode();
	        String lname = employee.getlName();
	        String fname = employee.getfName();
	        String lkana_name = employee.getlRubyName();
	        String fkana_name = employee.getfRubyName();
	        String sex = employee.getSex();
	        String sectionname = employee.getSectionName();

	        httpSession.setAttribute("empCode", empCode);
	%>

<h1>従業員情報変更</h1>
<center>
<form action = "./UpdateServlet" method = "post">
<table>
	<tr>
		<th>従業員コード：<%=empCode %></th>
	</tr>
	<tr>
		<td>
			<input type="text" name="lname"  style="color:gray" value="<%=lname %>" >
			<input type="text" name="fname"  style="color:gray" value="<%=fname %>" >
		</td>
	</tr>
	<tr>
		<td>
			<input type="text" name="lkana_name"  style="color:gray" value="<%=lkana_name%>" >
			<input type="text" name="fkana_name"  style="color:gray" value="<%=fkana_name %>" >
		</td>
	</tr>
	<tr>
		<%if(sex.equals("男")){%>
			<td>男<input type = "radio" name = "sex" value = "1" checked>
				女<input type = "radio" name = "sex" value = "2">
			</td>
		<%}else{%>
			<td><input type = "radio" name = "sex" value = "1"></td>
			<td><input type = "radio" name = "sex" value = "2" checked></td>
		<%}
		%>
	</tr>
	<tr>
		<td>
			<select name = "sectionname">
				<option value = "経理部">経理部</option>
				<option value = "営業部">営業部</option>
				<option value = "製造部">製造部</option>
				<option value = "販売部">販売部</option>
				<option value = "開発部">開発部</option>
				<option value = "人事部">人事部</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>
			<center>
			<div class="button-panel">
				<input type="submit" name="ACTION" value="更新" class="button"
				style="background-color:#001e43" onmouseover="this.style.background='#a9a9a9'" onmouseout="this.style.background='#001e43'">
			</div>
			</center>
		</td>
	</tr>
</table>
</form>
<div class="footer"><br><br>Produced by team A　</div>
</center>
	<%
		}
	%>
</body>
</html>