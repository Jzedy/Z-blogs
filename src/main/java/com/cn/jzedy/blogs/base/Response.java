package com.cn.jzedy.blogs.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jzedy
 * @time 19-6-5
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private Integer code;
    private String message;
    private Object body;


    public static Response success(){
        return success(null);
    }

    private static Response success(Object body) {
        return new Response(GlobalConts.Code.SUCCESS,GlobalConts.Message.SUCCESS,body);
    }
}
