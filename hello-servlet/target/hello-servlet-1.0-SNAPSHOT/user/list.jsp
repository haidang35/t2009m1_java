<%@ page import="com.example.helloservlet.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    String title = (String) request.getAttribute("title");
    List<User> userList = (List<User>) request.getAttribute("userList");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h1><%= title %>
</h1>
<ul>
    <% for (User user : userList) { %>
    <li><%= user.getName() %> --- <%= user.getEmail() %>
    </li>
    <% } %>
</ul>
</body>
</html>
