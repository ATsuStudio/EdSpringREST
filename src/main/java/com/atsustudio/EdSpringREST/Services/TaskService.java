package com.atsustudio.EdSpringREST.Services;

import com.atsustudio.EdSpringREST.Entity.TaskEntity;
import com.atsustudio.EdSpringREST.Entity.UserEntity;
import com.atsustudio.EdSpringREST.Exceptions.TaskNotFoundException;
import com.atsustudio.EdSpringREST.Exceptions.UserNotFoundException;
import com.atsustudio.EdSpringREST.Models.TaskModel;
import com.atsustudio.EdSpringREST.Repository.TaskRepository;
import com.atsustudio.EdSpringREST.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;

    public TaskModel createTask(TaskEntity task, Long userId) throws UserNotFoundException {
        if(userRepository.findById(userId).isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        UserEntity user = userRepository.findById(userId).orElseThrow();
        task.setUser(user);
        return  TaskModel.toModel(taskRepository.save(task));
    }
    public TaskModel updateTask(TaskEntity task, Long taskId) throws TaskNotFoundException {
        if(taskRepository.findById(taskId).isEmpty()){
            throw new TaskNotFoundException("Task not found");
        }

        TaskEntity findedTask = taskRepository.findById(taskId).orElseThrow();

        findedTask.set_title(
                task.get_title().isEmpty()
                ?findedTask.get_title()
                :task.get_title()
        );

        findedTask.set_status(
                task.get_status() == null
                ?findedTask.get_status()
                :task.get_status()
        );

        return TaskModel.toModel(taskRepository.save(findedTask));
    }

}
