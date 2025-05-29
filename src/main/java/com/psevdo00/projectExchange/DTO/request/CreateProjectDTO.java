package com.psevdo00.projectExchange.DTO.request;

import com.psevdo00.projectExchange.enums.TypeProjectEnum;

import java.time.Year;
import java.util.List;

public class CreateProjectDTO {

    private String title;
    private String info;
    private String subjectArea;
    private String university;
    private Year projectYear;
    private TypeProjectEnum type;
    private Long id_command;
    private List<String> tags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Year getProjectYear() {
        return projectYear;
    }

    public void setProjectYear(Year projectYear) {
        this.projectYear = projectYear;
    }

    public TypeProjectEnum getType() {
        return type;
    }

    public void setType(TypeProjectEnum type) {
        this.type = type;
    }

    public Long getId_command() {
        return id_command;
    }

    public void setId_command(Long id_command) {
        this.id_command = id_command;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
