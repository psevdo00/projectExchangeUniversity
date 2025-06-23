package com.psevdo00.projectExchange.controller;

import com.psevdo00.projectExchange.DTO.request.CreateCommandDTO;
import com.psevdo00.projectExchange.DTO.request.SelectProjectDTO;
import com.psevdo00.projectExchange.entity.CommandEntity;
import com.psevdo00.projectExchange.service.CommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("api/command")
public class CommandController {

    private final CommandService service;

    public CommandController(CommandService service) {
        this.service = service;
    }

    @PostMapping("/createCommand/{user_id}")
    public ResponseEntity createCommand(@RequestBody CreateCommandDTO command, @PathVariable Long user_id){

        service.createCommand(command, user_id);

        return ResponseEntity.ok(Map.of("message", "Создание команды прошло успешно!"));

    }

    @DeleteMapping("/deleteCommand/{id}")
    public ResponseEntity deleteCommand(@PathVariable Long id){

        service.deleteCommand(id);

        return ResponseEntity.ok(Map.of("message", "Удаление команды прошло успешно!"));

    }



}
