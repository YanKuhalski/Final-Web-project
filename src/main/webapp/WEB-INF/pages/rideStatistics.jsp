<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/ride_statistics_page_style.css">
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
					<table>
						<thead>
							<tr>
								<th><fmt:message key="table.label.driverLogin" bundle="${lang}"/></th>
								<th><fmt:message key="table.label.carBrend" bundle="${lang}"/></th>
								<th><fmt:message key="table.label.carModel" bundle="${lang}"/></th>
								<th><fmt:message key="table.label.startRegionName" bundle="${lang}"/></th>
								<th><fmt:message key="table.label.endRegioName" bundle="${lang}"/></th>
								<th><fmt:message key="table.label.discount" bundle="${lang}"/></th>
								<th><fmt:message key="table.label.isPayed" bundle="${lang}"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${trips}" var="trip" >
								<tr>
									<td>${trip.driverLogin}</td>
									<td>${trip.carBrend}</td>
									<td>${trip.carModel}</td>
									<td>${trip.startRegionName}</td>
									<td>${trip.endRegioName}</td>
									<td>${trip.discount}</td>
									<td>${trip.isPayed()?"Yes":"No"}</td>
								</tr>
							</c:forEach>	
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</html>
