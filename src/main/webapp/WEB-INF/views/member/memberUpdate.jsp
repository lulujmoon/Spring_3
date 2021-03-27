<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Update Information</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<div class="container">
	<h1>Update Information</h1>
	
	<form action="./memberUpdate" method="post">
		ID <input type="text" readonly="readonly" name="id" value="${sessionScope.member.id}"><br>
		Password <input type="password" name="pw" value="${member.pw }"><br>
		Name <input type="text" name="name" value="${member.name}"><br>
		Phone <input type="text" name="phone" value="${member.phone}"><br>
		Email <input type="email" name="email" value="${member.email}"><br>
		<button>Update</button>
	</form>
	</div>
</body>
</html>