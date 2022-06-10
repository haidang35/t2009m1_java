package com.rms.model;

import com.rms.entity.Category;
import com.rms.entity.Food;
import com.rms.entity.entityEnum.FoodStatus;
import com.rms.model.interfaceModel.CategoryModel;
import com.rms.model.interfaceModel.FoodModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlFoodModelTest {
    private FoodModel foodModel;
    private CategoryModel categoryModel;

    @BeforeEach
    void setUp() {
        foodModel = new MySqlFoodModel();
        categoryModel = new MySqlCategoryModel();
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Food 1")
                .withThumbnail("https://res.edu.vn/wp-content/uploads/2021/12/unit-46-topic-food.jpeg")
                .withPrice(50000)
                .withCategoryId(category.getId())
                .withDescription("Food description")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("F000" + System.nanoTime())
                .build());
    }

    @Test
    void create() {
        List<Category> categoryList = categoryModel.findAll();
        assertNotEquals(0, categoryList.size());
        Category category = categoryList.get(0);
        assertEquals(true, foodModel.create(Food.FoodBuilder.aFood()
                        .withName("Food 1")
                        .withThumbnail("https://res.edu.vn/wp-content/uploads/2021/12/unit-46-topic-food.jpeg")
                        .withPrice(50000)
                        .withCategoryId(category.getId())
                        .withDescription("Food description")
                        .withStatus(FoodStatus.ON_SALE)
                        .withCode("F000" + System.nanoTime())
                        .build()));
    }

    @Test
    void update() {
        List<Food> foodList = foodModel.findAll();
        assertNotEquals(0, foodList.size());
        Food food = foodList.get(0);
        food.setName("Food Updated Name");
        assertEquals(true, foodModel.update(food.getId(), food));
        Food foodUpdated = foodModel.findById(food.getId());
        assertNotEquals(null, foodUpdated);
        assertEquals(food.getName(), foodUpdated.getName());
    }

    @Test
    void delete() {
        List<Food> foodList = foodModel.findAll();
        assertNotEquals(0, foodList.size());
        Food food = foodList.get(0);
        assertEquals(true, foodModel.delete(food.getId()));
    }

    @Test
    void findById() {
        List<Food> foodList = foodModel.findAll();
        assertNotEquals(0, foodList.size());
        Food food = foodList.get(0);
        assertNotEquals(null, foodModel.findById(food.getId()));
    }

    @Test
    void findByCode() {
        List<Food> foodList = foodModel.findAll();
        assertNotEquals(0, foodList.size());
        Food food = foodList.get(0);
        assertNotEquals(null, foodModel.findByCode(food.getCode()));
    }

    @Test
    void findAll() {
        List<Food> foodList = foodModel.findAll();
        assertNotEquals(0, foodList.size());
    }
}
