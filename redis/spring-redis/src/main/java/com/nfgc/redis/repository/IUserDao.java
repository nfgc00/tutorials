package com.nfgc.redis.repository;

import com.nfgc.redis.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserDao {

    boolean save(User user);
    List<User> getAll();
    Optional<User> getById(Integer id);
    boolean delete(User user);
}
