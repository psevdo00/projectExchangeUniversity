package com.psevdo00.projectExchange.service;

import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.entity.CommandEntity;
import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.entity.UserEntity;
import com.psevdo00.projectExchange.repository.CommandRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommandService {

    private final CommandRepository repository;
    private final UserService userService;

    public CommandService(CommandRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public void createCommand(CommandEntity command, Long user_id){

        userService.updateRoleStudentToCaptain(user_id);

        UserEntity userCaptain = userService.findById(user_id);

        List<UserEntity> users = new ArrayList<>();
        users.add(userCaptain);

        command.setStudents(users);
        command.setProject(null);

        repository.save(command);

    }

    public void deleteCommand(Long id){

        repository.deleteById(id);

    }

    public CommandEntity findById(Long id){

        return repository.findById(id).get();

    }

}
