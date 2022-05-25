package com.t2009m1.accountmodelasm.controller;

import com.t2009m1.accountmodelasm.model.AccountModel;
import com.t2009m1.accountmodelasm.model.MySqlAccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAccountServlet extends HttpServlet {
    private AccountModel accountModel;

    @Override
    public void init() throws ServletException {
        accountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        if(accountModel.delete(id)) {
            resp.sendRedirect("/accounts");
        }
    }
}
