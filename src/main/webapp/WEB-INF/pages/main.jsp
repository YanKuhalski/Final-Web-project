<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
    <head>
			<link rel="stylesheet" type="text/css" href="style/main.css">
    </head>
<body>
<jsp:include page ="../fragments/header.jsp"/>
<div class="central-div">
    <h2>Hello ${sessionScope.user.login}</h2>
</div>
</body>
</html>
