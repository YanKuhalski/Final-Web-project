<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/active_ride_page_style.css">
	</head>
	<body>
        <jsp:include page ="../fragments/header.jsp"/>
        <div class="central-div">
                <div class="in-div">
                <span><fmt:message key="table.label.driverLogin" bundle="${lang}"/> : </span>
                ${ride.driverLogin}<br/><br/>
                <span><fmt:message key="table.label.carBrend" bundle="${lang}"/> : </span>
                ${ride.carBrend}<br/><br/>
                <span><fmt:message key="table.label.carModel" bundle="${lang}"/> : </span>
                ${ride.carModel}<br/><br/>
                <span><fmt:message key="table.label.startRegionName" bundle="${lang}"/> : </span>
                ${ride.startRegionName}<br/><br/>
                <span><fmt:message key="table.label.endRegioName" bundle="${lang}"/> : </span>
                ${ride.endRegioName}<br/><br/>
                <span><fmt:message key="table.label.price" bundle="${lang}"/> : </span>
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