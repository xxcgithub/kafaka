package com.example.kafaka2.easypoi;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/23
 * Time: 11:23
 */
public class EasyPoiTest {
    @Excel(name = "name" ,width = 20)
    private  String name ;
    @Excel(name = "sex" , replace = {"男","女","保密"})
    private String sex;
}
