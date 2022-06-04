package com.example.ecommercever1.controller.home.cart;

import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.entity.ShoppingCart;
import com.example.ecommercever1.model.MySqlProductModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveCartItemServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productModel.findById(id);
        if(product == null) {
            req.getRequestDispatcher("/public/pages/errors/404.jsp").forward(req, resp);
        }
        ShoppingCart shoppingCart = new ShoppingCart(req.getSession());
        if(shoppingCart.removeCartItem(id)) {
            // Handle success message
        }
        req.getRequestDispatcher("/public/pages/shop/cart.jsp").forward(req, resp);
    }
}
