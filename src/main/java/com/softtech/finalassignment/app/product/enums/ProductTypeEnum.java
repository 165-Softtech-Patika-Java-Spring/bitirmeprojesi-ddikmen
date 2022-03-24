package com.softtech.finalassignment.app.product.enums;

import java.math.BigDecimal;

public enum ProductTypeEnum {

    FOOD(BigDecimal.valueOf(1)),
    STATIONARY(BigDecimal.valueOf(8)),
    CLOTHING(BigDecimal.valueOf(8)),
    TECHNOLOGY(BigDecimal.valueOf(18)),
    CLEANING(BigDecimal.valueOf(18)),
    OTHER(BigDecimal.valueOf(18)),
    ;


    private final BigDecimal vatRate;

    ProductTypeEnum(BigDecimal vatRate) {
        this.vatRate = vatRate;
    }

    public BigDecimal getVatRate() {
        return vatRate;
    }
}
