package com.psevdo00.projectExchange.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.psevdo00.projectExchange.enums.TypeProjectEnum;
import jakarta.persistence.*;

import java.time.Year;
import java.util.Set;

@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String info;
    private String subjectArea;
    private String university;
    private Year projectYear;
    private TypeProjectEnum type;

    private Boolean flag_completed;

    @OneToOne
    @JoinColumn(name = "command_id")
    private CommandEntity command;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;

    @ManyToMany
    @JoinTable(
            name = "project_tags", // имя таблицы связей
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonBackReference
    private Set<TagTechnologyEntity> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getFlag_completed() {
        return flag_completed;
    }

    public void setFlag_completed(Boolean flag_completed) {
        this.flag_completed = flag_completed;
    }

    public CommandEntity getCommand() {
        return command;
    }

    public void setCommand(CommandEntity command) {
        this.command = command;
    }

    public Set<TagTechnologyEntity> getTags() {
        return tags;
    }

    public void setTags(Set<TagTechnologyEntity> tags) {
        this.tags = tags;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }
}
