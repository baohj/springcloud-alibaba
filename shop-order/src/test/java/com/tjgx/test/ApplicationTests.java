package com.tjgx.test;

import com.tjgx.order.OrderStart;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = OrderStart.class)
@RunWith(SpringRunner.class)
@Slf4j
public class ApplicationTests {
    @Test
    public void contextLoads() {
        for(int i=0;i<100;i++){
            log.info("我们就是林中的小鸟儿");
            log.info("闭着眼睛越飞越高");
        }
    }
}
