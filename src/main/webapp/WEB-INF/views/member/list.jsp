<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div  id="body">	
	<div id="menu" style="font-weight:bold; text-align:center;">
		<h2>Member List</h2>
		<a href="/hotel/member/writeForm">Member registry</a>&nbsp;&nbsp;&nbsp;
		<a href="/hotel/member/batchForm">Batch registry</a>&nbsp;&nbsp;&nbsp;
		<a href="/hotel/">HOME</a>
	</div>

	<hr>
	<table border="1" align="center">
		<tr>
			<th>Member ID</th>
			<th>Password</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Age</th>
			<th>Profession</th>
			<th>Hobbies</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.id }</td>
				<td>${dto.pass}</td>
				<td>${dto.email}</td>
				<td>${dto.tel}</td>
				<td>${dto.age}</td>
				<td>${dto.job}</td>
				<td>${dto.hobby}</td>
				<td align="center">
				<button onclick="location.href='delete?id=${dto.id}'">Delete</button>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${list[0] == null}">
			<tr><td colspan="8"align="center">No content yet.</td></tr>
		</c:if>
	</table>
	<hr>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>