package com.dongdongmall.core.dao;

import com.dongdongmall.core.bean.Test;
import org.springframework.stereotype.Repository;

/**
 测试Dao
 */
@Repository
public interface TestDao {
    void insert(Test test);
}
