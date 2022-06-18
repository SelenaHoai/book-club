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
			<button class="buttons"><a href="/logout" class="deco-none">Logout</a></button>
			<button class="buttons"><a href="/books/new" class="deco-none">Add a new book</a></button>
		</div>
		<div>
			<h1 class="welcome mb-3">Welcome, <c:out value="${user.name}"/>!</h1>
			<p> Books from everyone's shelves.</p>
			<div>
				<table class="table">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Title</th>
					<th scope="col">Author Name</th>
					<th scope="col">Posted By</th>
					<th scope="col">Actions</th>
				</tr>
				<tbody>
					<c:forEach var="book" items="${book}">
			        <tr>
			        	<td><c:out value="${book.id}"></c:out></td>
				        <td><a href="/books/${book.id}/show"><c:out value="${book.title}"></c:out></a></td>
				        <td><c:out value="${book.author}"></c:out></td>
				        <td><c:out value="${book.user.name}"/></td>				        
				        <td class="d-flex flex-row"><button><a href="/books/${book.id}/edit" class="deco-none">Edit</a></button>&nbsp&nbsp
				        <form action="/books/${book.id}/delete" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete" class="red">
						</form>
						</td>
								  
			        </tr>
			    	</c:forEach>
				</tbody>		
				</table>
			</div>
		</div>
	</div>

</body>
</html>