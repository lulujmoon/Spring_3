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
		<button class="b" id="btn0">BUTTON</button>
		<button id="btn" class="b">Click</button>
		<button id="btn2" class="b">Click2</button>
		<input type="text" id="num">
		<h2 id="t">version 5</h2>
		
		<ol id="result">
			<li>A</li>
		</ol>
		
		<select id="mon">
		
		</select>
	
	<div id="d1">
		<div id="d2">
			<!-- title과 contents를 뿌려보장 -->
			<h4 id="d3"></h4>
			<h6 id="d4"></h6>
		</div>
	</div>
	
	<div id="exchange">
		<h4 id="krw"></h4>
		<h4 id="usd"></h4>
	</div>
	

	
	
	</div>
	
<script type="text/javascript">
	getMap(33.450701, 126.570667);
	
	function getMap(lat, lng){
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { 	//지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	}

$("#btn0").click(function(){
    $.get("https://jsonplaceholder.typicode.com/users", function(result){
		for(index of result){
		    console.log(index.company.name);
		}
		
		//첫 번째 요소(user)의 내용 중 lat, lng
		console.log(result[0].address.geo.lat);
		console.log(result[0].address.geo.lng);
		let t=parseFloat(result[0].address.geo.lat);
		let n = parseFloat(result[0].address.geo.lng);
		getMap(n, t);
    });
});


$("#btn").click(function(){
    $.ajax({
		type: "GET",
		url:"https://api.manana.kr/exchange/price.json",
		data:{
		    base: "KRW", 
		    price: 1000, 
		    code: "KRW,USD,JPY"
		    },
		success: function(result){
		    console.log(result);
		    $("#krw").html(result.KRW);
		    $("#usd").html(result.USD);
		}
    });
})


$("#btn2").click(function(){
let num = $("#num").val();
    $.get("https://jsonplaceholder.typicode.com/posts/"+num, function(data){
		$("#d3").text(data.title);
		$("#d4").text(data.contents);
    })
})
	
</script>
  </body>
</html>