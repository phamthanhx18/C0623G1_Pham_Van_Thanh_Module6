package com.example.demologin.controller;

import com.example.demologin.model.Account;
import com.example.demologin.payload.request.LoginRequest;
import com.example.demologin.payload.response.JwtResponse;
import com.example.demologin.repository.IAccountRepository;
import com.example.demologin.security.jwt.JwtTokenProvider;
import com.example.demologin.security.service.AccountDetailsImpl;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IAccountRepository roleRepository;

    @Autowired
    private JwtTokenProvider jwtUtils;

    @PostMapping(value = "/test123")
    public ResponseEntity<String> test(String username, String password) {
        return new ResponseEntity<>(username+" "+password, HttpStatus.OK);
    }

//    @PostMapping(value = "/signin")
//    public ResponseEntity<?> authenticateUser(@RequestParam String username, String password) {
//        LoginRequest loginRequest = new LoginRequest(username,password);
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateToken((AccountDetailsImpl) authentication);
//
//        AccountDetailsImpl accountDetails = (AccountDetailsImpl) authentication.getPrincipal();
//        List<String> roles = accountDetails.getAuthorities().stream()
//                .map(item -> item.getAuthority())
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                accountDetails.getId(),
//                accountDetails.getUsername(),
//                roles));
//    }
}
