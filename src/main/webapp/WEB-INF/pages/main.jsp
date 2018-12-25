<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<body>
<jsp:include page ="../fragments/header.jsp"/>
<h2>Hello ${sessionScope.user.login}</h2>
</body>
</html>
