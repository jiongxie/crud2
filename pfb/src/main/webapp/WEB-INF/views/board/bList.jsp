<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bList.jsp</title>
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
	<div style="float:left;">
		<input type="button" value="Input" style="width: 50px;" onclick="location.href='${ctp}/board/bInput?pag=${pageVo.pag }&pageSize=${pageVo.pageSize }';">
	</div>
	<table>
		<tr class="a">
			<th>Number</th>
			<th>Title</th>
			<th>Name</th>
			<th>Content</th>
		</tr>
		<c:set var="num" value="${pageVo.curScrNo }"/>
		<c:forEach var="vo" items="${vos }">
		<tr class="a">
			<td>${num }</td>
			<td><a href="${ctp }/board/bContent?idx=${vo.idx }&pag=${pageVo.pag}&pageSize=${pageVo.pageSize}">${vo.title }</a></td>
			<td>${vo.name }</td>
			<td>${vo.content }</td>
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