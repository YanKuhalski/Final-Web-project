<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
                        <c:choose>
                            <c:when test="${sessionScope.user.role!=null}">
						        <jsp:forward page="WEB-INF/pages/main.jsp"/>
						    </c:when>
						    <c:otherwise>
						      <jsp:forward page="WEB-INF/pages/login.jsp"/>
						    </c:otherwise>
						</c:choose>
</html>
