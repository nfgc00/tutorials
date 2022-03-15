package com.nfgc.user.service;

import com.nfgc.user.dto.ResponseTemplate;
import com.nfgc.user.entity.User;

public interface IUserService {
    User save(User user);
    User getById(int id);
    ResponseTemplate getUser(int id);
}
