<%@ page import="com.example.ecommercever1.entity.ShoppingCart" %>
<%@ page import="com.example.ecommercever1.entity.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/public/includes/head.jsp">
    <jsp:param name="style" value="true"/>
</jsp:include>
<body>
<%
    HttpSession session1 = request.getSession();
    ShoppingCart shoppingCart = new ShoppingCart(session1);
%>
<div class="page-wrapper">
    <div class="top-notice text-white bg-dark">
        <div class="container text-center">
            <h5 class="d-inline-block mb-0">Get Up to <b>40% OFF</b> New-Season Styles</h5>
            <a href="demo1-shop.html" class="category">MEN</a>
            <a href="demo1-shop.html" class="category">WOMEN</a>
            <small>* Limited time only.</small>
            <button title="Close (Esc)" type="button" class="mfp-close">×</button>
        </div>
        <!-- End .container -->
    </div>
    <!-- End .top-notice -->

    <header class="header home">
        <jsp:include page="/public/includes/header-top.jsp"/>
        <jsp:include page="/public/includes/header-middle.jsp"/>
        <jsp:include page="/public/includes/navbar.jsp"/>
    </header>
    <!-- End .header -->

    <main class="main">
        <div class="container">
            <ul class="checkout-progress-bar d-flex justify-content-center flex-wrap">
                <li class="active">
                    <a href="cart.html">Shopping Cart</a>
                </li>
                <li>
                    <a href="checkout.html">Checkout</a>
                </li>
                <li class="disabled">
                    <a href="cart.html">Order Complete</a>
                </li>
            </ul>

            <div class="row">
                <div class="col-lg-8">
                    <div class="cart-table-container">
                        <table class="table table-cart">
                            <thead>
                            <tr>
                                <th class="thumbnail-col"></th>
                                <th class="product-col">Product</th>
                                <th class="price-col">Price</th>
                                <th class="qty-col">Quantity</th>
                                <th class="text-right">Subtotal</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% for(CartItem cartItem : shoppingCart.getCartItemList()) { %>
                            <tr class="product-row">
                                <td>
                                    <figure class="product-image-container">
                                        <a href="product.html" class="product-image">
                                            <img src="<%=cartItem.getThumbnail()%>" alt="product">
                                        </a>

                                        <a href="/remove-cart-item?id=<%=cartItem.getId()%>" class="btn-remove icon-cancel" title="Remove Product"></a>
                                    </figure>
                                </td>
                                <td class="product-col">
                                    <h5 class="product-title">
                                        <a href="/products?name=<%=cartItem.getSlug()%>"><%=cartItem.getName()%></a>
                                    </h5>
                                </td>
                                <td>$<%=cartItem.getPrice()%></td>
                                <td>
                                    <div class="product-single-qty">
                                        <input class="horizontal-quantity form-control" value="<%=cartItem.getQuantity()%>"
                                               type="text" name="quantity"
                                               data-id="<%=cartItem.getId()%>"
                                                data-price="<%=cartItem.getPrice()%>">
                                    </div><!-- End .product-single-qty -->
                                </td>
                                <td class="text-right"><span class="subtotal-price subtotal-price-id-<%=cartItem.getId()%>">$<%=cartItem.getQuantity() * cartItem.getPrice()%></span></td>
                            </tr>

                            <% } %>
                            </tbody>


                            <tfoot>
                            <tr>
                                <td colspan="5" class="clearfix">
                                    <div class="float-left">
                                        <div class="cart-discount">
                                            <form action="#">
                                                <div class="input-group">
                                                    <input type="text" class="form-control form-control-sm"
                                                           placeholder="Coupon Code" required>
                                                    <div class="input-group-append">
                                                        <button class="btn btn-sm" type="submit">Apply
                                                            Coupon
                                                        </button>
                                                    </div>
                                                </div><!-- End .input-group -->
                                            </form>
                                        </div>
                                    </div><!-- End .float-left -->

                                    <div class="float-right">
                                        <button type="submit" class="btn btn-shop btn-update-cart">
                                            Update Cart
                                        </button>
                                    </div><!-- End .float-right -->
                                </td>
                            </tr>
                            </tfoot>
                        </table>
                    </div><!-- End .cart-table-container -->
                </div><!-- End .col-lg-8 -->

                <div class="col-lg-4">
                    <div class="cart-summary">
                        <h3>CART TOTALS</h3>

                        <table class="table table-totals">
                            <tbody>
                            <tr>
                                <td>Subtotal</td>
                                <td id="subtotal">$<%=shoppingCart.calcTotalMoney()%></td>
                            </tr>

                            <tr>
                                <td colspan="2" class="text-left">
                                    <h4>Shipping</h4>

<%--                                    <div class="form-group form-group-custom-control">--%>
<%--                                        <div class="custom-control custom-radio">--%>
<%--                                            <input type="radio" class="custom-control-input" name="radio"--%>
<%--                                                   checked>--%>
<%--                                            <label class="custom-control-label">Local pickup</label>--%>
<%--                                        </div><!-- End .custom-checkbox -->--%>
<%--                                    </div><!-- End .form-group -->--%>

<%--                                    <div class="form-group form-group-custom-control mb-0">--%>
<%--                                        <div class="custom-control custom-radio mb-0">--%>
<%--                                            <input type="radio" name="radio" class="custom-control-input">--%>
<%--                                            <label class="custom-control-label">Flat rate</label>--%>
<%--                                        </div><!-- End .custom-checkbox -->--%>
<%--                                    </div><!-- End .form-group -->--%>

<%--                                    <form action="#">--%>
<%--                                        <div class="form-group form-group-sm">--%>
<%--                                            <label>Shipping to <strong>NY.</strong></label>--%>
<%--                                            <div class="select-custom">--%>
<%--                                                <select class="form-control form-control-sm">--%>
<%--                                                    <option value="USA">United States (US)</option>--%>
<%--                                                    <option value="Turkey">Turkey</option>--%>
<%--                                                    <option value="China">China</option>--%>
<%--                                                    <option value="Germany">Germany</option>--%>
<%--                                                </select>--%>
<%--                                            </div><!-- End .select-custom -->--%>
<%--                                        </div><!-- End .form-group -->--%>

<%--                                        <div class="form-group form-group-sm">--%>
<%--                                            <div class="select-custom">--%>
<%--                                                <select class="form-control form-control-sm">--%>
<%--                                                    <option value="NY">New York</option>--%>
<%--                                                    <option value="CA">California</option>--%>
<%--                                                    <option value="TX">Texas</option>--%>
<%--                                                </select>--%>
<%--                                            </div><!-- End .select-custom -->--%>
<%--                                        </div><!-- End .form-group -->--%>

<%--                                        <div class="form-group form-group-sm">--%>
<%--                                            <input type="text" class="form-control form-control-sm"--%>
<%--                                                   placeholder="Town / City">--%>
<%--                                        </div><!-- End .form-group -->--%>

<%--                                        <div class="form-group form-group-sm">--%>
<%--                                            <input type="text" class="form-control form-control-sm"--%>
<%--                                                   placeholder="ZIP">--%>
<%--                                        </div><!-- End .form-group -->--%>

<%--                                        <button type="submit" class="btn btn-shop btn-update-total">--%>
<%--                                            Update Totals--%>
<%--                                        </button>--%>
<%--                                    </form>--%>
                                </td>
                            </tr>
                            </tbody>

                            <tfoot>
                            <tr>
                                <td>Total</td>
                                <td id="total">$<%=shoppingCart.calcTotalMoney()%></td>
                            </tr>
                            </tfoot>
                        </table>

                        <div class="checkout-methods">
                            <a href="/checkout" class="btn btn-block btn-dark">Proceed to Checkout
                                <i class="fa fa-arrow-right"></i></a>
                        </div>
                    </div><!-- End .cart-summary -->
                </div><!-- End .col-lg-4 -->
            </div><!-- End .row -->
        </div><!-- End .container -->

        <div class="mb-6"></div><!-- margin -->
    </main><!-- End .main -->
    <!-- End .main -->
    <jsp:include page="/public/includes/footer.jsp"/>
</div>
<!-- End .page-wrapper -->

<div class="loading-overlay">
    <div class="bounce-loader">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
    </div>
</div>

<jsp:include page="/public/includes/mobile-menu.jsp"/>

<jsp:include page="/public/includes/sticky-navbar.jsp"/>

<a id="scroll-top" href="#top" title="Top" role="button"><i class="icon-angle-up"></i></a>
<jsp:include page="/public/includes/script.jsp"/>
<script>
    $(document).ready(function() {
        $('input[name=quantity]').change(function() {
            const cartItemId = $(this).data("id");
            const quantity = $(this).val();
            const price = $(this).data("price");
            $(`.subtotal-price-id-` + cartItemId).html("$" + parseFloat(price) * parseInt(quantity));
            $.ajax({
                url: '/update-cart-item-ajax',
                type: 'POST',
                dataType: 'application/json',
                data: {
                    productId: cartItemId,
                    quantity,
                },
                success : function (result){
                    console.log("result")
                    console.log(result)
                    $("#subtotal").text(result.subTotal);
                },
                error: function (err) {
                    const data = JSON.parse(err.responseText);
                    $("#subtotal").text("$" + data.subTotal);
                    $("#total").text("$" + data.subTotal);
                }
            });
        })
    })
</script>
</body>
</html>

