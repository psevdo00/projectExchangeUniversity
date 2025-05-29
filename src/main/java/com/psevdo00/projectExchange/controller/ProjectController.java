package com.psevdo00.projectExchange.controller;

import com.psevdo00.projectExchange.DTO.request.CreateProjectDTO;
import com.psevdo00.projectExchange.DTO.request.EditProjectDTO;
import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.DTO.request.TagDTO;
import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.enums.TypeProjectEnum;
import com.psevdo00.projectExchange.service.ProjectService;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping("/createProject")
    public ResponseEntity createProject(@RequestBody CreateProjectDTO dto){

        Long id_project = service.createProject(dto);

        return ResponseEntity.ok(Map.of(
                "message", "Создание проекта прошло успешно!",
                "id_project", id_project
        ));

    }

    @PatchMapping("/editProject")
    public ResponseEntity editproject(@RequestBody EditProjectDTO dto){

        service.editProject(dto);

        return ResponseEntity.ok(Map.of(
                "message", "Изменение проекта прошло успешно!"
        ));

    }

    @PatchMapping("/updateStatusProject/{id}")
    public ResponseEntity updateStatusProject(@PathVariable Long id){

        Boolean statusValue = service.updateStatusProject(id);

        if (statusValue){

            return ResponseEntity.ok(Map.of(
                    "message", "У проекта установлен статус Завершен!",
                    "status_completed", statusValue
            ));

        } else {

            return ResponseEntity.ok(Map.of(
                    "message", "У проекта установлен статус Открыт!",
                    "status_completed", statusValue
            ));

        }

    }

    @PatchMapping("/selectProject")
    public ResponseEntity selectProject(@RequestBody SelectProjectDTO dto){

        service.selectProject(dto);

        return ResponseEntity.ok(Map.of("message", "Выбор проекта прошел успешно!"));

    }

    @GetMapping("/find/By/Id/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        ProjectEntity project = service.findById(id);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", project
        ));

    }

    @GetMapping("/find/All")
    public ResponseEntity findAll(){

        List<ProjectEntity> listProject = service.findAll();

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/Title/{title}")
    public ResponseEntity findByTitle(@PathVariable String title){

        List<ProjectEntity> listProject = service.findByTitle(title);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/University/{university}")
    public ResponseEntity findByUniversity(@PathVariable String university){

        List<ProjectEntity> listProject = service.findByUniversity(university);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/Tags")
    public ResponseEntity findByTags(@RequestBody TagDTO tagsDTO){

        List<ProjectEntity> listProject = service.findByTags(tagsDTO.getTags());

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/Flag_completed/{flag}")
    public ResponseEntity findByFlag_completed(@PathVariable boolean flag){

        List<ProjectEntity> listProject = service.findByFlag_completed(flag);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/SubjectArea/{subjectArea}")
    public ResponseEntity findBySubjectArea(@PathVariable String subjectArea){

        List<ProjectEntity> listProject = service.findBySubjectArea(subjectArea);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/ProjectYear/{year}")
    public ResponseEntity findByProjectYear(@PathVariable int year){

        Year projectYear = Year.of(year);

        List<ProjectEntity> listProject = service.findByProjectYear(projectYear);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

    @GetMapping("/find/By/Type/{type}")
    public ResponseEntity findByType(@PathVariable String type){

        TypeProjectEnum typeProject = TypeProjectEnum.valueOf(type.toUpperCase());

        List<ProjectEntity> listProject = service.findByType(typeProject);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "project", listProject
        ));

    }

}
