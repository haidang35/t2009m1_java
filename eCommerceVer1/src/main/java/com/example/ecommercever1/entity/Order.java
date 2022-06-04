package com.example.ecommercever1.entity;

import com.example.ecommercever1.entity.base.BaseEntity;
import com.example.ecommercever1.entity.entityEnum.OrderStatus;

import java.time.LocalDateTime;

public class Order extends BaseEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String address;
    private String email;
    private String phoneNumber;
    private String note;
    private double total;
    private double shippingFee;
    private OrderStatus status;

    public Order() {
    }

    public Order(int id, String firstName, String lastName, String companyName, String country, String address, String email, String phoneNumber, String note, double total, double shippingFee, OrderStatus status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.total = total;
        this.shippingFee = shippingFee;
        this.status = status;
    }

    public Order(String firstName, String lastName, String companyName, String country, String address, String email, String phoneNumber, String note, double total, double shippingFee, OrderStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.note = note;
        this.total = total;
        this.shippingFee = shippingFee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


    public static final class OrderBuilder {
        public LocalDateTime createdAt;
        public LocalDateTime updatedAt;
        public LocalDateTime deletedAt;
        public int createdBy;
        public int updatedBy;
        public int deletedBy;
        private int id;
        private String firstName;
        private String lastName;
        private String companyName;
        private String country;
        private String address;
        private String email;
        private String phoneNumber;
        private String note;
        private double total;
        private double shippingFee;
        private OrderStatus status;

        private OrderBuilder() {
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public static OrderBuilder anOrder() {
            return new OrderBuilder();
        }

        public OrderBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public OrderBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public OrderBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public OrderBuilder withCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public OrderBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public OrderBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public OrderBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public OrderBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public OrderBuilder withNote(String note) {
            this.note = note;
            return this;
        }

        public OrderBuilder withTotal(double total) {
            this.total = total;
            return this;
        }

        public OrderBuilder withShippingFee(double shippingFee) {
            this.shippingFee = shippingFee;
            return this;
        }

        public OrderBuilder withStatus(OrderStatus status) {
            this.status = status;
            return this;
        }

        public OrderBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public OrderBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public OrderBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public OrderBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public OrderBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public OrderBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.setId(id);
            order.setFirstName(firstName);
            order.setLastName(lastName);
            order.setCompanyName(companyName);
            order.setCountry(country);
            order.setAddress(address);
            order.setEmail(email);
            order.setPhoneNumber(phoneNumber);
            order.setNote(note);
            order.setTotal(total);
            order.setShippingFee(shippingFee);
            order.setStatus(status);
            order.setCreatedAt(createdAt);
            order.setUpdatedAt(updatedAt);
            order.setDeletedAt(deletedAt);
            order.setCreatedBy(createdBy);
            order.setUpdatedBy(updatedBy);
            order.setDeletedBy(deletedBy);
            return order;
        }
    }
}
