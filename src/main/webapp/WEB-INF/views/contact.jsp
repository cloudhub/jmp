<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>Hello <b>${name}</b>. How are you?</div>

<form action="/contact" method="post">
    <p>
        First name: <input type="text" name="firstName">
    </p>

    <p>
        Last name: <input type="text" name="firstName">
    </p>
    <input type="submit" value="Submit form">
</form>

</body>
</html>
