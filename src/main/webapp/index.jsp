<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 09.10.2020
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body class="body_Registration">
<header>
    <br>!!!Welcome to FightAssistant!!!
</header>
<form action="controller" method="post">
    <div class="registrationBox">
        <br>Register or sign in
        <input type="text" name="login">
        <input type="password" name="password">
        <button>Enter</button>
    </div>
</form>
    <footer>
        @Copyright 2020. All rights reserved.
    </footer>
</body>

</html>
