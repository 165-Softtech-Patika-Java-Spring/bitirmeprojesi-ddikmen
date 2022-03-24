package com.softtech.finalassignment.app.product.dto.request;

import com.softtech.finalassignment.app.product.enums.ProductTypeEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCreateRequestDto {

    private String name;
    private BigDecimal rawPrice;
    private ProductTypeEnum type;

}
