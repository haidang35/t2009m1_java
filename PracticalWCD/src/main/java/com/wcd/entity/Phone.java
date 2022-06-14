package com.wcd.entity;

import com.wcd.entity.base.BaseEntity;

import java.time.LocalDateTime;

public class Phone extends BaseEntity {
    private int id;
    private String name;
    private String brand;
    private double price;
    private String description;

    public Phone() {
    }

    public Phone(String name, String brand, double price, String description) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static final class PhoneBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        private int id;
        private String name;
        private String brand;
        private double price;
        private String description;

        private PhoneBuilder() {
            this.name = "";
            this.brand = "";
            this.description = "";
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public static PhoneBuilder aPhone() {
            return new PhoneBuilder();
        }

        public PhoneBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public PhoneBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public PhoneBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public PhoneBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public PhoneBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PhoneBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PhoneBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public PhoneBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PhoneBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public PhoneBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Phone build() {
            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setBrand(brand);
            phone.setPrice(price);
            phone.setDescription(description);
            phone.setCreatedAt(createdAt);
            phone.setUpdatedAt(updatedAt);
            phone.setDeletedAt(deletedAt);
            phone.setCreatedBy(createdBy);
            phone.setUpdatedBy(updatedBy);
            phone.setDeletedBy(deletedBy);
            return phone;
        }
    }
}
