package com.example.kafaka2.entity;

import com.baomidou.mybatisplus.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/5
 * Time: 11:22
 */
public class Student extends MetaDate {

    @TableId(value = "id", type = IdType.UUID)
    private String  id;
    @TableField(condition = SqlCondition.LIKE ,  insertStrategy = FieldStrategy.NOT_EMPTY)
    private String  name ;
    @TableField(fill = FieldFill.INSERT)
    private String classId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
