<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询评论</title>
<style type="text/css">
		body{
	color:#4d5255;
	}
	#comments_table {
		border:1px solid #D2D0D0;
		margin-top: 20px;
	}
	#comments_table tr th{
		border:1px solid #D2D0D0;
	}
	#comments_table #comments_tbody td{
	 text-align:center;  
	 border-top: 1px solid #D2D0D0;
	}
	
	#comments_table a{
		text-decoration:none;
		color:#35719E;
		
	}

</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function(){
		 $.ajax( {//动态加载评论
		    url : "/where-web/comments/select",
		    type : "get", 
		    dataType:"json",
		    contentType:'application/json;charset=UTF-8',
		    success : function(data) {
		    	for (var i = 0; i < data.length; i++) {
		    		var row = $("#tem").clone();
		    		row.find("#oper #oper_a1").click({id:data[i].id},deleteComments);
		    		row.find("#oper #oper_a2").click({id:data[i].id},lookComments);
		    		row.find("#id").text(data[i].id);
					row.find("#name").text(data[i].users.username); 
		    		row.find("#commentsTime").text(data[i].commentTime);
		    		row.appendTo("#comments_tbody");
				}
		    	$("#comments_tbody tr").eq(0).remove();
		    },
		error:function(e){
				window.location.href="/where-web/error.jsp";
		    }
		 });
		function operation(a){
			alert(a.data.name);
		} 
		
		function lookComments(a){
			window.location.href="/where-web/comments/lookComments?id="+a.data.id;
		/* $.ajax( {
			    url : "/where-web/goodsCategory/updateGoodsCategoryHelper",
			    type : "POST", 
			    dataType:"html",  
			    data:{"id":a.data.id,"name":a.data.name,sort:a.data.sort},
			    contentType:'application/x-www-form-urlencoded'
			 });  */
			/*  $.get("/where-web/goodsCategory/updateGoodsCategoryHelper",{"id":a.data.id,"name":a.data.name,sort:a.data.sort}); */
		}
		
		function deleteComments(a){
			 var result=confirm("你确定删除此评论吗？")
			if(result ){
			$.ajax( {
			    url : "/where-web/comments/deleteComments",
			    type : "POST", 
			    dataType:"json",
			    data:{"id":a.data.id},
			    contentType:'application/x-www-form-urlencoded',
			    success : function(data) {
			    	if(data==1){
			    		alert("该评论已被删除！");
			    		window.location.reload();
			    	}else{
			    		alert("该评论删除失败！");
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
	<div align="center"><h3>评论列表</h3></div>
	<table align="center" id="comments_table" width="680"   cellspacing="0" cellpadding="0" >
		<tr>
			<th>编号</th>
			<th>评论者</th>
			<th>评论时间</th>
			<th>操作</th>
		</tr>
		
		<tbody id="comments_tbody">
			<tr id="tem">
				<td id="id"></td>
				<td id="name"></td>
				<td id="commentsTime"></td>
				<td id="oper"><a href="#" id="oper_a1" >删除</a>&nbsp;|&nbsp;<a href="#" id="oper_a2" >查看</a></td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>