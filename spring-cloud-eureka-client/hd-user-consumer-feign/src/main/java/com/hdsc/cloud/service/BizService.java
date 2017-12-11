package com.hdsc.cloud.service;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hdsc.cloud.admin.User;

/**
 * @author Administrator
 *  客户端调用业务服务
 */
@FeignClient(value = "user-service-provider")
public interface BizService {
	@PostMapping(value = "/user/save")
	public User save(@RequestBody User user);

	@RequestMapping(value = "/user/list",method = RequestMethod.GET)
	public Collection<User> findAll();
}
