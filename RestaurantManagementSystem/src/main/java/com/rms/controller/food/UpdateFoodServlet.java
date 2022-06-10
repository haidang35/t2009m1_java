package com.rms.controller.food;

import com.rms.entity.Category;
import com.rms.entity.Food;
import com.rms.entity.entityEnum.FoodStatus;
import com.rms.entity.entityEnum.FormAction;
import com.rms.entity.entityEnum.MessageType;
import com.rms.entity.viewEntity.MessageView;
import com.rms.model.MySqlCategoryModel;
import com.rms.model.MySqlFoodModel;
import com.rms.model.interfaceModel.CategoryModel;
import com.rms.model.interfaceModel.FoodModel;
import com.rms.util.LanguageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateFoodServlet", urlPatterns = "/admin/foods/update")
public class UpdateFoodServlet extends HttpServlet {
    private FoodModel foodModel;
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        foodModel = new MySqlFoodModel();
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id") == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Food food = foodModel.findById(id);
        if(food == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("formAction", FormAction.UPDATE);
        req.setAttribute("categoryList", categoryList);
        req.setAttribute("food", food);
        req.getRequestDispatcher("/admin/pages/food/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        if(foodModel.findById(id) == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, resp);
            return;
        }
        String name = req.getParameter("name");
        String thumbnail = req.getParameter("thumbnail");
        String code = req.getParameter("code");
        String description = req.getParameter("description");
        double price = 0;
        if(req.getParameter("price") != null) {
            price = Double.parseDouble(req.getParameter("price"));
        }
        FoodStatus status = FoodStatus.of(Integer.parseInt(req.getParameter("status")));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        Food food = Food.FoodBuilder.aFood()
                .withName(name)
                .withCode(code)
                .withThumbnail(thumbnail)
                .withPrice(price)
                .withStatus(status)
                .withCategoryId(categoryId)
                .withDescription(description)
                .build();
        HttpSession session = req.getSession();
        MessageView messageView = new MessageView();
        try {
            if(food.isValid()) {
                if(foodModel.update(id, food)) {
                    messageView.setMessageType(MessageType.SUCCESS);
                    messageView.setContent(LanguageHelper.getString("updateProductSuccess"));
                }else {
                    throw new Exception();
                }
            }else {
                System.out.println("hello");
                List<Category> categoryList = categoryModel.findAll();
                req.setAttribute("formAction", FormAction.UPDATE);
                req.setAttribute("categoryList", categoryList);
                req.setAttribute("food", food);
                req.setAttribute("errors", food.getErrors());
                req.getRequestDispatcher("/admin/pages/food/form.jsp").forward(req, resp);
                return;
            }
        }catch (Exception e) {
            messageView.setMessageType(MessageType.ERROR);
            messageView.setContent(LanguageHelper.getString("updateProductFailed"));
        }
        session.setAttribute("message", messageView);
        resp.sendRedirect("/admin/foods");
    }
}
