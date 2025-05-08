package com.psevdo00.projectExchange.controller;

import com.psevdo00.projectExchange.DTO.request.CreateProjectDTO;
import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        service.createProject(dto);

        return ResponseEntity.ok(Map.of("message", "Создание проекта прошело успешно!"));

    }

    @PatchMapping("/updateStatusProject/{id}")
    public ResponseEntity updateStatusProject(@RequestParam Long id){

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

}
