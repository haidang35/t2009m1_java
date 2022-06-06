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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListOrderServlet", urlPatterns = "/admin/orders")
public class ListOrderServlet extends HttpServlet {
    private OrderModel orderModel;

    @Override
    public void init() throws ServletException {
        orderModel = new MySqlOrderModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String search = req.getParameter("search");
        int status = -1;
        if(req.getParameter("status") != null) {
            status = Integer.parseInt(req.getParameter("status"));
        }
        List<Order> orderList = new ArrayList<>();
        if(search != null) {
            search = search.replaceAll(" ", "");
            Order order = orderModel.findByCode(search);
            if(order != null) {
                orderList.add(order);
            }
        }else {
            orderList = orderModel.findAll();
        }
        req.setAttribute("orderList", orderList);
        req.getRequestDispatcher("/admin/pages/order/list.jsp").forward(req, resp);
    }
}
