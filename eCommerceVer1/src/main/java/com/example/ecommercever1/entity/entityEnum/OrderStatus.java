package com.example.ecommercever1.entity.entityEnum;

public enum OrderStatus {
    PENDING(1),
    CANCEL(0),
    PROCESSING(-1),
    SHIPPING(2),
    SUCCESSFUL(3),
    UNDEFINED(4);
    private int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static OrderStatus of(int value) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if(orderStatus.getValue() == value) {
                return orderStatus;
            }
        }
        return OrderStatus.UNDEFINED;
    }
}
