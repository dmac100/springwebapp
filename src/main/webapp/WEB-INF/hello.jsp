<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

Hello JSP:

<% out.println(1 + 1); %>

<%= 1 + 1 %>

${1 + 1}

<c:out value="2"/>
