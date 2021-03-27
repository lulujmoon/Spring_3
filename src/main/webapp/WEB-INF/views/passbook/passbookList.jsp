<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Passbook</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	<h3>Passbook List</h3>
	
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Interest Rate</th>
				<th>Openable</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td><a href="./passbookSelect?num=${dto.num}">${dto.name}</td>
				<td>${dto.irate}</td>
				<td>${dto.openable}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>