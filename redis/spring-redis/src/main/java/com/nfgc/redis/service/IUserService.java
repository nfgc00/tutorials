package com.nfgc.redis.service;

import com.nfgc.redis.model.User;

import java.util.List;

public interface IUserService {

    boolean save(User user);
    List<User> getAll();
    User getById(Integer id);
    boolean update(Integer id, User user);
    boolean delete(Integer id);
}
