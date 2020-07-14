package com.boss.demo.mytask;

import com.boss.demo.mytask.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author asus
 * @create 10/7/2020 上午9:48
 */
@SpringBootTest
@Slf4j
public class TestDAO {
    @Test
    public void TestApplyForm(){
        for (int i=0;i<100;i++){
            log.info("第 "+i+" UUID：  "+SnowFlake.nextId());
        }

    }

}
