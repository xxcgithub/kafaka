package com.example.kafaka2.IntergerTest;

import java.time.Instant;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/27
 * Time: 18:21
 */
public class IntergerTest {

    public static void main(String[] args) {


    }






    private static void instantTest() {
        Instant instant = Instant.now();
        System.out.println(instant);
        Instant ofEpochMilli = Instant.ofEpochMilli(instant.toEpochMilli());
        System.out.println(ofEpochMilli);

    }



}
