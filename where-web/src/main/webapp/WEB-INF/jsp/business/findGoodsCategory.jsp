<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询餐品类别</title>
<style type="text/css">
	body{
		color:#4d5255;
	}
	
	#goodsCategory_table {
		border:1px solid #D2D0D0;
	}
	#goodsCategory_table tr th{
		border:1px solid #D2D0D0;
	}
	#goodsCategory_table #goodsCategory_tbody td{
	 text-align:center;  
	 border-top: 1px solid #D2D0D0;
	}
	
	#goodsCategory_table a{
		text-decoration:none;
		color:#35719E;
		
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
		    	for (var i = 0; i < data.length; i++) {
		    		var row = $("#tem3").clone();
		    		row.find("#oper #oper_a1").click({id: data[i].id},deleteGoodsCategory);
		    		row.find("#oper #oper_a2").click({id: data[i].id,name: data[i].name,sort: data[i].sort},updateGoodsCategory);
					row.find("#name").text(data[i].name); 
		    		row.find("#sort").text(data[i].sort);
		    		row.appendTo("#goodsCategory_tbody");
				}
		    	$("#goodsCategory_tbody tr").eq(0).remove();
		    },
		error:function(e){
				window.location.href="";
		    }
		 });
		function operation(a){
			alert(a.data.name);
		}
		
		function updateGoodsCategory(a){
			window.location.href="/where-web/goodsCategory/updateGoodsCategoryHelper?id="+a.data.id+"&name="+a.data.name+"&sort="+a.data.sort;
		/* $.ajax( {
			    url : "/where-web/goodsCategory/updateGoodsCategoryHelper",
			    type : "POST", 
			    dataType:"html",  
			    data:{"id":a.data.id,"name":a.data.name,sort:a.data.sort},
			    contentType:'application/x-www-form-urlencoded'
			 });  */
			/*  $.get("/where-web/goodsCategory/updateGoodsCategoryHelper",{"id":a.data.id,"name":a.data.name,sort:a.data.sort}); */
		}
		
		function deleteGoodsCategory(a){
			 var result=confirm("你确定删除此餐品类别吗？")
			if(result ){
			$.ajax( {
			    url : "/where-web/goodsCategory/delete",
			    type : "POST", 
			    dataType:"json",
			    data:{"id":a.data.id},
			    contentType:'application/x-www-form-urlencoded',
			    success : function(data) {
			    	if(data==1){
			    		alert("该餐品类别已被删除！");
			    		window.location.reload();
			    	}else{
			    		alert("该餐品类别删除失败！");
			    	}
			    	
			    },
			error:function(e){
					window.location.href="";
			    }
			 });
		 	} 
			
		}
		
	});
</script>
</head>
<body>
	<table align="center" id="goodsCategory_table" width="680"   cellspacing="0" cellpadding="0" >
		<tr id="tem2">
			<th>类别名称</th>
			<th>排序</th>	
			<th>操作</th>		
		</tr>
		<tbody id="goodsCategory_tbody">
			<tr id="tem3" >
				<td id="name"></td>
				<td id="sort"></td>
				<td id="oper"><a href="#" id="oper_a1" >删除</a>&nbsp;|&nbsp;<a href="#" id="oper_a2" >修改</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>