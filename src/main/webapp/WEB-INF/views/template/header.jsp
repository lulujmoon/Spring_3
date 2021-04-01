<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">Logo</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="${pageContext.request.contextPath}/passbook/passbookList">Passbook</a>
    </li>
    <!-- Dropdown -->
 	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Board
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/notice/noticeList">Notice</a>
        <a class="dropdown-item" href="#">-</a>
      </div>
    </li>

    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Member
      </a>
      <div class="dropdown-menu">
      	<c:if test="${empty member}">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/member/memberLogin">Login</a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/member/memberJoinCheck">Join</a>
       	</c:if>
       	<c:if test="${not empty member}">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/member/memberPage">My Page</a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/account/accountList">Manage Account</a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/member/memberLogout">Logout</a>
      	</c:if>
      </div>
    </li>
  </ul>
</nav>
