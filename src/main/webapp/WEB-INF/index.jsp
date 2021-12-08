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
		<h1>PokeBook</h1>
        		<!-- ************* TABLE ************* -->
        <div class="">        	
			<table class="table table-primary table-striped">
				<thead>
				    <tr>				      
				      <th class="col-4">Expense</th>
				      <th class="col">Vendor</th>
				      <th class="col">Amount</th>
					</tr>
				</thead>
				<tbody>
				  	<c:forEach var="expense" items="${expenses}">
					<tr>
    					<td><c:out value="${expense.name}"/></td>    				
    					<td><c:out value="${expense.vendor}"/></td>
    					<td>$<c:out value="${expense.amount}"/></td>
				  	</tr>
					</c:forEach>
				</tbody>
			</table>         
        </div>	
        		<!-- ************* FORM ************* -->
        <div>				
        	<h4>Track an expense:</h4>
        	<form:form class="form-control" action="/expenses" method="post" modelAttribute="newExpense">
        	  	
        	  	<div class="mb-3 ">
			  		<form:label path="name" class="form-label">Expense Name:</form:label>
			  		<form:errors path="name" class="text-danger"/>
			    	<form:input path="name" class="form-control"/>	    
			  	</div>
			  	<div class="mb-3">
			    	<form:label path="vendor" class="form-label">Vendor:</form:label>
			    	<form:errors path="vendor" class="text-danger"/>
			    	<form:input path="vendor" class="form-control"/>	    
			  	</div>
			  	<div class="mb-3">
					<form:label path="amount" class="form-label">Amount:</form:label>
					<form:errors path="amount" class="text-danger"/>					
			    	<form:input path="amount" type="number" step="0.01" class="form-control"/>	    
			  	</div>
			  	<div class="mb-3">
			    	<form:label path="description" class="form-label">Description:</form:label>
			    	<form:errors path="description" class="text-danger"/>
			    	<form:textarea path="description" class="form-control" rows="3"/>	    
			  	</div>
			  	<div class="">		
			  		<button type="submit" class="btn btn-primary">Submit</button>
			  	</div>
        	</form:form>	
        </div>
    </div>	
</body>
</html>
