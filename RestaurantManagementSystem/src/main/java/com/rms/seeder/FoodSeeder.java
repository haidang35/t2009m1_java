package com.rms.seeder;

import com.rms.entity.Food;
import com.rms.entity.entityEnum.FoodStatus;
import com.rms.model.MySqlFoodModel;
import com.rms.model.interfaceModel.FoodModel;

public class FoodSeeder {
    private FoodModel foodModel;

    public FoodSeeder() {
        foodModel = new MySqlFoodModel();
    }

    public void seedingData() {
        // Món luộc
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Rau muống luộc")
                .withThumbnail("https://vcdn-suckhoe.vnecdn.net/2019/05/11/7a63718778c69198c8d7-155755839-9641-6402-1557559469.png")
                .withPrice(1000)
                .withCategoryId(1)
                .withDescription("Rau muống luộc")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("RAUMUONGLUOC")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Thịt gà luộc")
                .withThumbnail("https://daubepgiadinh.vn/wp-content/uploads/2018/05/cach-luoc-ga-ngon-nhat-600x400.jpg")
                .withPrice(100000)
                .withCategoryId(1)
                .withDescription("Thịt gà luộc")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("THIGALUOC")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Thịt lợn luộc")
                .withThumbnail("https://bankhoedep.com/wp-content/uploads/2021/08/cach-luoc-thit-ba-chi-ngon-1.jpg")
                .withPrice(100000)
                .withCategoryId(1)
                .withDescription("Thịt lợn luộc")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("THITLONLUOC")
                .build());
        // Món chay
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Bò kho chay")
                .withThumbnail("https://monngonmoingay.com/wp-content/uploads/2017/12/bo-kho-chay-500.jpg")
                .withPrice(120000)
                .withCategoryId(2)
                .withDescription("Bò kho chay")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("BOKHOCHAY")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Chả chay")
                .withThumbnail("http://media.cooky.vn/images/blog-2016/7-mon-an-chay-cho-ngay-tet-nguyen-tieu-them-tron-ven-1.jpg")
                .withPrice(80000)
                .withCategoryId(2)
                .withDescription("Chả chay")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("CHACHAY")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Chả chay xào nấm")
                .withThumbnail("https://cdn.daotaobeptruong.vn/wp-content/uploads/2019/10/gia-xao-dau-hu-nhung-mon-chay-ngon-de-lam.jpg")
                .withPrice(60000)
                .withCategoryId(2)
                .withDescription("Chả chay xào nấm")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("CHACHAYXAONAM")
                .build());
        // Món nướng
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Thịt lợn xiên nướng")
                .withThumbnail("https://vcdn-dulich.vnecdn.net/2015/11/27/1-2666-1448591868.png")
                .withPrice(200000)
                .withCategoryId(3)
                .withDescription("Thịt lợn xiên nướng")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("THITLONNUONG")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Thịt gà nướng nguyên con")
                .withThumbnail("https://dulichvietnam.com.vn/vnt_upload/news/11_2020/Mon_nuong_o_Viet_Nam_21.jpg")
                .withPrice(150000)
                .withCategoryId(3)
                .withDescription("Thịt gà nướng nguyên con")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("GANUONGNGUYENCON")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Mực nướng")
                .withThumbnail("https://i.pinimg.com/originals/c4/c8/5f/c4c85f9b6ed8e4607a5555c483f3b4af.jpg")
                .withPrice(600000)
                .withCategoryId(3)
                .withDescription("Mực nướng")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("MUCNUONG")
                .build());
        // Đồ uống
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Cà phê phin")
                .withThumbnail("https://cdn.tgdd.vn/2020/12/content/thumb7-800x500-1.jpg")
                .withPrice(25000)
                .withCategoryId(4)
                .withDescription("Cà phê phin")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("CAPHEPHIN")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Cappuccino")
                .withThumbnail("https://cdn.tgdd.vn/2020/12/content/thumb8-800x500-1.jpg")
                .withPrice(40000)
                .withCategoryId(4)
                .withDescription("Cappuccino")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("CAPPUCCINO")
                .build());
        foodModel.create(Food.FoodBuilder.aFood()
                .withName("Americano")
                .withThumbnail("https://cdn.tgdd.vn/2020/12/content/thumb9-800x500-1.jpg")
                .withPrice(66000)
                .withCategoryId(4)
                .withDescription("Americano")
                .withStatus(FoodStatus.ON_SALE)
                .withCode("AMERICANO")
                .build());
    }
}
