package com.psevdo00.projectExchange.DTO.request;

public class SelectProjectDTO {

    private Long command_id;
    private Long project_id;

    public Long getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Long command_id) {
        this.command_id = command_id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

}
