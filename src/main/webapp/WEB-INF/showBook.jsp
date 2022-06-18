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
			<button class="buttons"><a href="/dashboard" class="deco-none">back to the shelves</a></button>
		</div>
			<div>
				<h2><c:out value="${book.title}"/></h2>
			</div>
			<div>
				<div class="d-flex d-flex-column mt-5 mb-3">
					<b class="red"><c:out value="${book.user.name}"/></b>&nbsp
					<b>read</b>&nbsp
					<b class="purple"><c:out value="${book.title}"/></b>&nbsp
					<b>by</b>&nbsp
					<b class="text-success"><c:out value="${book.author}"/></b>
					<b>.</b>
				</div>
				<div class="col-5">
					<div>
						<p>Here are <c:out value="${book.user.name}"/>'s thoughts:</p>
					</div>
					<div class="thoughts border-dark border-top border-bottom">
						<c:out value="${book.myThoughts}"/>
					</div>
					<div class="d-flex justify-content-end mx-5 mt-3">
						
						<button class="buttons"><a href="/books/${book.id}/edit" class="deco-none">Edit</a></button>
						
					</div>
				</div>
				


			</div>

	</div>

</body>
</html>