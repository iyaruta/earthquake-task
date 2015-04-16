<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
    <style>
        .form {
            background-color: #fff;
            padding: 15px;
            width: 500px;
            margin: 0 auto;
        }

        table {
            width: 100%;
        }

        th {
            width: 19.9%;
            text-align: left;
        }
        .add-link {
            display: inline-block;
            margin-top: 25px;
            padding: 5px;
            background-color: #bce;
        }
    </style>
</head>
<body>
<div class="form">
    <table>
        <tr>
            <th>City</th>
            <th>Magnitude</th>
            <th>Scale</th>
            <th>Time</th>
            <th></th>
        </tr>
        <c:forEach items="${list}" var="rec">
            <tr>
                <td>${rec.city}</td>
                <td>${rec.magnitude}</td>
                <td>${rec.scale}</td>
                <td>${rec.time}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/edit" class="add-link">Add Record</a>
</div>
</body>
</html>