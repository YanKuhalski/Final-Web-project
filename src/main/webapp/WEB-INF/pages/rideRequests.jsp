<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/ride_requests_page_style.css">

	</head>
	<body>
		<jsp:include page ="../fragments/header.jsp"/>
		<div class="central-div">
			 
		<c:choose>
			<c:when test="${trips.size()==0}"> 

			<div class="in-div">
				No trips
			</div>
			</c:when>    
			<c:otherwise>
				<table >
					<thead>
						<tr>
							<th><fmt:message key="table.label.clientLogin" bundle="${lang}"/></th>
							<th><fmt:message key="table.label.startRegionName" bundle="${lang}"/></th>
							<th><fmt:message key="table.label.endRegioName" bundle="${lang}"/></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${trips}" var="trip" >
							<tr>
								<td>${trip.clientLogin}</td>
								<td>${trip.startRegionName}</td>
								<td>${trip.endRegioName}</td>
								<c:if test="${!trip.isAccepted()}">
									<td>
										<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=accepRide">
											<input type="hidden"  name="ride-to-accept-id" value=${trip.id}  />
											<input type="submit"  value="Accept">
										</form>
									</td>
								</c:if>    
							</tr>
						</c:forEach>	
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
			
		</div>
	</body>
</html>
