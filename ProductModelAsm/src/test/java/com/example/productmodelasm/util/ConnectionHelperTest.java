package com.example.productmodelasm.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionHelperTest {

    @Test
    void getConnection() {
        Connection connection = ConnectionHelper.getConnection();
        assertNotEquals(null, connection);
    }
}
