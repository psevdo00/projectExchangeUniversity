package com.psevdo00.projectExchange.service;

import com.psevdo00.projectExchange.DTO.request.CreateProjectDTO;
import com.psevdo00.projectExchange.DTO.request.EditProjectDTO;
import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.entity.CommandEntity;
import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.entity.TagTechnologyEntity;
import com.psevdo00.projectExchange.enums.TypeProjectEnum;
import com.psevdo00.projectExchange.repository.CommandRepository;
import com.psevdo00.projectExchange.repository.ProjectRepository;
import com.psevdo00.projectExchange.repository.TagTechnologyRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.*;

@Service
public class ProjectService {

    private final ProjectRepository repository;
    private final CommandRepository commandRepository;
    private final TagTechnologyRepository tagRepository;

    public ProjectService(ProjectRepository repository, CommandRepository commandRepository, TagTechnologyRepository tagRepository) {
        this.repository = repository;
        this.commandRepository = commandRepository;
        this.tagRepository = tagRepository;
    }

    public Long createProject(CreateProjectDTO dto){

        ProjectEntity project = new ProjectEntity();
        List<TagTechnologyEntity> allTags = tagRepository.findAll();
        List<String> dtoTags = dto.getTags();

        Set<TagTechnologyEntity> projectTags = new HashSet<>();

        Map<String, TagTechnologyEntity> tagMap = new HashMap<>();
        for (TagTechnologyEntity tag : allTags) {

            tagMap.put(tag.getTechnology(), tag);

        }

        project.setTitle(dto.getTitle());
        project.setInfo(dto.getInfo());
        project.setSubjectArea(dto.getSubjectArea());
        project.setUniversity(dto.getUniversity());
        project.setProjectYear(dto.getProjectYear());
        project.setType(dto.getType());
        project.setFlag_completed(false);
        project.setCommand(null);

        for (String tagName : dtoTags){

            TagTechnologyEntity tag = tagMap.get(tagName);

            if (tag != null) {

                projectTags.add(tag);

            }

        }

        project.setTags(projectTags);

        ProjectEntity saveProject = repository.save(project);

        return saveProject.getId();
    }

    public void editProject(EditProjectDTO dto){

        ProjectEntity project = repository.findById(dto.getId()).get();

        project.setTitle(dto.getTitle());
        project.setInfo(dto.getInfo());
        project.setSubjectArea(dto.getSubjectArea());
        project.setUniversity(dto.getUniversity());
        project.setProjectYear(dto.getProjectYear());
        project.setType(dto.getType());
        project.setFlag_completed(false);
        project.setCommand(null);

        //TODO(Пока еще не доделано)

        //repository.save(project);

    }

    public boolean updateStatusProject(Long id){

        ProjectEntity project = repository.findById(id).get();

        project.setFlag_completed(!project.getFlag_completed());
        repository.save(project);

        return project.getFlag_completed();

    }

    public void selectProject(SelectProjectDTO dto){

        Long command_id = dto.getCommand_id();
        Long project_id = dto.getProject_id();

        ProjectEntity project = repository.findById(project_id).get();
        CommandEntity command = commandRepository.findById(command_id).get();

        project.setCommand(command);

        repository.save(project);

    }

    public ProjectEntity findById(Long id){

        return repository.findById(id).get();

    }

    public List<ProjectEntity> findAllByProfessor(Long id){

        return repository.findAllByProfessor(id);

    }

    public List<ProjectEntity> findAll(){

        return repository.findAll();

    }

    public List<ProjectEntity> findByTitle(String title){

        return repository.findByTitle(title);

    }

    public List<ProjectEntity> findByUniversity(String university){

        return repository.findByUniversity(university);

    }

    public List<ProjectEntity> findByTags(List<String> tags){

        return repository.findByTagsIn(tags);

    }

    public List<ProjectEntity> findByFlag_completed(Boolean flag){

        return repository.findByFlag_completed(flag);

    }

    public List<ProjectEntity> findBySubjectArea(String subjectArea){

        return repository.findBySubjectArea(subjectArea);

    }

    public List<ProjectEntity> findByProjectYear(Year projectYear){

        return repository.findByProjectYear(projectYear);

    }

    public List<ProjectEntity> findByType(TypeProjectEnum type){

        return repository.findByType(type);

    }

}
