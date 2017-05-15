<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户点击店铺</title>
<style type="text/css">
	.container{
		margin:0 auto;border:1px solid #e1e1e1;width:1035px;height:2000px;
	}
	.search_top{
		margin-top: 20px;
	}
	.changeAddress{
	width: 345px;
	float: left;
	text-align:center;
	}
	.search{
		width: 690px;
		float: left;
		text-align:center;
	}
	#spe{
		width:1035px;
		height:40px;
		border:1px solid #e1e1e1;
		color: #FFFFFF;
		float: left;
		background-color: #37719F;
		margin-top: 30px;
	}
	#specific_shop{
		width:1035px;
		height:250px;
		background-color: #ffffff;
		margin-top: 140px;
	}
	
	#specific_shop_left{
	
		width:320px;
		height:250px;
		float: left;
		border:1px solid #e1e1e1;
	}
	#specific_shop_right{
		width: 711px;
		height:250px;
		float: left;
		border:1px solid #e1e1e1;
	}
	
	#specific_shop_right #shop_name{
		width: 711px;
		height:60px;
		border:1px solid #e1e1e1;
		font-size: 20px;
		
	}
	#specific_shop_right #shop_name .name{
		margin-left: 20px;
		padding-top: 15px;
		float: left;
	}
	#specific_shop_right #shop_name .status{
		margin-left: 20px;
		padding-top: 15px;
		float: left;
		color:red;
	}
	.address{
		width:691px;
		height:168px;
		border:1px solid #e1e1e1;
		padding-left: 20px;
		padding-top: 20px;
	}
	#goods_category{
		width:1005px;
		height:80px;
		background-color: #ffffff;
		float: left;
		margin-top: 20px;
		padding-top: 20px;
		padding-left: 30px;
	}
	.specific_goodsCategory{
		padding:10px;
		width:1015px;
		height:auto;
		background-color: #ffffff;
		display:inline-block !important; display:inline;
	}
	.goodsCategory_name{
		padding-left: 20px;
		padding-bottom: 10px;
		padding-top: 10px;
	}
	.goodsShow{
		padding:8px;
		width:490px;
		height:40px;
		float: left;
		background-color: #ffffff;
		border-bottom: 1px dashed #e1e1e1;
	}
	.goodsShow .goodsShow_name{
		width:90px;
		height:30px;
	float: left;
	}
	.goodsShow .goodsShow_price{
	width:90px;
		height:30px;
	float: left;
	}
	.goodsShow .goodsShow_a{
	width:90px;
		height:30px;
	float: left;
	color:#551A8B;
	}
	
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
</head>
<body style="height: 2000px; background-color: #F5F5F5">
	<div class="container">
		<div class="search_top">
			<div class="changeAddress">
			<span>${province }-${city }</span>
			<a href="<%=request.getContextPath()%>/selectAddress.jsp">切换地址</a></div>
			<div class="search"><input type="text" value="搜索店铺和美食" name="search_box" id="search_box" onfocus="if(value=='搜索店铺和美食') {value=''}" onblur="if (value=='') {value='搜索店铺和美食'}"><input type="button" value="搜索" id="search_button"/></div>
		</div>
		<div id="spe"></div>
		<div id="specific_shop">
			<div id="specific_shop_left">
				<img alt="暂无图片" src="${shopPicture.url }/${shopPicture.name}.${shopPicture.suffixName}?date=<%= new java.util.Date() %>" style="width: 300px; height:250px;">
			</div>
			<div id="specific_shop_right">
				<div id="shop_name"><div class="name">${shop.name }</div><div class="status">${shop.status }</div></div>
				<div class="address">
					商家地址：${shopAddress.specificAddress }
				</div>
			</div>
			<div id="goods_category">
				菜品分类 :&nbsp;
				<c:forEach items="${list }" var="goodsCategory" varStatus="lis">
					<a href="#${goodsCategory.name }">${goodsCategory.name }</a>&nbsp;
					
				</c:forEach>
			</div>
			
			<c:forEach items="${list }" var="goodsCategory" varStatus="lis">
				<div class="goodsCategory_name">
					<a name="${goodsCategory.name }"></a>
					${goodsCategory.name }
				</div>
				
				<div class="specific_goodsCategory">
					<c:forEach items="${goodsCategory.list }" var="goods" varStatus="goodsCateList">
						<div class="goodsShow">
						<div class="goodsShow_name">
							${goods.name }
						</div>
						<div class="goodsShow_price">
							 ${goods.price }元
						</div>
						<div class="goodsShow_a">
							<a href="/where-web/usersManager/confirmOrdersHelper?goodsId=${goods.id}">立即购买</a>
						</div>
						
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</div>
	</div>
</body>

</html>