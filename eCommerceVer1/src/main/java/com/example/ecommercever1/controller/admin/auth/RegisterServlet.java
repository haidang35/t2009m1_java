package com.example.ecommercever1.controller.admin.auth;

import com.example.ecommercever1.entity.Account;
import com.example.ecommercever1.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminRegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/pages/auth/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");
        String cPassword = req.getParameter("cPassword");
        Account account = Account.AccountBuilder.anAccount()
                .withUsername(username)
                .withFullName(fullName)
                .withEmail(email)
                .withPassword(password)
                .withConfirmPassword(cPassword)
                .withPhoneNumber(phoneNumber)
                .build();
        if(account.isValid()) {
            if(accountService.register(account) != null) {
                resp.sendRedirect("/admin-login");
            }
        }else {
            req.setAttribute("errors", account.getErrors());
            req.setAttribute("account", account);
            req.getRequestDispatcher("/admin/pages/auth/register.jsp").forward(req, resp);
        }
    }
}
