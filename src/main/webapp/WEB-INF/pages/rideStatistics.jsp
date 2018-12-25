<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<jsp:include page ="../fragments/header.jsp"/>
		<div>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>clientLogin</th>
					<th>driverLogin</th>
					<th>carBrend</th>
					<th>carModel</th>
					<th>startRegionName</th>
					<th>endRegioName</th>
					<th>discountValue</th>
					<th>isAccepted</th>
					<th>isPayed</th>
					<th>isFinished</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${trips}" var="trip" >
					<tr>
						<td>${trip.id}</td>
						<td>${trip.clientLogin}</td>
						<td>${trip.driverLogin}</td>
						<td>${trip.carBrend}</td>
						<td>${trip.carModel}</td>
						<td>${trip.startRegionName}</td>
						<td>${trip.endRegioName}</td>
						<td>${trip.discountValue}</td>
						<td>${trip.isAccepted()}</td>
						<td>${trip.isPayed()}</td>
						<td>${trip.isFinished()}</td>
					</tr>
		    	</c:forEach>	
			</tbody>
		</table>
			
		</div>
	</body>
</html>
