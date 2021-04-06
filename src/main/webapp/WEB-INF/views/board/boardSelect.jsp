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
	<h2>${board} Select Page</h2>
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

	<c:if test="${not empty member}">
	<a href="./${board}Update?num=${post.num}" class="btn btn-info">Update</a>
	<a href="#" class="btn btn-info" id="del">Delete</a>
	<a href="./${board}Reply?num=${post.num}" class="btn btn-info">Reply</a>
	</c:if>
	<a href="./${board}List" class="btn btn-info">List</a>
	</div>
	
	<form action="./${board}Delete" id="frm">
		<input type="hidden" name="num" value="${post.num}">
	</form>
	
	</div>
	
	
	<script type="text/javascript">
		const del = document.getElementById("del");
		const del2 = document.getElementById("del2");
		const frm = document.getElementById("frm");
		
		del.addEventListener("click", function(){
		    let result = confirm("삭제하시겠습니까?");
		    if(result){
				frm.method="post";
				frm.submit();
		    }
		})

	</script>
</body>
</html>