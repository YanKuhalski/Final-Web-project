<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/active_driver_ride_page_style.css">
	</head>
	<body>
        <jsp:include page ="../fragments/header.jsp"/>
        <div class="central-div">
            <div class="in-div">
                <span><fmt:message key="table.label.clientLogin" bundle="${lang}"/> : </span>
                ${ride.clientLogin}<br/><br/>
                <span><fmt:message key="table.label.startRegionName" bundle="${lang}"/> : </span>
                ${ride.startRegionName}<br/><br/>
                <span><fmt:message key="table.label.endRegioName" bundle="${lang}"/> : </span>
                ${ride.endRegioName}<br/><br/>
                
                <c:choose>
                    <c:when test="${!ride.isPayed()}"> 
                        <form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=acceptPayment">
                            <input type="hidden"  name="payed-ride-id" value=${ride.id}  />
                            <input class="button accept" type="submit"  value="Accept Payment">
                        </form>
                    </c:when>    
                    <c:otherwise>
                       <span style="font-size: 27px; color: green;"><fmt:message key="table.label.pay" bundle="${lang}"/></span> 
                    </c:otherwise>
                </c:choose>
                <form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=finishRide">
                    <input type="hidden"  name="ride-to-finish-id" value=${ride.id}  />
                    <input class="button finish" type="submit"  value="Finish">
                </form>
             
            </div>
        </div>

	</body>
</html>