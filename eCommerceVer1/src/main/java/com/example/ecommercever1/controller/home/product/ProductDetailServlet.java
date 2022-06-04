package com.example.ecommercever1.controller.home.product;

import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.model.MySqlCategoryModel;
import com.example.ecommercever1.model.MySqlProductModel;
import com.example.ecommercever1.model.interfaceModel.CategoryModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductDetailServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        productModel = new MySqlProductModel();
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String slug = req.getParameter("name");
        if(slug == null) {
           req.getRequestDispatcher("/public/pages/errors/404.jsp").forward(req, resp);
        }
        Product product = productModel.findBySlug(slug);
        if(product == null) {
            req.getRequestDispatcher("/public/pages/errors/404.jsp").forward(req, resp);
        }
        req.setAttribute("product", product);
        req.getRequestDispatcher("/public/pages/shop/product.jsp").forward(req, resp);
    }
}
