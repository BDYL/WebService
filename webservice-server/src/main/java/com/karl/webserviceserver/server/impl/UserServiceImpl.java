package com.karl.webserviceserver.server.impl;

import com.karl.webserviceserver.server.UserService;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Karl
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2020年09月14日 21:22:00
 */

@WebService
public class UserServiceImpl implements UserService {

    @Override
    public String getUserInfo(@WebParam(name = "username") String username, @WebParam(name = "userage") Integer userage) {
        System.out.println("你好，" + username);
        String result = "你好! " + username + "你的年龄是" + userage;
        return result;
    }

}
