<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="constants.SearchDataConstants"%>	
<%@ page import="model.SearchDataModel"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<jsp:useBean id="errorData" class="model.SearchDataModel" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yelp Inputs page</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/paramsearch" method="post">
		<table>
		<tr>
        	<th colspan="5" style="background-color:#7c2f97;"><%= SearchDataConstants.TABLE_MAIN_HEADING %></th>
         </tr>
    	<tr style="background-color:#f0a64e;">
		        <th class="border"><%= SearchDataConstants.FIELD1_LABEL %><input type="text" name="<%= SearchDataConstants.FIELD1_VALUE %>">
		        </th></tr>
		 <tr style="background-color:#f0a64e;"><th class="border"><%= SearchDataConstants.FIELD2_LABEL %><input type="text" name="<%= SearchDataConstants.FIELD2_VALUE %>">
		    	</th></tr>
		 <tr style="background-color:#f0a64e;"><th class="border" align="center"><input type="submit" value="<%= SearchDataConstants.SUBMIT_BUTTON%>"></th></tr>
		    
		  <c:forEach var="errRecord" items="${errorData.getErrorsList()}">
        		<tr style="background-color:#f0a64e;"><th class="border">${errRecord}</th></tr>
    	  </c:forEach>   
		</table>    
	</form>
</body>
</html>

