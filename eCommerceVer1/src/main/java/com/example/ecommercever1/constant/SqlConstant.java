package com.example.ecommercever1.constant;

public class SqlConstant {
    public static final String PRODUCT_INSERT = "INSERT INTO products (name, description, detail, price, thumbnail, categoryId," +
            "createdAt, updatedAt, deletedAt, createdBy, updatedBy, deletedBy, status, slug) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String PRODUCT_UPDATE = "UPDATE products SET name = ?, description = ?, detail = ?, price = ?, thumbnail = ?, categoryId = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ?, slug = ? WHERE id = ?;";
    public static final String PRODUCT_DELETE = "DELETE FROM products WHERE id = ?;";
    public static final String PRODUCT_UPDATE_STATUS = "UPDATE products SET status = ? WHERE id = ?";
    public static final String PRODUCT_FIND_BY_ID = "SELECT * FROM products WHERE id = ? AND status = ?;";
    public static final String PRODUCT_FIND_ALL = "SELECT * FROM products WHERE status = ? ORDER BY createdAt DESC;";
    public static final String PRODUCT_FIND_BY_SLUG = "SELECT * FROM products WHERE status = ? AND slug = ?;";
    public static final String PRODUCT_FIND_BY_CATEGORY_ID = "SELECT * FROM products WHERE status = ? AND categoryId = ? ORDER BY createdAt DESC;";

    public static final String CATEGORY_INSERT = "INSERT INTO categories (name, parentId, createdAt, updatedAt, createdBy, updatedBy, status, slug) " +
            "                                                   VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String CATEGORY_UPDATE = "UPDATE categories SET name = ?, parentId = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ?, slug = ? WHERE id = ?;";
    public static final String CATEGORY_DELETE = "DELETE FROM categories WHERE id = ?;";
    public static final String CATEGORY_UPDATE_STATUS = "UPDATE categories SET status = ? WHERE id = ?";
    public static final String CATEGORY_FIND_BY_ID = "SELECT * FROM categories WHERE id = ? AND status = ?;";
    public static final String CATEGORY_FIND_ALL = "SELECT * FROM categories WHERE status = ? ORDER BY createdAt DESC;";
    public static final String CATEGORY_FIND_BY_SLUG = "SELECT * FROM categories WHERE status = ? AND slug = ?;";

    public static final String ORDER_INSERT = "INSERT INTO orders (firstName, lastName, companyName, country, address, email, phoneNumber, note, total, shippingFee" +
            "                                   , createdAt, updatedAt, createdBy, updatedBy, status) " +
            "                                                   VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    public static final String ORDER_UPDATE = "UPDATE orders SET firstName = ?, lastName = ?, companyName = ?, country = ?, address = ?, email = ?, phoneNumber = ?, note = ?, total = ?, shippingFee = ?," +
            "createdAt = ?, updatedAt = ?, deletedAt = ?, createdBy = ?, updatedBy = ?, deletedBy = ?, status = ? WHERE id = ?;";
    public static final String ORDER_DELETE = "DELETE FROM orders WHERE id = ?;";
    public static final String ORDER_UPDATE_STATUS = "UPDATE orders SET status = ? WHERE id = ?";
    public static final String ORDER_FIND_BY_ID = "SELECT * FROM orders WHERE id = ?;";
    public static final String ORDER_FIND_ALL = "SELECT * FROM orders ORDER BY createdAt DESC;";

    public static final String PRODUCT_FIELD_ID = "id";
    public static final String PRODUCT_FIELD_NAME = "name";
    public static final String PRODUCT_FIELD_DESCRIPTION = "description";
    public static final String PRODUCT_FIELD_DETAIL = "detail";
    public static final String PRODUCT_FIELD_PRICE = "price";
    public static final String PRODUCT_FIELD_THUMBNAIL = "thumbnail";
    public static final String PRODUCT_FIELD_MANUFACTURE_EMAIL = "manufactureEmail";
    public static final String PRODUCT_FIELD_MANUFACTURE_PHONE = "manufacturePhone";
    public static final String PRODUCT_FIELD_STATUS = "status";
    public static final String PRODUCT_FIELD_CATEGORY_ID = "categoryId";


    public static final String CATEGORY_FIELD_ID = "id";
    public static final String CATEGORY_FIELD_NAME = "name";
    public static final String CATEGORY_FIELD_PARENT_ID = "parentId";
    public static final String CATEGORY_FIELD_STATUS = "status";

    public static final String ORDER_FIELD_ID = "id";
    public static final String ORDER_FIELD_FIRST_NAME = "firstName";
    public static final String ORDER_FIELD_LAST_NAME = "lastName";
    public static final String ORDER_FIELD_COMPANY_NAME = "companyName";
    public static final String ORDER_FIELD_COUNTRY = "country";
    public static final String ORDER_FIELD_ADDRESS = "address";
    public static final String ORDER_FIELD_EMAIL = "email";
    public static final String ORDER_FIELD_PHONE_NUMBER = "phoneNumber";
    public static final String ORDER_FIELD_TOTAL = "total";
    public static final String ORDER_FIELD_SHIPPING_FEE = "shippingFee";
    public static final String ORDER_FIELD_NOTE = "note";
    public static final String ORDER_FIELD_STATUS = "status";

    public static final String FIELD_CREATED_AT = "createdAt";
    public static final String FIELD_UPDATED_AT = "updatedAt";
    public static final String FIELD_DELETED_AT = "deletedAt";
    public static final String FIELD_CREATED_BY = "createdBy";
    public static final String FIELD_UPDATED_BY = "updatedBy";
    public static final String FIELD_DELETED_BY = "deletedBy";
}
