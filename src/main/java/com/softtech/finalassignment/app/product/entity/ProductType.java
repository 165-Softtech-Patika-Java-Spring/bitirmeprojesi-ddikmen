package com.softtech.finalassignment.app.product.entity;

import com.softtech.finalassignment.app.product.enums.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT_TYPE")
@Getter
@Setter
public class ProductType {

    @Id
    @SequenceGenerator(name = "ProductType",sequenceName = "PRODUCT_TYPE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "ProductType")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ProductTypeEnum productType;

    @Column(name = "VAT_RATE", nullable = false, precision = 19, scale = 2)
    private BigDecimal vatRate;

}
