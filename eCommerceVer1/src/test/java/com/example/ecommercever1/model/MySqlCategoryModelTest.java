package com.example.ecommercever1.model;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.entityEnum.CategoryStatus;
import com.example.ecommercever1.model.interfaceModel.CategoryModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryModelTest {
    private CategoryModel categoryModel;

    @BeforeEach
    void setUp() {
        categoryModel = new MySqlCategoryModel();
        categoryModel.create(Category.CategoryBuilder.aCategory()
                .withName("Category Test")
                .withStatus(CategoryStatus.ACTIVE)
                .build());
    }

    @Test
    void create() {
        assertEquals(true, categoryModel.create(Category.CategoryBuilder.aCategory()
                .withName("Category 1")
                .withStatus(CategoryStatus.ACTIVE)
                .build()));
    }

    @Test
    void update() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        assertNotEquals(null, category);
        category.setName("Category Updated");
        categoryModel.update(category.getId(), category);
        Category categoryUpdated = categoryModel.findById(category.getId());
        assertEquals(category.getName(), categoryUpdated.getName());
    }

    @Test
    void delete() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        assertNotEquals(null, category);
        assertEquals(true, categoryModel.delete(category.getId()));
    }

    @Test
    void findById() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        assertNotEquals(null, category);
        assertNotEquals(null, categoryModel.findById(category.getId()));
    }

    @Test
    void findAll() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
    }

    @Test
    void findBySlug() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        assertNotEquals(null, category);
        assertNotEquals(null, categoryModel.findBySlug(category.getSlug()));
    }
}
