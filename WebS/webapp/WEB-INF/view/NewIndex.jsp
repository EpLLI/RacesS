  <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:spring="http://www.springframework.org/tags"
      xmlns:tiles="http://tiles.apache.org/tags-tiles"
      >
      <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<tiles:insertAttribute name="title" />
<c:if test="${not empty title}">
	<title>${title}</title>
</c:if>
<style>
text {
	height: 16px;
	width: 40px;
	margin: 10px;
}
</style>
</head>
<body>
	<security:authorize access="isAuthenticated()">
 <security:authorize access="hasRole('admin')" >
 This content will only be visible to users who have
the "supervisor" authority in their list of <tt>GrantedAuthority</tt>
 <form name="Race" action="AdminMenu">
		<input type="submit" value="AdminMenu" />
	</form>
 </security:authorize>
 
 <security:authorize access="hasRole('user')">
<form name="Race" action="UserMenu">
		<input type="submit" value="UserMenu" />
	</form>

 </security:authorize>
 <security:authorize access="hasRole('bucmek')">
 <form name="Race" action="BucmekMenu">
		<input type="submit" value="BucmekMenu" />
	</form>
 
 </security:authorize>
 
</security:authorize>
</body>
</html>