<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<style type="text/css">
			table{
				border: 4px solid black;
 				border-collapse: collapse;
			}
			th,td{
				 border: 2px solid black; 
			}
		</style>
	</head>
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
						<c:choose>
						    <c:when test="${!trip.isAccepted()}">
							    <td>
							      	<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=accepRide">
										<input type="hidden"  name="ride-to-accept-id" value=${trip.id}  />
							      		<input type="submit"  value="Accept">
							      	</form>
							    </td>
								<td>is not accepted</td>
								<td>is not accepted</td>
						    </c:when>    
						    <c:otherwise>
	   					        <td>Yes</td>
							    <c:choose>
								    <c:when test="${!trip.isPayed()}">
								      <td>
								      	<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=acceptPayment">
											<input type="hidden"  name="payed-ride-id" value=${trip.id}  />
								      		<input type="submit"  value="Accept Payment">
								      	</form>
								      </td>
								    </c:when>    
								    <c:otherwise>
								       <td>Yes</td>
								    </c:otherwise>
								</c:choose>
								<c:choose>
								    <c:when test="${!trip.isFinished()}">
								      <td>
								      	<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=finishRide">
											<input type="hidden"  name="ride-to-finish-id" value=${trip.id}  />
								      		<input type="submit"  value="Finish">
								      	</form>
								      </td>
								    </c:when>    
								    <c:otherwise>
								       <td>Yes</td>
								    </c:otherwise>
								</c:choose>

						    </c:otherwise>
						</c:choose>
						
					</tr>
		    	</c:forEach>	
			</tbody>
		</table>
			
		</div>
	</body>
</html>
