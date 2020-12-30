package com.tjgx.common.product.fallBackFactory;

import com.tjgx.common.product.feignClient.ProductFeignClient;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author 83495
 */
@Component
@Slf4j
public class ProductFeignFallbackFactory implements FallbackFactory<ProductFeignClient> {
    @Override
    public ProductFeignClient create(Throwable throwable) {
        log.error("远程接口异常:",throwable);
       return new ProductFeignClient(){
           @Override
           public String getProduct(Integer productId) {
               return "请查看异常";
           }
       };
    }
}
