<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="include/header.jsp">
	<jsp:param name="title" value="Register"/>
</jsp:include>

<div class="panel">
	<form action="register" method="post" class="form-horizontal">
		<div class="form-group">
			<label class="col-sm-2 control-label">Username:</label>
			<div class="col-sm-10">
				<input class="form-control" type="text" size="50" name="username" value="${fn:escapeXml(username)}"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Password:</label>
			<div class="col-sm-10">
				<input class="form-control" type="password" size="50" name="password"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Repeat Password:</label>
			<div class="col-sm-10">
				<input class="form-control" type="password" size="50" name="passwordRepeat"/>
			</div>
		</div>
		<input type="submit" class="btn btn-primary" value="Register"/>
	</form>
</div>

<jsp:include page="include/footer.jsp"/>