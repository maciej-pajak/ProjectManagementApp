package pl.maciejpajak.service;

import java.util.List;

import pl.maciejpajak.dto.ProjectDto;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.User;

public interface IProjectService {
    
    public Project createProject(ProjectDto dto, Long ownerId);
    public List<User> getAvailableUsers();

}
