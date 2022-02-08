<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bContent.jsp</title>
<script>
	function bDelCheck() {
		var pwd = myform.pwd.value;
		
		if(pwd == "") {
			alert("비밀번호를 입력해주세요");
			myform.pwd.focus();
		}
		else {
		var ans = confirm("게시글을 삭제 하기겠습니까?");
			if(ans) {
				location.href = "${ctp}/board/bDelete?pag=${pageVo.pag}&pageSize=${pageVo.pageSize}&idx=${vo.idx}&pwd="+pwd+"";
			}
			
		}
		
	}
</script>
<style>
	.a {
		text-align: center
	}
	table {
		width: 100%;
		margin: 0 auto;
	}
	tr, th, td {
		border: 1px solid;
	}
</style>
</head>
<body>
	<div style="text-align: center;">
		<tr>
			<td><h2>bContent</h2></td>
		</tr>
	</div>
	<form name="myform">
	<table>
		<tr class="a">
			<th>Title</th>
			<td>${vo.title }</td>
		</tr>
		<tr class="a">
			<th>Name</th>
			<td>${vo.name }</td>
		</tr>
		<tr class="a">
			<th>Content</th>
			<td>${vo.content }</td>
		</tr>
		<tr class="a">
			<th>Password</th>
			<td><input type="password" name="pwd"/></td>
		</tr>
	</table>
	</form>
		<div style="float: left">
			<input type="button" value="bList" onclick="location.href='${ctp}/board/bList?pag=${pageVo.pag }&pageSize=${pageVo.pageSize }';"/>
			<input type="button" value="bDelete" onclick="bDelCheck()"/>
			<input type="button" value="bUpdate" onclick="location.href='${ctp}/board/bUpdate?idx=${vo.idx }&pag=${pageVo.pag }&pageSize=${pageVo.pageSize }';"/>
			<input type="hidden" var="idx" value="${vo.idx }"/>
			<input type="hidden" var="pag" value="${pageVo.pag }"/>
			<input type="hidden" var="pageSize" value="${pageVo.pageSize }"/>
		</div>
</body>
</html>