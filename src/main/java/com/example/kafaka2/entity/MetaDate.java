package com.example.kafaka2.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/23
 * Time: 11:04
 */
public abstract class MetaDate implements Serializable {
    private final static Long serialVersionUID = 1L;
    @TableField(fill = FieldFill.INSERT)
    private  String createBy ;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;


    }


    private String xxcTest;


    private String ww;
}
