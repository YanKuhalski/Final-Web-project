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
		</div>
	</body>
</html>
