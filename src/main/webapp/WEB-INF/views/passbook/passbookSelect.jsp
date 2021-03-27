<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Passbook Select</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>Passbook Select</h1>
	
	<h3>Name : ${dto.name}</h3>
	<h3>Interest Rate : ${dto.irate}</h3>
	<h3>Openable : ${dto.openable}</h3>
	
	<c:choose>
	<c:when test="${not empty member and member.id eq 'admin'}">
	<a href="./passbookDelete?num=${dto.num}">Delete</a>
	<a href="./passbookUpdate?num=${dto.num}">Update</a>
	</c:when>
	<c:when test="${not empty member and member.id ne 'admin' and dto.openable eq 'Y'}">
	<a href="../account/accountOpen?passbook_num=${dto.num}">Open Account</a>
	</c:when>
	</c:choose>
	
	
</body>
</html>