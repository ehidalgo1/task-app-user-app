package com.userapp.mapper.impl;

import com.userapp.dto.UserDto;
import com.userapp.mapper.UserMapper;
import com.userapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {

    private Logger logger = LoggerFactory.getLogger(UserMapperImpl.class);
    @Override
    public UserDto userToUserDto(User user) {
        if (user == null){
            logger.warn("No se ha ingresado un user");
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUuid(user.getUuid());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setUsername(user.getUsername());
        userDto.setCreateAt(user.getCreateAt());
        userDto.setUpdateAt(user.getUpdateAt());
        return userDto;
    }

    @Override
    public List<UserDto> ListUserToListUserDto(List<User> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        userList.stream().forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUuid(user.getUuid());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setUsername(user.getUsername());
            userDto.setCreateAt(user.getCreateAt());
            userDto.setUpdateAt(user.getUpdateAt());
            userDtoList.add(userDto);
        });

        List<UserDto> userDtoOrderById = userDtoList.stream().sorted(Comparator.comparingLong(UserDto::getId)).collect(Collectors.toList());

        return userDtoOrderById;
    }
}
