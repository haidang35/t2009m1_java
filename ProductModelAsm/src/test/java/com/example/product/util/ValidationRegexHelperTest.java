package com.example.product.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationRegexHelperTest {

    @Test
    void validateEmail() {
        assertEquals(true, ValidationRegexHelper.validateEmail("nguyenhaidangyq@gmail.com"));
    }

    @Test
    void validatePhone() {
        assertEquals(true, ValidationRegexHelper.validatePhone("+12 345 678 9012"));
    }

    @Test
    void validateVietnamesePhone() {
        assertEquals(true, ValidationRegexHelper.validateVietnamesePhone("0357446532"));
    }
}
