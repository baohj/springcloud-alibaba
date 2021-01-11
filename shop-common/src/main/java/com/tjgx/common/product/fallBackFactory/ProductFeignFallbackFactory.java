package com.tjgx.common.product.fallBackFactory;

import com.tjgx.common.product.exception.Result;
import com.tjgx.common.product.feignClient.ProductFeignClient;
import com.tjgx.common.product.vo.ProductOut;
import com.tjgx.common.product.vo.UserOut;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

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
           public String getProduct() {
               return null;
           }

           @Override
           public Result<List<UserOut>> getUser() {
               return null;
           }

           @Override
           public Result saveProduct() {
               return null;
           }
       };
    }
}
