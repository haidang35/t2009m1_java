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

public class UpdateCartAjaxServlet extends HttpServlet {
    private ProductModel productModel;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        Product product = productModel.findById(id);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if(product == null) {
            Object resJson = new Object() {
                public final boolean success = false;
            };
            resp.getWriter().print(gson.toJson(resJson));
            resp.getWriter().flush();
        }
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = new ShoppingCart(session);
        if(shoppingCart.updateCartItem(id, quantity)) {
            UpdateCartResponse updateCartResponse = new UpdateCartResponse(true, shoppingCart.calcTotalMoney());
            System.out.println(gson.toJson(updateCartResponse));
            resp.getWriter().print(gson.toJson(updateCartResponse));
            resp.getWriter().flush();
        }else {
            Object resJson = new Object() {
                public final boolean success = false;
            };
            resp.getWriter().print(gson.toJson(resJson));
            resp.getWriter().flush();
        }
    }
}

  class UpdateCartResponse {
    public boolean success;
    public double subTotal;

     public UpdateCartResponse(boolean success, double subTotal) {
         this.success = success;
         this.subTotal = subTotal;
     }
 }
