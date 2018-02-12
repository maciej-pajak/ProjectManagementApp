package pl.maciejpajak.service;

import java.util.List;
import java.util.Map;

import pl.maciejpajak.entity.BaseEntity;
import pl.maciejpajak.entity.Project;
import pl.maciejpajak.util.LoggableActivity;
import pl.maciejpajak.util.OperationType;

public interface ProjectService {
    @LoggableActivity(operationType = OperationType.CREATE) // TODO
    public Project createProject(Project project, Long id);
    public List<Project> getProjectsByOwnerId(Long id);
    public List<Project> getProjectsByUsersId(Long id);
    public Project getProjectById(Long id);
    public Project getProjectByIdFetchUsers(Long id);
    public BaseEntity closeProject(Long id);
    public Map<Long, String> findActiveNamesAndIdsByOwnerAndActive(Long id);
    public String findProjectIdentifier(Long id);
}
