package com.nfgc.property.service;

import com.nfgc.property.domain.User;
import com.nfgc.property.dto.UserDto;
import com.nfgc.property.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = userRepository.save(new User(userDto));
        userDto.setId(user.getId());
        userDto.setPassword(null);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        return null;
    }
}
