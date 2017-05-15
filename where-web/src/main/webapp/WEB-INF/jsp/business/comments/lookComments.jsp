<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看评论</title>
</head>
<body>
	<table>
		<tr>
			<th>内容</th>
			<th>评论者</th>
		</tr>
		<tr>
			<td id="content">${comments.content}</td>
			
			<td id="comments_person">${comments.users.username }</td>
		</tr>
		<tr>
			<td id="commentsTime">${comments.commentTime }</td>
			
		</tr>
	</table>
</body>
</html>