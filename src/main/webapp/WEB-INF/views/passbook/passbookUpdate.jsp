<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Passbook Update</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h1>Passbook Update</h1>
	
	<form action="./passbookUpdate" method="post">
		<input type="hidden" name="num" value="${dto.num}" readonly="readonly">
		Name <input type="text" name="name" value="${dto.name}"><br>
		Interest Rate <input type="text" name="irate" value="${dto.irate}" ><br>
		Openable <input type="text" name="openable" value="${dto.openable}"><br>
		<button>Update</button>
	</form>
	</div>
</body>
</html>