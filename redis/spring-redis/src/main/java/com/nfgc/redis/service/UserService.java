package com.nfgc.redis.service;

import com.nfgc.redis.ResourceNotFoundException;
import com.nfgc.redis.model.User;
import com.nfgc.redis.repository.IUserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private IUserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(Integer id) {
        Optional<User> opt = userDao.getById(id);
        if(opt.isEmpty()) {
            throw new ResourceNotFoundException(String.format("User %s not found.", id));
        }
        return opt.get();
    }

    @Override
    public boolean update(Integer id, User user) {
        User userExists = getById(id);
        return userDao.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        User user = getById(id);
        return userDao.delete(user);
    }
}
