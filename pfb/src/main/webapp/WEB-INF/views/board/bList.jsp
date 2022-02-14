<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bList.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function pageSizeCheck() {
		var pageSize = pageSize = pageForm.pageSize.value;
		location.href = "${ctp}/board/bList?pag=${pageVo.pag}&pageSize="+pageSize;
		
	}
	function ADel(idx) {
		var ans = confirm("해당 글을 삭제할까요?");
		if(!ans) {
			return false;
		}
		var query = {idx : idx};
		$.ajax({
			url : "${ctp}/board/bADelete",
			type : "get",
			data : query,
			success : function(data) {
				if(data == 1) {
					location.reload();
				}
			}
		});
	}
</script>
<style>
	.a {
		text-align: center;
	}
	table {
		width: 100%;
	}
	th, td {
		border: 1px solid;
	}
</style>
</head>
<body>
	<div style="text-align: center;">
		<tr>
			<td><h2>BList</h2></td>
		</tr>
	</div>
	<table>
		<tr>
			<td style="text-align: left; border: none;">
				<input type="button" value="Input" style="width: 50px;" onclick="location.href='${ctp}/board/bInput?pag=${pageVo.pag }&pageSize=${pageVo.pageSize }';">
			</td>
			<%-- 
			<td style="text-align: center; border: none;">
				<select name="search" method="get" action="${ctp }/board/bSearch">
					<option value="title" selected>Title</option>
					<option value="name">Name</option>
					<option value="content">Content</option>
				</select>
				<input type="text" name="searchString"/>
				<input type="hideen" name="pag" value="${pag }"/>
				<input type="hidden" name="pageSize" value="${pageSize }"/>
			</td>
			 --%>
			<td style="text-align : right; border: none;">
				<form name="pageForm">
					<select name="pageSize" onchange="pageSizeCheck()">
						<option value="5" <c:if test="${pageVo.pageSize == 5 }">selected</c:if>>5건</option>
						<option value="10" <c:if test="${pageVo.pageSize == 10 }">selected</c:if>>10건</option>
						<option value="15" <c:if test="${pageVo.pageSize == 15 }">selected</c:if>>15건</option>
						<option value="20" <c:if test="${pageVo.pageSize == 20 }">selected</c:if>>20건</option>
					</select>
				</form>
			</td>
		</tr>
	</table>
	<table>
		<tr class="a">
			<th>Number</th>
			<th>Title</th>
			<th>Name</th>
			<th>Content</th>
			<th>Admin</th>
		</tr>
		<c:set var="num" value="${pageVo.curScrNo }"/>
		<c:forEach var="vo" items="${vos }">
		<tr class="a">
			<td>${num }</td>
			<td><a href="${ctp }/board/bContent?idx=${vo.idx }&pag=${pageVo.pag}&pageSize=${pageVo.pageSize}">${vo.title }</a></td>
			<td>${vo.name }</td>
			<td>${vo.content }</td>
			<td><a href="javascript:ADel(${vo.idx })">X</a></td>
		</tr>
		<c:set var="num" value="${num-1 }"/>
		</c:forEach>
	</table>
	<div style="text-align: center;">
		<ul>
			<c:set var="startPageNum" value="${pageVo.pag - (pageVo.pag-1) % pageVo.blockSize}"/>
			<c:if test="${pageVo.pag != 1 }">
				<a href="${ctp }/board/bList?pag=1&pageSize=${pageVo.pageSize}">처음</a>
				<a href="${ctp }/board/bList?pag=${pageVo.pag-1}&pageSize=${pageVo.pageSize}">이전</a>
		    </c:if>
		    <c:forEach var="i" begin="0" end="2">
		    	<a href="${ctp }/board/bList?pag=${startPageNum+i}&pageSize=${pageVo.pageSize}">${startPageNum+i }</a>
		    </c:forEach>
		    <c:if test="${pageVo.pag != pageVo.totPage }">
		    	<a href="${ctp }/board/bList?pag=${pageVo.pag+1}&pageSize=${pageVo.pageSize}">다음</a>
		    	<a href="${ctp }/board/bList?pag=${pageVo.totPage}&pageSize=${pageVo.pageSize}">마지막</a>
		    </c:if>
		</ul>
	</div>
</body>
</html>