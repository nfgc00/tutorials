package com.nfgc.user.service;

import com.nfgc.user.dto.Department;
import com.nfgc.user.dto.ResponseTemplate;
import com.nfgc.user.entity.User;
import com.nfgc.user.exception.ResourceNotFoundException;
import com.nfgc.user.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;
    private RestTemplate departmentRestTemplate;

    @Override
    public User save(User user) {
        log.info("Save User: {}", user);
        return userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        log.info("Get User {}", id);
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public ResponseTemplate getUser(int id) {
        log.info("Get User {}", id);
        ResponseTemplate dto = new ResponseTemplate();
        User user = getById(id);
        Department department = departmentRestTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        dto.setUser(user);
        dto.setDepartment(department);
        return dto;
    }
}
