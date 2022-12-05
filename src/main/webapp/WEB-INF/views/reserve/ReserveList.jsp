<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Reservations</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div id="body">	
	<div id="menu">
		<h2>My reservations</h2>
		<a href="/hotel/">HOME</a>
	</div>

	<hr> 
	<table border="1" align="center">
	<tr>
		<th>Reservation no</th>
		<th>Hotel no</th>
		<th>User ID</th>
		<th>Hotel name</th>
		<th>Checkin date</th>
		<th>Stay length</th>
		<th>Room count</th>
		<th>Rate</th>
		<th>Total fee</th>
		<th>Cancel</th>
	</tr>
		<c:forEach items="${reserveData}" var="dto">
			<tr align="right">
				<td>${dto.regno }</td>
				<td>${dto.hotelno }</td>
				<td>${dto.memid }</td>
				<td>${dto.name }</td>
				<td>${dto.rday }</td>
				<td>${dto.dday } days</td>
				<td>${dto.qty }</td>
				<td>${dto.price }</td>
				<td>${dto.total }</td>
				<td align="center">
				<button onclick="location.href='/hotel/reserve/delete?regno=${dto.regno}'">Cancel</button>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${reserveData[0] == null}">
			<tr><td colspan="10"align="center">No content yet.</td></tr>
		</c:if>
	</table>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>