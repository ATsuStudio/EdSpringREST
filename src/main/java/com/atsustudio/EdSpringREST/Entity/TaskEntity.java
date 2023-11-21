package com.atsustudio.EdSpringREST.Entity;

import com.atsustudio.EdSpringREST.Enums.TaskStatus;
import jakarta.persistence.*;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String _title;
    private TaskStatus _status;

    @ManyToOne
    @JoinColumn(name = "uid")
    private UserEntity _user;


    public void set_id(Long _id) {
        this._id = _id;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_status(TaskStatus _status) {
        this._status = _status;
    }

    public void setUser(UserEntity user) {
        this._user = user;
    }
    public Long get_id() {
        return _id;
    }

    public String get_title() {
        return _title;
    }

    public TaskStatus get_status() {
        return _status;
    }

    public UserEntity getUser() {
        return _user;
    }

    public TaskEntity() {
    }
}
