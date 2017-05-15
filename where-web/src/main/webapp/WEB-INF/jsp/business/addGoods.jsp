<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加餐品</title>
<style type="text/css">
	.red{
	color:#f00
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax( {//动态加载餐品类别
		    url : "/where-web/goodsCategory/select",
		    type : "get", 
		    dataType:"json",
		    contentType:'application/json;charset=UTF-8',
		    success : function(data) {
		    	$("#goods_category").html("");
		    	for (var i = 0; i < data.length; i++) {
		    		$("#goods_category").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>");
		    		/* //alert(data[i].id); */
				}
		      /*  $.each(data,function(goodsCategory){
		    	   $("#goods_category").append("<option value='"+goodsCategory.name+"'>"+goodsCategory.name+"</option>");
		       }); */
		    },
		error:function(e){
				window.location.href="";
		    }
		 });
		
		
		
	});
</script>
</head>
<body>
	<sf:form action="/where-web/goods/addGoods" method="post" name="goods_category_form" commandName="goods">
		 <fieldset>
	    	<legend>添加餐品</legend>
	    	<table align="center">
	    		<tr>
				<td colspan="2" align="center"><h2>添加餐品</h2></td>
				</tr>
				<tr>
					<td align="right">餐品名</td>
					<td ><sf:input path="name"  name="name" id="name"  /></td>
					<td>&nbsp;(名字长度不能超过十个字)<sf:errors path="name" cssClass="red"/></td>
				</tr>
				<tr>
					<td align="right"> 所属类别</td>
					<td><sf:select path="goodsCategory.id"   id="goods_category" style="width: 145px"></sf:select><sf:errors path="goodsCategory" cssClass="red"/></td>
					
				</tr>
				<tr>
					<td align="right">图片</td>
					<td></td>
				</tr>
				<tr>
					<td align="right">价格</td>
					<td><sf:input  path="price" name="price" id="price"/></td>
					<td>&nbsp;(价格范围在0到999.99精确两位小数)<sf:errors path="price" cssClass="red"/></td>
				</tr>
				<tr>
					<td align="right">排序</td>
					<td><sf:input path="sort" name="sort" id="sort"/></td>
					<td>&nbsp;(为0到999,99的整数)<sf:errors path="sort" cssClass="red"/></td>
				</tr>
				<tr>
					<td align="right">库存</td>
					<td><sf:input path="repertory" name="repertory" id="repertory"/><sf:errors path="repertory" cssClass="red"/></td>
				</tr>
				<tr>
				<td colspan="2" align="center"><input type="submit" value="确定"/></td>
				</tr>
	    	
	    	</table>
		</fieldset>
	</sf:form>
</body>
</html>