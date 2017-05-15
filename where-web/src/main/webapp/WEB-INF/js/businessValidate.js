$(function(){
	
	
	$("#form").validate({
		submitHandler:function(form){
            alert("提交事件!");   
            form.submit();
        } ,
	  rules: {
	      username: {
	        required: true,
	        minlength: 2,
	        maxlength:12,
	        remote:{
	        	url: "/where-web/business/byUsername",	
	        	type:"POST",
	        	data: {					 //要传递的数据
	        		username: function() {
	        			return $("#username").val();
	        		}
	        	}
	        	
	        }
	      },
	      password: {
	        required: true,
	        minlength: 6,
	        maxlength:12
	      },
	      confirm_password: {
	        required: true,
	      /*  minlength: 6,*/
	       /* maxlength:12,*/
	        equalTo: "#password"
	      },
	      email: {
	        email: true
	      }
	    },
	    messages: {
	      username: {
	        required: "请输入用户名",
	        minlength: "用户名必需由两个字母组成",
	        maxlength:"用户名不得超过12个字符",
	        remote:"用户名已存在"	
	      },
	      password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 6 个字母",
	        maxlength:"密码长度不能超过12个字母"
	        
	      },
	      confirm_password: {
	        required: "请输入密码",
	       /* minlength: "密码长度不能小于 6 个字母",*/
	        equalTo: "两次密码输入不一致"
	      },
	      email: "请输入一个正确的邮箱"
	    }
		});
});