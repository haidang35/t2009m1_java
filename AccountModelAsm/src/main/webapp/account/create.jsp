<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>

<head>
    <title>Account Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Account Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/accounts" class="nav-link">Account List</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <form action="/accounts/create" method="post">
                <fieldset class="form-group">
                    <label>Fullname</label> <input type="text"  class="form-control" name="fullName" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Username</label> <input type="text"  class="form-control" name="username">
                </fieldset>
                <fieldset class="form-group">
                    <label>Email</label> <input type="email"  class="form-control" name="email" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Password</label> <input type="password"  class="form-control" name="password">
                </fieldset>
                <fieldset class="form-group">
                    <label>Status</label>
                    <select class="form-control" name="status">
                        <option value="">Select status</option>
                        <option value="1">Active</option>
                        <option value="0">Deactive</option>
                    </select>
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </div>
    </div>
</div>
</body>

</html>
