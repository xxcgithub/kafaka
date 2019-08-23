package com.example.kafaka2.entity;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/23
 * Time: 11:11
 */
@Component
public class MyMetaObjectHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setInsertFieldValByName("creatBy","xxc",metaObject);
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("upCreateBy","xxc",metaObject);
    }
}
