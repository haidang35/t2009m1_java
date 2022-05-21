package com.example.helloservlet.controller;

import com.example.helloservlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Hello User Title");
        User user = new User("User 1", "user1@gmail.com", "123456");
        User user2 = new User("User 2", "user2@gmail.com", "123456");
        User user3 = new User("User 3", "user3@gmail.com", "123456");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
        userList.add(user3);
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("/user/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
