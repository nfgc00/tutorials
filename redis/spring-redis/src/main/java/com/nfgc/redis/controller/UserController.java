package com.nfgc.redis.controller;

import com.nfgc.redis.model.User;
import com.nfgc.redis.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private IUserService uSerService;

    @PostMapping("/users")
    public ResponseEntity<String> save(@RequestBody User user) {
        boolean result = uSerService.save(user);
        if(result) {
            return ResponseEntity.ok("User Created Successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(uSerService.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        return ResponseEntity.ok(uSerService.getById(id));
    }

    @PutMapping ("/users/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody User user) {
        boolean result = uSerService.update(id, user);
        if(result) {
            return ResponseEntity.ok("User Updated Successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping ("/users/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        boolean result = uSerService.delete(id);
        if(result) {
            return ResponseEntity.ok("User Deleted Successfully.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
