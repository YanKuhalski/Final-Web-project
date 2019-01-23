<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/login_page_style.css">
	</head>
<body>
	<jsp:include page ="../fragments/header.jsp"/>

	<div class="central-div">
		<div class="login-form-div">
			<form method="POST" action="${pageContext.servletContext.contextPath}/controller?command=login">
					<input type="text" name="login"/>
				<br/><br/>
					<input type="text" name="password"/>
				<br/><br/>
				<input class="log-button" type="submit" value="log in">
			</form>
			
		</div>
	</div>
	
</body>
</html>
