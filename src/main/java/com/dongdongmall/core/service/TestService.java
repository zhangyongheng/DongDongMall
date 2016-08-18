package com.dongdongmall.core.service;

import com.dongdongmall.core.bean.Test;
import com.dongdongmall.core.dao.TestDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * TestService
 */
@Service
@Transactional
public class TestService {

    @Resource
    private TestDao testDao;

    public void save(Test test) {
        testDao.insert(test);
    }

}
