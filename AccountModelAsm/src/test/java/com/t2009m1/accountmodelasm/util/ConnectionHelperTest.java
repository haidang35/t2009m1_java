package com.t2009m1.accountmodelasm.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionHelperTest {

    @Test
    void getConnection() {
        assertNotEquals(null, ConnectionHelper.getConnection());
    }
}
