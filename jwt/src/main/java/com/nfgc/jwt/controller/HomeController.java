package com.nfgc.jwt.controller;

import com.nfgc.jwt.dto.JwtRequest;
import com.nfgc.jwt.dto.JwtResponse;
import com.nfgc.jwt.service.UserService;
import com.nfgc.jwt.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HomeController {

    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome....");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw  new Exception("Invalid credentials", e);
        }
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
