<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
  <c:import url="./template/bootstrap.jsp"></c:import>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6a7af300f375c011b8c7f05c46aa6aa2"></script>
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
		<div id="map" style="width:500px;height:400px;"></div>
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
	
var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { 	//지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 3 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

	
</script>
  </body>
</html>