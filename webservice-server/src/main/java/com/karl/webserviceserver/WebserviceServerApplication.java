package com.karl.webserviceserver;

import com.karl.webserviceserver.server.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import javax.xml.ws.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WebserviceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebserviceServerApplication.class, args);

        String address = "http://172.17.188.17:9090/webservice-server";
        UserServiceImpl userService = new UserServiceImpl();
        Endpoint.publish(address,userService);
    }



}
