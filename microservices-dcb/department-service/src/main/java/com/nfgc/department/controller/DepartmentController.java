package com.nfgc.department.controller;

import com.nfgc.department.entity.Department;
import com.nfgc.department.service.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private IDepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> add(@RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.save(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> get(@PathVariable int id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }
}
