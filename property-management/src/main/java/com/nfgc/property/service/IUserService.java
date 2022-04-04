package com.nfgc.property.service;

import com.nfgc.property.dto.UserDto;

public interface IUserService {

    UserDto register(UserDto userDto);
    UserDto login(String email, String password);
}
