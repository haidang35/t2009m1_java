<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/public/includes/head.jsp" />
<body>
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
        <jsp:include page="/public/includes/header-top.jsp" />
        <jsp:include page="/public/includes/header-middle.jsp" />
        <jsp:include page="/public/includes/navbar.jsp" />
    </header>
    <!-- End .header -->

    <main class="main">
        <div class="container">
            <div class="m-5">
                <h1 class="title text-success text-center">Order successfully. Thanks !</h1>
            </div>
        </div>
        <!-- End .container -->
        <div class="mb-4"></div>
        <!-- margin -->
    </main>
    <!-- End .main -->
    <jsp:include page="/public/includes/footer.jsp" />
</div>
<!-- End .page-wrapper -->

<div class="loading-overlay">
    <div class="bounce-loader">
        <div class="bounce1"></div>
        <div class="bounce2"></div>
        <div class="bounce3"></div>
    </div>
</div>

<jsp:include page="/public/includes/mobile-menu.jsp" />

<jsp:include page="/public/includes/sticky-navbar.jsp" />

<!-- End .newsletter-popup -->
<a id="scroll-top" href="#top" title="Top" role="button"><i class="icon-angle-up"></i></a>
<jsp:include page="/public/includes/script.jsp" />
</body>
</html>

