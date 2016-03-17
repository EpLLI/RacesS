<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="by.academy.it.pojos.Race"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=charset=UTF-8">
<title>Admin menu</title>
</head>
<body>
	<p>
	<h1>Welcome Admin!</h1>
	<h4>Races in database:</h4>
	<br>
	<s:url var="saveUrl" value="/AdminPages/1" />
	<form name="Race" method="POST" action="${saveUrl}">
	 <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}">
		<input type="submit" value="Race" />
	</form>
	<%-- <s:url var="saveUrl" value="/addRace" />
	<form:form modelAttribute="Race" method="POST" action="${saveUrl}">
	 <table>
        <tr>
            <td><form:label path="race">race:</form:label></td>
            <td><form:input path="race" maxlength="20"/></td>
            <td></td>
            
        </tr>
         <tr>
            <td><form:label path="Result">result:</form:label></td>
            <td><form:input path="Result" maxlength="20"/></td>         
        </tr>
        </table>
        <br>
		<input type="hidden" name="operation" value="Add"> 
		Title: <input name="race" type="text"><br /> 
		<form:errors path="race" cssStyle="color: red"/>
		Price: <input name="result"	type="text"><br /> 
		 <font color="red" face="Arial">${errorDataMessage}</font><br />
	     <font color="red" face="Arial">${errorCantRemoveMessage}</font><br />
	     <font color="red" face="Arial">${errorDigitMessage}</font><br />
		<input type="submit" value="Save" />
	</form:form> --%>
	 <h4>Update Result?</h4>
	<s:url var="saveUrl" value="/UpdateResultRace" />
	<form:form modelAttribute="Race" method="POST" action="${saveUrl}">
		<input type="hidden" name="operation" value="Update"> Id: <input
			name="id_race" type="text"><br /> result: <input
			name="result" type="text"><br /> 		
		<input type="submit" value="UpdateResultRace" />
	</form:form>
	<c:url var="logout" value="/logout"/>
	<a href="${logout}">Logout</a>
	<!-- <b>Администратор </b> <a href="AdminController?operation=exit">Выйти</a> -->
</body>
</html>