package com.qcxy.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootTest
@EnableFeignClients("com.qxxy.demo.client")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
