package com.example.kafaka2.dto;

import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/23
 * Time: 11:39
 */
public class MessDTO {
    @Size(max = 100, message = "长度过长")
    private String name;

}
