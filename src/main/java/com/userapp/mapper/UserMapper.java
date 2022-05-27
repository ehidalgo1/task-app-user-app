package com.userapp.mapper;

import com.userapp.dto.UserDto;
import com.userapp.model.User;

import java.util.List;

public interface UserMapper {

    UserDto userToUserDto(User user);

    List<UserDto> ListUserToListUserDto(List<User> userList);
}
