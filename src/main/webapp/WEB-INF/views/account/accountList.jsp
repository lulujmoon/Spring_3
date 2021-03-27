<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<c:import url="../template/bootstrap.jsp"></c:import>
<title>Account List</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<div class="container">
	<h2 style="padding-left:10px">${member.name}님의 계좌 현황입니다.</h2>
	
	<table type="table tablehover">
		<thead >
			<tr >
				<th style="padding-left:10px;padding-right:20px">Account Number</th>
				<th style="padding-left:10px;padding-right:20px">Passbook</th>
				<th style="padding-left:10px;padding-right:20px">Open Date</th>
				<th style="padding-left:10px;padding-right:20px">Balance</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${list}" var="account">
				<tr>
					<td style="padding:5px 20px;">${account.account_num}</td>
					<td style="padding-right:20px;text-align: right" >${account.passbook_num}</td>
					<td style="padding-right:20px;text-align: right">${account.open_date}</td>
					<td style="padding-right:20px;text-align: right">${account.balance}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>