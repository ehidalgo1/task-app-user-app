package com.userapp.service;

import com.userapp.dto.UserDto;
import com.userapp.model.User;


import java.util.List;

public interface UserService {

    UserDto findByUuid(String uuid);

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto saveUser(User user);
}
