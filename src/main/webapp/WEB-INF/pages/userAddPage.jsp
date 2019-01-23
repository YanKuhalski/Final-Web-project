<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}" />
<fmt:setBundle  basename="text" var="lang" />
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/add_user_page_style.css">
	</head>
<body>
	<jsp:include page ="../fragments/header.jsp"/>

	<div class="central-div">
		<div class="in-div">
			<form method="POST" action="${pageContext.servletContext.contextPath}/controller?command=addUser">
				<lable>Login&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="login"/></lable><br/><br/>
				<lable>Password&nbsp; <input type="text" name="password"/></lable><br/><br/>
                <select name="role" style=" width: 300px;" onchange="
                if(this.options[this.selectedIndex].value=='admin'){
                    var obj1 = document.getElementById('discount');  obj1.style.display = 'none';
                    var obj2 = document.getElementById('brand');  obj2.style.display = 'none';
                    var obj3 = document.getElementById('model');  obj3.style.display = 'none';
                }
                if(this.options[this.selectedIndex].value=='client'){
                    var obj1 = document.getElementById('discount');  obj1.style.display = 'block';
                    var obj2 = document.getElementById('brand');  obj2.style.display = 'none';
                    var obj3 = document.getElementById('model');  obj3.style.display = 'none';
                } 
                if(this.options[this.selectedIndex].value=='driver'){
                    var obj1 = document.getElementById('discount');  obj1.style.display = 'none';
                    var obj2 = document.getElementById('brand');  obj2.style.display = 'block';
                    var obj3 = document.getElementById('model');  obj3.style.display = 'block';
                }">
                    <option value="admin">admin</option>
                    <option value="client">client</option>
                    <option  value="driver">driver</option>
                </select><br/><br/>
                <lable id="discount" style="display: none;">Discount&nbsp; <input type="text" name="discount"/></lable><br/><br/>
                <lable id="brand" style="display: none;">Car Brand <input type="text" name="brand"/></lable><br/><br/>
                <lable id="model" style="display: none;">Car Model <input type="text" name="model"/></lable><br/><br/>
                
				<input class="button" type="submit" value="Add user">
			</form>
			
		</div>
	</div>
</body>
</html>
