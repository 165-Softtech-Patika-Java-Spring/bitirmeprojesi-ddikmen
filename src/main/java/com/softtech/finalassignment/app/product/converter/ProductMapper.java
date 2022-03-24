package com.softtech.finalassignment.app.product.converter;

import com.softtech.finalassignment.app.product.dto.request.ProductCreateRequestDto;
import com.softtech.finalassignment.app.product.dto.response.ProductCreateResponseDto;
import com.softtech.finalassignment.app.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductCreateRequestDto productCreateRequestDto);

    ProductCreateResponseDto convertToProductCreateResponseDto(Product product);

}
