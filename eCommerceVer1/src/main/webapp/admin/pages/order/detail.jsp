<%@ page import="com.example.ecommercever1.entity.Order" %>
<%@ page import="com.example.ecommercever1.entity.OrderItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Form"/>
</jsp:include>
<%
    Order order = (Order) request.getAttribute("order");
    if(order == null) {
        order = Order.OrderBuilder.anOrder().build();
    }
%>
<body class="sidebar-fixed sidebar-dark header-light header-fixed" id="body">
<!--    <script>-->
<!--      NProgress.configure({ showSpinner: false });-->
<!--      NProgress.start();-->
<!--    </script>-->
<div class="mobile-sticky-body-overlay"></div>
<div class="wrapper">
    <jsp:include page="/admin/includes/sidebar.jsp"/>
    <div class="page-wrapper">
        <jsp:include page="/admin/includes/navbar.jsp"/>

        <div class="content-wrapper">
            <div class="content">
                <div class="invoice-wrapper rounded border bg-white py-5 px-3 px-md-4 px-lg-5">
                    <div class="d-flex justify-content-between">
                        <h2 class="text-dark font-weight-medium">Order Detail #<%=order.getCode()%></h2>
                        <div class="btn-group">
                            <button class="btn btn-sm btn-secondary">
                                <i class="mdi mdi-content-save"></i> Save
                            </button>
                            <button class="btn btn-sm btn-secondary">
                                <i class="mdi mdi-printer"></i> Print
                            </button>
                        </div>
                    </div>
                    <div class="row pt-5">
                        <div class="col-xl-3 col-lg-4">
                            <p class="text-dark mb-2">Customer Details:</p>
                            <address>
                                <br> <label class="font-weight-bold">First Name: </label> <%=order.getFirstName()%>
                                <br> <label class="font-weight-bold">Last Name: </label> <%=order.getLastName()%>
                                <br> <label class="font-weight-bold">Email: </label>   <%=order.getEmail()%>
                                <br> <label class="font-weight-bold">Phone: </label>   <%=order.getPhoneNumber()%>
                            </address>
                        </div>
                        <div class="col-xl-3 col-lg-4">
                            <p class="text-dark mb-2">Address </p>
                            <address>
                                <br> <label class="font-weight-bold">Company Name: </label> <%=order.getCompanyName() != null ? order.getCompanyName() : ""%>
                                <br> <label class="font-weight-bold">Country: </label> <%=order.getCountry()%>
                                <br> <label class="font-weight-bold">Address: </label>   <%=order.getAddress()%>
                            </address>
                        </div>
                        <div class="col-xl-3 col-lg-4">
                            <p class="text-dark mb-2">Details</p>
                            <address>
                                <br> <label class="font-weight-bold">Order Code: </label> <%=order.getCode()%>
                                <br> <label class="font-weight-bold">Created At: </label> <%=order.getCreatedAt()%>
                                <br> <label class="font-weight-bold">Status: </label>   <%=order.getStatus()%>
                                <br> <label class="font-weight-bold">Note: </label>   <%=order.getNote()%>
                            </address>
                        </div>
                    </div>
                    <table class="table mt-3 table-striped table-responsive table-responsive-large" style="width:100%">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Thumbnail</th>
                            <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            int index = 0;
                            for(OrderItem orderItem : order.getOrderItems()) {
                        %>
                            <tr>
                                <td><%=++index%></td>
                                <td>
                                    <img width="100" class="img-thumbnail img-responsive rounded" src="<%=orderItem.getThumbnail()%>" />
                                </td>
                                <td><%=orderItem.getProductName()%></td>
                                <td><%=orderItem.getQuantity()%></td>
                                <td><%=orderItem.getPrice()%></td>
                                <td><%=orderItem.getQuantity() * orderItem.getPrice()%></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                    <div class="row justify-content-end">
                        <div class="col-lg-5 col-xl-4 col-xl-3 ml-sm-auto">
                            <ul class="list-unstyled mt-4">
                                <li class="mid pb-3 text-dark"> Subtotal
                                    <span class="d-inline-block float-right text-default">$<%=order.getTotal()%></span>
                                </li>
                                <li class="mid pb-3 text-dark">Shipping Fee
                                    <span class="d-inline-block float-right text-default">$0</span>
                                </li>
                                <li class="pb-3 text-dark">Total
                                    <span class="d-inline-block float-right">$<%=order.getTotal()%></span>
                                </li>
                            </ul>
                            <a href="#" class="btn btn-block mt-2 btn-lg btn-primary btn-pill"> Procced to Payment</a>
                        </div>
                    </div>
                </div>
            </div>


        </div>

        <jsp:include page="/admin/includes/footer.jsp"/>
    </div>
</div>
<jsp:include page="/admin/includes/script.jsp"/>
</body>
</html>
