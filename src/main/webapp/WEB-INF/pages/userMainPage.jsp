<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
        <link rel="stylesheet" type="text/css" href="style/userMain.css">
        <link rel="stylesheet" type="text/css" href="style/main.css">
	</head>
<body>
    <jsp:include page ="../fragments/header.jsp"/>
    <div class="central-div">
        <div class="in-div">
            <section>
                <h3>Вы находитесь:</h3> Улица : ${startRegion.name} <br/>
            </section>
            <form method="post"  action="${pageContext.servletContext.contextPath}/controller?command=acceptRide">
                <input style="display: none;"  name="startRegion" value="${startRegion.id}" />
                <select size="10" name="aim" style=" width: 300px;" onchange="var obj = document.getElementById('car-selector');  obj.style.display = 'block';" required>
                    <c:forEach items="${regions}" var="region" >
                        <option value='${region.id}'>${region.name}</option>
                    </c:forEach>	
                </select>
                <select class="car-select" id="car-selector" style="display: none; width: 300px;" size="10" name="choosedCar" onchange="var obj = document.getElementById('button');  obj.style.display = 'block';"required>
                    <c:forEach items="${freeCars}" var="car" >
                        <option value='${car.id}'>${car.carBrand} | ${car.carModel}</option>
                    </c:forEach>	
                </select>
                <input class="accept-button"  id="button" style="display: none;" type="submit" value="ready">
            </form>
        </div>
    </div>
</body>
</html>
