<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地址定位</title>

 <link href="<%=request.getContextPath()%>/css/business/map.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/js/map.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/js/area.js"></script>
</head>
<body>
	<form action="" method="POST" name="selectAddress_form">
		<table>
			<tr>
				<td>请选择省份</td>
				<td><select name="province">
					<option value="dfdfd">gfgf</option>
				</select></td>
				<td>请选择市</td>
				<td><select name="city">
					<option value="rere">gfgfg</option>
				</select></td>
			</tr>
		</table>
	</form>
</body>
</html>