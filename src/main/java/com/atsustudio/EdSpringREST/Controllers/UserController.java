package com.atsustudio.EdSpringREST.Controllers;


import com.atsustudio.EdSpringREST.Entity.UserEntity;
import com.atsustudio.EdSpringREST.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity getUsers(){
        try {
            return ResponseEntity.status(200).body("Okey");
        }catch (Exception err){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }


}
