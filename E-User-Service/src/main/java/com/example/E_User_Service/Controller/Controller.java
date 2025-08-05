package com.example.E_User_Service.Controller;


import com.example.E_User_Service.DTO.ReigisterRequest;
import com.example.E_User_Service.Entity.Usere;
import com.example.E_User_Service.Repository.Repositoryu;
import com.example.E_User_Service.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class Controller {

    @Autowired
    public final UserService userService;
    @Autowired
    public final Repositoryu repositoryu;


    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody ReigisterRequest request) {
        String message = userService.register(request);
        return ResponseEntity.ok(message);
    }
    @GetMapping("/profile")
    public ResponseEntity<Usere> getProfile(Authentication authentication) {
        String email = authentication.getName();
        Usere user = repositoryu.findByEmail(email).orElseThrow();
        return ResponseEntity.ok(user);
    }


}
