package com.t2009m1.accountmodelasm.entity.myenum;

public enum AccountStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(-2);

    private int value;
    AccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
