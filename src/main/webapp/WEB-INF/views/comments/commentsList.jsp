<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-hover">
	<c:forEach items="${list}" var="comment">
		<tr>
			<td>${comment.writer}</td>
			<td>${comment.contents}</td>
			<td>${comment.regdate}</td>
			<td><input type="checkbox" class="del" value="${comment.commentsNum}"></td>
		</tr>
	</c:forEach>
</table>

<button type="button" class="btn btn-info" id="remove">Delete</button>