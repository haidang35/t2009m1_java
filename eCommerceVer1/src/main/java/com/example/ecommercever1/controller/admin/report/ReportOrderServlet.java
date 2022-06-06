package com.example.ecommercever1.controller.admin.report;

import com.example.ecommercever1.entity.Report;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;
import com.example.ecommercever1.model.MySqlReportModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReportOrderServlet", urlPatterns = "/admin/reports/order")
public class ReportOrderServlet extends HttpServlet {
    private MySqlReportModel reportModel;

    @Override
    public void init() throws ServletException {
        reportModel = new MySqlReportModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int orderStatus = 99;
        int totalOrders = 0;
        double totalPriceOrders = 0;
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        if(req.getParameter("status") != null) {
            orderStatus = Integer.parseInt(req.getParameter("status"));
        }
        if(from != null && to != null && orderStatus != 99) {
            totalOrders = reportModel.getCountOrderByCreatedAtAndStatus(from, to, OrderStatus.of(orderStatus));
            totalPriceOrders = reportModel.getSumTotalPriceOrderByCreatedAtAndStatus(from, to, OrderStatus.of(orderStatus));
        }else {
            totalOrders = reportModel.getCountOrder();
            totalPriceOrders = reportModel.getSumTotalPriceOrder();
        }
        req.setAttribute("totalOrders", totalOrders);
        req.setAttribute("totalPriceOrders", totalPriceOrders);
        req.getRequestDispatcher("/admin/pages/report/order.jsp").forward(req, resp);
    }
}
