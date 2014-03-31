<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp">
	<jsp:param name="title" value="Log In"/>
</jsp:include>

<div class="panel">
	<form action="login" method="post" class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2 control-label">Username:</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" size="50" name="username"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Password:</label>
			<div class="col-sm-10">
				<input class="form-control" type="password" size="50" name="password"/>
			</div>
		</div>
		<input type="submit" class="btn btn-primary" value="Log In"/>
	</form>
</div>

<jsp:include page="include/footer.jsp"/>