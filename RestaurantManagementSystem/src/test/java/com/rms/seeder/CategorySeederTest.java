package com.rms.seeder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategorySeederTest {
    private CategorySeeder categorySeeder;

    @BeforeEach
    void setUp() {
        categorySeeder = new CategorySeeder();
    }

    @Test
    void seedingData() {
        categorySeeder.seedingData();
    }
}
