<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店铺状态管理</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function(){
		$("#confirm").click(
				function(){
					if(confirm("确定修改？")){
						statusManager();
					}
					
				});
		function statusManager(){
			$.ajax( {//动态加载餐品类别
			    url : "/where-web/shop/statusManager",
			    type : "post", 
			    dataType:"json",
			    data:{"status":$("#status").val()},
			    contentType:'application/x-www-form-urlencoded',
			    success : function(data) {
			    	if(data=="1"){
			    		alert("修改成功！！");
			    	}else{
			    		alert("修改失败！！");
			    	}
			    },
			error:function(e){
					window.location.href="";
			    }
			 });
		}
			
		
	});
</script>
</head>
<body>
	<sf:form action="" id="status_form" method="POST" commandName="shop">
		 <fieldset>
	    	<legend>修改店铺营业状态</legend>
	    	<table align="center">
	    		<tr>
	    			<td>状态</td>
	    			<td>
		    			<sf:select path="status" name="status" id="status">
		    				<sf:option value="营业">营业</sf:option>
			    			<sf:option value="休息">休息</sf:option>
		    			</sf:select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td></td>
	    		</tr>
	    		<tr>
	    			<td><input type="button" value="确定" id="confirm"/></td>
	    		</tr>
	    	</table>
	    </fieldset>
	</sf:form>
</body>
</html>