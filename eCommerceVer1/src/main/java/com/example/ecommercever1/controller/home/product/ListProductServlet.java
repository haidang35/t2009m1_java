package com.example.ecommercever1.controller.home.product;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.Product;
import com.example.ecommercever1.model.MySqlCategoryModel;
import com.example.ecommercever1.model.MySqlProductModel;
import com.example.ecommercever1.model.interfaceModel.CategoryModel;
import com.example.ecommercever1.model.interfaceModel.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
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
       Category category = categoryModel.findBySlug(slug);
       if(category == null) {
           req.getRequestDispatcher("/public/pages/errors/404.jsp").forward(req, resp);
           return;
       }
       req.setAttribute("productList", productModel.findByCategory(category.getId()));
       req.setAttribute("categoryList", categoryModel.findAll());
       req.getRequestDispatcher("/public/pages/shop/product-list.jsp").forward(req, resp);
    }
}
