<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Bootstrap -->
<spring:url value="/resources/css/bootstrap.css" var="bootstrapCSS"/>
<spring:url value="/resources/css/main.css" var="mainCSS"/>
<spring:url value="/resources/js/jquery-3.1.1.js" var="jqueryJS"/>
<spring:url value="/resources/js/bootstrap.js" var="bootstrapJS"/>

<link href="${bootstrapCSS}" rel="stylesheet">
<link href="${mainCSS}" rel="stylesheet">

<title>Contacts</title>

<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Contact Management System</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#home">Home</a></li>
                <li class="active"><a href="#">All Contacts</a></li>
                <li><a href="#contact">Search</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div>
        <table class="table table-hover small">
            <thead>
            <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="contacts" items="${contacts}">
                <tr>
                    <td>${contacts.key}</td>
                    <td>${contacts.value.firstName}</td>
                    <td>${contacts.value.lastName}</td>
                    <td><a href="mailto:${contacts.value.email}">${contacts.value.email}</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="${jqueryJS}"></script>
<script src="${bootstrapJS}"></script>