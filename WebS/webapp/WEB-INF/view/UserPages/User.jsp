<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>

<a href="UserController?operation=exit">Выйти</a>
<form action="UserController" method="post">
        <input type="hidden" name="operation" value="lookcoef">
	<td><input type="submit"  value="Просмотреть коэффициенты" name="lookcoef"></td>
	</form>	
	
	
	<form action="UserController" method="post">
		<input type="hidden" name="operation" value="chooseRace">
		<table border="1px">
			<tr>
				<th>Id_race</th>
				<th>Race</th>
				<th>Result</th>
			</tr>
			<c:forEach var="p" items="${sessionScope.race}">
				<tr>
					<td><c:out value="${p.getId_race()}" />
					<td><c:out value="${p.getRace()}" />
					<td><c:out value="${p.getResult()}" />
				<tr />
			</c:forEach>
		</table>
		<c:if test="${pageNumber != 1}">
		<td><input type="submit" name="prevPageNumber" value="Предыдущая" />${sessionScope.pageNumber}
		</c:if>
			<input type="submit" name="nextPageNumber" value="Следующая" />
			Отображать по <select class="demo" name="pageS"><option
					disabled></option>
				<option value="${sessionScope.pageSize}">${sessionScope.pageSize}</option>
				<option value="${sessionScope.pageSizeSecond}">${sessionScope.pageSizeSecond}</option></select></td>
	</form>     
	<br>
	<br>
</body>
</html>

