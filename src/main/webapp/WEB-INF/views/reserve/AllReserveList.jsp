<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Reservations</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div id="body">		
	<div id="menu">
		<h2>All Reservations List</h2>
		<a href="/hotel/">HOME</a>
	</div>
	
	<hr> 
	<table border="1" align="center">
		<tr>
			<th>Reserve no</th>
			<th>Reserver ID</th>
			<th>Hotel image</th><th>Hotel name</th><th>Checkin date</th>
			<th>Stay duration</th><th>Room count</th>
			<th>Stay rate</th><th>Total cost</th>
			<th>Cancel</th>
		</tr>
		<c:forEach items="${allData}" var="dto">
			<tr align="right">
				<td>${dto.regno }</td>
				<td>${dto.memid }</td>
				<td>${dto.img }</td>
				<td>${dto.name }</td>
				<td>${dto.rday }</td>
				<td>${dto.dday }</td>
				<td>${dto.qty }</td>
				<td>${dto.price }</td>
				<td>${dto.total }</td>
				<td align="center">
				<button onclick="location.href='/hotel/reserve/delete2?regno=${dto.regno}'">Cancel</button>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${allData[0] == null}">
			<tr><td colspan="10"align="center">No content yet.</td></tr>
		</c:if>
	</table>
	</div>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>