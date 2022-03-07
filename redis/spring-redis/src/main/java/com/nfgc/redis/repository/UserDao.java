package com.nfgc.redis.repository;

import com.nfgc.redis.model.User;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserDao implements IUserDao {

    private static final String KEY = "USER";
    private RedisTemplate redisTemplate;

    @Override
    public boolean save(User user) {
        try {
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = redisTemplate.opsForHash().values(KEY);
        return users;
    }

    @Override
    public Optional<User> getById(Integer id) {
        return Optional.ofNullable((User) redisTemplate.opsForHash().get(KEY, id.toString()));
    }

    @Override
    public boolean delete(User user) {
        try {
            redisTemplate.opsForHash().delete(KEY, user.getId().toString());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
