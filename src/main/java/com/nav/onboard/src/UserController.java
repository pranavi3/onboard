package com.nav.onboard.src;

import com.nav.onboard.model.SignUpResponse;
import com.nav.onboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody User user){
        SignUpResponse signUpResponse = service.signup(user);
        return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<SignUpResponse> login(@RequestBody User user){
        SignUpResponse signUpResponse = service.login(user);
        return new ResponseEntity<>(signUpResponse, HttpStatus.OK);
    }
}
