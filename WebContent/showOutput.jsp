<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.SearchDataModel"%>
<%@ page import="constants.SearchDataConstants"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<jsp:useBean id="userBean" type="model.DataModel" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yelp Search details shown here!</title>
</head>
<body>
	<table>
    <tr>
        <th colspan="5" style="background-color:#7c2f97;"><%= SearchDataConstants.TABLE_MAIN_HEADING %>></th>
    </tr>
    <tr style="background-color:#f0a64e;">
        <th class="border"><%= SearchDataConstants.TABLE_HEADING1 %></th>
        <th class="border"><%= SearchDataConstants.TABLE_HEADING2 %></th>
        <th class="border"><%= SearchDataConstants.TABLE_HEADING3 %></th>
        <th class="border"><%= SearchDataConstants.TABLE_HEADING4 %></th>
    </tr>
    <c:forEach var="record" items="${userBean.getBusinesses()}">
        <tr>
            <td>${record.name}</td>
            <td>${record.rating}</td>
            <td>${record.price}</td>
            <td>${record.phone}</td>
        </tr>
    </c:forEach>     
</table>
</body>
</html>