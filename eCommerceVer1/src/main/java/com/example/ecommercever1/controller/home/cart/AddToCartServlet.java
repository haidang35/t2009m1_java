package com.example.ecommercever1.controller.home.cart;

import com.example.ecommercever1.entity.CartItem;
import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.entity.ShoppingCart;
import com.example.ecommercever1.model.MySqlProductModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToCartServlet extends HttpServlet {
    private ProductModel productModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Product product = productModel.findById(id);
        if(product == null) {
            req.getRequestDispatcher("/public/pages/errors/404.jsp").forward(req, resp);
        }
        CartItem cartItem = CartItem.CartItemBuilder.aCartItem()
                .withId(id)
                .withName(product.getName())
                .withSlug(product.getSlug())
                .withThumbnail(product.getThumbnail())
                .withQuantity(quantity)
                .withPrice(product.getPrice())
                .build();
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = new ShoppingCart(session);
        if(shoppingCart.addToCart(cartItem)) {
            resp.sendRedirect("/categories?name=" + product.getCategory().getSlug());
        }
    }
}
