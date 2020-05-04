package ca.ravichaudhary.ssointegration.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MainController {

    @GetMapping("/hello")
    public String hello() {
        checkUserContext();
        return "Hello";
    }

    @GetMapping("/user")
    public SecurityContext userContext() {
        return SecurityContextHolder.getContext();
    }

    public void checkUserContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName();
        Object principal = authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

    }
}
