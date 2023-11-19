package com.atsustudio.EdSpringREST.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/all")
    public ResponseEntity getUsers(){
        try {
            return ResponseEntity.status(200).body("Okey");
        }catch (Exception err){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
    @PostMapping("/login")
    public ResponseEntity Login(){
        try {
            return ResponseEntity.status(200).body("Okey");
        }catch (Exception err){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
}
