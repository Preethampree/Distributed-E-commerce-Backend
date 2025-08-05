package com.example.E_User_Service.Service;



import com.example.E_User_Service.DTO.ReigisterRequest;
import com.example.E_User_Service.Entity.Usere;
import com.example.E_User_Service.Repository.Repositoryu;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    public final Repositoryu repositoryu;



    private final PasswordEncoder passwordEncoder;
    public String register(ReigisterRequest request){
       if(repositoryu.findByEmail(request.getEmail()).isPresent()){
           return "User Already Register";
       }

       Usere user = Usere.builder()
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .role("ROLE_USER")
               .build();

       repositoryu.save(user);
       return "User registered successfully!";
   }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here username is email!
        Usere user = repositoryu.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole()))
        );
    }



}