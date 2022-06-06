package com.example.ecommercever1.controller.admin.order;

import com.example.ecommercever1.entity.Order;
import com.example.ecommercever1.model.MySqlOrderModel;
import com.example.ecommercever1.model.interfaceModel.OrderModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailOrderServlet", urlPatterns = "/admin/orders/detail")
public class DetailOrderServlet extends HttpServlet {
    private OrderModel orderModel;

    @Override
    public void init() throws ServletException {
        orderModel = new MySqlOrderModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Order order = orderModel.findById(id);
        if(order == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        req.setAttribute("order", order);
        req.getRequestDispatcher("/admin/pages/order/detail.jsp").forward(req, resp);
    }
}
