package com.example.ecommercever1.model.seeder;

import com.example.ecommercever1.entity.Category;
import com.example.ecommercever1.entity.entityEnum.CategoryStatus;
import com.example.ecommercever1.model.MySqlCategoryModel;
import com.example.ecommercever1.model.interfaceModel.CategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder() {
        categoryModel = new MySqlCategoryModel();
    }

    public void seedData() {
        categoryModel.create(Category.CategoryBuilder.aCategory()
                        .withName("Category 1")
                        .withStatus(CategoryStatus.ACTIVE)
                        .build());
    }
}
