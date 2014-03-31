<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp">
	<jsp:param name="title" value="Error"/>
</jsp:include>

<p>
	<div class="alert alert-danger">
		Sorry, there was a problem processing your request.
	</div>
	
	<p>
		<a href="index">Index</a>
	</p>
</p>

<jsp:include page="include/footer.jsp"/>