<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review Details</title>

<style type="text/css">
 th{
 text-align:left;
 width: 100px;
 }
</style>

<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>
<div  id="body">
	<div id="menu">
		<h2>Review Details</h2>
		<a href="/hotel/">HOME</a>
	</div>
	<hr>
	
	<table board="1" align="center">
		<form action = "modify" method="post">
	
			<%!String xid = null;%>
			<% String writer = (String) request.getParameter("writer");
			try {
				xid = (String) session.getAttribute("id");
				
			} catch (Exception e) {
				xid = "Guest";
			}%>	
		
			<input type="hidden" name="num" value="${content.num}">
			
			<tr>
				<th>Author</th>
				<td>${content.writer}</td>
			</tr>
			<tr>
				<th>Subject</th>		
				
			<%
			if (xid!=null && xid.equals(writer)) {
			%>
		        <input type="hidden" name="writer" value="${content.writer}"> 	
				<td><input type="text" name="subject" size="50" value="${content.subject }"></td>
			</tr>
			<%
			} else {%>
				<td>${content.subject }</td>
			</tr>
			<%} %>				
			
			<tr>
				<th>Upload date</th>
				<td>${content.reg_date}</td>
			</tr>		 
			
			<tr>
				<th>Hits</th>
				<td>${content.readcount}</td>
			</tr>
	
			<%
			if (xid!=null && xid.equals(writer)) {
			%>	
			<tr>
				<th>Content</th>
				<td><textarea  name="content" rows="10" cols="49">${content.content}</textarea></td>
			</tr>
			<%} else {%>
			<tr>
				<th>Content</th>
				<td><textarea readonly name="content" rows="10" cols="49">${content.content}</textarea></td>
			</tr>
			<%} %>		
			
			<tr>
			<td></td>
			<td  align="center">
			
			<%if (xid!=null && xid.equals(writer)) {%>
				<input type="submit" value="Modify"> &nbsp;&nbsp;
		
				<button type="button" onclick="location.href='delete?num=${content.num}'">Delete</button> &nbsp;&nbsp;
	
			<%}if (xid!=null) {%>			
			    <button type="button" onclick="location.href='reply_view?num=${content.num}'">Reply</button> &nbsp;&nbsp;
			<%}%>		
				<button type="button" onclick="location.href='list'">Review List</button>
				
			
			</td>	
			</tr>
			
		</form>	
	</table>
</div>
</body>

<%@include file="../footer.jsp"%>

</html>