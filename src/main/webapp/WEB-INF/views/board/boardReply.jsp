<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<style>
	.c1{
		background-color:red;
	}
	.c2{
		background-color:green;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		
		<c:if test="${(not empty member and member.id ne 'admin' and board=='notice') or empty member}">
			<br><br>
			<p style="text-align:center">잘못된 접근입니다.</p>
		</c:if>
		
		
		<h2>${board} Reply Page</h2>
		<form action="./${board}Reply" method="post" id="frm">
			<input type="hidden" name="num" value="${param.num}">
			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly">
				<small id="subResult" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label for="subject">Subject</label>
				<input type="text" class="form-control" id="subject" name="subject">
				<small id="subResult" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
   				 <label for="content">Content</label>
  				 <textarea class="form-control" id="content" rows="6" name="content"></textarea>
 				<small id="conResult" class="form-text text-muted"></small>
 			</div>

			<button class="btn btn-info">Write</button>
			<button class="btn btn-danger" id="btn">Submit</button>
		</form>

	</div>

<script type="text/javascript" src="../resources/js/noticeInsert.js"></script>
</body>
</html>