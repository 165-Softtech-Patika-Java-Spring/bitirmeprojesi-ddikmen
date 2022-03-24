package com.softtech.finalassignment.app.product.dto.response;

import com.softtech.finalassignment.app.product.enums.ProductTypeEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class ProductCreateResponseDto {

    private String name;
    private BigDecimal rawPrice;
    private ProductTypeEnum type;

}
