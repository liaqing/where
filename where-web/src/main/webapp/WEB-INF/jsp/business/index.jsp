<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>where外卖商家管理</title>
</head>
<frameset cols="*,1035,*"  border="0" frameborder="0" frameSpacing="0" scrolling="false">
	<frame src="<%=request.getContextPath() %>/html/business/background.html" frameSpacing="0">
	<frameset rows="110,*" frameborder="0" noresize frameSpacing="0">
		<frame name="top" src="<%=request.getContextPath() %>/business/index/top.jsp" frameborder="0" frameSpacing="0"/>
		<frameset cols="164,*" frameborder="0" frameSpacing="0">
			<frame name="nav" src="<%=request.getContextPath() %>/business/index/nav.jsp" frameborder="0"/>
			<frameset cols="700,*" frameborder="0" frameSpacing="0">
				<frame name="content" src="<%=request.getContextPath() %>/html/business/01.html" frameborder="0"/>
			</frameset>
		</frameset>
	</frameset>
	<frame src="<%=request.getContextPath() %>/html/business/background.html" frameSpacing="0">
</frameset>
</html>