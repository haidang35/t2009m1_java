<%@ page import="com.wcd.entity.Phone" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Phone List"/>
</jsp:include>
<%
    List<Phone> phoneList = (List<Phone>) request.getAttribute("phoneList");
    if (phoneList == null) {
        phoneList = new ArrayList<>();
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
                                <h2>Phone List</h2>
                                <div class="date-range-report ">
                                    <span></span>
                                </div>
                            </div>
                            <div class="card-body pt-0 pb-5">
                                <%
                                    String message = (String) session.getAttribute("message");
                                    if(message != null) {
                                %>
                                <div class="alert alert-success">
                                    <%=message%>
                                </div>
                                <% } %>
                                <table class="table card-table table-responsive table-responsive-large"
                                       style="width:100%">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Brand</th>
                                        <th>Price</th>
                                        <th>Created At</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <% for (Phone phone : phoneList) { %>
                                    <tr>
                                        <td><%=phone.getId()%></td>
                                        <td>
                                            <a class="text-dark" href=""> <%=phone.getName()%></a>
                                        </td>
                                        <td class="d-none d-md-table-cell"><%=phone.getBrand()%></td>
                                        <td class="d-none d-md-table-cell"><%=phone.getPrice()%></td>
                                        <td class="d-none d-md-table-cell"><%=phone.getCreatedAt()%></td>
                                        <td class="text-right">
                                            <div class="dropdown show d-inline-block widget-dropdown">
                                                <a class="dropdown-toggle icon-burger-mini" href="" role="button"
                                                   id="dropdown-recent-order1" data-toggle="dropdown"
                                                   aria-haspopup="true" aria-expanded="false" data-display="static"></a>
                                                <ul class="dropdown-menu dropdown-menu-right"
                                                    aria-labelledby="dropdown-recent-order1">
                                                    <li class="dropdown-item">
                                                        <a href="#">View</a>
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
