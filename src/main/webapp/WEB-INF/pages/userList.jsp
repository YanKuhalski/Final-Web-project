<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <style type="text/css">
            TABLE {
             border-collapse: collapse; /* Убираем двойные границы между ячейками */
             border: 4px solid black; /* Рамка вокруг таблицы */
            }    
            TH{
             background: #dc0; /* Цвет фона таблицы */
            }
            TD, TH {
             padding: 5px; /* Поля вокруг текста */
             border: 2px solid black; /* Рамка вокруг ячеек */
            }
        </style>
     </head> 
<body>
<jsp:include page ="../fragments/header.jsp"/>
<table>
	<thead>
		<tr>
	    	<th>ID</th>
	        <th>Login</th>
	        <th>Role</th>
	        <th>Discount ID</th>
	        <th> </th>>
	        <th>Status</th>
	    </tr>	
	</thead>
    <tbody>
		<c:forEach items="${users}" var="otherUser" >
			<tr>
				<td>${otherUser.id}</td>
				<td>${otherUser.login}</td>
				<td>${otherUser.role}</td>

				<c:choose >
					<c:when test="${otherUser.role=='client'}">
					    <td>${otherUser.discountId}</td>
					    <td>
					      	<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=changeUserDiscount">
								<input type="hidden"  name="user-to-unblock-id" value=${otherUser.id}  />
					      		<input type="submit"  value="Change discount">
					      	</form>
					    </td>
				    </c:when>    
				    <c:otherwise>
					        <td> </td>
					        <td> </td>
				    </c:otherwise>
				</c:choose>



				<c:choose>
				    <c:when test="${!otherUser.isActive()}">
					    <td>
					      	<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=unblockUser">
								<input type="hidden"  name="user-to-unblock-id" value=${otherUser.id}  />
					      		<input type="submit"  value="Unblock">
					      	</form>
					    </td>
				    </c:when>    
				    <c:otherwise>
					        <td>
							<form  method="post" action="${pageContext.servletContext.contextPath}/controller?command=blockUser">
								<input type="hidden"  name="user-to-block-id" value=${otherUser.id}  />
					      		<input type="submit"  value="Block">
					      	</form>
					        </td>
				    </c:otherwise>
				</c:choose>
			</tr>
    	</c:forEach>	
    </tbody>
</table>



 
</body>
</html>
