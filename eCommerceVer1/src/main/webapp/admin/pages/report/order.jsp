<%@ page import="com.example.ecommercever1.entity.Report" %>
<%@ page import="com.example.ecommercever1.entity.entityEnum.OrderStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Form"/>
</jsp:include>
<%
    int totalOrders = (Integer) request.getAttribute("totalOrders");
    double totalPriceOrders = (Double) request.getAttribute("totalPriceOrders");
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
                        <h2 class="text-dark font-weight-medium">Report Order</h2>
                        <div class="btn-group">
                            <button class="btn btn-sm btn-secondary">
                                <i class="mdi mdi-content-save"></i> Export
                            </button>
                            <button class="btn btn-sm btn-secondary">
                                <i class="mdi mdi-printer"></i> Print
                            </button>
                        </div>
                    </div>
                    <div class="row pt-5">
                        <div class="col-xl-8 col-lg-12">
                            <form action="/admin/reports/order" method="get" class="form-inline">
                                <div class="form-group mr-3">
                                    <input type="date" name="from" value="<%=request.getParameter("from")%>" placeholder="From"  class="form-control"/>
                                </div>
                                <div class="form-group mr-3">
                                    <input type="date" name="to" value="<%=request.getParameter("to")%>" placeholder="To"  class="form-control"/>
                                </div>
                                <div class="form-group mr-3">
                                    <select name="status" class="form-control">
                                        <option value="99">All</option>
                                        <% for(OrderStatus status : OrderStatus.values()) { %>
                                        <option <%=request.getParameter("status") != null ? Integer.parseInt(request.getParameter("status")) == status.getValue() ? "selected" : "" : ""%> value="<%=status.getValue()%>"><%=status.name()%></option>
                                        <% } %>
                                    </select>
                                </div>
                                <button class="btn btn-primary">Filter</button>
                            </form>
                        </div>
                    </div>
                    <table class="table mt-3 table-striped table-responsive table-responsive-large" style="width:100%">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Report</th>
                            <th>Quantity</th>
                            <th>Total Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>Total Orders</td>
                            <td><%=totalOrders%></td>
                            <td><%=totalPriceOrders%></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="row justify-content-end">
                        <div class="col-lg-5 col-xl-4 col-xl-3 ml-sm-auto">
                            <ul class="list-unstyled mt-4">
                                <li class="pb-3 text-dark">Total
                                    <span class="d-inline-block float-right">$8.686,70</span>
                                </li>
                            </ul>
                            <a href="#" class="btn btn-block mt-2 btn-lg btn-primary btn-pill"> Export</a>
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

