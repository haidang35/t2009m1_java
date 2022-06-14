package com.wcd.constant;

public class SqlConstant {
    public static final String PHONE_INSERT = "INSERT INTO phones (name, brand, price, description, createdAt, updatedAt, createdBy, updatedBy) " +
            "                                                   VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String PHONE_UPDATE = "UPDATE phones SET name = ?, brand = ?, price = ?, description = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ? WHERE id = ?;";
    public static final String PHONE_DELETE = "DELETE FROM phones WHERE id = ?;";
    public static final String PHONE_FIND_BY_ID = "SELECT * FROM phones WHERE id = ?;";
    public static final String PHONE_FIND_ALL = "SELECT * FROM phones ORDER BY createdAt DESC;";

    public static final String PHONE_FIELD_ID = "id";
    public static final String PHONE_FIELD_NAME = "name";
    public static final String PHONE_FIELD_BRAND = "brand";
    public static final String PHONE_FIELD_PRICE = "price";
    public static final String PHONE_FIELD_DESCRIPTION = "description";

    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final String FIELD_DELETED_AT = "deletedAt";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_UPDATED_BY = "updatedBy";
    public static final String FIELD_DELETED_BY = "deletedBy";

}
