<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		<jsp:include page ="../fragments/header.jsp"/>
		<h1>Сумма к оплате : ${price}</h1>
	   	<section>
	    	<h3>Вы находитесь:</h3>
	    	<jsp:useBean id="endRegion" scope="request" type="com.epam.webapp.entyti.Region"/>
	  		<tr>
	        	<td>ID: ${endRegion.id} | Улица : ${endRegion.name} | Эконом. зона: ${endRegion.zoneNumber}</td>
	      	</tr>
		</section>
		<section>
	    	<h3>Вы едете:</h3>
	    	<jsp:useBean id="startRegion" scope="request" type="com.epam.webapp.entyti.Region"/>
	  		<tr>
	        	<td>ID: ${startRegion.id} | Улица : ${startRegion.name} | Эконом. зона: ${startRegion.zoneNumber}</td>
	      	</tr>
		</section>
		<div>
			<form method="post"  action="${pageContext.servletContext.contextPath}/controller?command=addRide">
				<select style="width: 300px;" size="10" name="choosedCar" required>
				<c:forEach items="${freeCars}" var="car" >
					<option value='${car.id}'>${car.carBrand}  ${car.carModel}</option>
		    	</c:forEach>	
				</select>
				<input type="submit" value="ready">
			</form>
		</div>
	</body>
</html>
