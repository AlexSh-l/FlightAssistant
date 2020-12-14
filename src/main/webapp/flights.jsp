<%--
  Created by IntelliJ IDEA.
  User: Алексей
  Date: 13.12.2020
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Flights</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <c:set var="list" value='<%=request.getAttribute("flights")%>'/>
</head>
<body class="body_Registration">
<header>
    <br>Flights
</header>
    <div class="registrationBox">
        <table border="1" width="100%" name="flights">
        <tr>
            <th>Destination</th>
            <th>Starting point</th>
            <th>Starting time</th>
            <th>Ending time</th>
            <th>Flight number</th>
            <th>Plane type</th>
            <th>Airport</th>
        </tr>
            <c:forEach var="flight" items="${list}">
                <tr>
                    <td>${flight.destination}</td>
                    <td>${flight.start}</td>
                    <td>${flight.start_time}</td>
                    <td>${flight.end_time}</td>
                    <td>${flight.flightnum}</td>
                    <td>${flight.planetype}</td>
                    <td>${flight.airport}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
<footer>
    @Copyright 2020. All rights reserved.
</footer>
</body>
</html>
