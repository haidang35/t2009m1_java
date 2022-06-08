package com.example.ecommercever1.controller.admin.auth;

import com.example.ecommercever1.constant.ValidationConstant;
import com.example.ecommercever1.entity.Account;
import com.example.ecommercever1.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;


public class LoginServlet extends HttpServlet {
    private HashMap<String, String> errors;
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        errors = new HashMap<>();
        accountService = new AccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/pages/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("") || username == null) {
            errors.put(ValidationConstant.ACCOUNT_ERROR_KEY_USERNAME, ValidationConstant.ACCOUNT_ERROR_MESSAGE_USERNAME_REQUIRED);
        }
        if(password.equals("") || password == null) {
            errors.put(ValidationConstant.ACCOUNT_ERROR_KEY_PASSWORD, ValidationConstant.ACCOUNT_ERROR_MESSAGE_PASSWORD_REQUIRED);
        }
        HttpSession session = req.getSession();
        if(errors.size() == 0) {
            Account account = accountService.login(username, password);
            System.out.println("acc " + account.toString());
            if(account != null) {
                session.setAttribute("currentAccount", account);
                resp.sendRedirect("/admin/categories");
                return;
            }
        }
        req.setAttribute("errors", errors);
        req.setAttribute("username", username);
        req.getRequestDispatcher("/admin/pages/auth/login.jsp").forward(req, resp);
    }
}
