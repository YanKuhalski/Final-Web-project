<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<h1>BUBER</h1>
<br/>
<c:if test="${sessionScope.user.role!=null}">
<a href="${pageContext.servletContext.contextPath}/controller?command=comeToMain">Main</a>
</c:if>

<c:if test="${sessionScope.user.role=='user'}">
<a href="${pageContext.servletContext.contextPath}/controller?command=showClientDisconts">My Discounts</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=findCarForClient">Find Car</a>
</c:if>

<c:if test="${sessionScope.user.role=='admin'}">
<a href="${pageContext.servletContext.contextPath}/controller?command=giveDiscontToClient">Give Discount</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=showCars">Cars</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=showUsers">Users</a>
</c:if>

<c:if test="${sessionScope.user.role!=null}">
<a href="${pageContext.servletContext.contextPath}/controller?command=logOut">Log out</a>
</c:if>