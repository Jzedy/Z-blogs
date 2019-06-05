package com.cn.jzedy.blogs.web;

import com.cn.jzedy.blogs.base.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jzedy
 * @time 19-6-5
 * @description
 */
@RestController
public class LoginController {


    @PostMapping(value = "/login")
    public Response login(){
        return Response.success();
    }
}
