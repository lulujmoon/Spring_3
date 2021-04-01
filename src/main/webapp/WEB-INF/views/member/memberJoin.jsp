<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Member Join</title>
<style type="text/css">
	.r1{
		color:red;
	}
	.r2{
		color:green;
	}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	<form action="./memberJoin" method="post" id="frm">
  <div class="form-group">
  <!-- ID는 6글자 이상이어야 한다. -->
    <label for="id">ID</label>
    <input type="text" name="id" class="form-control" id="id" aria-describedby="idHelp">
    <small id="idResult" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="pw">Password</label>
    <input type="password" class="form-control" id="pw" name="pw">
  	<small id="pwResult" class="form-text text-muted"></small>
  </div>
  <!-- PW는 8글자 이상이어야 한다 -->
  <div class="form-group">
    <label for="pwCheck">PasswordCheck</label>
    <input type="password" class="form-control" id="pwCheck" name="pwCheck">
  	<small id="pwcResult" class="form-text text-muted"></small>
  </div> 
  <!-- PW와 일치할 것 -->
    <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control etc" id="name" name="name">
	<small id="nameResult" class="form-text text-muted"></small>
  </div>
  
  <!-- 비어있으면 안 됨 -->
     <div class="form-group">
    <label for="phone">Phone</label>
    <input type="text" class="form-control etc" id="phone" name="phone">
  </div>
  <!-- 비어있으면 안 됨 -->
     <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control etc" id="email" name="email">
  </div>
  <!-- 비어있으면 안 됨 -->
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  	<small id="idHelp" class="form-text text-muted">We'll never share your information with anyone else.</small>
  </div>
  <input type="button" value="Join" id="btn" class="btn btn-info">
 
</form>
	</div>
	
	<script type="text/javascript" src="../resources/js/memberJoin.js"></script>
</body>
</html>