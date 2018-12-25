<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<span style="color: #8A2BE2; font-size: 40px">B</span><span style="color: #FF8C00;  font-size: 24px">etter then </span> <span style="color: #8A2BE2; font-size: 40px">UBER</span>
<br/>
<c:if test="${sessionScope.user.role!=null}">
<a href="${pageContext.servletContext.contextPath}/controller?command=comeToMain">Main</a>
</c:if>

<c:if test="${sessionScope.user.role=='client'}">
<a href="${pageContext.servletContext.contextPath}/controller?command=chooseAim">Choose Aim</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=showClientTrips">My Trips</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=showClientDisconts">My Discounts</a>
</c:if>

<c:if test="${sessionScope.user.role=='admin'}">
<a href="${pageContext.servletContext.contextPath}/controller?command=giveDiscontToClient">Give Discount</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=showCars">Cars</a>
<a href="${pageContext.servletContext.contextPath}/controller?command=showUsers">Users</a>
</c:if>

<c:if test="${sessionScope.user.role!=null}">
<a href="${pageContext.servletContext.contextPath}/controller?command=logOut">Log out</a>
</c:if>