<%@ page language="java" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
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
	<br>
 
 
 
    <c:if test="${currentPage != 1}">
        <td><a href="/WebS/AdminPages/${currentPage - 1}">Previous</a></td>
    </c:if>
 
 <table >
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/WebS/AdminPages/${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="/WebS/AdminPages/${currentPage + 1}" > Next </a> </td>
    </c:if>



<br /> 
</body>
</html>