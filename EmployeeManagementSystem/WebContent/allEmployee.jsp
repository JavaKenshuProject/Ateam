<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.EmployeeBean" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員一覧情報</title>
</head>
<body>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession.getAttribute("user") == null || httpSession.getAttribute("employeeList") == null){
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}else{
		ArrayList<EmployeeBean> empList = (ArrayList<EmployeeBean>)httpSession.getAttribute("employeeList");
		HashMap<String,String> licenseList = (HashMap<String,String>)httpSession.getAttribute("licenseList");
%>
<div align="center">
<form action="./MenuServlet" method="post">
	<table>
		<tr>
			<th>従業員コード</th>
			<th>氏名</th>
			<th>氏名（フリガナ）</th>
			<th>性別</th>
			<th>生年月日</th>
			<th>所属部署</th>
			<th>入社日</th>
			<th>保有資格</th>
		</tr>
<%
		for(int i=0;i<empList.size();i++){
%>
		<tr>
			<td align="center"><input type="radio" name="empcode" value="<%=empList.get(i).getEmpCode() %>"><%=empList.get(i).getEmpCode() %></td>
			<td align="center"><%=empList.get(i).getlName() %> <%=empList.get(i).getfName() %></td>
			<td align="center"><%=empList.get(i).getlRubyName() %> <%=empList.get(i).getfRubyName() %></td>
			<td align="center"><%=empList.get(i).getSex() %></td>
			<td align="center"><%=empList.get(i).getBirthDay() %></td>
			<td align="center"><%=empList.get(i).getSectionName() %></td>
			<td align="center"><%=empList.get(i).getEmpDate() %></td>
			<td align="center">
				<%
					if(licenseList.containsKey(String.valueOf(i))){
				%>
						<%=licenseList.get(String.valueOf(i)) %>
				<%
					}
				%>
			</td>
		</tr>
<%
		}
%>
	</table>
	<input type="submit" name="menu" value="削除" >
	<input type="submit" name="menu" value="変更">
</form>
<form action="./MenuServlet" method="get">
	<input type="submit" name="menu" value="メニューへ戻る">
</form>
</div>
<%
	}
%>
</body>
</html>