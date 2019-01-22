<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				<th>Login</th>
				<th>Role</th>
				<th>Discount</th>
				<th> </th>
				<th>Status</th>
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
							<td>
									<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=changeUserDiscount">
									<input type="hidden"  name="user-to-unblock-id" value=${otherUser.id}  />
										<input type="submit"  value="Change discount">
									</form>
							</td>
						</c:when>    
						<c:otherwise>
								<td> </td>
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
