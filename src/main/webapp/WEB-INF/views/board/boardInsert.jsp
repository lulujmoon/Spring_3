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
	/* #sample{
		display:none;
	} */
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
		
		<h2>${board} Write Page</h2>
		<form action="./${board}Insert" method="post" id="frm">
			<div class="form-group">
				<label for="name">Name</label>
				<input type="text" class="form-control myCheck" id="name" name="name" value="${member.name}" readonly="readonly">
				<small id="subResult" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
				<label for="subject">Subject</label>
				<input type="text" class="form-control myCheck" id="subject" name="subject">
				<small id="subResult" class="form-text text-muted"></small>
			</div>
			<div class="form-group">
   				 <label for="content">Content</label>
  				 <textarea class="form-control myCheck" id="content" rows="6" name="content"></textarea>
 				<small id="conResult" class="form-text text-muted"></small>
 			</div>
			<input type="button" value="Add" id="add" class="btn btn-warning">
			
			<div id="files">
				
			</div>
			<br>
    		<input type="button" value="Write" id="btn" class="btn btn-info">

		</form>
	</div>
	<div id="sample">
		<div class="input-group">
 		 <div class="custom-file">
   		 <input type="file" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
   		 <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
  		</div>
 		<div class="input-group-append delete">
   		 <input class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" value="Delete">
   		 
		</div>
</div>
	</div>
<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
</body>
</html>