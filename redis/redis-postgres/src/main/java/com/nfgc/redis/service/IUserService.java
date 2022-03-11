package com.nfgc.redis.service;

import com.nfgc.redis.domain.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface IUserService {

    User create(User user);

    @Cacheable(value = "user", key = "#id", unless = "#id < 5")
    User get(int id);

    List<User> getAll();

    @CachePut(value = "user", key = "#id")
    User update(int id, User user);

    @CacheEvict(value = "user", key = "#id")
    void delete(int id);
}
