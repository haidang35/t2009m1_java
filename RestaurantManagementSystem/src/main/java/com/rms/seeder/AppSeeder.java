package com.rms.seeder;

import com.rms.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppSeeder {
    private static CategorySeeder categorySeeder;
    private static FoodSeeder foodSeeder;
    private static final String TRUNCATE_CATEGORY_SQL = "TRUNCATE TABLE categories";
    private static final String TRUNCATE_FOOD_SQL = "TRUNCATE TABLE foods";
    private static final String REMOVE_FOREIGN_KEY_CHECK_SQL = "SET FOREIGN_KEY_CHECKS = 0;";
    private static final String ADD_FOREIGN_KEY_CHECK_SQL = "SET FOREIGN_KEY_CHECKS = 1;";

    static {
         categorySeeder = new CategorySeeder();
         foodSeeder = new FoodSeeder();
    }

    public static void main(String[] args) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedCategoryStatement = connection.prepareStatement(TRUNCATE_CATEGORY_SQL);
            PreparedStatement preparedFoodStatement = connection.prepareStatement(TRUNCATE_FOOD_SQL);
            PreparedStatement preparedRemoveForeignKeyCheckStatement = connection.prepareStatement(REMOVE_FOREIGN_KEY_CHECK_SQL);
            PreparedStatement preparedAddForeignKeyCheckStatement = connection.prepareStatement(ADD_FOREIGN_KEY_CHECK_SQL);
            try {
                connection.setAutoCommit(false);
                preparedRemoveForeignKeyCheckStatement.executeUpdate();
                preparedCategoryStatement.executeUpdate();
                preparedFoodStatement.executeUpdate();
                preparedAddForeignKeyCheckStatement.executeUpdate();
                categorySeeder.seedingData();
                foodSeeder.seedingData();
                connection.commit();
            }catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
