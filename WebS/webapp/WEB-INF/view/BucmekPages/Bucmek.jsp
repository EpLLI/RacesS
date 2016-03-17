<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h1>Welcome back</h1>
	<h4>Races in database:</h4>
	<table border="1px">
		<tr>
			<th>Id_race</th>
			<th>Race</th>
			<th>Result</th>

		</tr>
		<c:forEach var="p" items="${race}">
			<tr>
				<td><c:out value="${p.getId_race()}" />
				<td><c:out value="${p.getRace()}" />
				<td><c:out value="${p.getResult()}" />
			<tr />
		</c:forEach>
	</table>
	
	 <c:if test="${currentPage != 1}">
        <td><a href="/WebS/BucmekPages/${currentPage - 1}">Previous</a></td>
    </c:if>
 
 <table >
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/WebS/BucmekPages/${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="/WebS/BucmekPages/${currentPage + 1}" > Next </a> </td>
    </c:if>
	
	<h4>TupeBets in database:</h4>
	<table border="1px">
		<tr>
			<th>Id</th>
			<th>TupeBets</th>

		</tr>
		<c:forEach var="p" items="${tupebets}">
			<tr>
				<td><c:out value="${p.getId_bets()}" />
				<td><c:out value="${p.getTupe_bets()}" />
			<tr />
		</c:forEach>
	</table>

	<h4>Coefficients</h4>
	<table border="1px">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Id_race</th>
				<th>Id_bets</th>
				<th>Coeff</th>
			</tr>
			<c:forEach var="t" items="${coef}">
				<tr>
					<td><c:out value="${t.getId()}"></c:out></td>
					<td><c:out value="${t.getRace()}"></c:out></td>
					<td><c:out value="${t.getId_bets()}"></c:out></td>
					<td><c:out value="${t.getCoeff()}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<h4>Add coeff?</h4>
	<s:url var="saveUrl" value="/UpdateCoefficient" />
	<form:form modelAttribute="Race" method="POST" action="${saveUrl}">
		<input type="hidden" name="operation" value="AddCoeff">
		Id: <input name="id" type="text"> Coeff: <input name="coeff"
			type="text">
		<br />
		<input type="submit" value="UpdateResultRace" />
	</form:form>
	
	<c:url var="logout" value="/logout"/>
	<a href="${logout}">Logout</a>
</body>
</html>