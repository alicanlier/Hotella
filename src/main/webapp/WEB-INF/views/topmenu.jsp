<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Top Menu</title>
<link rel="stylesheet" href="/hotel/resources/css/Home.css">
</head>

<nav>
	<div class="myDiv1">
		<span id="span1"></span>
		<span id="span2" onclick="location.href='/hotel/'">Hotella</span>
		<span id="span3">
			 <c:set var = "now" value = "<%= new java.util.Date()%>" />
			      <p><fmt:formatDate type = "both" pattern="MMM dd, yyyy h:mm a" value = "${now}" /></p>
				
			<%String xid = null;
			xid = (String) session.getAttribute("id");
			if (xid == null) {
			%>
			
			<button class="regButton" onclick="location.href='/hotel/member/writeForm'" type="button">Register</button>
			<button class="logButton" onclick="location.href='/hotel/member/loginForm'" type="button">Login</button>
		</span>	
	</div>

			<%} else {%>
			<i>Welcome <%=xid%>!</i> 
			<button class="logButton" onclick="location.href='/hotel/member/logout'" type="button">Logout</button>
		</span>	
	</div>
			<%}%>
	
	<div class="myDiv2">
		<a href="/hotel/reserve/reserveMain" class="a_home">Book</a>
		<a href="/hotel/board/list" class="a_home">Review</a>
		
		<%if (xid!=null) {%>
			<a href="/hotel/reserve/reserveList" class="a_home">My page</a>
		<%}%>
		
		<%if (xid!=null && xid.equals("admin")) {%>
			<a href="/hotel/member/list" class="a_home">Members</a>
			<a href="/hotel/hotel/list" class="a_home">Hotels</a>
			<a href="/hotel/reserve/allReserveList" class="a_home">Reservations</a>
		<%}%>
	</div>
	
	<hr style="margin: 7px auto 7px; width:99.4%">
</nav>
</html>