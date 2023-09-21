package com.SpringBoot.RESTtesting.service;

import com.SpringBoot.RESTtesting.entity.HttpResponse;
import com.SpringBoot.RESTtesting.entity.StaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Map;

@RestController
public class MainController {
    @Autowired
    private StaffRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register/firstAdmin")
    public ResponseEntity<HttpResponse> register(@RequestBody StaffEntity staff)
    {
        String passwd = staff.getPassword();
        staff.setPassword(passwordEncoder.encode(passwd));
        System.out.println(staff);
        repository.save(staff);
        return (
                ResponseEntity.created(URI.create("")).body(
                        HttpResponse.builder()
                                .data(Map.of("response", "SUCCESS"))
                                .message("Admin registration Success")
                                .requestMethod("POST")
                                .status(HttpStatus.CREATED)
                                .statusCode(HttpStatus.CREATED.value())
                                .build()
                )
        );
    }
}
