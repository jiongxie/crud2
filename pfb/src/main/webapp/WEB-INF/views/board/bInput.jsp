<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
 function fCheck() {
	 var title = myform.title.value;
	 var name = myform.name.value;
	 var content = myform.content.value;
	 var pwd = myform.pwd.value;
	 var file = myform.file.value;
	 var maxSize = 1024 * 1024 * 10;
	 var fileSize = document.getElementById("file").files[0].size;
	 
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
		 myform.content.focus();
	 }
	 else if(pwd == ""){
		 alert("비밀번호를 입력하세요.");
		 myform.pwd.focus();
	 }
	 else if(fileSize > maxSize) {
		 alert("업로드할 파일의 최대용량은 10MByte 이내입니다.");
		 return false;
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
	<div style="text-align:center;">
		<tr>
			<td><h2>bInput</h2></td>
		</tr>
	</div>
	<form name="myform" method="post" enctype="multipart/form-data">
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
				<td><textarea name="content" rows="30px" cols="200px"></textarea></td>
			</tr>
			<tr class="a">
				<th>File</th>
				<td><input multiple="multiple" type="file" name="file" id="file" accept=".jpg, .png"/></td>
			</tr>
			<tr class="a">
				<th>Password</th>
				<td><input type="password" name="pwd"/></td>
			</tr>
		</table>
		<div style="float:left">
			<input type="button" value="Input" onclick="fCheck()"/>
			<input type="button" value="bList" onclick="location.href='${ctp}/board/bList?pag=${pageVo.pag}&pageSize=${pageVo.pageSize}';"/>
			<input type="hidden" var="pag" value="${paegVo.pag }"/>
			<input type="hidden" var="pageSize" value="${pageVo.pageSize }"/>
		</div> 
	</form>
</body>
</html>