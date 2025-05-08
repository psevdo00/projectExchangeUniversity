package com.psevdo00.projectExchange.controller;

import com.psevdo00.projectExchange.entity.UserEntity;
import com.psevdo00.projectExchange.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){

        this.service = service;

    }

    @PutMapping("/student/updateRoleStudent/{id}")
    public ResponseEntity updateRoleStudentToCaptain(@PathVariable Long id){

        service.updateRoleStudentToCaptain(id);

        return ResponseEntity.ok(Map.of("message", "Роль капитана успешно установлена!"));

    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity findById(Long id){

        UserEntity user = service.findById(id);

        return ResponseEntity.ok(Map.of(
                "message", "Поиск прошел успешно!",
                "entity", user
        ));

    }

    @GetMapping("/findAllStudent")
    public ResponseEntity findAllStudent(){

        try{

            List<UserEntity> list = service.findAllStudent();

            if (list == null){

                return ResponseEntity.ok(Map.of("message", "Никого не найдено!"));

            }

            return ResponseEntity.ok(Map.of(
                    "message", "Поиск прошел успешно!",
                    "list", list
            ));

        } catch (Exception e){

            return ResponseEntity.badRequest().body(Map.of("message", e));

        }



    }

    @GetMapping("/findAllProfessor")
    public ResponseEntity findAllProfessor(){

        try{

            List<UserEntity> list = service.findAllProfessor();

            if (list == null){

                return ResponseEntity.ok(Map.of("message", "Никого не найдено!"));

            }

            return ResponseEntity.ok(Map.of(
                    "message", "Поиск прошел успешно!",
                    "list", list
            ));

        } catch (Exception e){

            return ResponseEntity.badRequest().body(Map.of("message", e));

        }

    }

}
