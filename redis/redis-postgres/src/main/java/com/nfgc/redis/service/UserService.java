package com.nfgc.redis.service;

import com.nfgc.redis.domain.User;
import com.nfgc.redis.exception.ResourceNotFoundException;
import com.nfgc.redis.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(int id) {
        log.info("Get User {}", id);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public List<User> getAll() {
        log.info("Get All Users");
        return userRepository.findAll();
    }

    @Override
    public User update(int id, User user) {
        log.info("Update User {} with data {}", id, user);
        User exists = get(id);
        user.setId(exists.getId());
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        log.info("Delete User {}", id);
        User user = get(id);
        userRepository.delete(user);
    }
}