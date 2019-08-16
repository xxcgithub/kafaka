package com.example.kafaka2.java8;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/15
 * Time: 10:05
 */
public class CallbackTest {
    public static void main(String[] args) {
        CallbackTest.getCall("1", new Callback1() {
            @Override
            public void getBack() {
                System.out.println("这里是回调方法");
            }
        });
    }
    public static  void getCall(String str , Callback1 callback1){
        System.out.println("1111111111:"+str);
        callback1.getBack();
    }

}
