package com.ynet.fullview;

import com.ynet.fullview.dao.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FullviewApplicationTests {

    @Autowired
    private CustomerMapper customerMapper;

    @Value("${params.path}")
    private String path;

    @Test
    public void contextLoads() {
        log.info("日志打印测试：{}", "begin-------------");
    }

    @Test
    public void getParams() {
        log.info("取值-路径路径参数：{}", path);
    }

    @Test
    public void testGetParams() {
        char[] value = new char[10];
    }

    @Test
    public void testQueryOrderByContent(){
        log.info("查询到数据："+ customerMapper.queryOrderInfo(""));
    }

}

