package com.wcd.controller;

import com.wcd.entity.Phone;
import com.wcd.model.MySqlPhoneModel;
import com.wcd.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreatePhoneServlet", urlPatterns = "/phones/create")
public class CreatePhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;

    @Override
    public void init() throws ServletException {
        phoneModel = new MySqlPhoneModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        req.getRequestDispatcher("/admin/pages/phone/addphone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");
        double price = 0;
        if(req.getParameter("price") != null) {
            price = Double.parseDouble(req.getParameter("price"));
        }
        Phone phone = Phone.PhoneBuilder.aPhone()
                .withName(name)
                .withBrand(brand)
                .withPrice(price)
                .withDescription(description)
                .build();
        HttpSession session = req.getSession();
        if(phoneModel.create(phone)) {
            session.setAttribute("message", "Add new phone successfully !");
            resp.sendRedirect("/phones");
            return;
        }
        session.setAttribute("message", "Add new phone failed !");
        req.getRequestDispatcher("/admin/pages/phone/addphone.jsp").forward(req, resp);
    }
}
