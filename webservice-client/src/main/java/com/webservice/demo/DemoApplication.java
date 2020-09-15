package com.webservice.demo;

import org.apache.axis.client.Call;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.axis.client.Service;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;
import java.net.URL;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        try {
            Service service = new Service();
            Call call = (Call)service.createCall();
            String endpoint = "http://172.17.188.17:9090/webservice-server"; // 命名空间
            call.setTargetEndpointAddress(new URL(""));
            call.setOperationName(""); // 需要请求的方法
            call.addParameter("UserService", XMLType.SOAP_STRING, ParameterMode.IN);  // 入参
            String param1 = "karl";  // 参数
            call.setReturnType(XMLType.SOAP_STRING);  // 设置返回值
            String result = "";
            result = (String) call.invoke(new Object[] {param1}); // 调用获取返回值
//            log.info("请求结果:{}", result);
            System.out.println(result);


        }catch (Exception e){

        }
    }

}
