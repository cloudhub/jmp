<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="center">
    <h1>Add New Contact</h1>
    <form:form action="createContact" method="post">
        <table>
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