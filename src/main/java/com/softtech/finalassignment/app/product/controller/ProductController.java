package com.softtech.finalassignment.app.product.controller;

import com.softtech.finalassignment.app.generic.dto.RestResponse;
import com.softtech.finalassignment.app.product.dto.request.ProductCreateRequestDto;
import com.softtech.finalassignment.app.product.dto.response.ProductCreateResponseDto;
import com.softtech.finalassignment.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto){

        ProductCreateResponseDto productCreateResponseDto = productService.addProduct(productCreateRequestDto);

        return ResponseEntity.ok(RestResponse.of(productCreateResponseDto));
    }

}
