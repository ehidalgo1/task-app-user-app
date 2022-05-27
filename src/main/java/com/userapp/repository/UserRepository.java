package com.userapp.repository;

import com.userapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUuid(String uuid);

}
