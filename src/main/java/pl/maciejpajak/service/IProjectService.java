package pl.maciejpajak.service;

import java.util.List;

import pl.maciejpajak.dto.ProjectDto;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.entity.User;

public interface IProjectService {
    
    public Project createProject(ProjectDto dto, Long ownerId);
    public List<User> getAvailableUsers();
    public List<Project> getProjectsByOwnerId(Long id);
    public List<Project> getProjectsByUsersId(Long id);
    public Project getProjectById(Long id);
    public Project getProjectByIdFetchUsers(Long id);
    public List<Task> getTasksByProjectId(Long id);

}
