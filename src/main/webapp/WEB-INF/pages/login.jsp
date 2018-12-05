<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<body>
<jsp:include page ="../fragments/header.jsp"/>
<form method="POST" action="${pageContext.servletContext.contextPath}/controller?command=login">
   <lable title="Login">
     <input type="text" name="login"/>
    </lable>
     <lable title="Password">
       <input type="text" name="password"/>
      </lable>
    <input type="submit" value="log in">
</form>
</body>
</html>
