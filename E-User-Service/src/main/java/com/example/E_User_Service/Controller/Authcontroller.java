package com.example.E_User_Service.Controller;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.E_User_Service.Config.JwtService;
import com.example.E_User_Service.Config.SecurityConfig;
import com.example.E_User_Service.DTO.JwtResponse;
import com.example.E_User_Service.DTO.LoginRequest;
import com.example.E_User_Service.Repository.Repositoryu;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class Authcontroller {
    @Autowired
    public final Repositoryu repositoryu;
    @Autowired
    public final SecurityConfig securityConfig;
    @Autowired
    public final JwtService jwtService;
    @Autowired
    public final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        var user = repositoryu.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(user.getEmail());

        return ResponseEntity.ok(new JwtResponse(token));
    }



}
