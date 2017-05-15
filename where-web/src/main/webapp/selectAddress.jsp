<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地址定位</title>
	<style type="text/css">
		.field{
			width: 400px;
			 margin:0px auto;
		}
	</style>
 <link href="<%=request.getContextPath()%>/css/business/map.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/js/map.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/js/area.js"></script>
</head>
<body>
	<form action="/where-web/usersManager/selectAddress" method="POST" name="selectAddress_form" >
	 <fieldset class="field">
	    	<legend>选择省市</legend>
		<table align="center">
			<tr align="center">
				<td colspan="4" ><h3>请选择省市</h3></td>
			</tr>
			<tr></tr>
			<tr align="center">
				<td>请选择省份</td>
				<td><select name="province">
					<option value=""></option>
				</select></td>
				<td>请选择市</td>
				<td><select name="city">
					<option value=""></option>
				</select></td>
			</tr>
			<tr>
			<td>    &nbsp;</td>
			</tr>
			<tr align="center">
				<td  colspan="4"><input   type="submit" value="确定"/></td>
			</tr>
		</table>
		</fieldset>
	</form>
</body>
</html>