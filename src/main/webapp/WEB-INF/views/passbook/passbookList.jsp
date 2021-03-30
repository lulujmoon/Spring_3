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
	
	<div class="container">
		<ul class="pagination">
  			<li class="page-item"><a class="page-link" href="/s3/passbook/passbookList?curPage=${pager.startNum-1}&type=${pager.type}&search=${pager.search}">Previous</a></li>
 				 <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
 					 <li class="page-item"><a class="page-link" href="/s3/passbook/passbookList?curPage=${i}&type=${pager.type}&search=${pager.search}">${i}</a></li>
				</c:forEach>
 			 <li class="page-item"><a class="page-link" href="/s3/passbook/passbookList?curPage=${pager.lastNum+1}&type=${pager.type}&search=${pager.search}">Next</a></li>
		</ul>
		
		<div class="input-group mt-3 mb-3">
			<form action="./passbookList" class="form-inline">
 			 <div class="input-group-prepend">
  			 <select class="form-control" id="sel1" name="type">
  			  <option>Name</option>
 			 </select>
 			 </div>
 			 <input type="text" class="form-control" name="search">
  			  <div class="input-group-append">
   			 <button class="btn btn-success" type="submit">Search</button>
 			 </div>
			 </form> 
		</div>

	</div>
</body>
</html>