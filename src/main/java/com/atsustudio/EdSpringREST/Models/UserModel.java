package com.atsustudio.EdSpringREST.Models;

import com.atsustudio.EdSpringREST.Entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {


    private Long id;
    private String username;

    private List<TaskModel> _tasks;

    public static UserModel toModel(UserEntity userEntity){
        UserModel userM = new UserModel();
        userM.set_id(userEntity.get_id());
        userM.set_username(userEntity.get_username());
        userM.setTasks(
                userEntity
                        .getTasks()
                        .stream()
                        .map(TaskModel::toModel)
                        .collect(Collectors.toList()));
        return userM;
    }


    public UserModel() {
    }


    public List<TaskModel> getTasks() {
        return _tasks;
    }
    public Long get_id() {
        return id;
    }

    public String get_username() {
        return username;
    }



    public void setTasks(List<TaskModel> tasks) {
        this._tasks = tasks;
    }

    public void set_id(Long _id) {
        this.id = _id;
    }

    public void set_username(String _username) {
        this.username = _username;
    }
}
