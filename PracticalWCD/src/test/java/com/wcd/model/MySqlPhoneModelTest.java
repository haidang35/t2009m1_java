package com.wcd.model;

import com.wcd.entity.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqlPhoneModelTest {
    private PhoneModel phoneModel;

    @BeforeEach
    void setUp() {
        phoneModel = new MySqlPhoneModel();
    }

    @Test
    void create() {
        assertEquals(true, phoneModel.create(Phone.PhoneBuilder.aPhone()
                .withName("Iphone X")
                .withBrand("Apple")
                .withPrice(10000)
                .withDescription("Oke")
                .build()));
    }

    @Test
    void findAll() {
        assertEquals(true, phoneModel.findAll().size() > 0);
    }
}
