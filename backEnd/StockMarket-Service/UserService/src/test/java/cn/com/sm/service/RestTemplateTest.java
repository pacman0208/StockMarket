package cn.com.sm.service;

import cn.com.sm.UserServiceApplication;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * spring RestTemplate test
 */
@SpringBootTest(classes = UserServiceApplication.class)
public class RestTemplateTest {

    @Resource
    private EurekaDiscoveryClient discoveryClient;

    @Test
    public void test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("stock");

        for(ServiceInstance ins:instances){
            System.out.println(ins.getHost());
            System.out.println(ins.getInstanceId());
            System.out.println(ins.getPort());
            System.out.println(ins.getScheme());
            System.out.println(ins.getServiceId());
            System.out.println(ins.getMetadata());
            System.out.println(ins.getUri());
        }
    }

}
