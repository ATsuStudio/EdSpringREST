package com.atsustudio.EdSpringREST.Repository;

import com.atsustudio.EdSpringREST.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findBy_username(String _username);
}
