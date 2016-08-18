package com.dongdongmall.core;

import com.dongdongmall.core.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestTest {

    @Resource
    private TestService testService;

    @Test
    public void insert() {
        com.dongdongmall.core.bean.Test test = new com.dongdongmall.core.bean.Test();
        test.setName("张三");
        testService.save(test);
    }

}
