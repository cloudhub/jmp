<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <spring:url value="/resources/css/main.css" var="mainCss"/>
    <spring:url value="/resources/js/jquery-3.1.1.js" var="jqueryJs"/>
    <spring:url value="/resources/js/main.js" var="mainJs"/>

    <link href="${mainCss}" rel="stylesheet"/>
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>

    <title>Contact Management System</title>
</head>
<body>
<div>Status: <b>${msg}</b> <img src="resources/images/contacts.png"></div>

<p>1. test CSS</p>

<p>2. test JS</p>
<ul>
    <div id="msg"></div>
</ul>

</body>
</html>
