package com.t2009m1.accountmodelasm.controller;

import com.t2009m1.accountmodelasm.entity.Account;
import com.t2009m1.accountmodelasm.model.MySqlAccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountServlet extends HttpServlet {
    private MySqlAccountModel mySqlAccountModel;

    @Override
    public void init() throws ServletException {
        mySqlAccountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/account/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; chartset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        System.out.println("Full name " + fullName);
        String username = req.getParameter("username");
        System.out.println("username " + username);
        String email = req.getParameter("email");
        System.out.println("email " + email);
        String password = req.getParameter("password");
        System.out.println("password " + password);
        int status = Integer.parseInt(req.getParameter("status"));
        System.out.println("status " + status);
        Account account = new Account(fullName, username, email, password, status);
        mySqlAccountModel.save(account);
        resp.sendRedirect("/");
    }
}
