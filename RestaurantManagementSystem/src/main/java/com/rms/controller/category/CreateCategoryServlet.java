package com.rms.controller.category;

import com.rms.entity.Category;
import com.rms.entity.entityEnum.CategoryStatus;
import com.rms.entity.entityEnum.FormAction;
import com.rms.entity.entityEnum.MessageType;
import com.rms.entity.viewEntity.MessageView;
import com.rms.model.MySqlCategoryModel;
import com.rms.model.interfaceModel.CategoryModel;
import com.rms.util.LanguageHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateCategoryServlet", urlPatterns = "/admin/categories/create")
public class CreateCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("formAction", FormAction.CREATE);
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/pages/category/form.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        int status = Integer.parseInt(req.getParameter("status"));
        int parentId = Integer.parseInt(req.getParameter("parentId"));
        Category category = Category.CategoryBuilder.aCategory()
                .withName(name)
                .withStatus(CategoryStatus.of(status))
                .withParentId(parentId)
                .build();
        if (category.isValid()) {
            HttpSession session = req.getSession();
            MessageView messageView = new MessageView();
            if(categoryModel.create(category)) {
                messageView.setMessageType(MessageType.SUCCESS);
                messageView.setContent(LanguageHelper.getString("addCategorySuccess"));
            }else {
                messageView.setMessageType(MessageType.ERROR);
                messageView.setContent(LanguageHelper.getString("addCategoryFailed"));
            }
            session.setAttribute("message", messageView);
            res.sendRedirect("/admin/categories");
            return;
        }
        req.setAttribute("formAction", FormAction.CREATE);
        req.setAttribute("errors", category.getErrors());
        List<Category> categoryList = categoryModel.findAll();
        req.setAttribute("formAction", FormAction.CREATE);
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/admin/pages/category/form.jsp").forward(req, res);
    }
}
