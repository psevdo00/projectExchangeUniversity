package com.psevdo00.projectExchange.DTO.response;

import com.psevdo00.projectExchange.enums.UserRoleEnum;

public class StudentDTO {

    private Long id;
    private String username;
    private String firstName;
    private String familyName;
    private String middleName;
    private String email;
    private Long commandId;
    private UserRoleEnum role;

    public StudentDTO(Long id, String username, String firstName, String familyName, String middleName, String email, Long commandId, UserRoleEnum role) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.familyName = familyName;
        this.middleName = middleName;
        this.email = email;
        this.commandId = commandId;
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

    public Long getCommandId() {
        return commandId;
    }

    public void setCommandId(Long commandId) {
        this.commandId = commandId;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
