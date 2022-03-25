package com.softtech.finalassignment.app.product.service;

import com.softtech.finalassignment.app.product.converter.ProductMapper;
import com.softtech.finalassignment.app.product.dao.ProductDao;
import com.softtech.finalassignment.app.product.dto.request.ProductCreateRequestDto;
import com.softtech.finalassignment.app.product.dto.response.ProductCreateResponseDto;
import com.softtech.finalassignment.app.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    //todo revisit this for fetching vat data from db
    public ProductCreateResponseDto addProduct(ProductCreateRequestDto productCreateRequestDto){
        Product product = ProductMapper.INSTANCE.convertToProduct(productCreateRequestDto);

        BigDecimal rawPrice = product.getRawPrice();
        BigDecimal taxRate = product.getType().getVatRate().divide(BigDecimal.valueOf(100));
        BigDecimal priceAfterTax = rawPrice.add(rawPrice.multiply(taxRate));

        product.setPriceAfterTax(priceAfterTax);

        productDao.save(product);

        ProductCreateResponseDto productCreateResponseDto = ProductMapper.INSTANCE.convertToProductCreateResponseDto(product);

        return productCreateResponseDto;
    }
}
