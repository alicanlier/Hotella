<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.vision.hotel.model.Hotel"%>
<%@page import="java.util.List"%>
<%@page import="org.vision.hotel.model.HotelDao"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="mystyle.css">
<title>Hotel Search</title>
<Style>
	.grid-container {
		display: grid;
		grid-template-columns: 20% 20% 20%;
		background-color: white;
		padding-bottom: 20px;
		gap: 10px 10px;
		width: 90%;
		margin: auto;
		justify-content: center;
		align-content: center;
	}
	
	.grid-item {
		display: block;
		background-color: white;
		border: none;;
		padding: 0;
		font-size: 30px;
		font-style: normal;
		text-align: center;
	}
	
	.grid-item img {
		width: 300px; height: 200px; border:1px solid; border:hidden; border-radius:5px;
	}

	#photel {height: 15px; margin-bottom: 5px; font-style: normal;}

</Style>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div id="body">
	<div id="menu">
		<h2>Recent Registries</h2>
		<a href="/hotel/">HOME</a><br>
		<form action="/hotel/reserve/search" method="get" >
			<select required name="category" style="width:15%">
				<option selected="true" disabled="disabled">Star Category</option>  
				<option value="0">All</option>
				<option value="3">★★★</option>
				<option value="4">★★★★</option>
				<option value="5">★★★★★</option>
			</select>&nbsp;&nbsp; <input type="submit" value="Search" width="15%">&nbsp;&nbsp;&nbsp;
		</form>
	</div>

	<hr>
	
	<div class="grid-container">
		<c:forEach items="${recentList}" var="dto">
			<div class="grid-item">
				<p id="photel"><font size="3" color="gray"><b>${dto.name}</b></font><p>
				<a href="/hotel/reserve/reserve?no=${dto.no}">
				<img alt="" src="../resources/${dto.img}"></a>
				<button onclick="location.href='/hotel/reserve/reserve?no=${dto.no}'">Details</button>
			</div>
		</c:forEach>
	</div>
	
</div>	
</body>

<%@include file="../footer.jsp"%>

</html>