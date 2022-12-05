<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.grid-container {
		display: grid;
		grid-template-columns: 20% 20% 20% 20%;
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
		text-align: center;
	}
	
	.grid-item img {
		width: 300px; height: 200px; border:1px solid; border:hidden; border-radius:5px;
	}
	
	#photel {height: 15px; margin-bottom: 5px; font-style: normal;}
</style>
<title>Hotel Search Result</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div id="body">	
	<div id="menu">
		<h2>See ${type} Hotels</h2>
		<a href="reserveMain">Back</a>&nbsp;&nbsp;
		<a href="/hotel/">HOME</a>
	</div>	

	<hr>
	
	<div class="grid-container">
		<c:forEach items="${list}" var="dto">
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
