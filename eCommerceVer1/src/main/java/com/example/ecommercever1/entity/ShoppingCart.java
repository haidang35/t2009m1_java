package com.example.ecommercever1.entity;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
    public static final String cartSession = "cart";
    private List<CartItem> cartItemList;
    private HttpSession session;

    public ShoppingCart() {
        cartItemList = new ArrayList<>();
    }

    public ShoppingCart(HttpSession session) {
        cartItemList = (List<CartItem>) session.getAttribute(cartSession);
        this.session = session;
        if(cartItemList == null) {
            cartItemList = new ArrayList<>();
        }
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public boolean addToCart(CartItem cartItem) {
        try {
            boolean isExist = false;
            for (CartItem item : cartItemList) {
                if(item.getId() == cartItem.getId()) {
                    isExist = true;
                    item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                    break;
                }
            }
            if(!isExist) {
                cartItemList.add(cartItem);
            }
            this.session.setAttribute(cartSession, cartItemList);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
       return false;
    }

    public boolean updateCartItem(int cartItemId, int quantity) {
        try {
            for(CartItem cartItem : cartItemList) {
                if(cartItem.getId() == cartItemId) {
                    cartItem.setQuantity(quantity);
                    break;
                }
            }
            this.session.setAttribute(cartSession, cartItemList);
            return true;
        }catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean removeCartItem(int cartItemId) {
        boolean isSuccess = false;
        try {
            for (CartItem cartItem : cartItemList) {
                if(cartItem.getId() == cartItemId) {
                    cartItemList.remove(cartItem);
                    isSuccess = true;
                    break;
                }
            }
            this.session.setAttribute(cartSession, cartItemList);
            return isSuccess;
        }catch (Exception e) {
          e.printStackTrace();
        }
        return false;
    }

    public double calcTotalMoney() {
        double total = 0;
        for(CartItem cartItem : cartItemList) {
            total += cartItem.getQuantity() * cartItem.getPrice();
        }
        return total;
    }
}
