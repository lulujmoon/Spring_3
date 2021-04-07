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
	<h2>${board} List</h2>
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
					<td><a href="./${board}Select?num=${post.num}">
					<c:if test="${board=='qna'}">
					<c:forEach begin="1" end="${post.depth}">--</c:forEach>
					</c:if>
					${post.subject}</a></td>
					<td>${post.name}</td>
					<td>${post.regdate}</td>
					<td>${post.hit}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<c:if test="${not empty member and board=='qna'}">
		<a href="./${board}Insert" style="float:right" class="btn btn-info">Write</a>
		</c:if>
		<c:if test="${not empty member and member.id eq 'admin' and board=='notice'}">
		<a href="./${board}Insert" style="float:right" class="btn btn-info">Write</a>
		</c:if>
	</div>
	
	<div class="container">
	<ul class="pagination">
	<c:if test="${pager.pre}">
 	 	<li class="page-item"><a class="page-link p" title="${pager.startNum-1}" href="#">Previous</a></li>
	</c:if>
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
 		 <li class="page-item"><a class="page-link p" href="#" title="${i}">${i}</a></li>
	</c:forEach>
	<c:if test="${pager.next}">
  		<li class="page-item"><a class="page-link p" href="#" title="${pager.lastNum+1}">Next</a></li>
	</c:if>
</ul>

<div class="input-group mt-3 mb-3">
<form id="frm" action="./${board}List" class="form-inline">
	<input type="hidden" name="curPage" id="curPage" value="1">
  <div class="input-group-prepend">
   <select class="form-control" id="type" name="type">
    <option class="sel">Subject</option>
    <option class="sel">Content</option>
    <option class="sel">Name</option>
  </select>
  </div>
  <input type="text" class="form-control" name="search" id="search" value="${pager.search}">
    <div class="input-group-append">
    <button class="btn btn-success" type="submit">Search</button>
  </div>
 </form> 
</div>

<h2>version 2</h2>

</div>

<script type="text/javascript">
	let type = '${pager.type}';

	$(".sel").each(function(){
		 let t = $(this).text();
		 if(t == type){
		     $(this).prop("selected", true);
		 }
	});
	$(".p").click(function(){
	    //curPage, type, search
		 let curPage = $(this).attr("title");
		 $("#curPage").val(curPage);
		 let search = '${pager.search}';
		 $("#frm").submit();
	}

	    
/* 	    $("#curPage").val(curPage);
	    $("#type").val(type);
	    $("#search").val(search);
	    $("#frm").submit(); */
	    
	    
	    //location.href="./${board}List?curPage="+curPage+"&type=${pager.type}&search=${pager.search}";
	})
</script>

</body>
</html>