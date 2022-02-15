<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bLogin.jsp</title>
<script>
	function fCheck() {
		var mid = myform.mid.value;
		var pwd = myform.pwd.value;
		
		if(mid == "") {
			alert("아이디를 입력하세요.");
			myform.mid.focus();
		}
		else if(pwd == "") {
			alert("비밀번호를 입력하세요.");
			myform.pwd.focus();
		}
		else {
			myform.submit();
		}
	}
</script>
<style>
	table {
		width: 100%;
		maring: 0 auto;
	}
	.a {
		text-align: center;
	}
	th, td {
		border : 1px solid;
	}
	th {
		width: 50px
	}
</style>
</head>
<body>
	<div style="text-align:center";>
		<tr>
			<td><h2>Admin login</h2></td>
		</tr>
	</div>
	<form name="myform" method="post">
		<table>
			<tr class="a">
				<th>ID</th>
				<td><input type="text" name="mid"/></td>
			</tr>
			<tr class="a">
				<th >PW</th>
				<td><input type="password" name="pwd"/></td>
			</tr>
		</table>
		<div style="float: left;">
				<input type="button" value="Login" onclick="fCheck()"/>
		</div>
	</form>
</body>
</html>