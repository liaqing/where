<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改餐品类别</title>
<style type="text/css">
	.red{
		color:red;
	}
</style>

</head>
<body>
	<sf:form method="POST" action="/where-web/goodsCategory/updateGoodsCategory" name="updateGoodsCategory_form" commandName="goodsCategory">
		<fieldset>
	    	<legend>修改餐品类别</legend>
	    	<table align="center">
	    		<tr>
	    			<td style="display: none"><sf:input path="id" name="id"/></td>
	    			<td>餐品类别名称:&nbsp;</td>
	    			<td><sf:input path="name" name="name"/></td>
	    			<td>&nbsp;(名称长度不能超过十个字)<sf:errors path="name" cssClass="red"></sf:errors></td>
	    		</tr>
	    			<tr>
	    			
	    			<td>餐品类别排序:&nbsp;</td>
	    			<td><sf:input path="sort" name="sort"/></td>
	    			<td>&nbsp;(排序为0到99,999的整数)<sf:errors path="sort" cssClass="red"></sf:errors></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center"><input type="submit" value="确定"/></td>
	    		</tr>
	    	</table>
	    </fieldset>
	</sf:form>
</body>
</html>