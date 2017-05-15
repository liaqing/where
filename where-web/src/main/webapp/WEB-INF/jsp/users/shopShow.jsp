<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺展示</title>
<style type="text/css">
	.container{
		margin:0 auto;border:1px solid #000;width:1035px;height:2000px;
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
	.shopCategory{
	
	border:1px solid #000;width:1035px;height:40px;
	background-color: #37719F;
	float: left;
	margin-top: 30px;
	color: #FFFFFF;
	font-size: 18px;
	padding-top: 10px;
	}
	
	.shopCategory a{
	color:#ffffff;
	text-decoration: none;
	}
	
	.shop_picture{
	width:250px;
	height: 200px;
	}
	
	#shopShow{
		width:1035px;
		height:1500px;
		margin-top: 150px;
		border:1px solid #000;
	}
	
	.shopShowDetial{
		width:250px;
		height:250px;
		border:1px solid #000;
		margin:  0  4.4px;
	}
	
	.shopName{
		width:250px;
		height:40px;
		padding-left: 20px;
		padding-top:15px;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function(){
		$(".shopCategory_a").click(function(){
			alert($(this).text());
			$("#shopShow").hide();
			/* 在此处添加页面跳转 */
		});
		
	
	});

</script>
</head>
<body style="height: 2000px; ">
	<div class="container">
		<div class="search_top">
			<div class="changeAddress">
			<span>${province }-${city }</span>
			<a href="<%=request.getContextPath()%>/selectAddress.jsp">切换地址</a></div>
			<div class="search"><input type="text" value="搜索店铺和美食" name="search_box" id="search_box" onfocus="if(value=='搜索店铺和美食') {value=''}" onblur="if (value=='') {value='搜索店铺和美食'}"><input type="button" value="搜索" id="search_button"/></div>
			
			<div class="shopCategory">&nbsp;&nbsp;&nbsp;分类：&nbsp;
			<c:forEach items="${shopCategoryList }" var="shopCategory" varStatus="shopCategoryLi">
				<a href="#"  class="shopCategory_a" target="show">${shopCategory.name }</a>&nbsp;
			</c:forEach>
			</div>
		</div>
		<div id="shopShow" >
			
				<c:forEach items="${runList}" var="shop" varStatus="runli">
					<div class="shopShowDetial">
						
						<a  href="/where-web/usersManager/specificShop?id=${shop.id}"><img alt="图片加载失败" src="${shop.shopPicture.url}/${shop.shopPicture.name}.${shop.shopPicture.suffixName}" class="shop_picture"></a>
						<div class="shopName">${shop.name}</div>
					</div>
				</c:forEach>
			
		</div>
		<iframe name="show" src="<%=request.getContextPath()%>/show.jsp" style="width: 20px;height: 40px;border: 1px solid #000;"></iframe>
	</div>
</body>

</html>