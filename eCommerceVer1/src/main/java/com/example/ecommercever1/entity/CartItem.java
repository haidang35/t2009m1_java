package com.example.ecommercever1.entity;

public class CartItem {
    private int id;
    private String name;
    private double price;
    private String thumbnail;
    private int quantity;
    private String slug;

    public CartItem() {
    }

    public CartItem(int id, String name, double price, String thumbnail, int quantity, String slug) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.quantity = quantity;
        this.slug = slug;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public static final class CartItemBuilder {
        private int id;
        private String name;
        private double price;
        private String thumbnail;
        private int quantity;
        private String slug;

        private CartItemBuilder() {
        }

        public static CartItemBuilder aCartItem() {
            return new CartItemBuilder();
        }

        public CartItemBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public CartItemBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CartItemBuilder withSlug(String slug) {
            this.slug = slug;
            return this;
        }

        public CartItemBuilder withPrice(double price) {
            this.price = price;
            return this;
        }

        public CartItemBuilder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public CartItemBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItem build() {
            CartItem cartItem = new CartItem();
            cartItem.setId(id);
            cartItem.setName(name);
            cartItem.setSlug(slug);
            cartItem.setPrice(price);
            cartItem.setThumbnail(thumbnail);
            cartItem.setQuantity(quantity);
            return cartItem;
        }
    }
}
