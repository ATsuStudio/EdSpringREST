package com.atsustudio.EdSpringREST.Controllers;

import com.atsustudio.EdSpringREST.Entity.UserEntity;
import com.atsustudio.EdSpringREST.Exceptions.IncorrectPasswordException;
import com.atsustudio.EdSpringREST.Exceptions.UserAlreadyExistException;
import com.atsustudio.EdSpringREST.Exceptions.UserNotFoundException;
import com.atsustudio.EdSpringREST.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserEntity user){
        try {
            authService.login(user);
            return ResponseEntity.status(201).body("User created successful");
        }
        catch (UserAlreadyExistException err) {
            return ResponseEntity.status(409).body(err.getMessage());
        }
        catch (Exception err){
            return ResponseEntity.status(500).body(err);
        }
    }

    @PostMapping("/singin")
    public ResponseEntity singin(@RequestBody UserEntity user){
        String token;
        try {
            token = authService.singin(user);
            return ResponseEntity.status(200).body(token);
        }
        catch (IncorrectPasswordException err) {
            return ResponseEntity.status(401).body(err.getMessage());
        }
        catch (UserNotFoundException err) {
            return ResponseEntity.status(404).body(err.getMessage());
        }
        catch (Exception err){
            return ResponseEntity.status(500).body(err);
        }
    }
}
