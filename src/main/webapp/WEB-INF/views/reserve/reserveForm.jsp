<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking form</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
<style>
	table { width:100%; height: 300px; border: 1px solid black; border-radius: 5px;}
	tr td:first-child {font-weight: bold;}
	td {padding-left: 10px; text-align: left; width:25%; height: 12.5%; border: 1px solid rgba(0, 0, 0, 0.1);}
	.div1 {text-align:center; height:40; color:gray; padding: 4px; margin-bottom: 20px;}
	.div2 {display: grid; grid-template-columns: auto auto; margin: auto; padding-top:20px; justify-content: center; gap: 5px; width: 60%;}
	.div2 img {width:auto; height:300px; border: 1px solid; border:hidden; border-radius: 5px;}
	.div4 {text-align:center;}
	.bookButton {border: hidden; border-radius: 5px; background: #03b6fc; font-size: 16px; 
	font-weight: bold; height:30px; width: 100px; margin:20px 10px; cursor: pointer;}
	.bookButton:active {transform: translateY(1px);}
</style>
</head>

<body>
<div id="body">	
	<div id="menu">		
		<h2>${vo.name} Details</h2>
		<a href="/hotel/">HOME</a>
	</div>
	
	<form action="/hotel/reserve/reserveProc" method="post">
		<div class="div2">
			<div class="div3">
				<img alt="" src="../resources/${vo.img}"></img>
			</div>
			<div class="div3">
				<table>
					<tr>
						<td>Hotel name</td>
						<td>${vo.name}</td>
	
					</tr>
					<tr>
						<td>Category</td>
						<td>${vo.category} stars</td>
					</tr>
					<tr>
						<td>Rate</td>
						<td>${vo.price }</td>
					</tr>
					<tr>
						<td>Address</td>
						<td>${vo.address}</td>
					</tr>
					<tr>
						<td>Phone</td>
						<td>${vo.phone }</td>
					</tr>
					<tr>
						<td>Room amount</td>
						<td><select name="qty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select></td>
					</tr>
					
					<tr>
						<td>Stay length (days)</td>
						<td><select name="dday">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
						</select></td>
					</tr>
					<tr>
						<td>Checkin date</td>
						<td><input type="date" name="rday"></td>
					</tr>
				</table>
			</div>	
		</div>
				
		<div class="div4">
			<input type="hidden" name="no" value="${vo.no}">
			<input type="hidden" name="img" value="${vo.img }">
			<input type="hidden" name="memid" value="${memid}">
			<input type="hidden" name="price" value="${vo.price }">			
			<input class="bookButton" type="submit" value="Book">
		</div>			
	</form>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>