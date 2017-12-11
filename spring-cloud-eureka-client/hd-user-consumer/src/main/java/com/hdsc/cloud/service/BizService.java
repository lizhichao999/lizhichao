package com.hdsc.cloud.service;

import java.util.Collection;

import com.hdsc.cloud.admin.User;

/**
 * @author Administrator
 *  客户端调用业务服务
 */
public interface BizService {
	public boolean save(User user);

	public Collection<User> findAll();
}
