package com.psevdo00.projectExchange.controller;

import com.psevdo00.projectExchange.service.SessionService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService service){

        this.service = service;

    }

    public void setSessionState(String sessionState,  HttpSession session){

        session.setAttribute("SessionState", sessionState);

    }

    @GetMapping("/api/getSession")
    public ResponseEntity getSession(HttpSession session){

        return ResponseEntity.ok().body(session.getAttribute("SessionState"));

    }

    @GetMapping("/api/getCurrRoleUser")
    public ResponseEntity getCurrRoleUser(HttpSession session){

        if (session == null || session.getAttribute("role") == null) {

            return ResponseEntity.ok(Map.of("role", "not_role", "id_user", "-1"));
        }

        return ResponseEntity.ok(Map.of(
                "role", session.getAttribute("role"),
                "id_user", session.getAttribute("id"),
                "username", session.getAttribute("UserName")
        ));

    }

    @DeleteMapping("/api/deleteSession")
    public ResponseEntity deleteSession(HttpSession session){

        try{

            service.deleteSession(session.getId());

            return ResponseEntity.ok(Map.of("message", "Удаление прошло успешно!", "newURL", "/index.html"));

        } catch (Exception e){

            return ResponseEntity.badRequest().body(Map.of("message", "Ошибка удаления сессии!"));

        }

    }

}
