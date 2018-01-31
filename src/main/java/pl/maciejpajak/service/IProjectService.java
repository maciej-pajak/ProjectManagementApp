package pl.maciejpajak.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;

import pl.maciejpajak.entity.Project;
import pl.maciejpajak.entity.Task;
import pl.maciejpajak.entity.User;

public interface IProjectService {
    
    public Project createProject(Project project, Long id);
    public List<User> getAvailableUsers();
    public List<Project> getProjectsByOwnerId(Long id);
    public List<Project> getProjectsByUsersId(Long id);
    public Project getProjectById(Long id);
    public Project getProjectByIdFetchUsers(Long id);
    public Page<Task> getTasksByProjectId(Long id, Pageable pageable);
    public boolean closeProject(Long id);

}
