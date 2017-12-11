package com.hdsc.cloud.web.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hdsc.cloud.admin.User;
import com.hdsc.cloud.service.BizService;

/**
 * 用户服务 REST API
 */
@RestController
public class UserRestApiController {

    @Autowired
    private BizService bizService;
    
    @Autowired
    private DiscoveryClient client;

    /**     * @param name 请求参数名为“name”的数据
     * @return 如果保存成功的话，返回{@link User},否则返回<code>null</code>
     */
    @PostMapping("/user/save")
    public User saveUser(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if (bizService.save(user)) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 罗列所有的用户数据
     * @return 所有的用户数据
     */
    @GetMapping("/user/list")
    public Collection<User> list() {
    	Collection<User> list =    bizService.findAll();
    	
    	System.out.println(list);
    	
    	return list;
    }
    @GetMapping("/services")
    public Collection<User> listService(){
    	
    	
    	List<String> services = client.getServices();
    	
    	System.out.println("serives all =="+services);
    	for (String serviceId : services) {
    		List<ServiceInstance> ins = 	client.getInstances(serviceId);
    		
    		for (ServiceInstance instance : ins) {
    			String ms = "/add, host:" +instance.getHost()+":"+instance.getPort()+""  + ", service_id:" + instance.getServiceId() + ", result:";
    			
    			System.out.println("serviceId:"+serviceId+":"+ms);
			}
		}
    	
    	ServiceInstance instance =client.getLocalServiceInstance();
    	String ms = "/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:";
    	
    	Collection<User> list =    bizService.findAll();
    	
    	System.out.println(list);;
    	
    	return list;
    }

}
