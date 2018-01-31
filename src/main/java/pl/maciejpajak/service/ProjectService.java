package pl.maciejpajak.service;

import java.util.List;
import java.util.Map;

import pl.maciejpajak.entity.Project;

public interface ProjectService {
    
    public Project createProject(Project project, Long id);
    public List<Project> getProjectsByOwnerId(Long id);
    public List<Project> getProjectsByUsersId(Long id);
    public Project getProjectById(Long id);
    public Project getProjectByIdFetchUsers(Long id);
    public boolean closeProject(Long id);
    public Map<Long, String> findActiveNamesAndIdsByOwnerAndActive(Long id);
}
