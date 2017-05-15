<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<style type="text/css">
	.invalid{
	
	color:red;
	}
</style>
<script type="text/javascript" src="../js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../js/jquery.validate.js"></script>
<script type="text/javascript" src="../js/messages_zh.js"></script>
<script type="text/javascript">
	$(function(){

		$("#updatePassword_form").validate({
			 errorClass: "invalid",
			submitHandler:function(form){
	            form.submit();
	        } ,
		  rules: {
		      oldPassword: {
		        required: true,
		       /*  minlength: 6, */
		        maxlength:12,
		        remote:{
		        	url: "/where-web/business/oldPasswordConfirm",	
		        	type:"POST",
		        	data: {					 //要传递的数据
		        		oldPassword: function() {
		        			return $("#oldPassword").val();
		        		}
		        	}
		        	
		        }
		      },
		      newPassword: {
		        required: true,
		        minlength: 6,
		        maxlength:12
		      },
		      confirmPassword: {
		        required: true,
		      /*  minlength: 6,*/
		       /* maxlength:12,*/
		        equalTo: "#newPassword"
		      }
		    },
		    messages: {
		      oldPassword: {
		        required: "请输入原密码",
		        minlength: "密码长度不能小于 6 个字母",
		        maxlength:"密码长度不能超过12个字母",
		        remote:"原密码不正确"	
		      },
		      newPassword: {
		        required: "新密码不能为空",
		        minlength: "密码长度不能小于 6 个字母",
		        maxlength:"密码长度不能超过12个字母"
		        
		      },
		      confirmPassword: {
		        required: "请输入确认密码",
		       /* minlength: "密码长度不能小于 6 个字母",*/
		        equalTo: "两次密码输入不一致"
		      }
		    }
		    
			});
	});
</script>
</head>
<body>
	<form action="/where-web/business/updatePassword" id="updatePassword_form" method="POST" name="updatePassword_form">
		<fieldset>
	    	<legend>修改密码</legend>
	    	<table align="center">
	    		<tr>
	    			<td colspan="2" align="center"><h3>修改密码</h3></td>
	    		</tr>
	    		<tr>
	    			<td>原密码</td>
	    			<td><input type="password" name="oldPassword" id="oldPassword"></td>
	    		</tr>
	    		<tr>
	    			<td>新密码</td>
	    			<td><input type="password" name="newPassword" id="newPassword">&nbsp;(新密码长度为6到12位)</td>
	    		</tr>
	    		<tr>
	    			<td>确认密码</td>
	    			<td><input type="password" name="confirmPassword" id="confirmPassword"></td>
	    		</tr>
	    		<tr>
	    			
	    			<td><input type="submit" name="submit" id="submit" value="确认修改密码"></td>
	    		</tr>
	    	</table>
	    </fieldset>
	</form>
</body>
</html>