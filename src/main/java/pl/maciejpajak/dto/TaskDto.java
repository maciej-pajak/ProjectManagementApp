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

}
