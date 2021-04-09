<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>My Page</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h1>My Page</h1>
	
	<table style="border: 0px">
	<tr>
		<td>ID</td>
		<td>: ${sessionScope.member.id}</td>
	</tr>
	<tr>
		<td style="padding-right:3px">Password</td>
		<td>: ${sessionScope.member.pw}</td>
	</tr>
	<tr>
		<td>Name</td>
		<td>: ${sessionScope.member.name}</td>
	</tr>
	<tr>
		<td>Phone</td>
		<td> : ${sessionScope.member.phone}</td>
	</tr>
	<tr>
		<td>Email</td>
		<td> : ${sessionScope.member.email }</td>
	</tr>
	<tr>
		<td></td>
		<td><img alt="no" src="../resources/upload/member/${member.memberFileDTO.originName}"></td>
	</tr>
	</table>
	<br><br>
	<a href="./memberUpdate">Update Information</a><br>
	<a href="./memberDelete">Delete ID</a><br>
	<a href="../account/accountList">Manage Account</a>
	</div>
</body>
</html>