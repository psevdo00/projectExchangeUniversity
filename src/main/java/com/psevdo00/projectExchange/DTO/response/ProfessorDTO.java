package com.psevdo00.projectExchange.DTO.response;

import com.psevdo00.projectExchange.entity.ProjectEntity;
import com.psevdo00.projectExchange.enums.UserRoleEnum;

import java.util.List;

public class ProfessorDTO {

    private Long id;
    private String username;
    private String firstName;
    private String familyName;
    private String middleName;
    private String email;
    private List<ProjectEntity> projects;
    private UserRoleEnum role;

    public ProfessorDTO(Long id, String username, String firstName, String familyName, String middleName, String email, List<ProjectEntity> projects, UserRoleEnum role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.familyName = familyName;
        this.middleName = middleName;
        this.email = email;
        this.projects = projects;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
