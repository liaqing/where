<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>餐品列表</title>
<style type="text/css">
	body{
	color:#4d5255;
	}
	#goods_table {
		border:1px solid #D2D0D0;
	}
	#goods_table tr th{
		border:1px solid #D2D0D0;
	}
	#goods_table #goods_tbody td{
	 text-align:center;  
	 border-top: 1px solid #D2D0D0;
	}
	
	#goods_table a{
		text-decoration:none;
		color:#35719E;
		
	}
	
	#fenYe a{
		text-decoration:none;
		border:1px solid #cccccc;
		color:#4d5255;
		margin-right:5px;
		margin: 3px 2px 0 0 ;
		padding: 4px 5px 0;
	}
	
	#fenYe #a_current{
		border:none;
		color:red;
	}
	
	.recordcss{
		color:red;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
$(function(){
	var pageNo=1;
	var totalPage;
	var predisabled="";
	var nextdisabled="";
	findGoods(pageNo);
	$("#select").click(function(){
		$.ajax( {//按名字查询餐品
		    url : "/where-web/goods/selectByName",
		    type : "POST", 
		    dataType:"json",
		    data:{"name":$("#goodsName").val()},
		    contentType:"application/x-www-form-urlencoded",  /* 当后台用@RequestParam就收数据时，contentType必须用“application/x-www-form-urlencoded” 
		                                                                                                   。。参考博客http://www.cnblogs.com/frankhong/articles/5253849.html*/
		    success : function(data) {
		    	$("#goods_tbody").html("");
		    	for (var i = 0; i < data.length; i++) {
		    		$("#goods_tbody").append("<tr><td>"+data[i].name+"</td><td>"+data[i].goodsCategory.name+"</td><td>"+data[i].price+"</td><td><a class='a_table_delete' href='/where-web/goods/deleteGoods?id="+data[i].id+"&name="+data[i].name+"'>删除</a> &nbsp|&nbsp&nbsp<a class='a_table_update' href='/where-web/goods/updateGoodsHelper?id="+data[i].id+"'>修改</a>"+"</td></tr>");
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
	
	
	
 	/* $("#a_table_delete").click(function(){
		alert("sssssssssss");
		if(confirm("您确定删除此餐品？")){
			$.ajax( {//删除餐品
			    url : "/where-web/goods/deleteGoods",
			    type : "POST", 
			    dataType:"json",
			    data:{"id":$(this).attr("name")},
			    contentType:"application/x-www-form-urlencoded", 
			    success : function(data) {
			    	if("1".equals(data)){
			    		confirm("操作成功");
			    		window.location.reload();
			    	}else{
			    		confirm("操作失败");
			    	}
			    },
			error:function(e){
					window.location.href="";
			    }
			 });
		}
	});  */
	
/* 此方法本来用来实现餐品的删除功能，由于不能得到哪个a标签被点击，被放弃
$('#goods_tbody').on('click','#a_table_delete',function(){
		
	   a_table_delete();
	});
	
	function a_table_delete(){
		if(confirm("您确定删除此餐品？")){
			$.ajax( {//删除餐品
			    url : "/where-web/goods/deleteGoods",
			    type : "POST", 
			    dataType:"json",
			    data:{"id":1},
			    contentType:"application/x-www-form-urlencoded",  
			                                                                                                 
			    success : function(data) {
			    	if("1"==data){
			    		confirm("操作成功");
			    		window.location.reload();
			    	}else{
			    		confirm("操作失败");
			    	}
			    },
			error:function(e){
					window.location.href="";
			    }
			 });
		}
	} */
	  $("#goodsName").keydown(function(event) {
	         if (event.keyCode == 13) { 
	        	 $.ajax( {//按名字查询餐品
	     		    url : "/where-web/goods/selectByName",
	     		    type : "POST", 
	     		    dataType:"json",
	     		    data:{"name":$(this).val()},
	     		    contentType:"application/x-www-form-urlencoded",  /* 当后台用@RequestParam就收数据时，contentType必须用“application/x-www-form-urlencoded” 
	     		                                                                                                   。。参考博客http://www.cnblogs.com/frankhong/articles/5253849.html*/
	     		    success : function(data) {
	     		    	$("#goods_tbody").html("");
	     		    	$("#fenYe").html("");
	     		    	for (var i = 0; i < data.length; i++) {
	     		    		$("#goods_tbody").append("<tr><td>"+data[i].name+"</td><td>"+data[i].goodsCategory.name+"</td><td>"+data[i].price+"</td><td><a class='a_table_delete' href='/where-web/goods/deleteGoods?id="+data[i].id+"&name="+data[i].name+"'>删除</a> &nbsp|&nbsp&nbsp<a class='a_table_update' href='/where-web/goods/updateGoodsHelper?id="+data[i].id+"'>修改</a>"+"</td></tr>");
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
	         }  
	     }) ; 
	
	function getFirstPage(){
		pageNo=1;
		isPreable();
		isBackable();
		findGoods(pageNo);
	}
	
	function getPrePage(){
		if(pageNo>1){
			pageNo=pageNo-1;
		}
		pageNo=1;
		isPreable();
		isBackable();
		findGoods(pageNo);
	}
	
	function getnextPage(){
		if(pageNo<totalPage){
			pageNo=pageNo+1;
		}
		pageNo=totalPage;
		isPreable();
		isBackable();
		findGoods(pageNo);
	}
	
	 function  getLastPage(){
		pageNo= totalPage;
		isPreable();
		isBackable();
		findGoods(pageNo);
	}
	
		/* //判断‘首页’及‘前页’是否可用 */
		function isPreable(){
			if(pageNo == 1)
				predisabled= "disabled";
			predisabled= "";
		}
		
		/* //判断‘尾页’及‘下页’是否可用 */
		function isBackable(){
			if(pageNo == totalPage)
				nextdisabled= "disabled";
			nextdisabled= "";
		}
		
	 
	function findGoods(pagenumber){
		
		$.ajax( {//动态加载餐品
		    url : "/where-web/goods/find",
		    type : "post", 
		    dataType:"json",
		    contentType:'application/x-www-form-urlencoded',
		    data:{'pageNo':pagenumber},
		    success : function(data) {
		    	totalPage=data.totalPage; 
		    	$("#goods_tbody").html("");
		    	for (var i = 0; i < data.list.length; i++) {
		    		$("#goods_tbody").append("<tr><td>"+data.list[i].name+"</td><td>"+data.list[i].goodsCategory.name+"</td><td>"+data.list[i].price+"</td><td><a id='a_table_delete' href='/where-web/goods/deleteGoods?id="+data.list[i].id+"&name="+data.list[i].name+"' >删除</a> &nbsp|&nbsp&nbsp<a class='a_table_update' href='/where-web/goods/updateGoodsHelper?id="+data.list[i].id+"'>修改</a>"+"</td></tr>");
				}
		    	 if(data.totalPage>=2){
		    		 $("#fenYe").html("");
		    		var resultHtml="<div >共有记录<span class='recordcss'>"+data.totalNum+"</span>条&nbsp当前为<span class='recordcss'>"+data.pageNo+"</span>/<span class='recordcss'>"+data.totalPage+"</span>页</div>"+
	    			"<div ><a id='first' href='#' disabled='"+predisabled+"' ><<</a><a id='previous' href='#' disabled='"+predisabled+"' ><</a>";
	    			
		    	 for (var i = 1; i <= data.totalPage; i++) {
		    			 if(data.pageNo==i){
		    				 resultHtml=resultHtml+"<a id='a_current' href='#' disabled='disabled'" ;
		    			}else{
		    				 resultHtml=resultHtml+"<a id='a_other' href='javascript:void(0)'";	
		    			}
		    			 resultHtml=resultHtml+">"+i+"</a>"; 
		    		 } 
		    		resultHtml=resultHtml+"<a id='next' href='#' disabled='"+nextdisabled+"' >></a><a id='end' href='#' disabled='"+nextdisabled+"'>>></a></div>";
		    		$("#fenYe").append(resultHtml);  
		   	 	}
		    },
		error:function(e){
				window.location.href="";
		    }
		 });
		
	}
	
	
	$("#fenYe").on('click','#first',function(){
		getFirstPage();
	})
	$("#fenYe").on('click','#previous',function(){
		getPrePage();
	})
	$("#fenYe").on('click','#next',function(){
		getnextPage();
	})
	$("#fenYe").on('click','#end',function(){
		getLastPage();
	})
	
	
});
</script>
</head>
<body>

	<div style="margin-top: 20px">
		餐品名称<input type="text" name="goodsName" id="goodsName"/><input type="button" value="查询" name="select" id="select" /><br/><hr style="border:0;background-color:#D2D0D0;height:1px;" /><br/>
	</div>
		<table id="goods_table" width="680"   cellspacing="0" cellpadding="0" align="center">
			<tr>
				<th>餐品名称</th>
				<th>类别</th>
				<th>价格</th>
				<th>操作</th>
			</tr>
			<tbody id="goods_tbody">
			</tbody>
		</table>
		
		<div id="fenYe"></div>
</body>
</html>