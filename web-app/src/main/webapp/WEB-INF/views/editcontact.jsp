<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div align="center">
    <h1>Edit Contact</h1>
    <form:form action="editContactForm" method="post" modelAttribute="contact">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form:form>
</div>
