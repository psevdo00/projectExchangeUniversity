package com.psevdo00.projectExchange.service;

import com.psevdo00.projectExchange.entity.UserEntity;
import com.psevdo00.projectExchange.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.psevdo00.projectExchange.enums.UserRoleEnum.*;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void updateRoleStudentToCaptain(Long id){

        UserEntity user = repository.findById(id).get();

        user.setRole(TEAM_CAPTAIN);

        repository.save(user);

    }

    public UserEntity findById(Long id){

        return repository.findById(id).get();

    }

    public List<UserEntity> findAllStudent(){

        return repository.findAllStudent();

    }

    public List<UserEntity> findAllProfessor(){

        return repository.findAllProfessor();

    }

}
