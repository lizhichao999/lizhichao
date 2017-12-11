package com.hdsc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.hdsc.cloud.service.UserService;


/**
 * {@link UserService 用户服务} 引导类
 * {@link u}
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceProviderBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceProviderBootstrap.class, args);

	}

}
