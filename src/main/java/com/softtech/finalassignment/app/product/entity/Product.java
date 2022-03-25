package com.softtech.finalassignment.app.product.entity;

import com.softtech.finalassignment.app.product.enums.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

    @Id
    @SequenceGenerator(name = "Product",sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "Product")
    private Long id;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String name;

    @Column(name = "PRICE_RAW", nullable = false, precision = 19, scale = 2)
    private BigDecimal rawPrice;

    @Column(name = "PRICE_AFTER_VAT", nullable = false, precision = 19, scale = 2)
    private BigDecimal priceAfterTax;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private ProductTypeEnum type;

}
