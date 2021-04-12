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
		
		<h2>Notice Write Page</h2>
		<form action="./${board}Update" method="post">
			<div class="form-group">
				<label for="subject">Subject</label> 
				<input type="text" class="form-control" id="subject" name="subject" value="${post.subject}">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<input type="text" class="form-control" id="content" name="content" value="${post.content}">
			</div>
			<input type="hidden" name="num" value="${post.num}">
		<c:forEach items="${post.boardFiles}" var="file">
			<div>
				<span>${file.originName}</span><span class="fileDelete">X</span>
			</div>
		</c:forEach>
			<button class="btn btn-info">Update</button>
		</form>
 
	</div>
	
	<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
</body>
</html>