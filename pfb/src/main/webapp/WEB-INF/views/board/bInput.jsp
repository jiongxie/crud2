<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
</script>
<style>
	.a {
		text-align: center;
	}
	table {
		width: 100%;
		margin: o auto;
	}
	th, td {
		border: 1px solid;
	}
	th {
		width: 100px;
	}
</style>
<title>bInput</title>
</head>
<body>
	<div style="test-align:center;">
		<tr>
			<td><h2>bInput</h2></td>
		</tr>
	</div>
	<form name="myfrom" method="post">
		<table>
			<tr class="a">
				<th>Title</th>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr class="a">
				<th>Name</th>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr class="a">
				<th>Content</th>
				<td><textarea name="contnet" rows="30px" cols="200px"></textarea></td>
			</tr>
			<tr class="a">
				<th>Password</th>
				<td><input type type="password" name="pwd"/></td>
			</tr>
		</table>
		<div style="float:left">
			<input type="button" value="Input" onclick="fCheck()"/>
			<input type="button" value="bList" onclick="location.href='${ctp}/board/bList?pag=${pageVo.pag}&pageSize=${pageVo.pageSize}';"/>
		</div> 
	</form>
</body>
</html>