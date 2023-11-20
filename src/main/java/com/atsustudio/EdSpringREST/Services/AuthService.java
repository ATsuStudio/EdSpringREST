package com.atsustudio.EdSpringREST.Services;

import com.atsustudio.EdSpringREST.Entity.UserEntity;
import com.atsustudio.EdSpringREST.Exceptions.IncorrectPassword;
import com.atsustudio.EdSpringREST.Exceptions.UserAlreadyExistException;
import com.atsustudio.EdSpringREST.Exceptions.UserNotFoundException;
import com.atsustudio.EdSpringREST.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public UserEntity login(UserEntity userEntity) throws UserAlreadyExistException {
        if(userRepository.findBy_username(userEntity.get_username()) !=null){
            throw new UserAlreadyExistException("User already exists!");
        }
        return userRepository.save(userEntity);
    }
    public String singin(UserEntity userEntity) throws UserNotFoundException, IncorrectPassword {
        String token = "Bearer GeneratedSomeToken-"+userEntity.get_username()+"-"+userEntity.get_password();

        if(userRepository.findBy_username(userEntity.get_username()) ==null){
            throw new UserNotFoundException("User not found");
        }

        UserEntity existUser = userRepository.findBy_username(userEntity.get_username());

        if( !(existUser.get_password()).equals(userEntity.get_password())){
            throw new IncorrectPassword("Incorrect password");
        }

        return token;
    }
}
