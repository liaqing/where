<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认下单</title>
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
	#biaoqian div{
		width:190px;
		height:40px;
		float: left;
		padding-left: 10px;
		padding-top:10px;
		text-align: center;
	}
	#goods_show{
		padding:10px;
		width:1015px;
		height:auto;
		background-color: #ffffff;
		display:inline-block !important; display:inline;
	}
	#goods_show div{
		width:190px;
		height:40px;
		float: left;
		/* padding-left: 10px;
		padding-top:10px; */
		text-align: center;
	}
	
	#count{
	text-align: center;
	}
	#num{
	width: 40px;
	text-align: center;
	}
	#reduce{
	background-color: #ffffff;
	}
	#add{
	background-color: #ffffff;
	}
	#deliveryMessageName{
		width:1015px;
		height: 40px;
		float: left;
		margin-top: 20px;
		background-color:#ffffff;
		border:1px solid #e1e1e1;
		padding-top: 20px;
		padding-left: 20px;
	}
	#heji{
		width:1035px;
		height: 40px;
		float: left;
		text-align: right;
	}
	
	#totalPrice{
		border: none;
		width:40px;
	}
	#deliveryMessage div{
	width:1015px;
	height:50px;
	background-color: #ffffff;
	float: left;
	padding-left: 20px;
	padding-top: 20px;
	}
	#confirm{
		width:1035px;
		height: 50px;
		text-align: center;
		background-color: #ffffff;
		float: left;
		margin-top: 20px;
		padding-top: 20px;
	}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
	$(function(){
		
		var i = $("#num").val();
		var xiao=$("#xiao").text();
		var totalPrice=$("#totalPrice").val();
		 
	       $("#add").click(function () {
	           i++;
	           $("#num").attr("value", i);
	           $("#totalPrice").attr("value", accMul(xiao,i));
	           $("#xiao").text(accMul(xiao,i));
	       }),
	        $("#reduce").click(function (){
	            i--;
	        $("#num").attr("value", i);
	         if (i < 1) {
	        $("#num").attr("value", 1);
	             i = 1;
	            };
	            $("#xiao").text(accMul(xiao,i));
	            $("#totalPrice").attr("value", accMul(xiao,i));
	        })
	        $("#delete").click(function(){
	        	alert("dddddddddd");
	        	$("#goods_show").hide();
	        });
	       function accMul(arg1,arg2)
	       {
	         var m=0,s1=arg1.toString(),s2=arg2.toString();
	         try{m+=s1.split(".")[1].length}catch(e){}
	         try{m+=s2.split(".")[1].length}catch(e){}
	         return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
	       }
 
	});
</script>
</head>
<body style="height: 2000px; background-color: #F5F5F5">
<form action="/where-web/usersManager/confirmOrders?goodsId=${goods.id }" name="" method="POST">
	<div class="container">
		<div class="search_top">
			<div class="changeAddress">
			<span>${province }-${city }</span>
			<a href="<%=request.getContextPath()%>/selectAddress.jsp">切换地址</a></div>
			<div class="search"><input type="text" value="搜索店铺和美食" name="search_box" id="search_box" onfocus="if(value=='搜索店铺和美食') {value=''}" onblur="if (value=='') {value='搜索店铺和美食'}"><input type="button" value="搜索" id="search_button"/></div>
		</div>
		<div id="spe"></div>
		<div id="biaoqian"><div >商品</div> <div>单价</div><div>数量</div><div >小计</div><div>操作</div></div>
		<div id="goods_show">
			<div>${goods.name }</div><div>${goods.price }</div>
			
			<div id="count">
				<input class="input3 bor-e3 ml-8" id="reduce" type="button" value="-">
				<input class="input2 text-c" id="num" type="text" value="1" name="GoodsCount" disabled>
				<input class="input4 bor-e3" id="add" type="button" value="+">
			</div><div id="xiao">${goods.price }</div><div><a href="#" id="delete">删除</a></div>
		</div>
		<div id="heji">
			总计 : <input type="text" name="totalPrice" id="totalPrice" value="${goods.price }">&nbsp;元&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div id="deliveryMessageName">
		送餐信息
		</div>
		<div id="deliveryMessage">
			<div class="delivery_person">
				<span style="color: red">*</span><span >联系人 :</span>
				<input type="text" name="consigneeName"><span></span>
			</div>
			<div class="street_address">
				<span style="color: red">*</span><span>送餐地址 :</span>
				<input type="text" name="streetAddress"><span style="color: red"> (如小区须填写具体门牌号、网吧必须填写几号机、否则无法送餐。)</span>
			</div>
			<div class="phone">
				<span style="color: red">*</span><span >联系电话 :</span>
				<input type="text" name="phone"><span style="color: red">(请确认手机号码无误，并保持手机畅通，否则可能导致无法送餐。)</span>
			</div>
			<div class="remarks">
				<span>备注 :</span>
				<textarea rows="1" cols="40" name="remarks"></textarea>
			</div>
			
		</div>
		
		<div id="confirm">
				<input type="submit" name="submit" value="确认下单">
		</div>
	</div>
</form>
</body>
</html>