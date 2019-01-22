<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/active_ride_page_style.css">
	</head>
	<body>
        <jsp:include page ="../fragments/header.jsp"/>
        <div class="central-div">
                <div class="in-div">
                <span>Driver login : </span>
                ${ride.driverLogin}<br/><br/>
                <span>Car Brand : </span>
                ${ride.carBrend}<br/><br/>
                <span>Car model : </span>
                ${ride.carModel}<br/><br/>
                <span>Start Region : </span>
                ${ride.startRegionName}<br/><br/>
                <span>End Region : </span>
                ${ride.endRegioName}<br/><br/>
                <span>Price : </span>
                ${price}<br/><br/>
                <c:if test="${!ride.isAccepted()}">
                    <form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=cancelRide">
                        <input type="hidden"  name="ride-to-cancel-id" value=${ride.id}  />
                        <input class="cancel-button" type="submit"  value="Cancel">
                    </form>
                </c:if>    
                </div>
            </div>

	</body>
</html>