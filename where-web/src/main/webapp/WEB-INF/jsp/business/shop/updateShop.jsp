<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
     <%@ page language="java" import="java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改店铺资料</title>

<style type="text/css">
	#shopCategory{
	width: 30px;
	
	}
	#upLoad_tr{
	display: none;
	}
	#picture{
	width: 150px;
	height: 100px;
	}
	
	#table td{
	height: 40px;
	}
	
	#specificAddress{
	width: 490px;
	}
</style>
 <link href="<%=request.getContextPath()%>/css/business/map.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/js/map.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/business/js/area.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?ak=f3SnqSzsbeIw9M9ob1U8R5Rb&v=4.0&services=false"></script>
<script type="text/javascript">
$(function(){
	
	
	$("#fileUpLoad").click(function(){
		$("#upLoad_tr").css("display","block");
	});
	
	$("#upLoad_button").click(function(){
		upFile();
	});
	
	function upFile(){
		  var formData = new FormData($("#shop_form")[0]);
		/* var formData = new FormData();
		var name = $("#upPicture").val();
		formData.append("file",$("#upPicture")[0].files[0]);
		formData.append("name",name); */
		$.ajax({ 
		url : "/where-web/shop/fileUpLoad", 
		type : 'POST', 
		data : formData, 
		// 告诉jQuery不要去处理发送的数据
		processData : false, 
		// 告诉jQuery不要去设置Content-Type请求头
		contentType : false,
		beforeSend:function(){
		console.log("正在进行，请稍候");
		},
		success : function(responseStr) { 
			if(responseStr=="0"){
				alert("文件不得大于10M！！");
			}
			if(responseStr=="4"){
				alert("文件上传成功！！");
				window.location.reload();
			}
			
		}, 
		error : function(responseStr) { 
		console.log("error");
		} 
		});
	}
	
	
	
	
/* 	 //异步调用百度js  
    function map_load() {
        var load = document.createElement("script");
        load.src = "http://api.map.baidu.com/api?v=1.4&callback=map_init";
        document.body.appendChild(load);
    }
    window.onload = map_load;


    //根据经纬度显示地区
    function loadPlace(longitude, latitude, level) {
        if (parseFloat(longitude) > 0 || parseFloat(latitude) > 0) {
            level = level || 13;
            //绘制地图
            var map = new BMap.Map("map"); // 创建Map实例  
            var point = new BMap.Point(longitude, latitude); //地图中心点 
            map.centerAndZoom(point, level); // 初始化地图,设置中心点坐标和地图级别。  
            map.enableScrollWheelZoom(true); //启用滚轮放大缩小  
            //向地图中添加缩放控件  
            var ctrlNav = new window.BMap.NavigationControl({
                anchor: BMAP_ANCHOR_TOP_LEFT,
                type: BMAP_NAVIGATION_CONTROL_LARGE
            });
            map.addControl(ctrlNav);

            //向地图中添加缩略图控件  
            var ctrlOve = new window.BMap.OverviewMapControl({
                anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
                isOpen: 1
            });
            map.addControl(ctrlOve);

            //向地图中添加比例尺控件  
            var ctrlSca = new window.BMap.ScaleControl({
                anchor: BMAP_ANCHOR_BOTTOM_LEFT
            });
            map.addControl(ctrlSca);

       }
    }  */
    
    
    var map = new BMap.Map("container");
    var point = new BMap.Point(113.416982,23.178147);
    map.centerAndZoom(point,18);
   //添加鼠标滚动缩放
   map.enableScrollWheelZoom();
    //添加缩略图控件
   map.addControl(new BMap.OverviewMapControl({isOpen:false,anchor:BMAP_ANCHOR_BOTTOM_RIGHT}));
    //添加缩放平移控件
   map.addControl(new BMap.NavigationControl());
   //添加比例尺控件
   map.addControl(new BMap.ScaleControl());
    //添加地图类型控件
    map.addControl(new BMap.MapTypeControl());
    
    //设置标注的图标
    var icon = new BMap.Icon("<%=request.getContextPath()%>/image/mapLabel.png",new BMap.Size(100,100));
    //设置标注的经纬度
    var marker = new BMap.Marker(new BMap.Point(113.416982,23.178147),{icon:icon});
    //把标注添加到地图上
    map.addOverlay(marker);
    var content = "<table>";  
       content = content + "<tr><td> 编号：001</td></tr>";  
        content = content + "<tr><td> 地点：广州</td></tr>"; 
       content = content + "<tr><td> 时间：2016-12-07</td></tr>";  
        content += "</table>";
    var infowindow = new BMap.InfoWindow(content);
   marker.addEventListener("click",function(){
        this.openInfoWindow(infowindow);
    });
    
    //点击地图，获取经纬度坐标
   map.addEventListener("click",function(e){
       document.getElementById("aa").innerHTML = "经度坐标："+e.point.lng+" &nbsp;纬度坐标："+e.point.lat;
       if(confirm("你确定是该地址吗？")){
       	alert("完成添加！！");
       }
    });
   
    //关键字搜索
    function search(){
       var keyword = document.getElementById("keyword").value;
       var local = new BMap.LocalSearch(map, {
        renderOptions:{map: map}
   });
    local.search(keyword);
    }
	
});
</script>

</head>
<body>
	<sf:form action="" method="POST" id="shop_form" commandName="shop" enctype="multipart/form-data">
		 <fieldset>
	    	<legend>修改店铺信息</legend>
	    	<table align="center" id="table">
	    		<tr>
	    			<td>店铺名</td>
	    			<td><sf:input path="name" name="name"/>&nbsp;(名字长度不能超过十个字)<sf:errors path="name" cssClass="red"/></td>
	    			
	    		</tr>
	    		
	    		<tr>
	    			<td>状态</td>
	    			<td>
	    				<sf:select path="status" name="status">
		    				<sf:option value="营业">营业</sf:option>
		    				<sf:option value="休息">休息</sf:option>
		    			</sf:select> 
		    		</td>
	    		</tr>
	    		<tr>
	    			<td>分类</td>
	    			<td id="shopCategory">
	    			 	<sf:checkboxes path="list" items="${shopCategoryListName}" name=""/>   
		    		</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>图片</td>
	    			<td><img alt="店铺图片加载失败！" src="/where-web/image/201705130545311.JPG?date=<%= new java.util.Date() %>" id="picture"></td>
	    		</tr>
	    		
	    		
	    		<tr>
	    			<td>图片</td>
	    			<td><img alt="店铺图片加载失败！" src="${shopPicture.url }/${shopPicture.name}.${shopPicture.suffixName}?date=<%= new java.util.Date() %>" id="picture"></td>
	    		</tr>
	    		
	    		
	    		
	    		
	    		<tr>
	    			<td><input type="button" value="上传"  id="fileUpLoad"/></td>
	    		</tr>
	    		<tr  id="upLoad_tr" >
	    		
	    			<td colspan="3" rowspan="2">
	    			<div>
	    				<fieldset style="width: 300px">
	    					<legend>上传图片</legend>
	    					<input type="file" name="fileUpLoad" id="upPicture" /><input type="button" value="上传" id="upLoad_button"/>
	    				</fieldset>
	    				</div>
	    			</td>
	    		</tr>
	    		
	    		<tr>
	    			<td>地址</td>
	    			<td id="address">
	    			 	<sf:select path="province" name="province">
	    			 		<sf:option value="${province}">${areaProvince }</sf:option>
	    			 	</sf:select>
	    			 	<sf:select path="city" name="city">
	    			 		<sf:option value="${city}">${areaCity }</sf:option>
	    			 	</sf:select>
	    			 	<sf:select path="county" name="county">
	    			 		<sf:option value="${county}">${areaCounty }</sf:option>
	    			 	</sf:select>
		    		</td>
	    		</tr>
	    		<tr>
	    			<td>具体地址</td>
	    			<td><sf:textarea path="specificAddress" name="specificAddress" id="specificAddress" /></td>
	    		</tr>
	    		<tr>
	    			<td>地图定位</td>
	    			<td id="">
	    			 	<div id="container" style="width:500px;height:350px;border:0px solid gray"></div>
		    		</td>
	    		</tr>
	    		
	    	</table>
	    		
	    </fieldset>
	</sf:form>
</body>
</html>