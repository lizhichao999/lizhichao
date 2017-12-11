package com.hdsc.cloud.dao;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.hdsc.cloud.admin.User;

/**
 * {@link User 用户} 仓储
 *
 */
@Repository
public class UserDao {

	private ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();

	private static final AtomicLong idGenerator = new AtomicLong(0);

	public Collection<User> findAll() {
		return repository.values();
	}

	public boolean save(User user) {
		Long id = idGenerator.incrementAndGet();
		user.setId(id);
		return repository.putIfAbsent(id, user) == null;
	}
}
