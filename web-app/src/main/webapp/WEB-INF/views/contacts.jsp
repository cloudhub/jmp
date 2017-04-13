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

<title>All Contacts</title>

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
                <th>Action</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="contacts" items="${contacts}">
                <tr>
                    <td>${contacts.id}</td>
                    <td>${contacts.firstName}</td>
                    <td>${contacts.lastName}</td>
                    <td><a href="mailto:${contacts.email}">${contacts.email}</a></td>
                    <td>
                        <a href="editContact?id=${contacts.id}" type="button" class="btn btn-link btn-xs">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>&nbsp;edit
                        </a>
                        &nbsp;
                        <a href="deleteContact?id=${contacts.id}" type="button" class="btn btn-link btn-xs">
                            <span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>&nbsp;remove
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <input type="button" class="btn btn-info" value="Add New Contact" onclick="location.href = 'addContactForm';">
        <input type="button" class="btn btn-default" value="View All Contacts" onclick="location.href = 'contacts';">
    </div>
</div>

<script src="${jqueryJS}"></script>
<script src="${bootstrapJS}"></script>