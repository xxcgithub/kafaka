package com.example.kafaka2.stringTest;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/28
 * Time: 15:04
 */
public class StringTest {

    public static void main(String[] args) {

        int a1 =  1;




        String a = "admin";
        Boolean A = false;
        if ("admin".equals(a)){
            A = Boolean.TRUE;
        }
        int i = a.indexOf(a);
        System.out.println(i);
        if (a.indexOf(a) > -1){
            System.out.println(1);
        }
    }
}
