package com.nfgc.department.service;

import com.nfgc.department.entity.Department;
import com.nfgc.department.exception.ResourceNotFoundException;
import com.nfgc.department.repository.IDepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class DepartmentService implements IDepartmentService {

    private IDepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        log.info("Save Department: {}", department);
        return departmentRepository.save(department);
    }

    @Override
    public Department getById(int id) {
        log.info("Get Department by Id: {}", id);
        return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
    }
}
