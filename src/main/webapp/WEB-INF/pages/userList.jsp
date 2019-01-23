<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />

<html>
<head>
	<link rel="stylesheet" type="text/css" href="style/main.css">
	<link rel="stylesheet" type="text/css" href="style/user_view_page_style.css">
</head> 
<body>
<jsp:include page ="../fragments/header.jsp"/>
<div class="central-div">
	<table >
		<thead>
			<tr>
				<th><fmt:message key="table.label.login" bundle="${lang}"/></th>
				<th><fmt:message key="table.label.role" bundle="${lang}"/></th>
				<th><fmt:message key="table.label.discount" bundle="${lang}"/></th>
				<th><fmt:message key="table.label.staus" bundle="${lang}"/></th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${users}" var="otherUser" >
				<tr>
					<td>${otherUser.login}</td>
					<td>${otherUser.role}</td>
					<c:choose >
						<c:when test="${otherUser.role=='client'}">
							<td>${otherUser.discount}</td>
						</c:when>    
						<c:otherwise>
								<td> </td>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${!otherUser.isActive()}">
							<td>
								<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=unblockUser">
								<input type="hidden"  name="user-to-unblock-id" value=${otherUser.id}  />
									<input type="submit"  value="Unblock">
								</form>
							</td>
						</c:when>    
						<c:otherwise>
							<td>
							<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=blockUser">
								<input type="hidden"  name="user-to-block-id" value=${otherUser.id}  />
									<input type="submit"  value="Block">
								</form>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</div>
</body>
</html>
