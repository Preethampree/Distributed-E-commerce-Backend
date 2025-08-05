package com.example.E_User_Service.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReigisterRequest {
    @Email(message = "Email is Requried")
    @NotBlank(message = "Email should Not Be Null ")
    private String email;
    @NotBlank(message = "Password Should Be 6 Letters")
    private String password;


}
