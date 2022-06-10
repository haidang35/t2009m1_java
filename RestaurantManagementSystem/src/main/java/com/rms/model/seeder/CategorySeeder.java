package com.rms.model.seeder;

import com.rms.entity.Category;
import com.rms.entity.entityEnum.CategoryStatus;
import com.rms.model.MySqlCategoryModel;
import com.rms.model.interfaceModel.CategoryModel;

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
