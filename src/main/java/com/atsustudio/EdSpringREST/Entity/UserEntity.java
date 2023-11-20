package com.atsustudio.EdSpringREST.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String _username;
    private String _password;

    public UserEntity() {
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
