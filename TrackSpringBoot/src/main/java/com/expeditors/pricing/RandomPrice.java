package com.expeditors.pricing;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomPrice {
    public static BigDecimal generatePriceFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, RoundingMode.HALF_UP);
    }
}
