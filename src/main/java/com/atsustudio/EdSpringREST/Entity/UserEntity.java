package com.atsustudio.EdSpringREST.Entity;

import com.atsustudio.EdSpringREST.Models.TaskModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String _username;
    private String _password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "_user")
    private List<TaskEntity> _tasks;


    public UserEntity() {
    }



    public void setTasks(List<TaskEntity> tasks) {
        this._tasks = tasks;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public void set_password(String _password) {
        this._password = _password;
    }



    public List<TaskEntity> getTasks() { return _tasks; }

    public Long get_id() {
        return _id;
    }

    public String get_username() {
        return _username;
    }

    public String get_password() {
        return _password;
    }

}
