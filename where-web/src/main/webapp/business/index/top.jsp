<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/where-web/css/business/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.0.js"></script>

<script type="text/javascript">

function exitSystem() {
	//alert($("#contextPath").val()+"/admin/logout");
	window.parent.location.href = $("#contextPath").val()+"/admin/logout";
}
</script>
</head>
<body>
<jsp:include page="top_inc.jsp"></jsp:include>
</body>
</html>