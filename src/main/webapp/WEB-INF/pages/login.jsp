<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="style/main.css">
		<link rel="stylesheet" type="text/css" href="style/login_page_style.css">
	</head>
<body>
	<jsp:include page ="../fragments/header.jsp"/>

	<div class="central-div">
		<div class="login-form-div">
			<form method="POST" action="${pageContext.servletContext.contextPath}/controller?command=login">
				<lable title="Login">
					<input type="text" name="login"/>
				</lable>
				<br/><br/>
				<lable title="Password">
					<input type="text" name="password"/>
				</lable>
				<br/><br/>
				<input type="submit" value="log in">
			</form>
			<div id="id1" style="display: none;">
				Введены неверны данные
			</div>
			<div id="id2" style="display: none;">
				Ваш аккаунт заблокирован
			</div>
		</div>
	</div>
	
	<script>
	    if("${message}"=="wrong data"){
			show("id1");
		}else{
			hide("id1");
		}
		if ("${message}"=="block"){ 
	    	show("id2");
		}else{
			hide("id2");
		}
		function hide(id){
			if (document.getElementById(id)){ 
			  var obj = document.getElementById(id); 
			  obj.style.display = "none";
			 }
		}
		function show(id){
			if (document.getElementById(id)){ 
			  var obj = document.getElementById(id); 
			  obj.style.display = "block";
			 }
		}
	</script>
</body>
</html>
