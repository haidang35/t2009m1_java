<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<jsp:include page="/admin/includes/head.jsp">
    <jsp:param name="title" value="Form"/>
</jsp:include>
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
                                            <input type="text" class="form-control is-invalid"
                                                   id="name" name="name" placeholder="Name"
                                                   aria-describedby="inputGroupPrepend3">
                                            <div class="invalid-feedback">
                                                Name cannot be empty
                                            </div>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="brand">Brand</label>
                                            <select class="form-control is-invalid" name="brand"
                                                      id="brand">
                                                <option value="">Select brand</option>
                                                <option value="Apple">Apple</option>
                                                <option value="Samsung">Samsung</option>
                                                <option value="Nokia">Nokia</option>
                                                <option value="Others">Others</option>
                                            </select>
                                            <div class="invalid-feedback">
                                                Brand cannot be empty
                                            </div>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="price">Price</label>
                                            <input type="number" name="price" class="form-control is-invalid"
                                                   id="price" placeholder="Price"
                                                   aria-describedby="inputGroupPrepend3">
                                            <div class="invalid-feedback">
                                                Price cannot be empty
                                            </div>
                                        </div>
                                        <div class="col-md-12 mb-3">
                                            <label for="description">Description</label>
                                            <textarea name="description" class="form-control is-invalid"
                                                   id="description" placeholder="Price"></textarea>
                                            <div class="invalid-feedback">
                                                Description cannot be empty
                                            </div>
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
