<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
  <c:import url="./template/bootstrap.jsp"></c:import>
  <link rel="stylesheet" href="./resources/css/test.css">
    <title>Hello, world!</title>
	<style type="text/css">
		#d1{
			width:200px;
			height:200px;
			background-color:black;
			overflow:hidden;
		}
		#d2{
			width:100px;
			height:100px;
			background-color:pink;
			margin : 50px;
		}
	</style>
  </head>
  <body>
	<c:import url="./template/header.jsp"></c:import>
	
	<div class="container" style="margin-top:30px">
		
		<button class="b">BUTTON</button>
		<button id="btn" class="b">Click</button>
		<button id="btn2" class="b">Click2</button>
		<h2 id="t">version 5</h2>
		
		<ol id="result">
			<li>A</li>
		</ol>
		
		<select id="mon">
		
		</select>
	
	<div id="d1">
		<div id="d2"></div>
	</div>
	
	</div>
	
<script type="text/javascript">
	
	$("#btn2").click(function(){
	    $("#result").append('<li>Go</li>');
	});
	
	let mon = 1;
	
	for(let i=1;i<13;i++){
	    $("#mon").append("<option>"+i+"</option");
	}
	

	
</script>
  </body>
</html>