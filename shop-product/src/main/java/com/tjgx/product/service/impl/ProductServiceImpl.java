package com.tjgx.product.service.impl;

import com.tjgx.common.product.exception.Result;
import com.tjgx.product.entity.Product;
import com.tjgx.product.mapper.ProductMapper;
import com.tjgx.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    @Transactional
    public Result saveProduct(){
        Product product = new Product();
        product.setPrice(new BigDecimal(100));
        product.setProductId(1);
        product.setProductName("vivo音乐手机");
        product.setStock(1002);
        productMapper.insert(product);
        return Result.Ok;
    }
}
