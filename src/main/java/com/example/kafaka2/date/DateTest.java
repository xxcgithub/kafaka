package com.example.kafaka2.date;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/28
 * Time: 11:51
 */
public class DateTest {
    public static void main(String[] args) {


        String format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:ss:mm").format(LocalDateTime.now());
        System.out.println(format);


        Instant instant = Instant.now();
        System.out.println(instant);
        Instant ofEpochMilli = Instant.ofEpochMilli(instant.toEpochMilli());
        System.out.println(ofEpochMilli);
        String s = String.valueOf(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+08:00")));
        System.out.println(s);
        long l = System.currentTimeMillis();
        System.out.println(l);
    }

}
