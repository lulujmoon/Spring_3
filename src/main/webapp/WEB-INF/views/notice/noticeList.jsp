<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	
	
	<div class="container">
	<br>
	<h2>Notice List</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th style="width:7%">No</th>
				<th style="width:60%">Subject</th>
				<th style="width:11%">Name</th>
				<th style="width:15%">Date</th>
				<th style="width:7%">Hit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="post">
				<tr>
					<td>${post.num}</td>
					<td><a href="./noticeSelect?num=${post.num}">${post.subject}</a></td>
					<td>${post.name}</td>
					<td>${post.regdate}</td>
					<td>${post.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<c:if test="${not empty member and member.id eq 'admin'}">
		<a href="./noticeInsert" style="float:right" class="btn btn-info">Write</a>
		</c:if>
	</div>
	
	
	

</body>
</html>