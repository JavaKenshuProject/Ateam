<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8">
	<title>資格登録</title>
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
		<h1>従業員保有資格登録</h1>
	</div>

	<div align = "center">
		<form action = "./GetLicenseServlet" method = "POST">
			<table>
        		<tr>
            		<td align="left">従業員コードを入力してください</td>
                	<td align="left"><input type="text" name="emp_code"></td>
             	</tr>
             	<tr>
                	<td align="left">取得した資格名を入力してください</td>
                	<td align="left">
       					<select name="license_name">
       						<option value="ITパスポート">ITパスポート</option>
       						<option value="基本情報">基本情報</option>
       						<option value="応用情報">応用情報</option>
       						<option value="Oracle Master Bronze">Oracle Master Bronze</option>
       						<option value="Oracle Master Silver">Oracle Master Silver</option>
       						<option value="OOracle Master Gold">Oracle Master Gold</option>
       						<option value="OJC-P">OJC-P</option>
       						<option value="OJC-WS">OJC-WS</option>
       						<option value="OCUP-F">OCUP-F</option>
       						<option value="OCUP-I">OCUP-I</option>
       						<option value="OCUP-A">OCUP-A</option>
       					</select>
       				</td>
             	</tr>
        	</table>
            	<br>
        	<input type="submit" value="送信">&nbsp;&nbsp;<input type="reset" value="取消">
		</form>
	</div>

</body>

</html>