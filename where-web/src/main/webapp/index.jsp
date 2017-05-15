<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>用户登录</title>
		
		<script type="text/javascript">
			var xmlHttp;
			function ctrateXMLRequest(){
				if(window.XMLHttpRequest){
					xmlHttp=new XMLHttpRequest();
				}else{
					xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				}
			}
			
			function validate(){
				createXMLRequest();
				var date=document.getElementById("name");
				var url="ValidationServlet?birthDate="+escape(date.value);
				xmlHttp.open("GET",url,true);
				xmlHttp.onreadystatechange=callback;
				xmlHttp.send(null);
			}
			
			
			
		</script>
	</head>
	<body>
	<form action="/where-web/login/user" method="post" >
		<table align="center">
			
				<tr>
					<td colspan="2" align="center"><h2>用户登录</h2></td>
				<tr/>
				<tr>
					<td align="center"><label>用户名</label></td>
					<td align="center"><input name="username" id="name" type="text" onblur="validate()"></td>
				<tr/>
				<tr>
					<td align="center"><label>密&nbsp;码</label></td>
					<td align="center"><input name="password" id="password" type="password" style="width: 120;" /></td>
				<tr/>
				<tr>
					<td  align="center">记住我<input type="checkbox" name="rememberMe" value="true" style="width: 120;" /></td>
				<tr/>
				<tr>
					<td align="center"><input type="submit" value="登录" style="width: 120;" /></td>
				<tr/>
			
		</table>
	</form>
	
	</body>
</html>
