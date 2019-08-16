package com.example.kafaka2.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/12
 * Time: 19:31
 */
@Slf4j
public class JsonTest {

    public static void main(String[] args) {
        JsonTest.g();


    }


    public static void g (){
        /*  String string = "{"code":400,"msg":"error"}";

        JSON json = {"code":400,"msg":"face not detected"};*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        String a = null;
        String securityPrefix = JSONPObject.SECURITY_PREFIX;
        Object parse = JSON.parse("1");
        //JSONArray objects = JSONArray.parseArray("[{"a":"1"}]");
        //Object object = JSONObject.parse("OBJECT");
        String string = JSONObject.toJSONString(list);

        log.info("jsonp:"+securityPrefix+"json:"+parse+"jsono:"+"JSONObject.toJSONString(list):"+string);

        Map<String,Object> map = new HashMap<>();
//        map.put("1","1");





        Set<Integer> set  =  new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);


        List<Integer> listLink = new LinkedList<>();
        listLink.add(1);
        listLink.add(6);
        System.out.println(listLink);

        String xxc = "123";
    }
}
