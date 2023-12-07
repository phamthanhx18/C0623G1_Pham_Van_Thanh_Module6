package com.example.fashionshop.controller;

import com.example.fashionshop.dto.request.SignInForm;
import com.example.fashionshop.dto.response.JwtResponse;
import com.example.fashionshop.security.jwt.JwtProvider;
import com.example.fashionshop.security.service.AccountDetailsImpl;
import com.example.fashionshop.service.IAccountService;
import com.example.fashionshop.service.IRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private IAccountService userService;
    @Autowired
    IRoleService roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        AccountDetailsImpl userPrinciple = (AccountDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()));
    }
}
