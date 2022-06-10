package com.rms.controller.category;

import com.rms.entity.Category;
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

@WebServlet(name = "DeleteCategoryServlet", urlPatterns = "/admin/categories/delete")
public class DeleteCategoryServlet extends HttpServlet {
    private CategoryModel categoryModel;

    @Override
    public void init() throws ServletException {
        categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if(req.getParameter("id") == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, res);
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryModel.findById(id);
        if(category == null) {
            req.getRequestDispatcher("/admin/pages/errors/404.jsp").forward(req, res);
            return;
        }
        MessageView messageView = new MessageView();
        HttpSession session = req.getSession();
        if(categoryModel.delete(id)) {
           messageView.setMessageType(MessageType.SUCCESS);
           messageView.setContent(LanguageHelper.getString("deleteCategorySuccess"));
        }else {
            messageView.setMessageType(MessageType.ERROR);
            messageView.setContent(LanguageHelper.getString("deleteCategoryFailed"));
        }
        session.setAttribute("message", messageView);
        res.sendRedirect("/admin/categories");
    }
}
