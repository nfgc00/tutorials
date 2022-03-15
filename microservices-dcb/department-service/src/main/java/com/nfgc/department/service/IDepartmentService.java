package com.nfgc.department.service;

import com.nfgc.department.entity.Department;
import org.springframework.http.ResponseEntity;

public interface IDepartmentService {
    Department save(Department department);
    Department getById(int id);
}
