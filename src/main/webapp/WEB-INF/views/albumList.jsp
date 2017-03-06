<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Photos</h2>  
    <table>
        <tr>
            <td>ID</td><td>UserID</td><td>Title</td><td></td>
        </tr>
        <c:forEach items="${albumList}" var="album">
            <tr>
            <td>${album.id}</td>
            <td>${album.userId}</td>
            <td>${album.title}</td>
            <%-- <td><a href="<c:url value='/edit-${user.id}-user' />">${user.id}</a></td>
            <td><a href="<c:url value='/delete-${user.id}-user' />">delete</a></td>
             --%></tr>
        </c:forEach>
    </table>
    <br/>
<%--     <a href="<c:url value='/new' />">Add New Employee</a>
 --%></body>
</html>
