<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<style type="text/css">
	#sample{
		display:none;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		
		<h2>Notice Write Page</h2>
		<form action="./${board}Update" method="post" id="frm", enctype="multipart/form-data">
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

		<c:forEach items="${post.boardFiles}" var="file">
			<div>
				<span>${file.originName}</span><span class="fileDelete" title="${file.fileNum}">X</span>
			</div>
		</c:forEach>
		
		<input type="button" value="Add" id="add" class="btn btn-warning">
			
		<div id="files" title="${post.boardFiles.size()}"></div>
		
		<input type="button" value="Update" id="btn" class="btn btn-info">

		</form>

	</div>
	
		<div id="sample">
		<div class="input-group">
 		 <div class="custom-file">
   		 <input type="file" name="files" class="custom-file-input" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
   		 <label class="custom-file-label" for="inputGroupFile04">Choose file</label>
  		</div>
 			<div class="input-group-append delete">
   				 <input class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04" value="Delete">
   		 
			</div>
			</div>
		</div>
	<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
	<script type="text/javascript" src="../resources/jquery/fileUpload.js"></script>

</body>
</html>