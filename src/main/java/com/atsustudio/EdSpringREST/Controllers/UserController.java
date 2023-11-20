package com.atsustudio.EdSpringREST.Controllers;


import com.atsustudio.EdSpringREST.Entity.UserEntity;
import com.atsustudio.EdSpringREST.Exceptions.UserNotFoundException;
import com.atsustudio.EdSpringREST.Models.UserModel;
import com.atsustudio.EdSpringREST.Repository.UserRepository;
import com.atsustudio.EdSpringREST.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity getAllUser(){
        try {
            List<UserModel> users = userService.getAllUser();

            return ResponseEntity.status(200).body(users);
        }catch (Exception err){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getSpecUser(@PathVariable(value = "id") Long uid){
        try {
            UserModel user = userService.getSpecUser(uid);
            return ResponseEntity.status(200).body(user);
        }catch (UserNotFoundException err){
            return ResponseEntity.status(404).body(err.getMessage());
        }catch (Exception err){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpecUser(@PathVariable(value = "id") Long uid){
        try {
            Long deleted_uid = userService.deleteSpecUser(uid);
            return ResponseEntity.status(200).body("User by id: "+deleted_uid + " deleted successful");
        }catch (UserNotFoundException err){
            return ResponseEntity.status(404).body(err.getMessage());
        }catch (Exception err){
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }


}
