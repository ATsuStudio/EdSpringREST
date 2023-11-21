package com.atsustudio.EdSpringREST.Repository;

import com.atsustudio.EdSpringREST.Entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
}
