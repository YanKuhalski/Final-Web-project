<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="sessionScope.language" value="ru" />
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div  class="header-body">
		<span class="big-text">B</span>
		<span class="white-text">etter then </span> 
		<span class="big-text">UBER</span>
		<c:if test="${sessionScope.user.role==null}">
			<div style=" position:  relative ; left: 10px; top:  10px">
				<a style=" color: white" href="${pageContext.servletContext.contextPath}/controller?command=changeLanguage&lang=ru">RU</a>|
				<a style=" color: white" href="${pageContext.servletContext.contextPath}/controller?command=changeLanguage&lang=en">EN</a>
			</div>
		</c:if>
		<div class="div-container">
			<c:if test="${sessionScope.user.role=='client'}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=comeToUserMain"><fmt:message key="header.label.main" bundle="${lang}"/></a>
				</div>
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=showClientTrips"><fmt:message key="header.label.trips" bundle="${lang}"/></a>
				</div>
			</c:if>

			<c:if test="${sessionScope.user.role=='admin'}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=openUserAddForm"><fmt:message key="header.label.add.user" bundle="${lang}"/></a>
				</div>
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=showUsers"><fmt:message key="header.label.users" bundle="${lang}"/></a>
				</div>
			</c:if>


			<c:if test="${sessionScope.user.role!=null}">
				<div class="bar-item">
					<a href="${pageContext.servletContext.contextPath}/controller?command=logOut"><fmt:message key="header.label.log.out" bundle="${lang}"/></a>
				</div>
			</c:if>
		</div>
	</div>

</body>
</html>