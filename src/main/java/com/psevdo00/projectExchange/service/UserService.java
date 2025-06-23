package com.psevdo00.projectExchange.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psevdo00.projectExchange.DTO.response.ProfessorDTO;
import com.psevdo00.projectExchange.DTO.response.StudentDTO;
import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.entity.StudentEntity;
import com.psevdo00.projectExchange.entity.UserEntity;
import com.psevdo00.projectExchange.repository.StudentRepository;
import com.psevdo00.projectExchange.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import static com.psevdo00.projectExchange.enums.UserRoleEnum.*;

@Service
public class UserService {

    private final UserRepository repository;
    private final StudentRepository studentRepository;
    private final ProjectService projectService;

    public UserService(UserRepository repository, StudentRepository studentRepository, ProjectService projectService) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.projectService = projectService;
    }

    public Long decodingAccessToken(ResponseEntity response){

        Map<String, Object> tokens = (Map<String, Object>) response.getBody();

        String accessToken = (String) tokens.get("access_token");

        String[] parts = accessToken.split("\\."); // Разделяем на header, payload, signature

        // Декодируем payload (вторая часть)
        String payload = new String(Base64.getUrlDecoder().decode(parts[1]));

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Для парсинга в Map
            Map<String, Object> payloadMap = mapper.readValue(payload, Map.class);
            Map<String, List<String>> realmAccess = (Map<String, List<String>>) payloadMap.get("realm_access");

            String username = (String) payloadMap.get("preferred_username");
            UserEntity checkUser = repository.findByUsername(username);

            if (checkUser == null) {

                UserEntity user = new UserEntity();

                user.setUsername(username);
                String firstname = (String) payloadMap.get("first_name");
                user.setFirstName(firstname);
                String familyname = (String) payloadMap.get("family_name");
                user.setFamilyName(familyname);
                String middlename = (String) payloadMap.get("middle_name");
                user.setMiddleName(middlename);
                String email = (String) payloadMap.get("email");
                user.setEmail(email);

                List<String> roles = realmAccess.get("roles");

                if (roles.contains("Student")) {

                    user.setRole(STUDENT);

                    repository.save(user);

                    UserEntity savedUser = repository.findByUsername(username);

                    StudentEntity student = new StudentEntity();
                    student.setUser(savedUser);
                    student.setCommand(null);

                    studentRepository.save(student);

                }

            }

            UserEntity userInDatabase = repository.findByUsername(username);

            return userInDatabase.getId();

        } catch (JsonProcessingException e) {
            System.err.println("Ошибка парсинга JSON: " + e.getMessage());
            return null;
        }

    }

    public void saveUser(){



    }

    public void authUser(){



    }

    public void updateRoleStudentToCaptain(Long id){

        UserEntity user = repository.findById(id).get();

        user.setRole(TEAM_CAPTAIN);

        repository.save(user);

    }

    public StudentDTO findStudentDtoById(Long id){

        return repository.findStudentDtoById(id).get();

    }

    public ProfessorDTO findProfessorDtoById(Long id){

        ProfessorDTO dto = repository.findProfessorDtoById(id).get();
        List<ProjectEntity> list = projectService.findAllByProfessor(dto.getId());

        dto.setProjects(list);

        return dto;

    }

    public StudentEntity findStudentById(Long id){

        return repository.findStudentById(id).get();

    }

    public List<UserEntity> findAllStudent(){

        return repository.findAllStudent();

    }

    public List<UserEntity> findAllProfessor(){

        return repository.findAllProfessor();

    }

}
