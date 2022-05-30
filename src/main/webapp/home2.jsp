<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 5/30/22
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${manager != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${manager == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${manager != null}">
                                Edit User
                            </c:if>
                            <c:if test="${manager == null}">
                                Add New Employee
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${manager != null}">
                        <input type="hidden" name="id" value= "<c:out value='${manager.id}'/>" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Name</label> <input type="text" value="<c:out value='${manager.name}' />"
                                                   class="form-control" name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Email</label> <input type="text" value="<c:out value='${manager.email}' />"
                                                    class="form-control" name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Address</label> <input type="text" value="<c:out value='${manager.address}' />"
                                                      class="form-control" name="address">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Phone</label> <input type="text" value="<c:out value='${manager.phone}' />"
                                                    class="form-control" name="phone">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                    <a href="formlist.jsp">
                        <button type="button" class="btn btn-primary">Back To List</button>
                    </a>
                </form>
        </div>
    </div>
</div>
</body></html>
