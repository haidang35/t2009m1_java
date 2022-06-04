<%@ page import="com.example.ecommercever1.entity.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ecommercever1.entity.ShoppingCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    HttpSession session1 = request.getSession();
    ShoppingCart shoppingCart = new ShoppingCart(session1);
%>
<div class="header-middle text-dark sticky-header">
    <div class="container">
        <div class="header-left col-lg-2 w-auto pl-0">
            <button class="mobile-menu-toggler mr-2" type="button">
                <i class="fas fa-bars"></i>
            </button>
            <a href="demo1.html" class="logo">
                <img src="/public/assets/images/logo.png" width="111" height="44" alt="Porto Logo">
            </a>
        </div>
        <!-- End .header-left -->

        <div class="header-right w-lg-max pl-2">
            <div class="header-search header-icon header-search-inline header-search-category w-lg-max">
                <a href="#" class="search-toggle" role="button"><i class="icon-search-3"></i></a>
                <form action="#" method="get">
                    <div class="header-search-wrapper">
                        <input type="search" class="form-control" name="q" id="q" placeholder="Search..." required>
                        <div class="select-custom">
                            <select id="cat" name="cat">
                                <option value="">All Categories</option>
                                <option value="4">Fashion</option>
                                <option value="12">- Women</option>
                                <option value="13">- Men</option>
                                <option value="66">- Jewellery</option>
                                <option value="67">- Kids Fashion</option>
                                <option value="5">Electronics</option>
                                <option value="21">- Smart TVs</option>
                                <option value="22">- Cameras</option>
                                <option value="63">- Games</option>
                                <option value="7">Home &amp; Garden</option>
                                <option value="11">Motors</option>
                                <option value="31">- Cars and Trucks</option>
                                <option value="32">- Motorcycles &amp; Powersports</option>
                                <option value="33">- Parts &amp; Accessories</option>
                                <option value="34">- Boats</option>
                                <option value="57">- Auto Tools &amp; Supplies</option>
                            </select>
                        </div>
                        <!-- End .select-custom -->
                        <button class="btn icon-magnifier" type="submit"></button>
                    </div>
                    <!-- End .header-search-wrapper -->
                </form>
            </div>
            <!-- End .header-search -->

            <div class="header-contact d-none d-lg-flex align-items-center pr-xl-5 mr-5 mr-xl-3 ml-5">
                <i class="icon-phone-2"></i>
                <h6 class="pt-1 line-height-1">Call us now<a href="tel:#" class="d-block text-dark ls-10 pt-1">+123 5678
                    890</a></h6>
            </div>
            <!-- End .header-contact -->

            <a href="login.html" class="header-icon header-icon-user"><i class="icon-user-2"></i></a>

            <a href="wishlist.html" class="header-icon"><i class="icon-wishlist-2"></i></a>

            <div class="dropdown cart-dropdown">
                <a href="#" title="Cart" class="dropdown-toggle dropdown-arrow cart-toggle" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                    <i class="minicart-icon"></i>
                    <span class="cart-count badge-circle"><%=shoppingCart.getCartItemList().size()%></span>
                </a>

                <div class="cart-overlay"></div>

                <div class="dropdown-menu mobile-cart">
                    <a href="#" title="Close (Esc)" class="btn-close">×</a>

                    <div class="dropdownmenu-wrapper custom-scrollbar">
                        <div class="dropdown-cart-header">Shopping Cart</div>
                        <!-- End .dropdown-cart-header -->
                        <div class="dropdown-cart-products">
                           <% for(CartItem cartItem : shoppingCart.getCartItemList()) {%>
                            <div class="product">
                                <div class="product-details">
                                    <h4 class="product-title">
                                        <a href="/products?name=<%=cartItem.getSlug()%>">
                                            <%=cartItem.getName()%>
                                        </a>
                                    </h4>

                                    <span class="cart-product-info">
                                                    <span class="cart-product-qty"><%=cartItem.getQuantity()%></span> × $<%=cartItem.getPrice()%>
                                                </span>
                                </div>
                                <!-- End .product-details -->

                                <figure class="product-image-container">
                                    <a href="/products?name=<%=cartItem.getSlug()%>" class="product-image">
                                        <img src="<%=cartItem.getThumbnail()%>" alt="product" width="80"
                                             height="80">
                                    </a>
                                    <a href="#" class="btn-remove" title="Remove Product"><span>×</span></a>
                                </figure>
                            </div>
                           <% } %>
                        </div>
                        <!-- End .cart-product -->

                        <div class="dropdown-cart-total">
                            <span>SUBTOTAL:</span>

                            <span class="cart-total-price float-right">$<%=shoppingCart.calcTotalMoney()%></span>
                        </div>
                        <!-- End .dropdown-cart-total -->

                        <div class="dropdown-cart-action">
                            <a href="/cart" class="btn btn-gray btn-block view-cart">View
                                Cart</a>
                            <a href="#" class="btn btn-dark btn-block">Checkout</a>
                        </div>
                        <!-- End .dropdown-cart-total -->
                    </div>
                    <!-- End .dropdownmenu-wrapper -->
                </div>
                <!-- End .dropdown-menu -->
            </div>
            <!-- End .dropdown -->
        </div>
        <!-- End .header-right -->
    </div>
    <!-- End .container -->
</div>
<!-- End .header-middle -->
