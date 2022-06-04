package com.example.ecommercever1.controller.home.cart;

import com.example.ecommercever1.entity.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShoppingCart shoppingCart = new ShoppingCart(req.getSession());
        if(shoppingCart.getCartItemList().size() == 0) {
            resp.sendRedirect("/cart");
            return;
        }
        req.getRequestDispatcher("/public/pages/shop/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
