package com.salahin.rocky.service;

import com.salahin.rocky.dto.UserDto;
import com.salahin.rocky.entity.UserEntity;
import com.salahin.rocky.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;

    @CacheEvict(cacheNames = "users", allEntries = true)
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity;
        userEntity = modelMapper.map(userDto, UserEntity.class);
        userEntity = userRepository.save(userEntity);
        userDto = modelMapper.map(userEntity, UserDto.class);
        log.info("UsersService::saveUser() connecting to Database");
        return userDto;
    }

    @Cacheable(cacheNames = "users",sync = true)
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntityList;
        userEntityList = userRepository.findAll();
        log.info("UsersService::getAllUsers() connecting to Database");
        List<UserDto> userDtoList = userEntityList.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
        return userDtoList;
    }

    @CacheEvict(cacheNames = "users", allEntries = true)
    public UserDto getUsersById(int id){
        Optional<UserEntity> users;
        UserDto userDto = new UserDto();
        users = userRepository.findById(id);
        log.info("UsersService::getUsersById() connecting to Database");
        if(users.isPresent()) {
            userDto = modelMapper.map(users, UserDto.class);
        }
        return userDto;
    }

    @CachePut(cacheNames = "users",key = "#id")
    public UserDto updateUserById(int id, UserDto userDto){
        Optional<UserEntity> users;
        UserEntity updatedUserEntity;
        users = userRepository.findById(id);
        log.info("UsersService::updateUser() connecting to Database");
        if(users.isPresent()) {
            users = Optional.ofNullable(modelMapper.map(userDto, UserEntity.class));
            updatedUserEntity = userRepository.save(users.get());
            userDto = modelMapper.map(updatedUserEntity, UserDto.class);
        }
        return userDto;
    }
    @CacheEvict(cacheNames = "users",key = "#id")
    public long deleteUsersById(int id){
        Optional<UserEntity> users;
        long count=0;
        users = userRepository.findById(id);
        log.info("UsersService::deleteUsersById() connecting to Database");
        if(users.isPresent()) {
            userRepository.deleteById(id);
            count= userRepository.count();
        }
        return count;
    }
}
