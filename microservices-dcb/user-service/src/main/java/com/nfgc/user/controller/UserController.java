package com.nfgc.user.controller;

import com.nfgc.user.dto.ResponseTemplate;
import com.nfgc.user.entity.User;
import com.nfgc.user.service.IUserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private IUserService userService;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<User> get(@PathVariable int id) {
//        return ResponseEntity.ok(userService.getById(id));
//    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "departmentService", fallbackMethod = "departmentServiceFallBack")
    public ResponseEntity<ResponseTemplate> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    public ResponseEntity<String> departmentServiceFallBack(Exception ex) {
        return ResponseEntity.ok("Department Service is not responding, please try again later");
    }
}
