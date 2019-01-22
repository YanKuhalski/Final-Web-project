<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
	</head>
	<body>
		<jsp:include page ="../fragments/header.jsp"/>
		<div class="central-div">
			<form method="post"  action="${pageContext.servletContext.contextPath}/controller?command=chooseCar">
				<select size="10" name="aim" required>
				<c:forEach items="${regions}" var="region" >
					<option value='${region.id}'>${region.name}</option>
		    	</c:forEach>	
				</select>
				<input type="submit" value="ready">
			</form>
		</div>
	</body>
</html>
