package com.psevdo00.projectExchange.service;

import com.psevdo00.projectExchange.DTO.request.CreateProjectDTO;
import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.entity.CommandEntity;
import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository repository;
    private final CommandService commandService;

    public ProjectService(ProjectRepository repository, CommandService commandService) {
        this.repository = repository;
        this.commandService = commandService;
    }

    public void createProject(CreateProjectDTO dto){

        ProjectEntity project = new ProjectEntity();

        project.setTitle(dto.getTitle());
        project.setInfo(dto.getInfo());
        project.setFlag_completed(false);

        //TODO(вопрос по поводу комманды при создании проекта)
        project.setCommand(null);

        repository.save(project);

    }

    public boolean updateStatusProject(Long id){

        ProjectEntity project = repository.findById(id).get();

        project.setFlag_completed(!project.getFlag_completed());

        return project.getFlag_completed();

    }

    public ProjectEntity findById(Long id){

        return repository.findById(id).get();

    }

    public void selectProject(SelectProjectDTO dto){

        Long command_id = dto.getCommand_id();
        Long project_id = dto.getProject_id();

        ProjectEntity project = repository.findById(project_id).get();
        CommandEntity command = commandService.findById(command_id);

        project.setCommand(command);

        repository.save(project);

    }

}
