package com.wcd.controller;

import com.wcd.model.MySqlPhoneModel;
import com.wcd.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListPhoneServlet", urlPatterns = "/phones")
public class ListPhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;

    @Override
    public void init() throws ServletException {
        phoneModel = new MySqlPhoneModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("phoneList", phoneModel.findAll());
        req.getRequestDispatcher("/admin/pages/phone/listphone.jsp").forward(req, resp);
    }
}
