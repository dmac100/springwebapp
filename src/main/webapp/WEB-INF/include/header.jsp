<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html>
	<head>
		<title><c:out value="${param.title}"/></title>
				
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	</head>
	<body class="container">
		<nav class="navnar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="index">Index</a></li>
					<li><a href="login">Log In</a></li>
					<li><a href="register">Register</a></li>
				</ul>
			</div>
		</nav>
	
		<h1><c:out value="${param.title}"/></h1>
		
		<c:if test="${not empty message}">
			<div class="alert alert-info">
				<c:out value="${message}"/>
			</div>
		</c:if>
		
		<c:if test="${not empty errors}">
			<div class="alert alert-danger">
				<ul>
					<c:forEach var="error" items="${errors}">
						<li><c:out value="${error}"/></li>
					</c:forEach>
				</ul>
			</div>
		</c:if>