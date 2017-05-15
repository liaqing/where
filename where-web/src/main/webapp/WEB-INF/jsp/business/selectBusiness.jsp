<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询个人信息</title>
<style type="text/css">
#email{
	
}
</style>
</head>
<body>
<sf:form commandName="business">
	<fieldset>
	    <legend>查询商家信息</legend>
	    <table align="center">
	    	<tr>
	    		<td>商家姓名</td>
	    		<td><sf:input path="username"  disabled="disabled" />
	    	</tr>
	    	<tr>
	    		<td>生日</td>
	    		<td><sf:input path="birthdayStr" disabled="disabled" />
	    	</tr>
	    	<tr>
	    			<td>性别</td>
	    			<td>
	    				<sf:select path="sex" name="sex">
	    					<sf:option value="1">男</sf:option>
	    					<sf:option value="0">女</sf:option>
	    				</sf:select>
	    			</td>
	    	</tr>
	    	<tr>
	    			<td>电话</td>
	    			<td>
	    				<sf:input path="phone"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>email</td>
	    			<td>
	    				<sf:input path="email" id="email" />
	    			</td>
	    		</tr>
	    	<tr>
	    			<td>地址</td>
	    			<td><sf:textarea path="address"/>
	    		</tr>
	    </table>
	 </fieldset>
</sf:form>
</body>
</html>