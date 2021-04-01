<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		
		<c:if test="${(not empty member and member.id ne 'admin') or empty member}">
			<br><br>
			<p style="text-align:center">잘못된 접근입니다.</p>
		</c:if>
		<c:if test="${not empty member and member.id eq 'admin'}">
		<h2>Notice Write Page</h2>
		<form action="./noticeInsert" method="post">
			<div class="form-group">
				<label for="subject">Subject</label>
				<input type="text" class="form-control" id="subject" name="subject">
			</div>
			<div class="form-group">
   				 <label for="exampleFormControlTextarea1">Content</label>
  				 <textarea class="form-control" id="exampleFormControlTextarea1" rows="6" name="content"></textarea>
 			</div>


			<button class="btn btn-info">Write</button>
		</form>
		</c:if>
	
	<button type="submit" class="btn btn-primary" onclick="insertCheck()">Submit</button>
	<input type="button" value="WRITE" class="btn btn-primary" onclick="insertCheck()">

	<script type="text/javascript" src="../resources/js/insertCheck.js"></script>	
	</div>

	


</body>
</html>