package com.psevdo00.projectExchange.entity;

import jakarta.persistence.*;

@Entity
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String info;

    private Boolean flag_completed;

    @OneToOne
    @JoinColumn(name = "command_id")
    private CommandEntity command;

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
}
