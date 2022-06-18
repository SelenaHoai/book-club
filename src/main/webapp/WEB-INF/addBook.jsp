<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Club</title>
<!-- CSS Link -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	
<!-- <!-- Bootstrap Link -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="nav-bar">
			<button class="buttons"><a href="/dashboard">back to the shelves</a></button>
		</div>
		<div>
			<h1>Add a Book to Your Shelf!</h1>
			<form:form action="/books/create" method='POST' modelAttribute="book">		
			 <div class="mt-3">
				<form:label path="title">Title: </form:label>
				<form:input type="text" path="title"/>
			<div>
				<form:errors class="text-danger" path="title"/>
			</div>
			</div>
			 <div class="mb-2 mt-3">
				<form:label path="author">Author: </form:label>
				<form:input type="text" path="author"/>				
			</div>
			<div>
				<form:errors class="text-danger" path="author"/>
			</div>
			 <div class="mb-2 mt-3">
				<form:label path="myThoughts">My thoughts: </form:label>
				<form:textarea type="text" rows="3" cols="30" path="myThoughts"/>
			</div>
			<div>
				<form:errors class="text-danger" path="myThoughts"/>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form:form>
		</div>
	</div>

</body>
</html>