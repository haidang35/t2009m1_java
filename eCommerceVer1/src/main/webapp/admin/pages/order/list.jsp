<%@ page import="java.util.List" %>
<%@ page import="com.example.ecommercever1.entity.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.ecommercever1.entity.entityEnum.OrderStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Form"/>
</jsp:include>
<%
    List<Order> orderList = (List<Order>) request.getAttribute("orderList");
    if (orderList == null) {
        orderList = new ArrayList<>();
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
                <div class="row">
                    <div class="col-12">
                        <!-- Recent Order Table -->
                        <div class="card card-table-border-none" id="recent-orders">
                            <div class="card-header justify-content-between">
                                <h2>Recent Orders</h2>
                                <div class="date-range-report ">
                                    <span></span>
                                </div>
                            </div>
                            <div class="card-body pt-0 pb-5">
                                <div class="">
                                    <form method="get" action="/admin/orders" class="form-inline">
                                        <div class="form-group mr-3">
                                            <input type="text" name="search" value="<%=request.getParameter("search") != null ? request.getParameter("search") : "" %>" placeholder="Search Order Code" class="form-control">
                                        </div>
                                        <div class="form-group mr-3">
                                            <select name="status" class="form-control">
                                                <option value="0">Choose status</option>
                                                <% for(OrderStatus orderStatus : OrderStatus.values()) { %>
                                                     <option <%=  request.getParameter("status") != null ? request.getParameter("status").equals(String.valueOf(orderStatus.getValue())) ? "selected" : "" : "" %> value="<%=orderStatus.getValue()%>"><%=orderStatus.name()%></option>
                                                <% } %>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Search</button>
                                    </form>
                                </div>
                                <table class="table card-table table-responsive table-responsive-large"
                                       style="width:100%">
                                    <thead>
                                    <tr>
                                        <th>Order ID</th>
                                        <th>Order Code</th>
                                        <th>Customer Name</th>
                                        <th>Phone Number</th>
                                        <th>Status</th>
                                        <th>Created At</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Order order : orderList) {%>
                                    <tr>
                                        <td><%=order.getId()%>
                                        </td>
                                        <td>
                                            <a class="text-dark" href="#"><%=order.getCode()%>
                                            </a>
                                        </td>
                                        <td class="d-none d-md-table-cell"><%=order.getLastName() + " " + order.getFirstName()%>
                                        </td>
                                        <td class="d-none d-md-table-cell">
                                            <%=order.getPhoneNumber()%>
                                        </td>
                                        <td>
                                            <span class="badge badge-success">
                                                <%=order.getStatus()%>
                                            </span>
                                        </td>
                                        <td class="d-none d-md-table-cell"><%=order.getCreatedAt()%>
                                        </td>

                                        <td class="text-right">
                                            <div class="dropdown show d-inline-block widget-dropdown">
                                                <a class="dropdown-toggle icon-burger-mini" href="" role="button"
                                                   id="dropdown-recent-order1" data-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false" data-display="static"></a>
                                                <ul class="dropdown-menu dropdown-menu-right"
                                                    aria-labelledby="dropdown-recent-order1">
                                                    <li class="dropdown-item">
                                                        <a href="/admin/orders/detail?id=<%=order.getId()%>">View</a>
                                                    </li>
                                                    <li class="dropdown-item">
                                                        <a href="#">Remove</a>
                                                    </li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                    <% } %>


                                    </tbody>
                                </table>
                            </div>
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
