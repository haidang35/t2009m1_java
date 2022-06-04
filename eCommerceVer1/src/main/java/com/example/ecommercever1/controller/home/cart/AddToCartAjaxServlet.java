package com.example.ecommercever1.controller.home.cart;

import com.example.ecommercever1.entity.CartItem;
import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.entity.ShoppingCart;
import com.example.ecommercever1.model.MySqlProductModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToCartAjaxServlet extends HttpServlet {
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
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if(product == null) {
            String json = new Gson().toJson(new Object() {
                public String getType() {
                    return "error";
                }
            });
            resp.getWriter().write(json);
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
            String json = new Gson().toJson(new Object() {
                public String getType() {
                    return "success";
                }
            });
            resp.getWriter().write(json);
        }
    }
}
