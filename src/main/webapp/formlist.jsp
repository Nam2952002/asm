<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 5/30/22
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">Manager Employees</h3>
        <hr>
        <div class="container text-center">

            <a href="<%=request.getContextPath()%>/home2.jsp" class="btn btn-success">Add New Employee</a>
            <a href="<%=request.getContextPath()%>/" class="btn btn-primary">Back To Home</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${manager}">

                <tr>
                    <td>
                        <c:out value="${manager.id}"/>
                    </td>
                    <td>
                        <c:out value="${manager.name}"/>
                    </td>
                    <td>
                        <c:out value="${manager.email}"/>
                    </td>
                    <td>
                        <c:out value="${manager.address}"/>
                    </td>
                    <td>
                        <c:out value="${manager.phone}"/>
                    </td>
                    <td>
                        <a href="edit?id=<c:out value='${manager.id}' />">Edit</a>
                        <a href="delete?id=<c:out value='${manager.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
