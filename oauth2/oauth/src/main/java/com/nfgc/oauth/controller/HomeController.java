package com.nfgc.oauth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken authentication) {
        return "Hello " + authentication.getPrincipal().getAttributes().get("name");
    }

    @GetMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
