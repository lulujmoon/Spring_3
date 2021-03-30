<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
  <c:import url="./template/bootstrap.jsp"></c:import>
  <link rel="stylesheet" href="./resources/css/test.css">
    <title>Hello, world!</title>

  </head>
  <body>
	<c:import url="./template/header.jsp"></c:import>


	<div>
		<button id="btn" onclick="go()">Click!</button>
		<button id="btn" onclick="go2()">Click!</button>
	</div>

	<div id="c1" class="b1">
		<h1 id="t1">Welcome Home Page</h1>
	</div>
	
	<script type="text/javascript" src="./resources/js/test.js"></script>
  </body>
</html>