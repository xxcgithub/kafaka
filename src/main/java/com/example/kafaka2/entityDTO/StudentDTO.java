package com.example.kafaka2.entityDTO;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/15
 * Time: 15:13
 */
public class StudentDTO implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Excel(name = "name" ,width = 20)
   private String name;
    @Excel(name = "sex" ,replace = {"男" ,"女" ,"保密"})
    private String sex ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO that = (StudentDTO) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex);
    }


    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }



}
