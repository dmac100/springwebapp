<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp">
	<jsp:param name="title" value="Index"/>
</jsp:include>

<ul>
	<li><a href="login">Log In</a></li>
	<li><a href="register">Register</a></li>
</ul>

<jsp:include page="include/footer.jsp"/>