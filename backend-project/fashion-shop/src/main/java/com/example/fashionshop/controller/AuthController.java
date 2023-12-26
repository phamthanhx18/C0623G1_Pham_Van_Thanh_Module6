package com.example.fashionshop.controller;

import com.example.fashionshop.dto.request.SignInForm;
import com.example.fashionshop.dto.response.JwtResponse;
import com.example.fashionshop.security.jwt.JwtProvider;
import com.example.fashionshop.security.service.AccountDetailsImpl;
import com.example.fashionshop.service.IAccountService;
import com.example.fashionshop.service.IRoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    JwtProvider jwtProvider;
    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody SignInForm loginRequest) {
//        String token = authenticateAndGetToken(loginRequest.getUsername(), loginRequest.getPassword());
        String token = loginRequest.getUsername();
        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }

//    private String authenticateAndGetToken(String username, String password) {
//
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        return jwtProvider.createToken(authentication);
//    }
}
