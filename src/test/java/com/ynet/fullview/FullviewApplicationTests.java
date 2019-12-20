package com.ynet.fullview;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FullviewApplicationTests {

    @Value("${params.path}")
    private String path;

    @Test
    public void contextLoads() {
        log.info("日志打印测试：{}","begin-------------");
    }

    @Test
    public void getParams(){
        log.info("取值-路径路径参数：{}",path);
    }

}

