package com.rms.seeder;

import com.rms.entity.Category;
import com.rms.entity.entityEnum.CategoryStatus;
import com.rms.model.MySqlCategoryModel;
import com.rms.model.interfaceModel.CategoryModel;

public class CategorySeeder {
    private CategoryModel categoryModel;

    public CategorySeeder() {
        categoryModel = new MySqlCategoryModel();
    }

    public void seedingData() {
        String[] foods = {"Món luộc", "Món chay", "Món nướng", "Đồ uống"};
        for(String food : foods) {
            categoryModel.create(Category.CategoryBuilder.aCategory()
                    .withName(food)
                    .withStatus(CategoryStatus.ACTIVE)
                    .build());
        }
    }
}
