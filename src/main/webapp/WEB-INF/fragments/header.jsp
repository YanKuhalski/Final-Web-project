<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html>
<html>
<head>
</head>
<body >
	<div  class="header-body">
		<span class="big-text">B</span>
		<span class="white-text">etter then </span> 
		<span class="big-text">UBER</span>

		<div class="div-container">
			<c:if test="${sessionScope.user.role!=null}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=comeToMain">Main</a>
				</div>
			</c:if>

			<c:if test="${sessionScope.user.role=='client'}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=chooseAim">Choose Aim</a>
				</div>
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=showClientTrips">My Trips</a>
				</div>
			</c:if>

			<c:if test="${sessionScope.user.role=='admin'}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=showUsers">Users</a>
				</div>
			</c:if>

			<c:if test="${sessionScope.user.role=='driver'}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=chooseClient">Choose Client</a>
				</div>
			</c:if>

			<c:if test="${sessionScope.user.role!=null}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=logOut">Log out</a>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>