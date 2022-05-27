package com.userapp.service.impl;

import com.userapp.dto.UserDto;
import com.userapp.mapper.UserMapper;
import com.userapp.model.User;
import com.userapp.repository.UserRepository;
import com.userapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDto findByUuid(String uuid) {
        if(uuid==null || uuid.isEmpty()) {
            logger.warn("No se ha ingresado uuid");
            return null;
        }
        User user = userRepository.findByUuid(uuid);
        if(user==null){
            logger.info("user no encontrado");
            return null;
        }
        return userMapper.userToUserDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> usersList = (List<User>) userRepository.findAll();
        if(usersList == null || usersList.isEmpty()){
            logger.info("no existen usuarios");
            return null;
        }

        return userMapper.ListUserToListUserDto(usersList);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user==null){
            logger.info("El usuario con id "+id+" no existe");
            return null;
        }
        logger.info("Usuario: "+user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto saveUser(User user) {
        logger.info("request: "+user);
        if(user==null){
            logger.error("el usuario no puede ser nulo");
        }
        user.setUuid(UUID.randomUUID().toString());
        user.setCreateAt(LocalDateTime.now());
        User userSave = userRepository.save(user);
        if(userSave==null){
            logger.error("no se ha podido guardar el usuario");
        }
        return userMapper.userToUserDto(user);
    }
}
