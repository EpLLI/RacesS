<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>

	<h4>You Bets in database:</h4>

	 <table border="1px">
        	<tr >
        		<th>Id</th>
        		<th>Race</th>
        		<th>Tupe_Bets</th>
        		<th>Coeff</th>
        		<th>Sum</th>

        	</tr>
        	<c:forEach var="c" items="${sessionScope.bets}"> 
            	<tr>
            		<td><c:out value="${c.getId()}"/>  

            		<td><c:out value="${c.getRace()}"/> 
            		<td><c:out value="${c.getTupe_bets()}"/> 
            		<td><c:out value="${c.getCoeff()}"/>  
            		<td><c:out value="${c.getSum()}"/>     
        		<tr/>
        	</c:forEach>
        </table>
  	<form action="UserController" method="post">
        <input type="hidden" name="operation" value="selectMyBets">      
         <table border="1px">
        	<tr >
        		<th>Id</th>
        		<th>Race</th>
        		<th>Tupe_Bets</th>
        		<th>Coeff</th>
        		<th></th>
        	</tr>
        	<c:forEach var="c" items="${sessionScope.bet}"> 
            	<tr>       	
            		<td><c:out value="${c.getId()}"/>  
            		<td><c:out value="${c.getRace()}"/> 
            		<td><c:out value="${c.getTupe_bets()}"/> 
            		<td><c:out value="${c.getCoeff()}"/>   
            		 <td ><input type="checkbox" name="bet" value="${c.getId()}"></td>
        		<tr/>
        		
        	</c:forEach>
      
        </table>
          	Id_client:
			<input name="id_client" type="text"><br/>
			Sum:
			<input name="sum" type="text"><br/>
        <input type = "submit" name = "ok" value="ok ">
        </form>
</body>
</html>