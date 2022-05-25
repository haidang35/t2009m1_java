<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.t2009m1.accountmodelasm.entity.Account" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">

        <h3 class="text-center">List of Accounts</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/accounts/create" class="btn btn-success">Add
                New Account</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>FullName</th>
                <th>Username</th>
                <th>Email</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Account> accounts = (List<Account>) request.getAttribute("accounts");
                for(Account account : accounts) {%>
            <tr>
                <td><%= account.getId() %></td>
                <td><%= account.getFullName() %></td>
                <td><%= account.getUsername() %></td>
                <td><%= account.getEmail() %></td>
                <td>
                    <%
                        if(account.getStatus() == 1) {
                    %>
                        <button class="btn btn-sm btn-success">Active</button>
                    <% } else { %>
                        <button class="btn btn-sm btn-danger">Deactive</button>
                    <% } %>
                </td>
                <td>
                    <a class="btn btn-primary" href="/accounts/update?id=<%= account.getId() %>">Edit</a>
                    <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal<%= account.getId() %>">Delete</button>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal<%= account.getId() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    Are you sure delete <%= account.getUsername() %>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    <a href="/accounts/delete?id=<%= account.getId() %>" class="btn btn-danger">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <%}%>
            </tbody>

        </table>
    </div>
</div>
</body>

</html>
