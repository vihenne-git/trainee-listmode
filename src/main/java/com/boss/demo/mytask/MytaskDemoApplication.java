package com.boss.demo.mytask;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * MytaskDemoApplication class
 *
 * @author yuhangchen
 * @date 2020/09/07
 */
@SpringBootApplication
@MapperScan("com.boss.demo.mytask.dao")
public class MytaskDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytaskDemoApplication.class, args);
    }

}
