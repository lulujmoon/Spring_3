<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
		<div class="container">
	<br>
	<h2>Notice</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>No</th>
				<th>Subject</th>
				<th>Name</th>
				<th>Date</th>
				<th>Hit</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${post.num}</td>
					<td>${post.subject}</td>
					<td>${post.name}</td>
					<td>${post.regdate}</td>
					<td>${post.hit}</td>
				</tr>
				<tr>
					<td colspan="5">${post.content}</td>
				</tr>
		</tbody>
	</table>
	<div style="float:right">
	<c:if test="${not empty member and member.id eq 'admin' }">
	<a href="./noticeUpdate?num=${post.num}" class="btn btn-info">Update</a>
	<a href="./noticeDelete?num=${post.num}" class="btn btn-info">Delete</a>
	</c:if>
	<a href="./noticeList" class="btn btn-info">List</a>
	</div>
	</div>
</body>
</html>