package com.psevdo00.projectExchange.service;

import com.psevdo00.projectExchange.DTO.request.CreateCommandDTO;
import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.DTO.response.StudentDTO;
import com.psevdo00.projectExchange.entity.CommandEntity;
import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.entity.StudentEntity;
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

    public void createCommand(CreateCommandDTO commandDTO, Long user_id){

        userService.updateRoleStudentToCaptain(user_id);

        StudentEntity userCaptain = userService.findStudentById(user_id);

        List<StudentEntity> users = new ArrayList<>();
        users.add(userCaptain);

        CommandEntity command = new CommandEntity();

        command.setCommandName(commandDTO.getCommandName());
        command.setUniversityCourse(commandDTO.getUniversityCourse());
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
