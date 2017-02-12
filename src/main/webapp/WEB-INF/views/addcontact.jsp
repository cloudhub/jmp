<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Add New Contact</h1>
<form:form method="post" action="save">
    <table>
        <tr>
            <td>ID :</td>
            <td><form:input path="id"/></td>
        </tr>
        <tr>
            <td>First Name :</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Email :</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>
