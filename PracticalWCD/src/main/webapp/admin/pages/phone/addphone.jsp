<%@ page import="com.wcd.entity.Phone" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Form"/>
</jsp:include>
<%
    Phone phone = (Phone) request.getAttribute("phone");
    if(phone == null) {
        phone = Phone.PhoneBuilder.aPhone().build();
    }
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null) {
        errors = new HashMap<>();
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
                    <div class="col-lg-12">
                        <div class="card card-default">
                            <div class="card-header card-header-border-bottom">
                                <h2>Add Phone</h2>
                            </div>
                            <div class="card-body">
                                <form action="/phones/create" method="post">
                                    <div class="form-row">
                                        <div class="col-md-12 mb-3">
                                            <label for="name">Name</label>
                                            <input type="text" class="form-control   <% if(errors.containsKey("name")) {%> is-invalid <% } %>"
                                                   id="name" name="name" placeholder="Name"
                                                   value="<%=phone.getName()%>"
                                                   aria-describedby="inputGroupPrepend3">
                                            <% if(errors.containsKey("name")) {%>
                                            <div class="invalid-feedback">
                                                <%=errors.get("name")%>
                                            </div>
                                            <% } %>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="brand">Brand</label>
                                            <select class="form-control <% if(errors.containsKey("brand")) {%> is-invalid <% } %>" name="brand"
                                                      id="brand">
                                                <option value="">Select brand</option>
                                                <option value="Apple" <% if(phone.getBrand().equals("Apple")) { %> selected <% } %>>Apple</option>
                                                <option value="Samsung" <% if(phone.getBrand().equals("Samsung")) { %> selected <% } %>>Samsung</option>
                                                <option value="Nokia" <% if(phone.getBrand().equals("Nokia") ) { %> selected <% } %>>Nokia</option>
                                                <option value="Others" <% if(phone.getBrand().equals("Others") ) { %> selected <% } %>>Others</option>
                                            </select>
                                            <% if(errors.containsKey("brand")) {%>
                                            <div class="invalid-feedback">
                                                <%=errors.get("brand")%>
                                            </div>
                                            <% } %>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="price">Price</label>
                                            <input type="number" name="price" class="form-control <% if(errors.containsKey("price")) {%> is-invalid <% } %>"
                                                   id="price" placeholder="Price"
                                                   value="<%=phone.getPrice()%>"
                                                   aria-describedby="inputGroupPrepend3">
                                            <% if(errors.containsKey("price")) {%>
                                            <div class="invalid-feedback">
                                                <%=errors.get("price")%>
                                            </div>
                                            <% } %>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="description">Description</label>
                                            <textarea name="description" class="form-control <% if(errors.containsKey("description")) {%> is-invalid <% } %>"
                                                   id="description" placeholder="Price"><%=phone.getDescription()%></textarea>
                                            <% if(errors.containsKey("description")) {%>
                                            <div class="invalid-feedback">
                                                <%=errors.get("description")%>
                                            </div>
                                            <% } %>
                                        </div>

                                    </div>
                                    <div class="form-row">
                                        <button class="btn btn-primary mr-3" type="submit">Submit form</button>
                                        <button class="btn btn-danger" type="reset">Reset</button>
                                    </div>
                                </form>
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
