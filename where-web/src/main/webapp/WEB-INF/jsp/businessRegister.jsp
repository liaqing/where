<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.red{
	color:#f00
	}
</style>
<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/messages_zh.js"></script>
<script type="text/javascript" src="../js/businessValidate.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
	<sf:form action="/where-web/business/register" method="post" id="form" commandName="business">
	  <fieldset>
    <legend>商家注册验证</legend>
		<table align="center">
			<tr>
				<td colspan="2" align="center"><h2>商家注册</h2></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><sf:input path="username" type="text" name="username" id="username" /><sf:errors path="username" cssClass="red"/></td>
				<td><span class="red">*</span></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><sf:input path="password" type="password" name="password" id="password"/><sf:errors path="password" cssClass="red"/></td>
				<td><span class="red">*</span></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="confirm_password" id="confirm_password"/></td>
				<td><span class="red">*</span></td>
			</tr>
			<tr>
				<td>email</td>
				<td><sf:input path="email" type="text" name="email" id="email" /><sf:errors path="email" cssClass="red"/></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><sf:input path="phone" type="text" name="phone" id="phone"/><sf:errors path="phone" cssClass="red"/></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><sf:input path="address" type="text" name="address" id="address"/><sf:errors path="address" cssClass="red"/></td>
			</tr>
			<tr>
				
				<td><div><input type="submit" name="submit" id="submit" value="确认注册" /></div></td>
			</tr>
		</table>
		</fieldset>
	</sf:form>
</body>
</html>