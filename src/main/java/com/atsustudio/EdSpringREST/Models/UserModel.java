package com.atsustudio.EdSpringREST.Models;

import com.atsustudio.EdSpringREST.Entity.UserEntity;

public class UserModel {


    private Long _id;
    private String _username;

    public static UserModel toModel(UserEntity userEntity){
        UserModel userM = new UserModel();
        userM.set_id(userEntity.get_id());
        userM.set_username(userEntity.get_username());
        return userM;
    }

    public UserModel() {
    }

    public Long get_id() {
        return _id;
    }

    public String get_username() {
        return _username;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public void set_username(String _username) {
        this._username = _username;
    }
}
