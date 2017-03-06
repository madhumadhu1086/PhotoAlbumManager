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
            <td>NAME</td><td>email Date</td><td>id</td><td></td>
        </tr>
        <c:forEach items="${photoList}" var="photo">
            <tr>
            <td>${photo.albumId}</td>
            <td>${photo.title}</td>
             <td>${photo.id}</td>
            
            <%-- <td><a href="<c:url value='/edit-${photo.id}-user' />"></a></td>
            <td><a href="<c:url value='/delete-${photo.id}-user' />"></a></td>
             --%></tr>
        </c:forEach>
    </table>
    <br/>
<%--     <a href="<c:url value='/new' />">Add New </a>
 --%></body>
</html>
