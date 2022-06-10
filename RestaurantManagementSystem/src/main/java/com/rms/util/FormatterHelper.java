package com.rms.util;

import java.text.DecimalFormat;

public class FormatterHelper {
    public static String formatCurrencyVnd(double price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(price) + " VND";
    }
}
