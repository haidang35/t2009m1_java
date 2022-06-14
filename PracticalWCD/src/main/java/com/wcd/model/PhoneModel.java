package com.wcd.model;

import com.wcd.entity.Phone;

import java.util.List;

public interface PhoneModel {
    boolean create(Phone obj);
    boolean update(int id, Phone obj);
    boolean delete(int id);
    Phone findById(int id);
    List<Phone> findAll();
}
