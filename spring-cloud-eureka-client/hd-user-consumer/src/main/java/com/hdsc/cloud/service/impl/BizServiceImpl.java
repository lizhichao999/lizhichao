package com.hdsc.cloud.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hdsc.cloud.admin.User;
import com.hdsc.cloud.service.BizService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BizServiceImpl implements BizService{

	  private static final String PROVIDER_SERVER_URL_PREFIX = "http://user-service-provider";

	    /**
	     * 通过 REST API 代理到服务器提供者
	     */
	    @Autowired
	    private RestTemplate restTemplate;

	    @HystrixCommand(fallbackMethod = "saveError")
	    @Override
	    public boolean save(User user) {
	        User returnValue =
	                restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save", user, User.class);
	        return returnValue != null;
	    }
	    
	    public boolean saveError(User user,Throwable throwable) {
	    	//System.out.println(throwable.getMessage());
	    	throwable.printStackTrace();
	        return false;
	    }
	    
	    
	    @HystrixCommand(fallbackMethod = "findAllError")
	    @Override
	    public Collection<User> findAll() {
	        return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list", Collection.class);
	    }
	    
	    public Collection<User> findAllError(Throwable throwable) {
	    	System.out.println(throwable.getMessage());
	    	List<User> list = new ArrayList<User>();
	    	User user = new User();
	    	user.setId(1000L);
	    	user.setName("error");
	    	list.add(user);
	    	return list;
	    }
	    
	    

}
