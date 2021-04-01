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
<h1 id="head">Member Join Check Page</h1>

<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input " value="" id="d1">전체 동의
  </label>
</div>

<br>
<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input c1" value="">동의
  </label>
</div>
<div class="jumbotron">
  <h1>Bootstrap Tutorial</h1>
  <p>Bootstrap is the most popular HTML, CSS...</p>
</div>

<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input c1" value="">동의
  </label>
</div>
<div class="jumbotron">
  <h1>Bootstrap Tutorial</h1>
  <p>Bootstrap is the most popular HTML, CSS...</p>
</div>

<div class="form-check">
  <label class="form-check-label">
    <input type="checkbox" class="form-check-input c1" value="">동의
  </label>
</div>
<div class="jumbotron">
  <h1>Bootstrap Tutorial</h1>
  <p>Bootstrap is the most popular HTML, CSS...</p>
</div>
</div>
<button class="btn btn-danger" onclick="check()">Join</button>
<script type="text/javascript" src="../resources/js/memberJoinCheck.js"></script>
<h1>version 1</h1>
</body>
</html>