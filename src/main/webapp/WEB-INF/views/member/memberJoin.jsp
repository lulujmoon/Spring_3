<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Member Join</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	<form action="./memberJoin" method="post">
  <div class="form-group">
  
    <label for="id">ID</label>
    <input type="text" name="id" class="form-control" id="id" aria-describedby="idHelp">
    
  </div>
  <div class="form-group">
    <label for="pw">Password</label>
    <input type="password" class="form-control" id="pw" name="pw">
  </div>
    <div class="form-group">
    <label for="name">Name</label>
    <input type="text" class="form-control" id="name" name="name">
  </div>
     <div class="form-group">
    <label for="phone">Phone</label>
    <input type="text" class="form-control" id="phone" name="phone">
  </div>
     <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email" name="email">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  	<small id="idHelp" class="form-text text-muted">We'll never share your information with anyone else.</small>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
	</div>

	</form>
</body>
</html>