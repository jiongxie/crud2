<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bUpdate.jsp</title>
<script>

function bUpdate(){
	var title = myform.title.value;
	var name = myform.name.value;
	var content = myform.content.value;
	var pwd = myform.pwd.value;
	
	if(title == "") {
		alert("제목을 입력하세요.");
		myform.title.focus();
	}
	else if(name == "") {
		alert("이름을 입력하세요.");
		myform.name.focus();
	}
	else if(content == "") {
		alert("내용을 입력하세요.");
		myform.content.value;
	}
	else if(pwd == "") {
		alert("비밀번호르 입력하세요.");
		myform.pwd.value;
	}
	else {
		myform.submit();
	}
		
}
	
</script>
<style>
	.a {
		text-align: center;
	}
	table {
		width: 100%;
		margin: 0 auto;
	}
	th, td {
		border: 1px solid;
	}
</style>
</head>
<body>
	<div style="text-align: center;">
		<tr>
			<td><h2>bUpdate.jsp</h2></td>
		</tr>
	</div>
	<form name="myform" method="post">
	<table>
		<tr class="a">
			<th>Title</th>
			<td><input type="text" name="title" value="${vo.title }"/></td>
		</tr>
		<tr class="a">
			<th>Name</th>
			<td><input type="text" name="name" value="${vo.name }"/></td>
		</tr>
		<tr class="a">
			<th>Content</th>
			<td><textarea name="content" cols="100px" rows="10px">${vo.content }</textarea></td>
		</tr>
		<tr class="a">
			<th>Password</th>
			<td><input type="password" name="pwd"></td>
		</tr>
	</table>
	<div style="float: left;">
		<input type="button" value="bUpdate" onclick="bUpdate()" />
		<input type="button" value="bContent" onclick="location.href='${ctp}/board/bContent?idx=${vo.idx }';" />
		<input type="hidden" var="idx" value="${vo.idx }"/>
		<input type="hidden" var="pwd" value=""+pwd+""/>
	</div>
	</form>
</body>
</html>