<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
<div id="top">
	<div id="topIntro">
		<span id="logo" >到哪儿了外卖商家后台管理</span>
		<span id="user_operator">
			<a href="<%=request.getContextPath()%>/index"  target="_blank">网站首页</a>
			|<a href="<%=request.getContextPath()%>/business/selectBusiness"  target="content">查询个人信息</a>
			| <a href="<%=request.getContextPath()%>/shop/updateBusinessHelper"  target="content">修改个人信息</a>
			| <a href="<%=request.getContextPath()%>/business/updatePasswordHelper"  target="content">修改密码</a>
			| <a href="<%=request.getContextPath()%>/logout" target="_top">退出系统</a>
		</span>
	</div>
	<div id="remind">
		<span id="showDate">欢迎[${business.username }]使用到哪儿了外卖商家后台管理。
		</span>
	</div>
</div>
