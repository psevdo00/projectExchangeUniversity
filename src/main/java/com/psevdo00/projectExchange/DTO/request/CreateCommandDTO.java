package com.psevdo00.projectExchange.DTO.request;

import com.psevdo00.projectExchange.entity.StudentEntity;

import java.util.List;

public class CreateCommandDTO {

    private String commandName;
    private String universityCourse;
    private List<Long> studentsId;

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getUniversityCourse() {
        return universityCourse;
    }

    public void setUniversityCourse(String universityCourse) {
        this.universityCourse = universityCourse;
    }

    public List<Long> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(List<Long> studentsId) {
        this.studentsId = studentsId;
    }

}
