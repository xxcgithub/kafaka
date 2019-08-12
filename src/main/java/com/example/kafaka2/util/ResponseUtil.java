package com.example.kafaka2.util;

import com.example.kafaka2.util.entity.Result;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 2019/8/6
 * Time: 13:39
 */
public class ResponseUtil {

    private static final int SUCCESS = 200;
    private static final int  ERROR = 100;
    public ResponseUtil (){};
    public static ResponseEntity buildSuccess (){
        return ResponseEntity.status(SUCCESS).body(new Result<>(SUCCESS,"操作成功",null));
    }

    public static <T>ResponseEntity<Result<T>> buileSuccess (String mess){
        return ResponseEntity.status(SUCCESS).body(new Result<>(SUCCESS,mess,null));
    }

    public static <T> ResponseEntity<Result<T>> bulidSuccess (T Data) {
        return Optional.ofNullable(Data)
                .map(da -> ResponseEntity.status(SUCCESS).body(new Result<T>(SUCCESS,"操作成功",null)))
                .orElseThrow( ()-> new NoSuchElementException());
    }

    public static  <T> ResponseEntity<Result<T>> bulidError (T Data) {
        return ResponseEntity.status(ERROR).body(new Result<>(ERROR,"操作失败",null));
    }


}
