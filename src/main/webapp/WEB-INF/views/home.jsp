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
	
	<div class="container" style="margin-top:30px">
		
		<button onclick="go()">BUTTON</button>
		<button id="btn">Click</button>
		<button id="btn2">Click</button>
		<h2>version 5</h2>
	</div>
	
<script type="text/javascript">

	let btn=document.getElementById("btn");
	let btn2=document.getElementById("btn2");
	btn.onclick= function (){
		alert("익명함수");
	}
	
	btn2.addEventListener("click", function(){
		alert('익명');
	});
	
	
	function go() {
			alert("hello");
	}
	
</script>
  </body>
</html>