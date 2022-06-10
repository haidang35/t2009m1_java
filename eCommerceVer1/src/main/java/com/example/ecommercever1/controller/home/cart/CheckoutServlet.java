package com.example.ecommercever1.controller.home.cart;

import com.example.ecommercever1.entity.*;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;
import com.example.ecommercever1.model.MySqlOrderItemModel;
import com.example.ecommercever1.model.MySqlOrderModel;
import com.example.ecommercever1.model.MySqlProductModel;
import com.example.ecommercever1.model.interfaceModel.OrderItemModel;
import com.example.ecommercever1.model.interfaceModel.OrderModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;
import com.example.ecommercever1.util.ConnectionHelper;
import com.example.ecommercever1.util.StringHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class CheckoutServlet extends HttpServlet {
    private OrderModel orderModel;
    private ProductModel productModel;
    private OrderItemModel orderItemModel;

    @Override
    public void init() throws ServletException {
        orderModel = new MySqlOrderModel();
        productModel = new MySqlProductModel();
        orderItemModel = new MySqlOrderItemModel();
    }

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
        req.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String companyName = req.getParameter("companyName");
        String country = req.getParameter("country");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phoneNumber = req.getParameter("phone");
        String note = req.getParameter("note");
        ShoppingCart cart = new ShoppingCart(req.getSession());
        if(cart.getCartItemList().size() == 0) {
            resp.sendRedirect("/");
        }
        String orderCode = StringHelper.generateOrderCode();
        Order order = Order.OrderBuilder.anOrder()
                .withCode(orderCode)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withCompanyName(companyName)
                .withCountry(country)
                .withAddress(address)
                .withEmail(email)
                .withPhoneNumber(phoneNumber)
                .withStatus(OrderStatus.PENDING)
                .withNote(note)
                .withTotal(cart.calcTotalMoney())
                .withShippingFee(0)
                .build();
        Connection connection = ConnectionHelper.getConnection();
        try {
            connection.setAutoCommit(false);
            if(orderModel.create(order)) {
                Order orderSaved = orderModel.findByCode(orderCode);
                if(orderSaved == null) {
                    req.getRequestDispatcher("/public/pages/errors/404.jsp").forward(req, resp);
                }
                for (CartItem cartItem : cart.getCartItemList()) {
                    Product product = productModel.findById(cartItem.getId());
                    if(product != null) {
                        OrderItem orderItem = OrderItem.OrderItemBuilder.anOrderItem()
                                .withOrderId(orderSaved.getId())
                                .withProductId(product.getId())
                                .withProductName(cartItem.getName())
                                .withQuantity(cartItem.getQuantity())
                                .withPrice(cartItem.getPrice())
                                .withThumbnail(cartItem.getThumbnail())
                                .build();
                        orderItemModel.create(orderItem);
                    }
                }
                cart.clearCart();
                connection.commit();
                req.getRequestDispatcher("/public/pages/notices/checkout-notice.jsp").forward(req, resp);
            }
        }catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
