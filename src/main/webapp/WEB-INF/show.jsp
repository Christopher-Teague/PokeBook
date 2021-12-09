<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
	<div class="container mt-5">
					<!-- HEADER -->
		<div class="d-flex justify-content-between">
			<h1>${expense.name}</h1>
			<a href="/pokebook">Go Back</a>
		</div>				
		<h3>Price: $<c:out value="${expense.amount}"/> </h3>
		<h3>Description: <c:out value="${expense.description}"/> </h3>
		<h3>Vendor: <c:out value="${expense.vendor}"/> </h3>
        		
        
    </div>	
</body>
</html>