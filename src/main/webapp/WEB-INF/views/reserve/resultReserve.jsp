<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Confirmation</title>

<style>
	.div1 {text-align:center; color:gray;  margin: auto auto 5px; align-items: center}
	.div1 img {width: 30%; height:auto; border: 1px solid; border:hidden; border-radius: 5px; margin-top: 10px;}
	table { width: 30%; height: auto; border: 1px solid black; border-radius: 5px; margin: auto auto 20px;}
	tr td:first-child {font-weight: bold;}
	td {padding-left: 10px; text-align: left; border: 1px solid rgba(0, 0, 0, 0.1);}
	.div2 {text-align:center; margin: auto auto 20px;}
	.div2 Button {border: hidden; border-radius: 5px; background: #03b6fc; font-size: 16px; 
	font-weight: bold; height:30px; width: 100px; margin:20px 10px; cursor: pointer;}
	.div2 Button:active {transform: translateY(1px);}
</style>

<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div id="body">	
	<div class="div1">
		<h2>Confirm your booking details.</h2>
		<img alt="" src="../resources/${img}">
	</div>

	<table>
		<tr>
			<td>Reservation no</td>
			<td>${reserveVo.no}</td>
		</tr>
		<tr>
			<td>Booker ID</td>
			<td>${reserveVo.memid}</td>
		</tr>
		<tr>
			<td>Checkin date</td>
			<td>${reserveVo.rday}</td>
		</tr>
		<tr>
			<td>Stay length</td>
			<td>${reserveVo.dday} days</td>
		</tr>
		<tr>
			<td>Room count</td>
			<td>${reserveVo.qty}</td>
		</tr>
		<tr>
			<td>1 night rate</td>
			<td>${price} KRW</td>
		</tr>
		<tr>
			<td>Total fee</td>
			<td>${price * reserveVo.dday * reserveVo.qty} KRW</td>
		</tr>
	</table>

	<div class="div2">
		<button onclick="location.href='/hotel/reserve/delete?regno=${currval}'">Cancel</button>&nbsp;&nbsp;&nbsp;
		<button onclick="location.href='/hotel/reserve/reserveList'">Confirm</button>
	</div>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>