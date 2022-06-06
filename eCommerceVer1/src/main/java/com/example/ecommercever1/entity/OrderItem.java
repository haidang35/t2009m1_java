package com.example.ecommercever1.entity;

public class OrderItem {
    private int id;
    private int orderId;
    private String productName;
    private int quantity;
    private String thumbnail;
    private double price;
    private int productId;

    public OrderItem() {
    }

    public OrderItem(int orderId, String productName, int quantity, String thumbnail, double price, int productId) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.thumbnail = thumbnail;
        this.price = price;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }


    public static final class OrderItemBuilder {
        private int id;
        private int orderId;
        private String productName;
        private int quantity;
        private String thumbnail;
        private double price;
        private int productId;

        private OrderItemBuilder() {
        }

        public static OrderItemBuilder anOrderItem() {
            return new OrderItemBuilder();
        }

        public OrderItemBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public OrderItemBuilder withOrderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderItemBuilder withProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public OrderItemBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItemBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public OrderItemBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public OrderItemBuilder withProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public OrderItem build() {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(id);
            orderItem.setOrderId(orderId);
            orderItem.setProductName(productName);
            orderItem.setQuantity(quantity);
            orderItem.setThumbnail(thumbnail);
            orderItem.setPrice(price);
            orderItem.setProductId(productId);
            return orderItem;
        }
    }
}
