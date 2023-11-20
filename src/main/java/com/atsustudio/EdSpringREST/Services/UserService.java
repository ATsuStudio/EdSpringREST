package com.atsustudio.EdSpringREST.Services;

import com.atsustudio.EdSpringREST.Entity.UserEntity;
import com.atsustudio.EdSpringREST.Exceptions.UserNotFoundException;
import com.atsustudio.EdSpringREST.Models.UserModel;
import com.atsustudio.EdSpringREST.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<UserModel> getAllUser() {
        Iterable<UserEntity> users = userRepository.findAll();
        List<UserModel> userModelList = new ArrayList<>();

        for (UserEntity user : users) {
            userModelList.add(UserModel.toModel(user));
        }

        return userModelList;
    }

    public UserModel getSpecUser(Long UserId) throws UserNotFoundException {
        if(userRepository.findById(UserId).isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        UserEntity user = userRepository.findById(UserId).orElseThrow();

        return UserModel.toModel(user);
    }

    public Long deleteSpecUser(Long UserId) throws UserNotFoundException {
        if(userRepository.findById(UserId).isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(UserId);

        return UserId;
    }

}
