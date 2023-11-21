package com.atsustudio.EdSpringREST.Controllers;

import com.atsustudio.EdSpringREST.Entity.TaskEntity;
import com.atsustudio.EdSpringREST.Exceptions.TaskNotFoundException;
import com.atsustudio.EdSpringREST.Exceptions.UserNotFoundException;
import com.atsustudio.EdSpringREST.Models.TaskModel;
import com.atsustudio.EdSpringREST.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;
    @PostMapping
    public ResponseEntity createTask(@RequestBody TaskEntity task, @RequestParam Long userId){
        try {
            TaskModel result = taskService.createTask(task,userId);
            return ResponseEntity.status(200).body(result);
        } catch (UserNotFoundException err) {
            return ResponseEntity.status(404).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }
    @PatchMapping
    public ResponseEntity updateTask(@RequestBody TaskEntity task, @RequestParam Long taskId){
        try {
            TaskModel result = taskService.updateTask(task,taskId);
            return ResponseEntity.status(200).body(result);
        } catch (TaskNotFoundException err) {
            return ResponseEntity.status(404).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(500).body("Something went wrong");
        }
    }

}
