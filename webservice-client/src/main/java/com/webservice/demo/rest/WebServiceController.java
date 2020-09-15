package com.webservice.demo.rest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.axis.client.Service;
import org.apache.axis.client.Call;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.encoding.XMLType;
import java.net.URL;
import org.slf4j.Logger;

/**
 * @author Karl
 * @version 1.0.0
 * @ClassName WebServiceController.java
 * @Description TODO
 * @createTime 2020年09月15日 15:08:00
 */
@Controller
@RequestMapping("/webservice")
public class WebServiceController {
    Logger logger = LoggerFactory.getLogger(WebServiceController.class);

    @GetMapping("/getUserMessage")
    public void getUserMessage() {

        try{
            Service service = new Service();
            Call call = (Call)service.createCall();
            String endpoint = "http://172.17.188.17:9090/webservice-server?wsdl"; // 命名空间
            call.setTargetEndpointAddress(new URL(endpoint));
            call.setOperationName(new QName("http://impl.server.webserviceserver.karl.com/","getUserInfo"));// 需要请求的方法
            call.setUseSOAPAction(true);
            call.addParameter("username", XMLType.SOAP_STRING, ParameterMode.IN);  // 入参
            call.addParameter("userage",XMLType.SOAP_INT,ParameterMode.IN);
            String param1 = "karl";  // 参数
            String param2 = "26";  // 参数
            call.setReturnType(XMLType.SOAP_STRING);  // 设置返回值
            String result = "";
            result = (String) call.invoke(new Object[] {param1,param2}); // 调用获取返回值
//            log.info("请求结果:{}", result);
            System.out.println(result);
        }catch (Exception e){
            logger.error("errorMessage",e);
        }

    }
}
