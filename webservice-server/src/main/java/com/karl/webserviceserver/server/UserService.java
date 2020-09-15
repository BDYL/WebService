package com.karl.webserviceserver.server;

import javax.jws.WebService;

/**
 * @author Karl
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2020年09月14日 21:23:00
 */

public interface UserService {
     String getUserInfo(String username,Integer userage);
}
