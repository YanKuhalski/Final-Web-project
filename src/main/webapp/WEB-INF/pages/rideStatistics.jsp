<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/ride_statistics_page_style.css">
	</head>
	<body>
		<jsp:include page ="../fragments/header.jsp"/>
		<div class="central-div">
		<table>
			<thead>
				<tr>
					<th>driverLogin</th>
					<th>carBrend</th>
					<th>carModel</th>
					<th>startRegionName</th>
					<th>endRegioName</th>
					<th>discount</th>
					<th>isPayed</th>
					<th>isFinished</th>
					<th></th>
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
						<td>${trip.isFinished()?"Yes":"No"}</td>
						<c:choose>
						    <c:when test="${!trip.isAccepted()}">
						      <td>
						      	<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=cancelRide">
									<input type="hidden"  name="ride-to-cancel-id" value=${trip.id}  />
						      		<input type="submit"  value="Cancel">
						      	</form>
						      </td>
						    </c:when>    
						    <c:otherwise>
						       <td></td>
						    </c:otherwise>
						</c:choose>
					</tr>
		    	</c:forEach>	
			</tbody>
		</table>
			
		</div>
	</body>
</html>
