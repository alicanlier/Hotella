<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {

  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 4px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

#memberwrite {
  margin: 0 auto 40px;
  width: 40%;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

</style>
<title>Hotel Registry Form</title>
<jsp:include page="../topmenu.jsp" flush="false"/>
</head>

<body>

	<div id="menu">
		<h2>Hotel Registry</h2>
		<a href="list">Hotel list</a>&nbsp;&nbsp;&nbsp;
		<a href="/hotel/">HOME</a><p>
	</div>
	<hr>

	<div id="memberwrite">
		<h3 align="center">Hotel Registry</h3>
	
		<form action="registHotel" method="post">
		    <label for="name">Hotel name</label>
		    <input type="text" id="name" name="name" placeholder="Hotel name..">
		
		    <label for="category">Category</label>
		    <select id="category" name="category">
				<option value='3'>★★★</option>
				<option value='4'>★★★★</option>
				<option value='5'>★★★★★</option>
		    </select>
		    		    
		    <label for="price">Rate</label>
		    <input type="text" id="price" name="price" placeholder="Rate..">
		    
		    <label for="usepeople">Capacity</label>
		    <input type="text" id="usepeople" name="usepeople" placeholder="Capacity..">
		    
		    <label for="address">Address</label>    
		    <input type="text" id="address" name="address" placeholder="Address..">		    
		    
		    <label for="phone">Phone</label>
			<input type="text" id="phone" name="phone" placeholder="Phone..">
		    
		    <label for="img">Hotel image file</label>    
		    <input type="text" id="img" name="img" placeholder="Hotel image file..">
		
		    <input type="submit" value="Submit">
		
		</form>
	</div>
	
	<!-- 
	<form action="registHotel" method="post">
		<table width="700" align="center" border="1">
			<tr>
				<th>Hotel name</th>
				<td colspan="2"><input type="text" name="name" size="50"></td>
			</tr>
			
			<tr>
				<th>Category</th>
				<td><input type="text" name="category" size="50"></td>
				<td>3.★★★ 4.★★★★ 5.★★★★★</td>
			</tr>
			
			<tr>
				<th>Rate</th>
				<td colspan="2"><input type="text" name="price" size="50"></td>
			</tr>
			
			<tr>
				<th>Capacity</th>
				<td colspan="2"><input type="text" name="usepeople" size="50"></td>
			</tr>
			
			<tr>
				<th>Address</th>
				<td colspan="2"><input type="text" name="address" size="50"></td>
			</tr>
					
			<tr>
				<th>Phone</th>
				<td colspan="2"><input type="text" name="phone" size="50"></td>
			</tr>
			<tr>
				<th>Hotel image file</th>
				<td colspan="2"><input type="text" name="img" size="50"></td>
			</tr>
	
			<tr>
				<td colspan="3" align="center">
					<input type="submit" value="Register">&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="list">Hotel list</a>
				</td>
			</tr>
			
		</table>
	</form>
	-->
	
</body>

<%@include file="../footer.jsp"%>

</html>