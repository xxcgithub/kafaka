package com.example.kafaka2.util.entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/6
 * Time: 13:40
 */
public class Result<T> implements Serializable {
    @Digits(integer = 3,fraction = 1)
    private Integer state;
    @Size(max = 200, min = 100)
    private String  mess;
    private T data;

    private String name ;

    public Result(Integer state, String  mess, T data) {
        this.data = data;
        this.mess = mess;
        this.data = data;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "state=" + state +
                ", mess='" + mess + '\'' +
                ", data=" + data +
                '}';
    }
}
