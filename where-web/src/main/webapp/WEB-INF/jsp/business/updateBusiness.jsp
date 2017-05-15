<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商家信息</title>
<style type="text/css">
	.red{
		color:red;
	}
	#updateBusiness_table tr{
		height: 50px;
	}
	
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>

</head>
<body>
	<sf:form action="/where-web/shop/updateBusiness" id="updateBusiness_form" method="POST" commandName="business">
		 <fieldset>
	    	<legend>修改商家信息</legend>
	    	<table id="updateBusiness_table" align="center">
	    		<tr>
	    			<td>商家姓名</td>
	    			<td><sf:input path="username" name="username"/>&nbsp;(名字长度不能超过十个字)<sf:errors path="username" cssClass="red"/></td>
	    		</tr>
	    		
	    		<tr>
	    			<td>生日</td>
	    			<td><sf:input path="birthdayStr" name="birthdayStr" id="birthdayStr"/>&nbsp;(生日格式为：2017-09-04)<sf:errors path="birthday" cssClass="red"/></td>
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
	    				<sf:input path="phone" name="phone"/>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>email</td>
	    			<td>
	    				<sf:input path="email" name="email" />
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>地址</td>
	    			<td><sf:textarea path="address" name="address"/>&nbsp;(地址字数不能超过50个字)<sf:errors path="address" cssClass="red"/></td>
	    		</tr>
	    		
	    		<tr>
	    			
	    			<td><input type="submit" value="确定"/></td>
	    		</tr>
	    	</table>
	    </fieldset>
	</sf:form>
</body>
</html>