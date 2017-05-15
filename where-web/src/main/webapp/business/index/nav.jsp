<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>到哪儿了外卖后台管理</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/business/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/business/js/jquery.cms.core.js"></script>
<script type="text/javascript">
$(function(){
	$("#left").myaccordion();
});
</script>
</head>
<body>
<div id="left">
<ul class="navMenu navSelected">

	<h3 class="navTitle">
		<span class="navTilteTxt">订单管理</span>
	</h3>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/user/users" target="content">新订单</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/group/groups" target="content">所有订单</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/role/roles" target="content">退单</a>
	</li>
</ul>

<ul class="navMenu navSelected">
	<h3 class="navTitle">
		<span class="navTilteTxt">菜单管理</span>
	</h3>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/goodsCategory/selectHelper" target="content">餐品类别列表</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/goodsCategory/addGoodsCategoryHelper" target="content">添加餐品类别</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/goods/findHelper" target="content">餐品列表</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/goods/addGoodsHelper" target="content">添加餐品</a>
	</li>
</ul>
	<ul class="navMenu">
		<h3 class="navTitle">
			<span class="navTilteTxt">评论管理</span>
		</h3>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/comments/selectHelper" target="content">评论管理</a>
		</li>
		
	</ul>
	<ul class="navMenu">
		<h3 class="navTitle">
			<span class="navTilteTxt">资料管理</span>
		</h3>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/shop/updateBusinessHelper" target="content">修改商家资料</a>
		</li>
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/shop/updateShopHelper" target="content">修改店铺资料</a>
		</li>
		
		<li class="navChild">
			<a href="<%=request.getContextPath() %>/shop/statusManagerHelper" target="content">状态管理</a>
		</li>
		
	</ul>
		</div>
</body>
</html>