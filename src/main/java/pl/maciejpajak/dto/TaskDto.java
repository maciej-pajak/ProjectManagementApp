package pl.maciejpajak.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import pl.maciejpajak.entity.Priority;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Status;
import pl.maciejpajak.entity.User;

public class TaskDto {
    
    @NotBlank
    private String topic;
    
    @NotBlank
    private String description;
    
    @NotNull
    private Project project;
    
    @NotNull
    private Status status;
    
    @NotNull
    private Priority priority;
    
    @NotNull
    private User user;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
