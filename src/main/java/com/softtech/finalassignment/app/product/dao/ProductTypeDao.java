package com.softtech.finalassignment.app.product.dao;

import com.softtech.finalassignment.app.product.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeDao extends JpaRepository<ProductType, Long> {
}
